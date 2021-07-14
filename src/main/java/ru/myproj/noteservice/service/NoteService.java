package ru.myproj.noteservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.myproj.noteservice.exception.NoteNotFoundException;
import ru.myproj.noteservice.model.Note;
import ru.myproj.noteservice.model.dto.NoteDTO;
import ru.myproj.noteservice.repository.NoteRepository;

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

    public Note findById(BigInteger noteId) {
        return noteRepository.findById(noteId).orElseThrow(() -> new NoteNotFoundException("Note with id: " + noteId + " not found"));
    }

    public List<Note> getAllByUserId(BigInteger userId) {
        return noteRepository.getAllByUserId(userId);
    }

    public Note addNote(NoteDTO noteDTO) {
        return noteRepository.save(new Note(noteDTO.getBody(), noteDTO.getUserId()));
    }

    public Note updateNote(NoteDTO noteDTO) {
        Note note;
        try {
            note = findById(noteDTO.getId());
        }
        catch (NoteNotFoundException e) {
            return addNote(noteDTO);
        }
        note.setBody(noteDTO.getBody());
        note.setUserId(noteDTO.getUserId());
        return noteRepository.save(note);
    }

    public void deleteNote(BigInteger noteId) {
        noteRepository.deleteById(noteId);
    }

    public void deleteAllByUserId(BigInteger userId) {
        noteRepository.deleteAllByUserId(userId);
    }

    public void deleteAll() {
        noteRepository.deleteAll();
    }
}
