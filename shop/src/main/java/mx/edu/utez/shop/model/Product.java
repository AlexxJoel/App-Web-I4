package mx.edu.utez.shop.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true,nullable = false,length = 200)
    private String name;

    @Column(unique = true,nullable = false,length = 200)
    private Double  price;

    @Column(name = "status",nullable = false,columnDefinition = "tinyint default 1")
    private Boolean availability;



    @OneToMany(mappedBy = "product")
    private List<Transaction> transactionList;



}
