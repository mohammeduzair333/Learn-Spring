package com.example.databasedemo;

import com.example.databasedemo.models.ID;
import com.example.databasedemo.models.Notes;
import com.example.databasedemo.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DatabasedemoApplication {


    /**
     * notes app 2 fileds ---->text and time
     * get 1 notes
     * get all notes
     * create all note
     * delete 1 notes
     * delete all notes
     * Update notes
     * epoch
     **/
    public static void main(String[] args) {
        SpringApplication.run(DatabasedemoApplication.class, args);

    }


}

