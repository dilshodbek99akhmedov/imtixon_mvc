package uz.pdp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import uz.pdp.dto.UserDto;
import uz.pdp.service.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping({"", "/", "/home"})
    public String home() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserDto dto) {
        if (userService.login(dto))
            return "adminCabinet";
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserDto dto) {
        userService.create(dto);
        return "login";
    }
}
