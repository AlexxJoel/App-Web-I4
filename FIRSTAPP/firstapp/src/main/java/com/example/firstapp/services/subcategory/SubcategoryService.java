package com.example.firstapp.services.subcategory;

import com.example.firstapp.models.subcategory.Subcategory;
import com.example.firstapp.models.subcategory.SubcategoryRepository;
import com.example.firstapp.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SubcategoryService {

    @Autowired
    private SubcategoryRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Subcategory>> getAll() {
        return new CustomResponse<>(
                repository.findAll(), false, 200, "OK"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<Subcategory> getOne(Long id) {
        boolean exists = this.repository.existsById(id);
        if (exists) {
            return new CustomResponse<>(
                    this.repository.findById(id).get(), false, 200, "OK"
            );
        } else {
            return new CustomResponse<>(
                    null, true, 400, "There is no subcategory with this id"
            );
        }
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Subcategory> insert(Subcategory subcategory) {
        Optional<Subcategory> exists = this.repository.findById(subcategory.getId());
        if (exists.isPresent()) {
            return new CustomResponse<>(
                    null, true, 400, "There is already a subcategory with this id"
            );
        } else {
            return new CustomResponse<>(
                    this.repository.saveAndFlush(subcategory), false, 200, "OK"
            );
        }
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Subcategory> update(Subcategory subcategory) {
        boolean exists = this.repository.existsById(subcategory.getId());
        if (exists) {
            return new CustomResponse<>(
                    this.repository.saveAndFlush(subcategory), false, 200, "OK"
            );
        } else {
            return new CustomResponse<>(
                    null, true, 400, "There is no subcategory with this id"
            );
        }
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Subcategory> delete(long id) {
        boolean exists = this.repository.existsById(id);
        if (exists) {
            this.repository.deleteById(id);
            return new CustomResponse<>(
                    null, false, 200, "OK"
            );
        } else {
            return new CustomResponse<>(
                    null, true, 400, "There is no subcategory with this id"
            );
        }
    }
}
