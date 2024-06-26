package bg.softuni.mobilelele.web;


import bg.softuni.mobilelele.model.dto.AddOfferDTO;
import bg.softuni.mobilelele.model.enums.EngineType;
import bg.softuni.mobilelele.service.CurrentUser;
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
    private final CurrentUser currentUser;

    public OfferController(OfferService offerService, CurrentUser currentUser) {
        this.offerService = offerService;
        this.currentUser = currentUser;
    }

    @ModelAttribute("engineTypes")
    public EngineType[] engineTypes() {
        return EngineType.values();
    }

    @GetMapping("/add")
    public String newOffer(Model model) {
        if (!currentUser.isLoggedIn()) return "redirect:/";

        if (!model.containsAttribute("addOfferDTO")) {
            model.addAttribute("addOfferDTO", AddOfferDTO.emptyInstance());
        }
        return "offer-add";
    }

    @PostMapping("/add")
    public String createOffer(@Valid AddOfferDTO addOfferDTO, BindingResult bindingResult, RedirectAttributes rAttr){
        if (!currentUser.isLoggedIn()) return "redirect:/";

        if (bindingResult.hasErrors()) {
            rAttr.addFlashAttribute("addOfferDTO", addOfferDTO);
            rAttr.addFlashAttribute("org.springframework.validation.BindingResult.addOfferDTO", bindingResult);
            return "redirect:/offers/add";
        }

        return "redirect:/offers/" +  offerService.addOffer(addOfferDTO);
    }

    @GetMapping("/{id}")
    public String offerDetails(@PathVariable("id") Long id, Model model){
        if (!currentUser.isLoggedIn()) return "redirect:/";

        model.addAttribute("offerDetails", offerService.getOfferDetails(id));
        return "details";
    }

    @DeleteMapping("/{id}")
    public String deleteOffer(@PathVariable("id") Long id){
        offerService.deleteOffer(id);

        return "redirect:/offers/all";
    }

    @GetMapping("/all")
    public String getAllOffers(Model model){
        if (!currentUser.isLoggedIn()) return "redirect:/";

        model.addAttribute("allOffers", offerService.getAllOffers());
        return "offers";
    }
}
