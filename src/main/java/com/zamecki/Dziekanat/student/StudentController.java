package com.zamecki.Dziekanat.student;

import com.zamecki.Dziekanat.fieldofstudy.FieldOfStudy;
import com.zamecki.Dziekanat.student.dto.StudentReqResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody StudentReqResDto requestDto){
        return studentService.addStudent(requestDto);
    }

    @GetMapping
    public ResponseEntity<List<StudentReqResDto>> findAll(){
        return studentService.findAll();
    }
    @GetMapping("/pesel/{pesel}")
    public ResponseEntity<StudentReqResDto> findByPesel(@PathVariable(name = "pesel") String pesel){
        return studentService.findByPesel(pesel);
    }
    @GetMapping("/indexNumber/{indexNumber}")
    public ResponseEntity<StudentReqResDto> findByIndexNumber(@PathVariable(name = "indexNumber") String indexNumber){
        return studentService.findByIndexNumber(indexNumber);
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<StudentReqResDto> findByEmail(@PathVariable(name="email")String email){
        return studentService.findByEmail(email);
    }
    @GetMapping("/phoneNumber/{phoneNumber}")
    public ResponseEntity<StudentReqResDto> findByPhoneNumber(@PathVariable(name="phoneNumber")String phoneNumber){
        return studentService.findByPhoneNumber(phoneNumber);
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<List<StudentReqResDto>>findAllByName(@PathVariable(name="name")String name){
        return studentService.findAllByName(name);
    }
    @GetMapping("/surname/{surname}")
    public ResponseEntity<List<StudentReqResDto>>findAllBySurname(@PathVariable(name="surname")String surname){
        return studentService.findAllBySurname(surname);
    }
    @GetMapping("/nationality/{nationality}")
    public ResponseEntity<List<StudentReqResDto>>findAllByNationality(@PathVariable(name="nationality")String nationality){
        return studentService.findAllByNationality(nationality);
    }
    @GetMapping("/isMale/{isMale}")
    public ResponseEntity<List<StudentReqResDto>>findAllByIsMale(@PathVariable(name="isMale")Boolean isMale){
        return studentService.findAllByIsMale(isMale);
    }
    @GetMapping("/fieldOfStudy")
    public ResponseEntity<List<StudentReqResDto>> findAllByFieldOfStudy(@RequestBody FieldOfStudy fieldOfStudy){
        return studentService.findAllByFieldOfStudy(fieldOfStudy);
    }
    @DeleteMapping("/pesel/{pesel}")
    public ResponseEntity<String> deleteByPesel(@PathVariable String pesel){
        return studentService.deleteByPesel(pesel);
    }

    @DeleteMapping("/indexNumber/{indexNumber}")
    public ResponseEntity<String> deleteByIndexNumber(@PathVariable String indexNumber){
        return studentService.deleteByIndexNumber(indexNumber);
    }
    @PutMapping
    public ResponseEntity<String> updateStudent(@RequestBody StudentReqResDto reqResDto){
        return studentService.updateStudent(reqResDto);
    }



}
