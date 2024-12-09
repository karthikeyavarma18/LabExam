package com.klu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mysql.cj.xdevapi.JsonString;

@RestController
@CrossOrigin
public class AppController {
	@Autowired
	DAO dao;
  
  @GetMapping("/welcome")
  public String fun1() {
    return "Welcome to Controller";
  }
  
  //localhost:8080/springmvc4/call/balajee
  @GetMapping("/call/{name}")
  public String fun2(@PathVariable("name") String name) {
    return "Welcome " + name;
  }
  
  //localhost:8080/springmvc4/call?n1=balajee&class=m206
  @GetMapping("/call")
  public String fun3(@RequestParam("n1") String name, @RequestParam("class") String cname) {
    return "Welcome " + name + " in " + cname;
  }
  
  //localhost:8080/springmvc4/form
  @PostMapping("/form")
  public String fun4(@RequestBody String s) {
    System.out.println(s);
    Student s1 = new Gson().fromJson(s, Student.class);
    dao.insert(s1);
    System.out.println("Inserted Data");
    return "Inserted Data";
  }
  
  //localhost:8080/springmvc4/form
  @GetMapping("/form")
  public String fun5(@RequestParam("id") int id) {
	List<Student> l= dao.retrieve();
    return "" +l;
  }
  
  //localhost:8080/springmvc4/form
  @PutMapping("/form")
  public String fun6(@RequestBody String s) {
    Student s1 = new Gson().fromJson(s, Student.class);
    dao.update(s1);
    return "Updated Data";
  }
  
  //localhost:8080/springmvc4/form
  @DeleteMapping("/form")
  public String fun7(@RequestParam("id") int id) {
	dao.delete(id);
    return "delete maaping id = " + id;
  }
    
}