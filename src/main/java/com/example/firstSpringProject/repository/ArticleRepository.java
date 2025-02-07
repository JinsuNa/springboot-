package com.example.firstSpringProject.repository;

import com.example.firstSpringProject.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
