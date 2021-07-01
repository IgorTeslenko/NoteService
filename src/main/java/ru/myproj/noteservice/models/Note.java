package ru.myproj.noteservice.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Data
@RequiredArgsConstructor
@Document(collection = "notes")
public class Note {

    @Id
    private BigInteger id;

    @NonNull
    private String body;

    @NonNull
    private BigInteger userId;
}
