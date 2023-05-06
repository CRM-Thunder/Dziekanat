package com.zamecki.Dziekanat.student;

import com.zamecki.Dziekanat.student.dto.RequestResponseDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public ResponseEntity<String> addStudent(@NotNull RequestResponseDto requestDto){
        studentRepository.save(Student.builder()
                .pesel(requestDto.getPesel())
                .createdAt(new Date())
                .indexNumber(requestDto.getIndexNumber())
                .name(requestDto.getName())
                .surname(requestDto.getSurname())
                .nationality(requestDto.getNationality())
                .isMale(requestDto.getIsMale())
                .email(requestDto.getEmail())
                .phoneNumber(requestDto.getPhoneNumber())
                .fieldsOfStudy(requestDto.getFieldsOfStudy())
                .build());
        return new ResponseEntity<>("Student has been added!", HttpStatus.OK);
    }
    public RequestResponseDto StudentToDto(Student student){
        return  RequestResponseDto.builder()
                .pesel(student.getPesel())
                .indexNumber(student.getIndexNumber())
                .name(student.getName())
                .surname(student.getSurname())
                .nationality(student.getNationality())
                .isMale(student.getIsMale())
                .email(student.getEmail())
                .phoneNumber(student.getPhoneNumber())
                .fieldsOfStudy(student.getFieldsOfStudy())
                .build();
    }
    public RequestResponseDto StudentOptionalToDto(Optional<Student> studentOptional){
        return  RequestResponseDto.builder().pesel(studentOptional.get().getPesel())
                .indexNumber(studentOptional.get().getIndexNumber())
                .name(studentOptional.get().getName())
                .surname(studentOptional.get().getSurname())
                .nationality(studentOptional.get().getNationality())
                .isMale(studentOptional.get().getIsMale())
                .email(studentOptional.get().getEmail())
                .phoneNumber(studentOptional.get().getPhoneNumber())
                .fieldsOfStudy(studentOptional.get().getFieldsOfStudy())
                .build();
    }
    public ResponseEntity<RequestResponseDto> findByPesel(@NotNull String pesel){
        try {
            Optional<Student> studentOptional= Optional.of(studentRepository.findByPesel(pesel).orElseThrow(ChangeSetPersister.NotFoundException::new));
            return new ResponseEntity<>(StudentOptionalToDto(studentOptional),HttpStatus.OK);
        }catch (ChangeSetPersister.NotFoundException err){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<RequestResponseDto> findByIndexNumber(@NotNull String indexNumber){
        try {
            Optional<Student> studentOptional= Optional.of(studentRepository.findByIndexNumber(indexNumber).orElseThrow(ChangeSetPersister.NotFoundException::new));
            return new ResponseEntity<>(StudentOptionalToDto(studentOptional),HttpStatus.OK);
        }catch (ChangeSetPersister.NotFoundException err){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<RequestResponseDto> findByEmail(@NotNull String email){
        try {
            Optional<Student> studentOptional= Optional.of(studentRepository.findByEmail(email).orElseThrow(ChangeSetPersister.NotFoundException::new));
            return new ResponseEntity<>(StudentOptionalToDto(studentOptional),HttpStatus.OK);
        }catch (ChangeSetPersister.NotFoundException err){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<RequestResponseDto> findByPhoneNumber(@NotNull String phoneNumber){
        try {
            Optional<Student> studentOptional= Optional.of(studentRepository.findByPhoneNumber(phoneNumber).orElseThrow(ChangeSetPersister.NotFoundException::new));
            return new ResponseEntity<>(StudentOptionalToDto(studentOptional),HttpStatus.OK);
        }catch (ChangeSetPersister.NotFoundException err){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<RequestResponseDto>> findAllByName(@NotNull String name){
        List<Student> dbStudents=studentRepository.findAllByName(name);
        List<RequestResponseDto> dtoStudents=dbStudents.stream().map(this::StudentToDto).toList();
        if(!dtoStudents.isEmpty()) {
            return new ResponseEntity<>(dtoStudents, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<List<RequestResponseDto>> findAllBySurname(@NotNull String surname){
        List<Student> dbStudents=studentRepository.findAllBySurname(surname);
        List<RequestResponseDto> dtoStudents=dbStudents.stream().map(this::StudentToDto).toList();
        if(!dtoStudents.isEmpty()) {
            return new ResponseEntity<>(dtoStudents, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<List<RequestResponseDto>> findAllByNationality(@NotNull String nationality){
        List<Student> dbStudents=studentRepository.findAllByNationality(nationality);
        List<RequestResponseDto> dtoStudents=dbStudents.stream().map(this::StudentToDto).toList();
        if(!dtoStudents.isEmpty()) {
            return new ResponseEntity<>(dtoStudents, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<List<RequestResponseDto>> findAllByIsMale(Boolean isMale){
        List<Student> dbStudents=studentRepository.findAllByIsMale(isMale);
        List<RequestResponseDto> dtoStudents=dbStudents.stream().map(this::StudentToDto).toList();
        if(!dtoStudents.isEmpty()) {
            return new ResponseEntity<>(dtoStudents, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<List<RequestResponseDto>> findAll(){
        List<Student> dbStudents=studentRepository.findAll();
        List<RequestResponseDto> dtoStudents=dbStudents.stream().map(this::StudentToDto).toList();
        if(!dtoStudents.isEmpty()) {
            return new ResponseEntity<>(dtoStudents, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }


}
