package com.example.firstapp.controllers.person.dtos;

import com.example.firstapp.models.person.Person;
import com.example.firstapp.models.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

//Validaciones
public class PersonDto {
    private Long id;
    @NotEmpty (message = "Campo obligatorio")
    @Size(min = 3, max = 50)
    private String name;
    @NotEmpty (message = "Campo obligatorio")
    @Size(min = 3, max = 50)
    private String surname;
    private String lastname;
    @NotEmpty
    private String birthday;
    @NotEmpty
    @Pattern(regexp = "^([A-Z][AEIOUX][A-Z]{2}\\d{2}(?:0\\d|1[0-2])(?:[0-2]\\d|3[01])[HM](?:AS|B[CS]|C[CLMSH]|D[FG]|G[TR]|HG|JC|M[CNS]|N[ETL]|OC|PL|Q[TR]|S[PLR]|T[CSL]|VZ|YN|ZS)[B-DF-HJ-NP-TV-Z]{3}[A-Z\\d])(\\d)$")
    private String curp;

    private Boolean status = true;
    @NotEmpty
    private String gender;

    private User user;

    //Profee
    public Person getPerson(){
        return new Person(
                getId(),
                getName(),
                getSurname(),
                getLastname(),
                getBirthday(),
                getCurp(),
                getStatus(),
                getGender(),
                getUser()
        );
    }
}