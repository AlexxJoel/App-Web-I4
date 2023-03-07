package com.example.firstapp.services.person;

import com.example.firstapp.models.person.Person;
import com.example.firstapp.models.person.PersonRepository;
import com.example.firstapp.models.user.User;
import com.example.firstapp.models.user.UserRepository;
import com.example.firstapp.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class PersonService {
    @Autowired
    private PersonRepository repository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    UserRepository userRepository;

    //Consulta
    @Transactional(readOnly = true)
    public CustomResponse<List<Person>> getAll(){
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<Person> getOne(long id){
        boolean exists = this.repository.existsById(id);
        if(exists){
            return new CustomResponse<>(
                    this.repository.findById(id).get(),
                    false,
                    200,
                    "OK"
            );
        } else {
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "There is no person with this id"
            );
        }
    }

    //Creación
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Person> create(Person person){
        return new CustomResponse<>(
                this.repository.save(person),
                false,
                200,
                "Person created"
        );
    }
    //-----------------Profeeee----------------------------------

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Person> insert(Person person){
        Optional<Person> exists = Optional.ofNullable(this.repository.findByCurp(person.getCurp()));
        if(exists.isPresent()){
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "This person already exists"
            );
        }
        User userExists = this.userRepository.findOneByUsername(person.getUser().getUsername());
        if(userExists != null){
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "This user already exists"
            );
        }
        person.getUser().setPassword(
                encoder.encode(person.getUser().getPassword())
        );
        return new CustomResponse<>(
                this.repository.saveAndFlush(person),
                false,
                200,
                "Person created"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Person> delete (long id) {
        boolean exists = this.repository.existsById(id);
        if(exists){
            this.repository.deleteById(id);
            return new CustomResponse<>(
                    null,
                    false,
                    200,
                    "Person deleted"
            );
        }
        return new CustomResponse<>(
                null,
                true,
                400,
                "Person not found"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Person> update (Person person){
        if(!this.repository.existsById(person.getId()))
            return new CustomResponse<>(
                    null, true,400, "La persona no existe"
            );
        return new CustomResponse<>(
                this.repository.saveAndFlush(person),
                false, 200, "Persona actualizada correctamente"
        );
    }
}
