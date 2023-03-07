package com.example.firstapp.controllers.category.dto;

import com.example.firstapp.controllers.category.CategoryController;
import com.example.firstapp.models.category.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private Long id;
    @NotEmpty(message = "Required field")
    @Size(min = 3, max = 50)
    private String name;

    private Boolean status = true;
    public Category castToCategory() {
        return new Category(
                getId(),
                getName(),
                getStatus(),
                null
        );
    }
}
