package com.example.firstapp.controllers.person;

import com.example.firstapp.controllers.person.dtos.PersonDto;
import com.example.firstapp.models.person.Person;
import com.example.firstapp.services.person.PersonService;
import com.example.firstapp.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-firstapp/person")
@CrossOrigin(origins = {"*"})
public class PersonController {

    //http://localhost:8080/api-firstapp/person/
    @Autowired
    private PersonService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Person>>>
        getAll(){
            return new ResponseEntity<>(
                    this.service.getAll(),
                    HttpStatus.OK
            );
        }

        @GetMapping("/{id}")
        public ResponseEntity<CustomResponse<Person>> getOne(@PathVariable long id){
            return new ResponseEntity<>(
                    this.service.getOne(id),
                    HttpStatus.OK
            );
        }

        //Yo
        @RequestMapping(value = "/create", method = RequestMethod.POST)
        public ResponseEntity<CustomResponse<Person>> create(@RequestBody Person person){
            return new ResponseEntity<>(
                    this.service.create(person),
                    HttpStatus.CREATED
            );

        }


        //Profee
    @PostMapping("/")
    public ResponseEntity<CustomResponse<Person>> insert (
           @Valid @RequestBody PersonDto person
            ){
        return new ResponseEntity<>(
                this.service.insert(person.getPerson()),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}") //Funciona pa
    public ResponseEntity<CustomResponse<Person>> delete(@PathVariable long id){
        return new ResponseEntity<>(
                this.service.delete(id),
                HttpStatus.OK
        );
    }

    @PutMapping("/")
    public ResponseEntity<CustomResponse<Person>> update (@Valid @RequestBody PersonDto person){
        return new ResponseEntity<>(
                this.service.update(person.getPerson()),
                HttpStatus.OK
        );
      }












}
