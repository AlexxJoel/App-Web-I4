package com.example.firstapp.controllers.subcategory.dto;

import com.example.firstapp.models.category.Category;
import com.example.firstapp.models.subcategory.Subcategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubcategoryDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Required field")
    @Size(min = 3, max = 50)
    private String name;
    private Boolean status = true;
    private Category category;
    public Subcategory toSubcategory(){
        return new Subcategory(
                getId(),
                getName(),
                getStatus(),
                getCategory()
        );
    }
}
