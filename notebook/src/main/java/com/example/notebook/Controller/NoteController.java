package com.example.notebook.Controller;

import com.example.notebook.Client.MessageClient;
import com.example.notebook.DTO.Note;
import com.example.notebook.Repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/notes")
public class NoteController {

    @Autowired
    private NotesRepository repository;
    @Autowired
    private MessageClient messageClient;

    @Autowired
    public NoteController(NotesRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public Mono<Integer> createMessage(@RequestBody Note noteRequest) {

        // make SOAP external client call
        messageClient.saveMessage(noteRequest.getMessage());

        // this will be Mono return type so that it's asynchronous
        // Make call to Model layer to store in database

        var savedEntity = repository.save(noteRequest);

        return savedEntity.map(Note::getId);
    }

    @GetMapping("/getById")
    public Mono<Note> getMessageById(@RequestParam Integer id) {


        var retrievedEntity = repository.findById(id);

        return retrievedEntity;
    }

}
