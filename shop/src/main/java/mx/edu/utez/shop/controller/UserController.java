package mx.edu.utez.shop.controller;


import mx.edu.utez.shop.dto.Message;
import mx.edu.utez.shop.dto.UserDto;
import mx.edu.utez.shop.model.Transaction;
import mx.edu.utez.shop.model.User;
import mx.edu.utez.shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-shop/user/")
@CrossOrigin(origins = {"*"})
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<User>> listUser(){
        List<User> users = userService.listUser();
        return  new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }



    @GetMapping("/getUser/{idUser}")
    public ResponseEntity<User> userById(@PathVariable("idUser") int idUser){

        if (userService.existsByIdUser(idUser))
            return new ResponseEntity(new Message("No existe rl usuario"), HttpStatus.NOT_FOUND);

        User user = userService.getUser(idUser).get();
        return new ResponseEntity(user, HttpStatus.OK);
    }


    @PostMapping("/insert")
    public ResponseEntity<?> insertUser(@RequestBody UserDto userDto){

        if(StringUtils.isEmpty(userDto.getFullName()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);


        User user = new User(userDto.getFullName(), userDto.getEmail(), userDto.getPassword(), userDto.getWishList());
        userService.save(user);
        return new ResponseEntity(new Message("Usuario creada"), HttpStatus.OK);
    }


    @PutMapping("/update/{idUser}")
    public ResponseEntity<?> updateUser(@PathVariable("idUser") int idUser, @RequestBody UserDto userDto){

        if (userService.existsByIdUser(idUser))
            return new ResponseEntity(new Message("No existe "), HttpStatus.NOT_FOUND);


        User user = userService.getUser(idUser).get();
        user.setEmail( userDto.getEmail());
        user.setFullName(userDto.getFullName());
        user.setPassword(userDto.getPassword());
        user.setWishList(userDto.getWishList());
        userService.save(user);
        return new ResponseEntity(new Message("Usuarip actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idUser}")
    public ResponseEntity<?> deleteUser(@PathVariable("idUser") int idUser){
        if (userService.existsByIdUser(idUser))
            return new ResponseEntity(new Message("No existe el usuario"), HttpStatus.NOT_FOUND);

        userService.deleteUser(idUser);
        return new ResponseEntity(new Message("usuario eliminado"), HttpStatus.OK);
    }
}
