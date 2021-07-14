package ru.myproj.noteservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.myproj.noteservice.model.Note;

import java.math.BigInteger;
import java.util.List;

public interface NoteRepository extends MongoRepository<Note, BigInteger> {

    List<Note> getAllByUserId(BigInteger userId);
    boolean existsById(BigInteger id);
    void deleteById(BigInteger id);
    void deleteAllByUserId(BigInteger userId);
}
