package com.example.firstapp.models.category;

import com.example.firstapp.models.subcategory.Subcategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="categories")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class  Category {
    @Id //Indica que es el id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Es el autoincrement
    private Long id;
    @Column(unique = true, nullable = false, length = 150) //Indica que es una columna en la base de datos.
    private String name;
    @Column(name="status",nullable = false, columnDefinition = "tinyint default 1")
    private Boolean status;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Subcategory> subcategories;



}
