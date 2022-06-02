package com.example.notebook;

import com.example.notebook.DTO.Note;
import com.example.notebook.Repository.NotesRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

@SpringBootApplication
public class NotebookApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotebookApplication.class, args);
	}


	@Bean
	ApplicationRunner init(NotesRepository repository, DatabaseClient client) {
		return args -> {
			client.sql("create table IF NOT EXISTS NOTE" +
					"(id SERIAL PRIMARY KEY, message varchar (255) not null);").fetch().first().subscribe();
			client.sql("DELETE FROM NOTE;").fetch().first().subscribe();

			Stream<Note> stream = Stream.of(new Note(0, "Hi this is my first note!"),
					new Note(1, "Here is another note"),
					new Note(2, "Add this one too"));

			// initialize the database

			repository.saveAll(Flux.fromStream(stream))
					.then()
					.subscribe(); // execute

		};
	}

}
