package mx.edu.utez.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.shop.model.Transaction;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private Integer id;
    private String fullName;


    private String email;

    private String password;

    private String  wishList;

    private List<Transaction> transactionList;
}
