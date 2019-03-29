package com.softvision.mongodb.controller;

import com.softvision.mongodb.model.Person;
import com.softvision.mongodb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;


    @RequestMapping(value="/create" ,method = RequestMethod.GET)
    public String create(@RequestParam String firstName,@RequestParam String lastname,@RequestParam int age){
        Person p = personService.create(firstName,lastname,age);
        System.out.println();
        return p.toString();
    }

    @RequestMapping("/get")
    public Person getPerson(@RequestParam String firstName){
       return personService.getByFirstName(firstName);

    }

    @RequestMapping("/getAll")
    public List<Person> getAll(){
        return personService.getAll();
    }

    @RequestMapping("/update")
    public String  update(@RequestParam String firstName,@RequestParam String lastName,@RequestParam int age){
        Person p = personService.update(firstName,lastName,age);
        return p.toString();
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String firstName){
        personService.deleteByFirstName(firstName);
        return "deleted"+" "+firstName;
    }

    @RequestMapping("/deleteAll")
    public String deleteAll(){
        personService.deleteAll();
        return "deleted all records";
    }

//    public String set(){
//        personService.getAll()
//    }


}
