package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.user.CurrentUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        if (userDetails instanceof CurrentUser currentUser) {
            model.addAttribute("welcomeMessage", currentUser.getFullName());
        } else {
            model.addAttribute("welcomeMessage", "Guest");
        }
        return "index";
    }
}
