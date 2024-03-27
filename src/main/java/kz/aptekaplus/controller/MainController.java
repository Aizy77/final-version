package kz.aptekaplus.controller;

import jakarta.servlet.http.HttpSession;
import kz.aptekaplus.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final CategoryService categoryService;
    @GetMapping("/")
    public String index(Model model, @CookieValue(name = "refreshToken", required = false) String token) {
        System.out.println("=======================");
        System.out.println(token);
        System.out.println("=======================");
        model.addAttribute("categories", categoryService.getCategories());
        return "index";
    }
}
