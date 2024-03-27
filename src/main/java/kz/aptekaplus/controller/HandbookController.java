package kz.aptekaplus.controller;


import kz.aptekaplus.dto.ProductViewDTO;
import kz.aptekaplus.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/handbook")
@AllArgsConstructor
public class HandbookController {

    private final ProductService productService;

    @GetMapping
    public String index() {
        return "spravochnik";
    }

    @GetMapping("/starts-with/{temp}")
    public String getStartsWith(@PathVariable("temp") String temp, Model model) {
        List<ProductViewDTO> productsStartsWith = productService.getProductsStartsWith(temp);
        model.addAttribute("products", productsStartsWith);
        model.addAttribute("isEmpty", productsStartsWith.isEmpty());
        System.out.println(productsStartsWith);
        return "spravochnik";
    }
}
