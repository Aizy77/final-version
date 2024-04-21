package kz.aptekaplus.service;


import kz.aptekaplus.model.Category;
import kz.aptekaplus.model.SubCategory;
import kz.aptekaplus.repository.SubCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;
    public List<SubCategory> findAllSubCategoriesByCategory(Category category) {
        return subCategoryRepository.findAllByCategory(category);
    }

    public List<SubCategory> findAllSubCategoryByCategoryId(UUID id) {
        return subCategoryRepository.findByCategoryId(id);
    }
}
