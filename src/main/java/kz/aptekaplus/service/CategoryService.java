package kz.aptekaplus.service;


import kz.aptekaplus.dto.CategoryViewDTO;
import kz.aptekaplus.model.Category;
import kz.aptekaplus.model.SubCategory;
import kz.aptekaplus.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final SubCategoryService subCategoryService;

    public List<CategoryViewDTO> getCategories() {
        List<CategoryViewDTO> categoryViewDTOS = new ArrayList<>();
        for (Category category : categoryRepository.findAll()) {
            List<SubCategory> allSubCategoriesByCategory = subCategoryService.findAllSubCategoriesByCategory(category);
            categoryViewDTOS.add(new CategoryViewDTO(category, allSubCategoriesByCategory));
        }
        return categoryViewDTOS;
    }
}
