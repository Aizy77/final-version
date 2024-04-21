package kz.aptekaplus.controller;

import kz.aptekaplus.dto.ProductViewDTO;
import kz.aptekaplus.model.Label;
import kz.aptekaplus.model.Product;
import kz.aptekaplus.service.CategoryService;
import kz.aptekaplus.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;


    @GetMapping("/{productId}")
    public String getProduct(@PathVariable("productId") UUID productId, Model model) {
        ProductViewDTO product = productService.getProduct(productId);
        System.out.println(product);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getCategories());
        return "product";
    }

    @GetMapping("/get/{id}")
    public String getAllProductsPage(@PathVariable UUID id, Model model){

        List<ProductViewDTO> products = productService.findBySubCategoryId(id);

        model.addAttribute("products", products);
        model.addAttribute("categories", categoryService.getCategories());
        return "products";
    }
}
