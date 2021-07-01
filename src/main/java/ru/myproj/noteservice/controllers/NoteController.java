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
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Note addNote(@RequestBody NoteDto notedto) {
        return noteService.addNote(notedto);
    }

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

    @PutMapping
    public Note updateNote(@RequestBody NoteDto noteDto) {
        return noteService.updateNote(noteDto);
    }

    @DeleteMapping
    public void deleteANote(@RequestParam BigInteger noteId) {
        noteService.deleteOne(noteId);
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
