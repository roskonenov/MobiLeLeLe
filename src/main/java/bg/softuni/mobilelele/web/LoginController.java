package bg.softuni.mobilelele.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("showError", true);
        return "auth-login";
    }
}

