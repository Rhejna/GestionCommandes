package com.example.demo.repository;

import com.example.demo.classes.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepo extends JpaRepository<Article, Long>{
    @Query(value = "SELECT * FROM article Where reference=:ref",nativeQuery = true)
    Article articleGetByReference(String ref);

    @Query(value = "SELECT u FROM Article u WHERE u.reference = :ref")
    Article getByRef(String ref);

    Article findByReference(String reference);


}
