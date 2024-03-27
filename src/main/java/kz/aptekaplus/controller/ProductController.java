package kz.aptekaplus.controller;

import kz.aptekaplus.dto.ProductViewDTO;
import kz.aptekaplus.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public String getProduct(@PathVariable("productId") UUID productId, Model model) {
        ProductViewDTO product = productService.getProduct(productId);
        System.out.println(product);
        model.addAttribute("product", product);
        return "product";
    }
}
