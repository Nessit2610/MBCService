package com.ftec.MBCService.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ftec.MBCService.Entity.LoginRequest;
import com.ftec.MBCService.Entity.User;
import com.ftec.MBCService.Service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginController {

	@Autowired
    private UserService userService;

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest,  HttpServletRequest request) {
    	System.out.println("Pass : "+loginRequest.getPassword());
    	System.out.println("Usname : "+loginRequest.getUsername());
        User user = userService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        if (user != null) {
        	HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return ResponseEntity.ok(user);     
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Tên đăng nhập hoặc mật khẩu không đúng");
        }
    }
}
