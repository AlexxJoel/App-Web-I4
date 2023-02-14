package mx.edu.utez.shop.controller;

import mx.edu.utez.shop.model.Product;
import mx.edu.utez.shop.model.Transaction;
import mx.edu.utez.shop.services.ProductService;
import mx.edu.utez.shop.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api-shop/transaction/")
@CrossOrigin(origins = {"*"})


public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/")
    public ResponseEntity<List<Transaction>> listProducts(){
        List<Transaction> transaction = transactionService.listTransaction();
        return  new ResponseEntity<List<Transaction>>(transaction, HttpStatus.OK);

    }
}
