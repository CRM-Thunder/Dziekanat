package com.zamecki.Dziekanat.student;

import com.zamecki.Dziekanat.fieldofstudy.FieldOfStudy;
import com.zamecki.Dziekanat.student.dto.StudentReqResDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody @Valid StudentReqResDto requestDto){
        return studentService.addStudent(requestDto);
    }

    @GetMapping
    public ResponseEntity<List<StudentReqResDto>> findAll(){
        return studentService.findAll();
    }
    @GetMapping("/pesel/{pesel}")
    public ResponseEntity<StudentReqResDto> findByPesel(@PathVariable(name = "pesel")  @Pattern(regexp = "\\d{11}", message = "wrong pesel pattern!") String pesel){
        return studentService.findByPesel(pesel);
    }
    @GetMapping("/indexNumber/{indexNumber}")
    public ResponseEntity<StudentReqResDto> findByIndexNumber(@PathVariable(name = "indexNumber") @Pattern(regexp = "\\d{6}", message = "wrong index number pattern!") String indexNumber){
        return studentService.findByIndexNumber(indexNumber);
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<StudentReqResDto> findByEmail(@PathVariable(name="email") @Email(regexp ="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",message = "wrong email pattern!") String email){
        return studentService.findByEmail(email);
    }
    @GetMapping("/phoneNumber/{phoneNumber}")
    public ResponseEntity<StudentReqResDto> findByPhoneNumber(@PathVariable(name="phoneNumber") @Pattern(regexp = "\\d{9}", message = "wrong phone number pattern!") String phoneNumber){
        return studentService.findByPhoneNumber(phoneNumber);
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<List<StudentReqResDto>>findAllByName(@PathVariable(name="name") @Length(min=2, max=20, message = "wrong name length!") @Pattern(regexp = "[a-zA-ZąćęłńóśźżĄĆĘŁŃÓŚŹŻ]+", message="wrong name pattern!") String name){
        return studentService.findAllByName(name);
    }
    @GetMapping("/surname/{surname}")
    public ResponseEntity<List<StudentReqResDto>>findAllBySurname(@PathVariable(name="surname") @Length(min=2, max=20, message = "wrong surname length!") @Pattern(regexp = "[a-zA-ZąćęłńóśźżĄĆĘŁŃÓŚŹŻ]+", message = "wrong surname pattern!") String surname){
        return studentService.findAllBySurname(surname);
    }
    @GetMapping("/nationality/{nationality}")
    public ResponseEntity<List<StudentReqResDto>>findAllByNationality(@PathVariable(name="nationality") @Length(min=2, max=30, message = "wrong nationality length!") @Pattern(regexp = "[a-zA-ZąćęłńóśźżĄĆĘŁŃÓŚŹŻ]+", message = "wrong nationality pattern!") String nationality){
        return studentService.findAllByNationality(nationality);
    }
    @GetMapping("/isMale/{isMale}")
    public ResponseEntity<List<StudentReqResDto>>findAllByIsMale(@PathVariable(name="isMale")Boolean isMale){
        return studentService.findAllByIsMale(isMale);
    }
    @GetMapping("/fieldOfStudy")
    public ResponseEntity<List<StudentReqResDto>> findAllByFieldOfStudy(@RequestBody @Valid FieldOfStudy fieldOfStudy){
        return studentService.findAllByFieldOfStudy(fieldOfStudy);
    }
    @DeleteMapping("/pesel/{pesel}")
    public ResponseEntity<String> deleteByPesel(@PathVariable @Pattern(regexp = "\\d{11}", message = "wrong pesel pattern!") String pesel){
        return studentService.deleteByPesel(pesel);
    }

    @DeleteMapping("/indexNumber/{indexNumber}")
    public ResponseEntity<String> deleteByIndexNumber(@PathVariable @Pattern(regexp = "\\d{6}", message = "wrong index number pattern!") String indexNumber){
        return studentService.deleteByIndexNumber(indexNumber);
    }
    @PutMapping
    public ResponseEntity<String> updateStudent(@RequestBody @Valid StudentReqResDto reqResDto){
        return studentService.updateStudent(reqResDto);
    }



}
