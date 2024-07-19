package ru.maxima.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.maxima.models.Person;
import ru.maxima.repositories.PeopleRepository;

import java.util.List;
import java.util.Random;

@Controller
public class HelloController {

    private final PeopleRepository peopleRepository;

    public HelloController(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello-view";
    }


    @ResponseBody
    @GetMapping("/people")
    public List<Person> getAllPeople(){
        return peopleRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/create")
    public List<Person> createPerson() {
        Person p = new Person();
        Random r = new Random();
        p.setName("User" + r.nextInt(0, 100));
        peopleRepository.save(p);

        return peopleRepository.findAll();
    }
}
