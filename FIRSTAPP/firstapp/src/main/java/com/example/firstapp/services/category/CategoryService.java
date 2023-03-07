package com.example.firstapp.services.category;

import com.example.firstapp.models.category.Category;
import com.example.firstapp.models.category.CategoryRepository;
import com.example.firstapp.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Category>> getAll() {
        return new CustomResponse<>(
                this.repository.findAll(),
                false, 200, "Ok"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<Category> getOne(Long id) {
        boolean exists = this.repository.existsById(id);
        if (exists) {
            return new CustomResponse<>(
                    this.repository.findById(id).get(),
                    false, 200, "Ok"
            );
        } else {
            return new CustomResponse<>(
                    null, true, 400, "No existe la categoria"
            );
        }
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Category> insert (Category category){
        if(this.repository.existsByName(category.getName()))
            return new CustomResponse<>(
                    null, true,400, "La cataegoria ya existe"
            );
        return new CustomResponse<>(
                this.repository.saveAndFlush(category),
                false, 200, "Categoria registrda correctamente"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Category> delete (long id){
        boolean exists = this.repository.existsById(id);
        if (exists) {
            this.repository.deleteById(id);
            return new CustomResponse<>(
                    null, false, 200, "Categoria eliminada correctamente"
            );
        } else {
            return new CustomResponse<>(
                    null, true, 400, "No existe la categoria"
            );
        }
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Category> update (Category category){
        if(!this.repository.existsById(category.getId()))
            return new CustomResponse<>(
                    null, true,400, "La cataegoria no existe"
            );
        return new CustomResponse<>(
                this.repository.saveAndFlush(category),
                false, 200, "Categoria actualizada correctamente"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Boolean> changeStatus (Category category){
        if(!this.repository.existsById(category.getId()))
            return new CustomResponse<>(
                    null, true,400, "La categoria no existe"
            );
        return new CustomResponse<>(
                this.repository.updateStatusById(category.getStatus(), category.getId()),
                false, 200, "Categoria actualizada correctamente"
        );
    }

}
