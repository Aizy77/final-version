package kz.aptekaplus.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "labels")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Label {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name="subCategory_id", nullable=false)
    private SubCategory subCategory;
}
