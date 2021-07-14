package ru.myproj.noteservice.exception;

import java.io.IOException;

public class NoteNotFoundException extends RuntimeException {
    public NoteNotFoundException(String message) {
        super(message);
    }
}
