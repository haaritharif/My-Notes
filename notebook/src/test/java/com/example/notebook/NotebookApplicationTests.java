package com.example.notebook;

import com.example.notebook.Controller.NoteController;
import com.example.notebook.DTO.Note;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

@SpringBootTest
class NotebookApplicationTests {

	@Autowired
	NoteController noteController;

	void setupClient() {
		when(noteController.createMessage(any(Note.class)))
				.thenReturn(Mono.empty());
	}

	@Test
	void testCreateMessage() {
		setupClient();

		var response = noteController.createMessage(new Note(1, "this is a test note"));

		assertNotNull(response);
	}

}
