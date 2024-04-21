package kz.aptekaplus.controller;

import kz.aptekaplus.model.Category;
import kz.aptekaplus.repository.CategoryRepository;
import kz.aptekaplus.repository.SubCategoryRepository;
import kz.aptekaplus.service.SubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/subcategory")
@RequiredArgsConstructor
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getSubCategories(@PathVariable UUID id) {
        System.out.println("UUID " + id);
        return ResponseEntity.ok(subCategoryService.findAllSubCategoryByCategoryId(id));
    }
}
