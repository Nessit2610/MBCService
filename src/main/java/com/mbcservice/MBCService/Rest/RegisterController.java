package com.mbcservice.MBCService.Rest;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mbcservice.MBCService.Dao.RoleRepository;
import com.mbcservice.MBCService.Entity.Role;
import com.mbcservice.MBCService.Entity.User;
import com.mbcservice.MBCService.Service.UserService;
import com.mbcservice.MBCService.UserRegister.UserRegister;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/showRegisterForm")
    public String showRegisterForm(Model model) {
        model.addAttribute("userregister", new UserRegister());
        return "register/form";
    }

    @InitBinder
    public void initBinder(WebDataBinder datab) {
        StringTrimmerEditor ste = new StringTrimmerEditor(true);
        datab.registerCustomEditor(String.class, ste);
    }

    @PostMapping("/process")
    public String process(@Valid @ModelAttribute("userregister") UserRegister userregister, BindingResult br, Model model, HttpSession session) {
        // Kiểm tra lỗi form
        if (br.hasErrors()) {
            return "register/form";
        }

        // Kiểm tra user đã tồn tại
        String username = userregister.getUsername();
        User existingUser = userService.findByUsername(username);
        if (existingUser != null) {
            model.addAttribute("myerror", "Tài khoản đã tồn tại");
            return "register/form";
        }

        // Nếu chưa tồn tại và không có lỗi
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User newUser = new User();
        newUser.setUsername(userregister.getUsername());
        newUser.setPassword(bCryptPasswordEncoder.encode(userregister.getPassword()));
        newUser.setFirstname(userregister.getFirstname());
        newUser.setLastname(userregister.getLastname());
        newUser.setEmail(userregister.getEmail());

        // Gán vai trò cho người dùng mới
        Collection<Role> roles = new ArrayList<>();
        Role userRole = roleRepository.findByName("ROLE_USER");
        roles.add(userRole);
        newUser.setRoles(roles);

        // Lưu người dùng mới
        userService.save(newUser);

        // Thông báo thành công
        session.setAttribute("newuser", newUser);
        return "register/confirmation";
    }
}
