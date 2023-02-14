package mx.edu.utez.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class TorreDTO {
    @NotBlank
    private String nombreTorre;

    @Min(0)
    private int cantidadAptos;

}
