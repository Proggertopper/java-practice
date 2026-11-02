//package tacos.client;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.ui.Model;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.core.oidc.user.OidcUser;
//
//@Controller
//public class HomeController {
//
//    @GetMapping("/")
//    public String home(Model model, @AuthenticationPrincipal OidcUser oidcUser) {
//        if (oidcUser != null) {
//            model.addAttribute("name", oidcUser.getFullName());
//        }
//        return "home";
//    }
//}
