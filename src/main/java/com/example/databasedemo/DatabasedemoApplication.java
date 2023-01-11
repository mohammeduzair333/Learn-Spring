package com.example.databasedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
public class DatabasedemoApplication {
    @Autowired
    NotesRepository notesRepository;

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

    @PostMapping("save-note")
    public Notes saveNote(@RequestBody Notes note) {
        //create note object with text and current time.
        Notes n = new Notes(note.getText(), System.currentTimeMillis());
        //saving the note to the database
        notesRepository.save(n);
        // getting the notes as a response
        return n;

    }

    @GetMapping("get-notes")
    public List<Notes> getNotes() {
        //getting all the notes from the database

        return notesRepository.findAll();

    }

    @GetMapping("get-note")
    public Notes getNote(@RequestBody Notes singleNote){
        Optional<Notes> n=notesRepository.findById(singleNote.getTextlineno());
        if(n.isPresent()){
           // notesRepository.save(n.get());
            return n.get();
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }


    @DeleteMapping("deleteAll")
    public String deleteAll() {
        //deleting all the notes present in the database
        notesRepository.deleteAll();
        //giving the user success message
        return "deleted successufully";
    }


    @DeleteMapping ("delete-singlenotes")
    public String delete(TextLine lineno) {
        //getting single note from database using id
        Optional<Notes> s = notesRepository.findById(lineno.getTextlineno());
        //checking if the note is present in the optional or not
        if (s.isPresent()) {
            //deleting the single note from the database
            notesRepository.delete(s.get());
            //giving the success message
            return "deleted";
        }
        //returning failure message
        return "not deleted";


    }

    @PatchMapping ("update-note")
    public String updateNotes(@RequestBody Notes requestNote) {
        // get single note from database using id
        Optional<Notes> note = notesRepository.findById(requestNote.getTextlineno());
        //check if note is present in optional
        if (note.isPresent()) {
            //get note from optional
            Notes n = note.get();
            //update text of note from request note (variable n)
            n.setText(requestNote.getText());
            //saving the note to the database
            notesRepository.save(n);

            return "updated";
        }
        return "not updated";
    }

}

