package com.example.firstapp.models.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(
            value = "UPDATE categories SET status = :status WHERE id = :id",
            nativeQuery = true
    )
    boolean updateStatusById(
            @Param("status") Boolean status,
            @Param("id") Long id);

    boolean existsByName(String name);

//    @Query(
//            value =" UPDATE categories SET name = :name SET status = :status WHERE id = :id",
//            nativeQuery = true
//    )
//    Category updateById(
//            @Param("id") Long id,
//            @Param("name") String name,
//            @Param("status") Boolean status
//    );

}
