package com.example.databasedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
public class DatabasedemoApplication {
    @Autowired
    NotesRepository notesRepository;
    public static void main(String[] args) {
        SpringApplication.run(DatabasedemoApplication.class, args);

    }


@PostMapping("save-note")
public Notes saveNote(@RequestBody  Notes note){
        Notes n=new Notes(note.getText(),System.currentTimeMillis());
        notesRepository.save(n);
        return n;

}
@GetMapping("get-notes")
    public List<Notes> getNotes(Notes get){
       return notesRepository.findAll();
}


@DeleteMapping("deleteAll")
public String deleteAll(){
        notesRepository.deleteAll();
        return"deleted successufully";
}


@PostMapping("delete-singlenotes")
    public String delete(TextLine lineno){
        Optional<Notes>s=notesRepository.findById(lineno.getTextlineno());
        if(s.isPresent()) {
            notesRepository.delete(s.get());
            return "deleted";
        }
        return "not deleted";


}




}

//notes app   1.2fileds ---->text and time
// get 1 notes
//get all notes
//create all note
//delete 1 notes
//delete all notes
//Update notes
//epoch
