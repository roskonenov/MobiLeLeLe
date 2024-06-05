package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.dto.AddOfferDTO;
import bg.softuni.mobilelele.model.dto.OfferDetailsDTO;

public interface OfferService {

    long addOffer(AddOfferDTO addOfferDTO);

    OfferDetailsDTO getOfferDetails(Long id);
}

