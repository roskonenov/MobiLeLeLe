package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.Offer;
import bg.softuni.mobilelele.model.dto.AddOfferDTO;
import bg.softuni.mobilelele.model.dto.OfferDetailsDTO;
import bg.softuni.mobilelele.repository.OfferRepository;
import bg.softuni.mobilelele.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addOffer(AddOfferDTO addOfferDTO) {
        offerRepository.saveAndFlush(modelMapper.map(addOfferDTO, Offer.class));
    }

    @Override
    public OfferDetailsDTO getOfferDetails(Long id) {
        return modelMapper.map(offerRepository.findById(id), OfferDetailsDTO.class);
    }
}
