package com.example.restapi.Controller;

import com.example.restapi.entity.Cat;
import com.example.restapi.repository.CatRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.xml.transform.sax.SAXResult;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {
    private final CatRepository catRepository;
    private final ObjectMapper objectMapper;


    @PostMapping("/api/add")
    public void addCat(@RequestBody Cat cat) {
        log.info("New row :" + catRepository.save(cat));
    }

    @SneakyThrows
    @GetMapping("/api/all")
    public List<Cat> getAll () {
        return catRepository.findAll();
    }

    @GetMapping("/api")
    public Cat getCat(@RequestParam int id) {
        return catRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/api")
    public void deleteCat(@RequestParam int id) {
        catRepository.deleteById(id);
    }

    @PutMapping("/api/put")
    public String changeCat(@RequestBody Cat cat) {
        if (!catRepository.existsById(cat.getId())){
            return "No such row";
        }
       return catRepository.save(cat).toString();
    }
}
