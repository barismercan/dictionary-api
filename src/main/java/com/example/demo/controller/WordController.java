package com.example.demo.controller;


import com.example.demo.entity.Word;
import com.example.demo.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo")
@Validated
public class WordController {

        @Autowired
        private WordRepository wordRepository;



        @GetMapping(path="/all")
        public @ResponseBody
        Iterable<Word> getAllWords() {
            return wordRepository.findAll();
        }
        @PostMapping(path="/add")
        public @ResponseBody String createWord(@RequestBody Word word) {
            Word create=new Word();
            if(!wordRepository.equals(word.getEn())) {
                 create = word;

                wordRepository.save(create);
                ResponseEntity.ok().build();
                System.out.println("Kaydedildi");
            }

            return "hey";
        }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Integer id) {
        wordRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }}

