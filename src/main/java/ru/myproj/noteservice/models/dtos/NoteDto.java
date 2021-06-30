package ru.myproj.noteservice.models.dtos;

import lombok.Data;

import java.math.BigInteger;

@Data
public class NoteDto {
    private BigInteger noteId;
    private String noteBody;
    private BigInteger noteUserId;
}
