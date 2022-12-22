package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    //@GetMapping("/my-customer")
//    public Customer getMyName() {
//        Customer c=new Customer("mohammeduzair@gmaul.com","uzair222");
//        return c;
//    }
    @PostMapping("/my-order")
    public Bill PostMyOrder(@RequestBody Bill bill) {
        Bill i = new Bill("Pizza", 2, 300* bill.quantity);
         return i;


    }

}

