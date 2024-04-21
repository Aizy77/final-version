package kz.aptekaplus.service;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import kz.aptekaplus.dto.ProductViewDTO;
import kz.aptekaplus.model.Product;
import kz.aptekaplus.model.User;
import kz.aptekaplus.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final UserService userService;
    private final JWTService jwtService;
    private final ProductService productService;
    private final UserRepository userRepository;
    @Transactional
    public void addBasket(HttpServletRequest request, UUID productId) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            String refreshToken = null;
            for (Cookie cookie : cookies) {
                if ("refreshToken".equals(cookie.getName())) {
                    refreshToken = cookie.getValue();
                    break;
                }
            }
            if (refreshToken != null) {
                UUID userId = UUID.fromString(jwtService.extractID(refreshToken));
                User user = userService.findById(userId);
                if (user != null) {
                    Product product = productService.findProduct(productId);
                    System.out.println("```````````````");
                    System.out.println(user);
                    System.out.println(product);
                    System.out.println("```````````````");
                    user.getBasket().add(product);
                    userService.updateUser2(user);
                }

            }
        }
    }

    public void deleteFromBasket(UUID productId, UUID userId) {
        User user = userService.findById(userId);
        Product product = productService.findProduct(productId);

        if (Objects.isNull(user) || Objects.isNull(product)) return;

        List<Product> userBasket = user.getBasket();
        userBasket.remove(product);
        user.setBasket(userBasket);

        userRepository.save(user);

    }
}
