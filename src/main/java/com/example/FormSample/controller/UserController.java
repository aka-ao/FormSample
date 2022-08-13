package com.example.FormSample.controller;

import com.example.FormSample.entity.User;
import com.example.FormSample.entity.UserStatus;
import com.example.FormSample.form.DeleteForm;
import com.example.FormSample.form.UserForm;
import com.example.FormSample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Transactional(readOnly = false)
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public String user(Model model) {
        Map<Integer, String> statuses = UserStatus.getAllStatus();

        model.addAttribute("statuses", statuses);
        model.addAttribute("userForm", new UserForm());
        model.addAttribute("deleteForm", new DeleteForm());

        model.addAttribute("userList", userService.findAll());
        return "user";
    }

    @PostMapping("register")
    public String registerUser(@ModelAttribute UserForm userForm, RedirectAttributes redirectAttributes) {
        User user = new User();
        user.setName(userForm.getUserName());
        user.setStatus(userForm.getStatus());
        userService.save(user);
        return "redirect:/user";
    }

    @PostMapping("delete")
    public String delete(@RequestParam Integer userId, RedirectAttributes redirectAttributes) {
        userService.deleteById(userId);
        return "redirect:/user";
    }

    @PostMapping("deleteAll")
    public String deleteAll(@ModelAttribute DeleteForm deleteForm, RedirectAttributes redirectAttributes) {
        userService.deleteAllById(deleteForm.getDeleteList());
        return "redirect:/user";
    }
}
