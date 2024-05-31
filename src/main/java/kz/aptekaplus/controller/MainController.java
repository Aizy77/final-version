package kz.aptekaplus.controller;

import kz.aptekaplus.dto.product.ProductResponseDto;
import kz.aptekaplus.service.impl.CategoryServiceImpl;
import kz.aptekaplus.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final CategoryServiceImpl categoryServiceImpl;
    private final ProductServiceImpl productServiceImpl;
    @GetMapping("/")
    public String index(Model model, @CookieValue(name = "refreshToken", required = false) String token) {
        System.out.println("=======================");
        System.out.println(token);
        ProductServiceImpl productServiceImpl1 = productServiceImpl;
        List<ProductResponseDto> allProducts = productServiceImpl1.getAllProducts();
        System.out.println("=======================");
        model.addAttribute("categories", categoryServiceImpl.getCategories());
        model.addAttribute("products", allProducts);
        return "index";
    }
}
