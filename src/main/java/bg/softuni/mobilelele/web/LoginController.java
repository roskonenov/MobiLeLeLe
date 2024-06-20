package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.dto.LoginDTO;
import bg.softuni.mobilelele.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("loginDTO")
    public LoginDTO loginDTO(){
        return new LoginDTO();
    }

    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }
    @PostMapping("/login")
    public String login(@Valid LoginDTO loginDTO, BindingResult bindingResult, RedirectAttributes rAttr){
        if (bindingResult.hasErrors()){
            rAttr.addFlashAttribute("loginDTO", loginDTO);
            rAttr.addFlashAttribute("org.springframework.validation.BindingResult.loginDTO", bindingResult);
            return "redirect:/users/login";
        }
        userService.login(loginDTO);
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(){
        userService.logout();
        return "redirect:/";
    }
}
