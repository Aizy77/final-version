package kz.aptekaplus;

import kz.aptekaplus.model.Category;
import kz.aptekaplus.model.Label;
import kz.aptekaplus.model.Product;
import kz.aptekaplus.model.SubCategory;
import kz.aptekaplus.repository.CategoryRepository;
import kz.aptekaplus.repository.LabelRepository;
import kz.aptekaplus.repository.ProductRepository;
import kz.aptekaplus.repository.SubCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
@RequiredArgsConstructor
public class AptekaplusApplication implements CommandLineRunner {


    private final CategoryRepository categoryRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final LabelRepository labelRepository;
    private final ProductRepository productRepository;

    public static void main(String[] args) {
        try {
            SpringApplication.run(AptekaplusApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("===================");
        System.out.println("command line runner");
        System.out.println("===================");
//
        var category = Category.builder()
                .name("Лекарственные средства")
                .build();
//        categoryRepository.save(category);
//


//
        var subCategory = SubCategory.builder()
                .category(category)
                .name("Витамины и минералы")
                .build();
//        subCategoryRepository.save(subCategory);
//


//
        var label = Label.builder()
                .subCategory(subCategory)
                .name("Витамин А")
                .build();
//        labelRepository.save(label);
//

        var product = Product.builder()
                .label(label)
                .name("РЕТИНОЛ ПАЛЬМИТАТ (ВИТ А)")
                .subCategory(subCategory)
                .countryProducer("countryProducer")
                .expirationDate(2000.0)
                .internationalName("internationalName")
                .dosageForm("dosageForm")
                .idRegistrationNumber("idRegistrationNumber")
                .imagePath("imagePath")
                .structure("structure")
                .price(100.0)
                .build();
//        productRepository.save(product);

    }


}
