package ru.myproj.noteservice.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.myproj.noteservice.models.Note;

import java.math.BigInteger;
import java.util.List;

public interface NoteRepository extends MongoRepository<Note, Integer> {

    Note getNoteById(BigInteger id);
    List<Note> getAllByUserId(BigInteger userId);
    boolean existsById(BigInteger id);
    void deleteById(BigInteger id);
    void deleteAllByUserId(BigInteger userId);
}
