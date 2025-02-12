package com.example.firstSpringProject.dto;

import com.example.firstSpringProject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private String title;
    private String content;

//    public ArticleForm(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }  @AllArgsConstructor 으로 인한 생략 가능

//    @Override
//    public String toString() {
//        return "ArticleForm{" +
//                "title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    } @ToString 으로 인한 생략가능 하지만 toString을 커스텀을 하고싶을때는 수동으로 해야한다.

    public Article toEntity() {  //entity article에 있는 폼데이터를 담은 dto객체를 엔티티로 반환 전달값은 article 클래스의 생성자 형식에 맞춘다.
        return new Article(null, title, content); //entity인 article과 form data를 맞출려고

    }
}
