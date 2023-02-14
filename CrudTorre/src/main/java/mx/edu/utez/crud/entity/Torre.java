package mx.edu.utez.crud.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "torres")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Torre {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTorre;
    private String nombreTorre;
    private int cantidadAptos;




    public Torre(String nombreTorre, int cantidadAptos) {
        this.nombreTorre = nombreTorre;
        this.cantidadAptos = cantidadAptos;
    }
}
