package kz.aptekaplus.dto;


import kz.aptekaplus.model.Category;
import kz.aptekaplus.model.SubCategory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CategoryViewDTO {

    private UUID id;
    private String name;
    private List<SubCategory> subCategories;
    public CategoryViewDTO(Category category, List<SubCategory> allSubCategoriesByCategory) {
        this.id = category.getId();
        this.name = category.getName();
        this.subCategories = allSubCategoriesByCategory;
    }
}
