package ru.myproj.noteservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.myproj.noteservice.models.Note;
import ru.myproj.noteservice.models.dtos.NoteDto;
import ru.myproj.noteservice.repos.NoteRepository;

import java.math.BigInteger;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    public Note getById(BigInteger noteId) {
        return noteRepository.getNoteById(noteId);
    }

    public List<Note> getAllByUserId(BigInteger userId) {
        return noteRepository.getAllByUserId(userId);
    }

    public Note addNote(NoteDto noteDto) {
        Note newNote = new Note(noteDto.getNoteBody(), noteDto.getNoteUserId());
        log.info("Created new Note: " + newNote);
        return noteRepository.save(newNote);
    }

    //не понимаю как здесь нормально сделать, возможно нужен адаптер для Note - NoteDto
    public Note updateNote(Note note) {
        if (!noteRepository.existsById(note.getId())) {
            Note newNote = new Note(note.getBody(), note.getUserId());
            log.info("Created new Note: " + newNote);
            return noteRepository.save(newNote);
        }
        log.info("Note with ID: " + note.getId() +" has been updated");
        return noteRepository.save(note);
    }

    public void deleteOne(BigInteger noteId) {
        noteRepository.deleteById(noteId);
    }

    public void deleteAllByUserId(BigInteger userId) {
        noteRepository.deleteAllByUserId(userId);
    }

    public void deleteAll() {
        noteRepository.deleteAll();
    }
}
