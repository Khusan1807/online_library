package uz.pdp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.pdp.dto.authUser.AuthUserCreateDto;
import uz.pdp.dto.authUser.AuthUserDto;
import uz.pdp.enums.Role;
import uz.pdp.service.AuthUserService;

@Controller
@RequestMapping("/auth/*")
@RequiredArgsConstructor
public class AuthUserController {

    private final AuthUserService service;


    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String createPage() {
        return "auth/register";
    }



    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String create(@ModelAttribute AuthUserCreateDto dto) {
        dto.setRole(Role.USER);
        service.create(dto);
        return "redirect:/";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "/auth/login";
    }


    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@ModelAttribute AuthUserDto dto) {
        service.login(dto);
        return "/book/list";
    }




}
