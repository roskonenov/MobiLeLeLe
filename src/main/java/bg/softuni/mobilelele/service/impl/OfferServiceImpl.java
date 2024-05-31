package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.Offer;
import bg.softuni.mobilelele.model.dto.AddOfferDTO;
import bg.softuni.mobilelele.repository.OfferRepository;
import bg.softuni.mobilelele.service.OfferService;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public void addOffer(AddOfferDTO addOfferDTO) {
        offerRepository.saveAndFlush(new Offer()
                .setEngineType(addOfferDTO.getEngineType())
                .setDescription(addOfferDTO.getDescription()));
    }
}
