package com.example.FormSample.controller;

import com.example.FormSample.entity.User;
import com.example.FormSample.form.DeleteForm;
import com.example.FormSample.form.UserForm;
import com.example.FormSample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

@Transactional(readOnly = false)
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository repository;

    @GetMapping
    public String user(Model model) {
        model.addAttribute("userForm", new UserForm());
        model.addAttribute("deleteForm", new DeleteForm());
        model.addAttribute("userList",repository.findAll());
        return "user";
    }

    @PostMapping("register")
    public String registerUser(@ModelAttribute UserForm userForm, RedirectAttributes redirectAttributes) {
        User user = new User();
        user.setName(userForm.getUserName());
        repository.save(user);
        redirectAttributes.addAttribute("userList",repository.findAll());
        return "redirect:/user";
    }

    @PostMapping("delete")
    public String delete(@RequestParam Integer userId, RedirectAttributes redirectAttributes) {
        repository.deleteById(userId);
        redirectAttributes.addAttribute("userList",repository.findAll());
        return "redirect:/user";
    }

    @PostMapping("deleteAll")
    public String deleteAll(@ModelAttribute DeleteForm deleteForm, RedirectAttributes redirectAttributes) {
        repository.deleteAllById(deleteForm.getDeleteList());
        redirectAttributes.addAttribute("userList",repository.findAll());
        return "redirect:/user";
    }
}
