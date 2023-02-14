package mx.edu.utez.shop.controller;

import mx.edu.utez.shop.dto.ProductDto;
import mx.edu.utez.shop.model.Product;
import mx.edu.utez.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api-shop/product/")
@CrossOrigin(origins = {"*"})

public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ResponseEntity<List<Product>> listProducts(){
        List<Product> products = productService.listProduct();
        return  new ResponseEntity<List<Product>>(products, HttpStatus.OK);

    }

}
