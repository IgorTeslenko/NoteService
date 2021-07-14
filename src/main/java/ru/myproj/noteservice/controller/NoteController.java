package ru.myproj.noteservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.myproj.noteservice.model.Note;
import ru.myproj.noteservice.model.dto.NoteDTO;
import ru.myproj.noteservice.service.NoteService;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Note addNote(@RequestBody NoteDTO notedto) {
        return noteService.addNote(notedto);
    }

    @GetMapping
    public List<Note> findAll() {
        return noteService.findAll();
    }

    @GetMapping("/{noteId}")
    public Note findANote(@PathVariable BigInteger noteId){
        return noteService.findById(noteId);
    }

    @GetMapping("/user/{userId}")
    public List<Note> findAllByUserId(@PathVariable BigInteger userId){
        return noteService.getAllByUserId(userId);
    }

    @PutMapping
    public Note updateNote(@RequestBody NoteDTO noteDto) {
        return noteService.updateNote(noteDto);
    }

    @DeleteMapping
    public void deleteNote(@RequestParam BigInteger noteId) {
        noteService.deleteNote(noteId);
    }

    @DeleteMapping("/user")
    public void deleteAllByUserId(@RequestParam BigInteger userId) {
        noteService.deleteAllByUserId(userId);
    }

    //для отладки, чтобы быстро базу очищать
    @DeleteMapping("/flush_all")
    public void deleteAll() {
        noteService.deleteAll();
    }

}
