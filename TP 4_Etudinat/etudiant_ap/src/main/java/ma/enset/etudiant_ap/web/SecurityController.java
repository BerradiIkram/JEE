package ma.enset.etudiant_ap.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController
{
    @GetMapping("/403")
    public String notAuthorized(){
        return  "page403";
    }
}
