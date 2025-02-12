package com.example.firstSpringProject.repository;

import com.example.firstSpringProject.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article, Long> { //entity를 db에 저장할 거니까 entity의 이름인 Article을 넣는다.


    @Override
    ArrayList<Article> findAll();
}
