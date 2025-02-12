package com.example.firstSpringProject.controller;

import com.example.firstSpringProject.dto.MemberForm;
import com.example.firstSpringProject.entity.Member;
import com.example.firstSpringProject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j

public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members/new")
    public String newMembers() {
        return "members/new";
    }

    @PostMapping("/members/create")
    public String createMembers(MemberForm form) {
//        dto를 entity로 이동
        Member member = form.toEntity();
//        이동한 entity와 껍데기 entity 동기화
        Member saved = memberRepository.save(member);
//        entity db에 저장
        return "redirect:/members/"+ saved.getId();
    }

//      show index 객체 만들기

    @GetMapping("/members/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        log.info("id : {}", id);
//      db 에서 데이터 확인
        Member memberEntity = memberRepository.findById(id).orElse(null);
        log.info("db에서 가져온 데이터는 : {}", memberEntity);
        model.addAttribute("member", memberEntity);
        return "members/show";
    }

    @GetMapping("/members")
    public String index(Model model) {
        List<Member> memberEntityList = memberRepository.findAll();
        model.addAttribute("member",memberEntityList);
        return "members/index";
    }
}
