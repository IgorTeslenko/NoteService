package ru.myproj.noteservice.models.dtos;

import lombok.Data;

import java.math.BigInteger;

@Data
public class NoteDto {
    private BigInteger id;
    private String body;
    private BigInteger userId;
}
