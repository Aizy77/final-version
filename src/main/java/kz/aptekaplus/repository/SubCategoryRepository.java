package kz.aptekaplus.repository;


import kz.aptekaplus.model.Category;
import kz.aptekaplus.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, UUID> {
    List<SubCategory> findAllByCategory(Category category);
    @Query("SELECT s FROM SubCategory s WHERE s.category.id = :categoryId")
    List<SubCategory> findByCategoryId(@Param("categoryId") UUID categoryId);
}
