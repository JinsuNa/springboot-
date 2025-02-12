package com.example.firstSpringProject.repository;

import com.example.firstSpringProject.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface MemberRepository extends CrudRepository<Member,Long> {
    @Override
    ArrayList<Member> findAll();
}
