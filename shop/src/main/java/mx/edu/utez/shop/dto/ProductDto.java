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
public class ProductDto {

    private Integer id;
    private String name;
    private Double  price;
    private Boolean availability;
    private List<Transaction> transactionList;
}
