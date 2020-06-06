package pl.coderslab.upill.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.upill.entity.CurrentUser;
import pl.coderslab.upill.entity.Medicine;
import pl.coderslab.upill.entity.User;
import pl.coderslab.upill.repository.MedicineRepository;
import pl.coderslab.upill.repository.UserRepository;
import pl.coderslab.upill.service.UserService;

import java.util.List;
import java.util.Set;


@Controller
@RequestMapping(value = "/uPill/user/meds", produces = "text/plain;charset=UTF-8")
public class MedicineController {

    private final MedicineRepository medicineRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    public MedicineController(MedicineRepository medicineRepository, UserRepository userRepository, UserService userService) {
        this.medicineRepository = medicineRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }


    @GetMapping("/add")
    public String addMedicineForm(Model model) {
        model.addAttribute("medicine", new Medicine());
        return "medicine-form";
    }

    @ModelAttribute("users")
    public List<User> users() {
        return userRepository.findAll();
    }

   /* @PostMapping("/add")
    @ResponseBody
    public String processMedicineForm(@ModelAttribute @Validated Medicine medicine, BindingResult bindingResult,
                                      @AuthenticationPrincipal CurrentUser currentUser) {

        User user = currentUser.getUser();
        Set<Medicine> userMeds = user.getMeds();
        if (!bindingResult.hasErrors()) {
            Medicine toSave = medicineRepository.save(medicine);
            userMeds.add(toSave);
            user.setMeds(userMeds);
            return "added";
        } else {
            return "not ok";
        }*/


        @PostMapping("/add")
        public String processMedicineForm(@ModelAttribute @Validated Medicine medicine, BindingResult bindingResult,
                @AuthenticationPrincipal CurrentUser currentUser) {
            User user = currentUser.getUser();
            Set<Medicine> userMeds = user.getMeds();
            Set<User> users = medicine.getUsers();
            if (!bindingResult.hasErrors()) {
                users.add(user);
                Medicine toSave = medicineRepository.save(medicine);
                userMeds.add(toSave);
                user.setMeds(userMeds);
                return "redirect:/uPill/user/meds/list";

            } else {
                return "medicine-form";
            }

    }


    @GetMapping("/list")
    public String displayUserMeds(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        User user = customUser.getUser();
        model.addAttribute("user", user);
        return "user-meds";
    }
}

