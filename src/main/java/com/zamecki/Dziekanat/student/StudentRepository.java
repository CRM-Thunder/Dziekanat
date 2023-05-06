package com.zamecki.Dziekanat.student;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository("mongodb")
public interface StudentRepository extends MongoRepository<Student, ObjectId> {
    public List<Student> findAll();
    public Optional<Student> findByPesel(String pesel);
    public Optional<Student> findByIndexNumber(String indexNumber);
    public List<Student> findAllByName(String name);
    public List<Student> findAllBySurname(String surname);
    public List<Student> findAllByNationality(String nationality);
    public List <Student> findAllByIsMale(Boolean isMale);
    public Optional<Student> findByEmail(String email);
    public Optional<Student> findByPhoneNumber(String phoneNumber);
    //TODO obsluzyc request z wyszukaniem uzytkownikow z danego kierunku
}
