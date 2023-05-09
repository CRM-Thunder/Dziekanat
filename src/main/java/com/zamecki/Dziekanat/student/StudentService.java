package com.zamecki.Dziekanat.student;

import com.zamecki.Dziekanat.exceptions.StudentNotFoundException;
import com.zamecki.Dziekanat.fieldofstudy.FieldOfStudy;
import com.zamecki.Dziekanat.student.dto.StudentReqResDto;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

//TODO Zrobić customowy errorhandler, ControllerAdvice
@Service
@RequiredArgsConstructor
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public ResponseEntity<String> addStudent(@NotNull StudentReqResDto requestDto){
        studentRepository.save(Student.builder()
                .pesel(requestDto.getPesel())
                .createdAt(new Date().toString())
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
    public StudentReqResDto StudentToDto(Student student){
        return  StudentReqResDto.builder()
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
    public StudentReqResDto StudentOptionalToDto(Optional<Student> studentOptional){
        return  StudentReqResDto.builder().pesel(studentOptional.get().getPesel())
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
    public ResponseEntity<StudentReqResDto> findByPesel(@NotNull String pesel) throws StudentNotFoundException{

            Optional<Student> studentOptional= Optional.ofNullable(studentRepository.findByPesel(pesel).orElseThrow(() -> new StudentNotFoundException("Student with pesel:" + pesel + " not found!", HttpStatus.NOT_FOUND)));
            return new ResponseEntity<>(StudentOptionalToDto(studentOptional),HttpStatus.OK);

    }
    public ResponseEntity<StudentReqResDto> findByIndexNumber(@NotNull String indexNumber) throws StudentNotFoundException{

            Optional<Student> studentOptional= Optional.ofNullable(studentRepository.findByIndexNumber(indexNumber).orElseThrow(() -> new StudentNotFoundException("Student with index number:" + indexNumber + " not found!", HttpStatus.NOT_FOUND)));
            return new ResponseEntity<>(StudentOptionalToDto(studentOptional),HttpStatus.OK);

    }
    public ResponseEntity<StudentReqResDto> findByEmail(@NotNull String email) throws StudentNotFoundException{

            Optional<Student> studentOptional= Optional.ofNullable(studentRepository.findByEmail(email).orElseThrow(()->new StudentNotFoundException("Student with email address:" + email + " not found!", HttpStatus.NOT_FOUND)));
            return new ResponseEntity<>(StudentOptionalToDto(studentOptional),HttpStatus.OK);

    }
    public ResponseEntity<StudentReqResDto> findByPhoneNumber(@NotNull String phoneNumber) throws StudentNotFoundException{

            Optional<Student> studentOptional= Optional.ofNullable(studentRepository.findByPhoneNumber(phoneNumber).orElseThrow(()->new StudentNotFoundException("Student with phone number:" + phoneNumber + " not found!", HttpStatus.NOT_FOUND)));
            return new ResponseEntity<>(StudentOptionalToDto(studentOptional),HttpStatus.OK);

    }

    public ResponseEntity<List<StudentReqResDto>> findAllByName(@NotNull String name){
        List<Student> dbStudents=studentRepository.findAllByName(name);
        List<StudentReqResDto> dtoStudents=dbStudents.stream().map(this::StudentToDto).toList();
        if(!dtoStudents.isEmpty()) {
            return new ResponseEntity<>(dtoStudents, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(dtoStudents,HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<List<StudentReqResDto>> findAllBySurname(@NotNull String surname){
        List<Student> dbStudents=studentRepository.findAllBySurname(surname);
        List<StudentReqResDto> dtoStudents=dbStudents.stream().map(this::StudentToDto).toList();
        if(!dtoStudents.isEmpty()) {
            return new ResponseEntity<>(dtoStudents, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(dtoStudents,HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<List<StudentReqResDto>> findAllByNationality(@NotNull String nationality){
        List<Student> dbStudents=studentRepository.findAllByNationality(nationality);
        List<StudentReqResDto> dtoStudents=dbStudents.stream().map(this::StudentToDto).toList();
        if(!dtoStudents.isEmpty()) {
            return new ResponseEntity<>(dtoStudents, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(dtoStudents,HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<List<StudentReqResDto>> findAllByIsMale(Boolean isMale){
        List<Student> dbStudents=studentRepository.findAllByIsMale(isMale);
        List<StudentReqResDto> dtoStudents=dbStudents.stream().map(this::StudentToDto).toList();
        if(!dtoStudents.isEmpty()) {
            return new ResponseEntity<>(dtoStudents, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(dtoStudents,HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<List<StudentReqResDto>> findAll(){
        List<Student> dbStudents=studentRepository.findAll();
        List<StudentReqResDto> dtoStudents=dbStudents.stream().map(this::StudentToDto).toList();
        if(!dtoStudents.isEmpty()) {
            return new ResponseEntity<>(dtoStudents, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(dtoStudents,HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<List<StudentReqResDto>>findAllByFieldOfStudy(@NotNull FieldOfStudy fieldOfStudy){
        List<Student> dbStudents=studentRepository.findAllByFieldsOfStudyContaining(fieldOfStudy);
            List<StudentReqResDto> dtoStudents=dbStudents.stream().map(this::StudentToDto).toList();
            if(!dtoStudents.isEmpty()){
                return new ResponseEntity<>(dtoStudents,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(dtoStudents,HttpStatus.NOT_FOUND);
            }
    }
    public ResponseEntity<String> deleteByPesel(String pesel) throws StudentNotFoundException{

            Optional<Student> studentOptional = Optional.ofNullable(studentRepository.findByPesel(pesel).orElseThrow(()->new StudentNotFoundException("Student with pesel:" + pesel + " not found and not deleted", HttpStatus.BAD_REQUEST)));
            studentRepository.deleteByPesel(pesel);
            return new ResponseEntity<>("Student with pesel:"+pesel+" has been successfully deleted",HttpStatus.OK);

    }
    public ResponseEntity<String> deleteByIndexNumber(String indexNumber) throws StudentNotFoundException{
            Optional<Student> studentOptional = Optional.ofNullable(studentRepository.findByIndexNumber(indexNumber).orElseThrow(()->new StudentNotFoundException("Student with indexNumber:" + indexNumber + " not found and not deleted", HttpStatus.BAD_REQUEST)));
            studentRepository.deleteByIndexNumber(indexNumber);
            return new ResponseEntity<>("Student with index number:"+indexNumber+" has been successfully deleted",HttpStatus.OK);
    }
    public ResponseEntity<String>updateStudent(@NotNull StudentReqResDto studentDto) throws StudentNotFoundException{
            Optional<Student> dbStudent = Optional.ofNullable(studentRepository.findByPesel(studentDto.getPesel()).orElseThrow(()->new StudentNotFoundException("Student with pesel:" + studentDto.getPesel() + " not found and not modified", HttpStatus.BAD_REQUEST)));

            dbStudent.get().setIndexNumber(studentDto.getIndexNumber());
            dbStudent.get().setName(studentDto.getName());
            dbStudent.get().setSurname(studentDto.getSurname());
            dbStudent.get().setNationality(studentDto.getNationality());
            dbStudent.get().setIsMale(studentDto.getIsMale());
            dbStudent.get().setEmail(studentDto.getEmail());
            dbStudent.get().setPhoneNumber(studentDto.getPhoneNumber());
            dbStudent.get().setFieldsOfStudy(studentDto.getFieldsOfStudy());
            studentRepository.save(dbStudent.get());
            return new ResponseEntity<>("Student with pesel:"+studentDto.getPesel()+" has been successfully modified!",HttpStatus.OK);
    }

}
