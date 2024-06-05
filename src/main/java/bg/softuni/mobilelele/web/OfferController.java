package bg.softuni.mobilelele.web;


import bg.softuni.mobilelele.model.dto.AddOfferDTO;
import bg.softuni.mobilelele.model.enums.EngineType;
import bg.softuni.mobilelele.service.OfferService;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @ModelAttribute("engineTypes")
    public EngineType[] engineTypes() {
        return EngineType.values();
    }

    @GetMapping("/add")
    public String newOffer(Model model) {

        if (!model.containsAttribute("addOfferDTO")) {
            model.addAttribute("addOfferDTO", AddOfferDTO.emptyInstance());
        }
        return "offer-add";
    }

    @PostMapping("/add")
    public String createOffer(@Valid AddOfferDTO addOfferDTO, BindingResult bindingResult, RedirectAttributes rAttr){
        if (bindingResult.hasErrors()) {
            rAttr.addFlashAttribute("addOfferDTO", addOfferDTO);
            rAttr.addFlashAttribute("org.springframework.validation.BindingResult.addOfferDTO", bindingResult);
            return "redirect:/offers/add";
        }

        return "redirect:/offers/" +  offerService.addOffer(addOfferDTO);
    }

    @GetMapping("/{id}")
    public String offerDetails(@PathVariable("id") Long id, Model model){
        model.addAttribute("offerDetails", offerService.getOfferDetails(id));
        return "details";
    }
}
