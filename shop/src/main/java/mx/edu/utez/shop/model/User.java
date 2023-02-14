package mx.edu.utez.shop.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true,nullable = false,length = 400)
    private String fullName;


    @Column(unique = true,nullable = false,length = 400)
    private String email;

    @Column(unique = true,nullable = false,length = 400)
    private String password;

    @Column(unique = true,nullable = false, columnDefinition = "TEXT")
    private String  wishList;


    @OneToMany(mappedBy = "user")
    private List<Transaction> transactionList;

    public User(String fullName, String email, String password, String wishList) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.wishList = wishList;
    }
}
