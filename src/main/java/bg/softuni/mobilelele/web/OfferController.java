package bg.softuni.mobilelele.web;


import bg.softuni.mobilelele.model.dto.AddOfferDTO;
import bg.softuni.mobilelele.model.enums.EngineType;
import bg.softuni.mobilelele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

//    @ModelAttribute
//    public EngineType[] engineTypes() {
//        return EngineType.values();
//    }

    @GetMapping("/add")
    public String newOffer(Model model) {
        model.addAttribute("engineTypes", EngineType.values());

        if (!model.containsAttribute("addOfferDTO")) {
            model.addAttribute("addOfferDTO", AddOfferDTO.emptyInstance());
        }
        return "offer-add";
    }

    @PostMapping("/add")
    public String createOffer(AddOfferDTO addOfferDTO){
        offerService.addOffer(addOfferDTO);
        return "offer-add";
    }
}
