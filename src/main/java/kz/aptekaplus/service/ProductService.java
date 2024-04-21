package kz.aptekaplus.service;


import kz.aptekaplus.dto.ProductViewDTO;
import kz.aptekaplus.model.Product;
import kz.aptekaplus.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;



    public List<ProductViewDTO> getProductsStartsWith(String temp) {
        List<ProductViewDTO> productViewDTOS = new ArrayList<>();
        for (Product product : productRepository.findByNameStartingWith(temp)) {
            productViewDTOS.add(
                    new ProductViewDTO(product)
            );
        }
        return productViewDTOS;
    }

    public ProductViewDTO getProduct(UUID productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        return productOptional.map(ProductViewDTO::new).orElse(null);
    }

    public Product findProduct(UUID productId) {
        return productRepository.findById(productId).get();
    }

    public List<ProductViewDTO> findBySubCategoryId(UUID id) {
        List<Product> products = productRepository.findBySubCategoryId(id);

        List<ProductViewDTO> productDTOs = products.stream()
                .map(ProductViewDTO::new)
                .collect(Collectors.toList());

        return productDTOs;
    }
}
