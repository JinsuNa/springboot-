package com.example.firstSpringProject.controller;

import com.example.firstSpringProject.dto.ArticleForm;
import com.example.firstSpringProject.entity.Article;
import com.example.firstSpringProject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/articles")
@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/new")
    public String newArticleForm() {
        return ("articles/new");
    }

    @PostMapping("/create")
    public String createArticle(ArticleForm form) {
        System.out.println(form.toString());
//        1. dto를 entity로 변환
        Article article = form.toEntity();
        System.out.println(article.toString());
//        2. repository로 entity를 db에 저장
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());
        return "";
    }
}
