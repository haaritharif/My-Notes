package com.example.notebook.Repository;

import com.example.notebook.DTO.Note;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface NotesRepository extends ReactiveCrudRepository<Note, Long> {

    Mono<Note> findById(Integer id);
}
