package com.example.FormSample.controller;

import com.example.FormSample.entity.user.User;
import com.example.FormSample.entity.user.UserFactory;
import com.example.FormSample.entity.user.UserStatus;
import com.example.FormSample.form.BuyProductForm;
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

    @GetMapping("detail")
    public String userDetail(@RequestParam Integer userId,@ModelAttribute("buyProductMsg") String buyProductMsg, Model model) {
        model.addAttribute("buyProductForm", new BuyProductForm());
        model.addAttribute("userId", userId);
        model.addAttribute("buyProductMsg", buyProductMsg);
        return "userDetail";
    }

    @PostMapping("register")
    public String registerUser(@ModelAttribute UserForm userForm, RedirectAttributes redirectAttributes) {
        User user = UserFactory.exec(null, userForm.getUserName(), userForm.getStatus());
        userService.save(user);
        return "redirect:/user";
    }

    @PostMapping("delete")
    public String delete(@RequestParam Integer userId, RedirectAttributes redirectAttributes) {
        userService.deleteById(userId);
        return "redirect:/user";
    }

    @PostMapping("buyProduct")
    public String buyProduct(@ModelAttribute BuyProductForm buyProductForm, RedirectAttributes redirectAttributes) {
        System.out.println("++++"+buyProductForm.getProductName());
        User user = userService.findById(buyProductForm.getUserId());
        String res = user.buyProduct(buyProductForm.getProductName(), buyProductForm.getProductPrice());
        redirectAttributes.addAttribute("buyProductMsg", res);
        return "redirect:/user/detail?userId="+buyProductForm.getUserId();
    }

    @PostMapping("deleteAll")
    public String deleteAll(@ModelAttribute DeleteForm deleteForm, RedirectAttributes redirectAttributes) {
        userService.deleteAllById(deleteForm.getDeleteList());
        return "redirect:/user";
    }
}
