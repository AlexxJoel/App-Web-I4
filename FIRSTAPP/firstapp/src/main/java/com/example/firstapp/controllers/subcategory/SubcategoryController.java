package com.example.firstapp.controllers.subcategory;

import com.example.firstapp.controllers.subcategory.dto.SubcategoryDto;
import com.example.firstapp.models.subcategory.Subcategory;
import com.example.firstapp.services.subcategory.SubcategoryService;
import com.example.firstapp.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-firstapp/subcategory")
@CrossOrigin(origins = {"*"})
public class SubcategoryController {

    @Autowired
    private SubcategoryService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Subcategory>>> getAll() {
        return new ResponseEntity<>(    
                this.service.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Subcategory>> getOne(@PathVariable long id) {
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Subcategory>> insert(@Valid @RequestBody SubcategoryDto subcategory) {
        return new ResponseEntity<>(
                this.service.insert(subcategory.toSubcategory()),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<CustomResponse<Subcategory>> update(@Valid @RequestBody SubcategoryDto subcategory) {
        return new ResponseEntity<>(
                this.service.update(subcategory.toSubcategory()),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse<Subcategory>> delete(@PathVariable long id) {
        return new ResponseEntity<>(
                this.service.delete(id),
                HttpStatus.OK
        );
    }
}
