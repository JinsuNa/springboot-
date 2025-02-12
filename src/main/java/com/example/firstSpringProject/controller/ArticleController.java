package com.example.firstSpringProject.controller;

import com.example.firstSpringProject.dto.ArticleForm;
import com.example.firstSpringProject.entity.Article;
import com.example.firstSpringProject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository; //내부에서 사용할거라 선언을 해놓는거다.

    //    private ArticleRepository articleRepository = new ArticleRepositoryImpl()  @Autowired을 사용하면 생략가능하다. 이를 의존성 주입 dependency injection 이라고 한다.
    //    controller 시작
    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create") //form 에서 submit을 누를 때 이용하는 객체.
    public String createArticle(ArticleForm form) { //DTO 에 담기 위해 form객체를 매개변수로 선언
        log.info("form의 값들은 : {}", form.toString());
//        1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        log.info("form을 entity로 변환한 값은 : {}", article.toString());
//        2. 레포지토리로 엔티티를 db에 저장
        Article saved = articleRepository.save(article);
        log.info("엔티티를 db로 저장하는 값은 : {}", saved.toString());
        return "redirect:/articles/" + saved.getId();
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = {}", id);

//        1. id를 조회 후 DB에서 해당 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);

//        2. 가져온 데이터를 모델에 등록하기
        model.addAttribute("article", articleEntity);
//        3. 조회한 데이터를 사용자에게 보여주기 위한 뷰 페이지 반환하기
        return "articles/show";
    }

    @GetMapping("/articles")
    private String index(Model model) {
//        1. 모든 데이터 가져오기
        List<Article> articleEntityList = articleRepository.findAll(); //find all를 하여 데이터를 받을 때 리스트로 받기 때문 형변환을 해야한다.
//        2. 모델에 데이터 등록하기
        model.addAttribute("articleList", articleEntityList);
//        3. 뷰 페이지 설정하기
        return "articles/index";
    }
//    controller 끝
}
