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
        return noteRepository.save(new Note(noteDto.getBody(), noteDto.getUserId()));
    }

    public Note updateNote(NoteDto noteDto) {
        if (!noteRepository.existsById(noteDto.getId())) {
            return noteRepository.save(new Note(noteDto.getBody(), noteDto.getUserId()));
        }
        Note note = noteRepository.getNoteById(noteDto.getId());
        note.setBody(noteDto.getBody());
        note.setUserId(noteDto.getUserId());
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
