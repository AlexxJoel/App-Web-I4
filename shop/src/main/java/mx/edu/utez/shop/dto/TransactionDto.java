package mx.edu.utez.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.shop.model.Product;
import mx.edu.utez.shop.model.User;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionDto {
    private Integer id;
    private User user;
    private Product product;

    private String dateSold;

}
