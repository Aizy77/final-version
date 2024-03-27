package kz.aptekaplus.dto;


import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import kz.aptekaplus.model.Label;
import kz.aptekaplus.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductViewDTO {

    private UUID id;

    private String name;
    private Label label;
    private String imagePath;
    private String idRegistrationNumber;
    private String internationalName;
    private String countryProducer;
    private Double expirationDate;
    private String dosageForm;
    private String structure;

    public ProductViewDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.label = product.getLabel();
        this.imagePath = product.getImagePath();
        this.idRegistrationNumber = product.getIdRegistrationNumber();
        this.internationalName = product.getInternationalName();
        this.countryProducer = product.getCountryProducer();
        this.expirationDate = product.getExpirationDate();
        this.dosageForm = product.getDosageForm();
        this.structure = product.getStructure();
    }

    @Override
    public String toString() {
        return "ProductViewDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", idRegistrationNumber='" + idRegistrationNumber + '\'' +
                ", internationalName='" + internationalName + '\'' +
                ", countryProducer='" + countryProducer + '\'' +
                ", expirationDate=" + expirationDate +
                ", dosageForm='" + dosageForm + '\'' +
                ", structure='" + structure + '\'' +
                '}';
    }
}
