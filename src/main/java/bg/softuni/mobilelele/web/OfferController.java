package bg.softuni.mobilelele.web;


import bg.softuni.mobilelele.model.dto.AddOfferDTO;
import bg.softuni.mobilelele.model.enums.EngineType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class OfferController {

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

        return "offer-add";
    }
}
