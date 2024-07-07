package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.exception.ObjectNotFoundException;
import bg.softuni.mobilelele.model.entity.Offer;
import bg.softuni.mobilelele.model.dto.AddOfferDTO;
import bg.softuni.mobilelele.model.dto.OfferDetailsDTO;
import bg.softuni.mobilelele.model.dto.offerSummaryDTO;
import bg.softuni.mobilelele.repository.OfferRepository;
import bg.softuni.mobilelele.service.ExRatesService;
import bg.softuni.mobilelele.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final ExRatesService exRatesService;
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(ExRatesService exRatesService, OfferRepository offerRepository, ModelMapper modelMapper) {
        this.exRatesService = exRatesService;
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public long addOffer(AddOfferDTO addOfferDTO) {
        return offerRepository.saveAndFlush(modelMapper.map(addOfferDTO, Offer.class)).getId();
    }

    @Override
    public OfferDetailsDTO getOfferDetails(Long id) {
//        return modelMapper.map(offerRepository.findById(id), OfferDetailsDTO.class);
        return offerRepository.findById(id)
                .map(offer -> {
                    OfferDetailsDTO dto = modelMapper.map(offer, OfferDetailsDTO.class);
                    dto.setAllCurrencies(exRatesService.findAllCurrencies());
                    return dto;
                }).orElseThrow(() -> new ObjectNotFoundException("There is no such offer"));
    }

    @Override
    public List<offerSummaryDTO> getAllOffers() {
        return offerRepository.findAll()
                .stream()
                .map(offer -> modelMapper.map(offer, offerSummaryDTO.class))
                .toList();
    }

    @Override
    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }
}
