package com.example.demo.repository;

import com.example.demo.entity.Word;
import org.springframework.data.repository.CrudRepository;

public interface WordRepository extends CrudRepository<Word,Integer> {
}
