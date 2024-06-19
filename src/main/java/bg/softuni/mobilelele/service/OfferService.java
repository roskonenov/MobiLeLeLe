package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.dto.AddOfferDTO;
import bg.softuni.mobilelele.model.dto.OfferDetailsDTO;
import bg.softuni.mobilelele.model.dto.offerSummaryDTO;

import java.util.List;

public interface OfferService {

    long addOffer(AddOfferDTO addOfferDTO);

    OfferDetailsDTO getOfferDetails(Long id);

    List<offerSummaryDTO> getAllOffers();

    void deleteOffer(Long id);
}

