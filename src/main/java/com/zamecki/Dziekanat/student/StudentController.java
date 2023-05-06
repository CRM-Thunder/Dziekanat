package com.zamecki.Dziekanat.student;

import com.zamecki.Dziekanat.student.dto.RequestResponseDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
    StudentService studentService;

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody RequestResponseDto requestDto){
        return studentService.addStudent(requestDto);
    }

    @GetMapping
    public ResponseEntity<List<RequestResponseDto>> findAll(){
        return studentService.findAll();
    }
    @GetMapping("/pesel/{pesel}")
    public ResponseEntity<RequestResponseDto> findByPesel(@PathVariable(name = "pesel") String pesel){
        return studentService.findByPesel(pesel);
    }
    @GetMapping("/indexNumber/{indexNumber}")
    public ResponseEntity<RequestResponseDto> findByIndexNumber(@PathVariable(name = "indexNumber") String indexNumber){
        return studentService.findByIndexNumber(indexNumber);
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<RequestResponseDto> findByEmail(@PathVariable(name="email")String email){
        return studentService.findByEmail(email);
    }
    @GetMapping("/phoneNumber/{phoneNumber}")
    public ResponseEntity<RequestResponseDto> findByPhoneNumber(@PathVariable(name="phoneNumber")String phoneNumber){
        return studentService.findByPhoneNumber(phoneNumber);
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<List<RequestResponseDto>>findAllByName(@PathVariable(name="name")String name){
        return studentService.findAllByName(name);
    }
    @GetMapping("/surname/{surname}")
    public ResponseEntity<List<RequestResponseDto>>findAllBySurname(@PathVariable(name="surname")String surname){
        return studentService.findAllBySurname(surname);
    }
    @GetMapping("/nationality/{nationality}")
    public ResponseEntity<List<RequestResponseDto>>findAllByNationality(@PathVariable(name="nationality")String nationality){
        return studentService.findAllByNationality(nationality);
    }
    @GetMapping("/isMale/{isMale}")
    public ResponseEntity<List<RequestResponseDto>>findAllByIsMale(@PathVariable(name="isMale")Boolean isMale){
        return studentService.findAllByIsMale(isMale);
    }


}
