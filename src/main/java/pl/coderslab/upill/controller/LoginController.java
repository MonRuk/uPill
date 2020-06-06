package pl.coderslab.upill.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.upill.entity.CurrentUser;
import pl.coderslab.upill.entity.User;
import pl.coderslab.upill.repository.RoleRepository;
import pl.coderslab.upill.repository.UserRepository;
import pl.coderslab.upill.service.UserService;



@Controller
@RequestMapping(value = "/uPill", produces = "text/plain;charset=UTF-8")
public class LoginController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public LoginController(UserService userService, UserRepository userRepository, RoleRepository roleRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String displayLogin() {
        return "login";
    }

    @RequestMapping(value = {"/login/error"}, method = RequestMethod.GET)
    public String displayLoginError() {
        return "login-error";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "logout";
    }

    @RequestMapping(value = "/loggedout", method = RequestMethod.GET)
    public String loggedOut() {
        return "logged-out";
    }

    @GetMapping("/check")
    @ResponseBody
    public String check(@AuthenticationPrincipal CurrentUser customUser) {
        User user = customUser.getUser();
        if (user != null) {
            return "logged";
        } else {
            return "nope";
        }
    }

/*    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    @ResponseBody
    public String logged(@AuthenticationPrincipal UserDetails customUser) {
        String username = customUser.getUsername();
        if (!(username == null)) {
            return "zalogowano";
        } else {
            return "login";
        }
    }*/

/*    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String logged(@AuthenticationPrincipal UserDetails customUser) {
        String username = customUser.getUsername();
        if (!(username == null)) {
            return "redirect:/uPill/logged";
        } else {
            return "login";
        }
    }*/

/*    @GetMapping("/redirect")
    @ResponseBody
    public String redirect(@AuthenticationPrincipal UserDetails customUser) {
        String username = customUser.getUsername();
        Set<Role> roles = userRepository.findByUsername(username).getRoles();
        Role role = roleRepository.findByName("ROLE_USER");
        if (roles.contains(role)) {
            return "logged";
        } else {
            return "nope";
        }
    }*/

}

