package kz.aptekaplus.controller;


import jakarta.servlet.http.HttpServletRequest;
import kz.aptekaplus.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/basket")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;

    @PostMapping
    @ResponseBody
    public String addBasket(HttpServletRequest request, @RequestParam("productId") UUID productId) {
        basketService.addBasket(request, productId);
        return "#";
    }

    @GetMapping
    public String index() {
        return "basket";
    }
}
