package ru.myproj.noteservice.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.myproj.noteservice.models.Note;
import ru.myproj.noteservice.models.dtos.NoteDto;
import ru.myproj.noteservice.services.NoteService;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/notes")
@Log
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping
    public List<Note> findAll() {
        return noteService.findAll();
    }

    @GetMapping("/{noteId}")
    public Note findANote(@PathVariable BigInteger noteId){
        return noteService.getById(noteId);
    }

    @GetMapping("/user/{userId}")
    public List<Note> findAllByUserId(@PathVariable BigInteger userId){
        return noteService.getAllByUserId(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Note addNote(@RequestBody NoteDto notedto) {
        return noteService.addNote(notedto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Note updateNote(@RequestBody Note note) {
        return noteService.updateNote(note);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteANote(@RequestParam BigInteger noteId) {
        noteService.deleteOne(noteId);
    }

    @DeleteMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllByUserId(@RequestParam BigInteger userId) {
        noteService.deleteAllByUserId(userId);
    }

    //deprecated
    @DeleteMapping("/flush_all")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAll() {
        noteService.deleteAll();
    }

}
