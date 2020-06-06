package pl.coderslab.upill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping(value = "/uPill", produces = "text/plain;charset=UTF-8")
public class HomeController {
    @RequestMapping("/uPill")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("uPill/about")
    public String about() { return "about"; }

/*

    @GetMapping("uPill/login")
    public String displayLoginForm() { return "login"; }
*/

}
