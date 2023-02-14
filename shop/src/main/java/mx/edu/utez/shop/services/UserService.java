package mx.edu.utez.shop.services;


import mx.edu.utez.shop.model.User;
import mx.edu.utez.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {


    @Autowired
    UserRepository userRepository;
    public List<User> listUser(){
        return  userRepository.findAll();
    }

    public Optional<User> getUser(int idUser){
        return userRepository.findById(idUser);
    }

    public  void save(User torre){
        userRepository.save(torre);
    }

    public void deleteUser(int idUser){
        userRepository.deleteById(idUser);
    }

    public boolean existsByIdUser(int idUser){
        return userRepository.existsById(idUser);
    }

        public Optional<User> getByNombreUser(String nombre){
        return userRepository.findByNameUser(nombre);
    }

    public boolean existsByNombreUser(String nombreUser){
        return userRepository.existsByNameUser(nombreUser);
    }




}
