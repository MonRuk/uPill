package pl.coderslab.upill.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.upill.entity.CurrentUser;
import pl.coderslab.upill.entity.User;
import pl.coderslab.upill.repository.RoleRepository;
import pl.coderslab.upill.repository.UserRepository;
import pl.coderslab.upill.service.UserService;



@Controller
@RequestMapping(value = "/uPill", produces = "text/plain;charset=UTF-8")

public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    public UserController(UserService userService, UserRepository userRepository, RoleRepository roleRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

    }



    @GetMapping("/register")
    public String registerUser(Model model) {
        model.addAttribute("user", new User());
        return "register-form";
    }


        @PostMapping("/register")
        public String processRegisterForm(@ModelAttribute @Validated User user, BindingResult bindingResult) {
            if (!bindingResult.hasErrors()) {
                userService.saveUser(user);
                return "login-after-registration";
            } else {
                return "register-form";
            }
        }

    @GetMapping("/logged")
    @ResponseBody
    public String loggedUser(@AuthenticationPrincipal CurrentUser customUser) {
        User user = customUser.getUser();
        return "Witaj " + user.getUsername();
    }


    @GetMapping("/user")
    public String userPage(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        User user = customUser.getUser();
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/user/details")
    public String displayUserDetails(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        User user = customUser.getUser();
        model.addAttribute("user", user);
        return "user-details";
    }
}



