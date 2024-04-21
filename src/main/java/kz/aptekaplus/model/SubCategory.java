package kz.aptekaplus.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "subcategories")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SubCategory {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;


    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;
}
