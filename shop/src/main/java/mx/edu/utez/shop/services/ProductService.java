package mx.edu.utez.shop.services;


import mx.edu.utez.shop.model.Product;
import mx.edu.utez.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> listProduct(){
        return  productRepository.findAll();
    }

    public Optional<Product> getProduct(int idProduct){
        return productRepository.findById(idProduct);
    }

    public  void save(Product torre){
        productRepository.save(torre);
    }

    public void deleteProduct(int idProduct){
        productRepository.deleteById(idProduct);
    }

    public boolean existsByIdProduct(int idProduct){
        return productRepository.existsById(idProduct);
    }

//    public Optional<Product> getByNombreProduct(String nombre){
//        return productRepository.findByNombreProduct(nombre);
//    }
//
//    public boolean existsByNombreProduct(String nombreProduct){
//        return productRepository.existsByNombreProduct(nombreProduct);
//    }
}
