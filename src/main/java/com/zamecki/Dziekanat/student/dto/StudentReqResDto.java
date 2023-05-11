package com.zamecki.Dziekanat.student.dto;

import com.zamecki.Dziekanat.fieldofstudy.FieldOfStudy;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentReqResDto {
    @Pattern(regexp = "\\d{11}", message = "wrong pesel pattern!")
    private String pesel;
    @Pattern(regexp = "\\d{6}", message = "wrong index number pattern!")
    private String indexNumber;
    @Length(min=2, max=20)
    @Pattern(regexp = "[a-zA-ZąćęłńóśźżĄĆĘŁŃÓŚŹŻ]+")
    private String name;
    @Length(min=2, max=20)
    @Pattern(regexp = "[a-zA-ZąćęłńóśźżĄĆĘŁŃÓŚŹŻ]+")
    private String surname;
    @Length(min=2, max=30)
    @Pattern(regexp = "[a-zA-ZąćęłńóśźżĄĆĘŁŃÓŚŹŻ]+")
    private String nationality;
    private Boolean isMale;
    @Email(regexp ="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",message = "wrong email pattern!")
    private String email;
    @Pattern(regexp = "\\d{9}")
    private String phoneNumber;
    @Valid
    private List<FieldOfStudy> fieldsOfStudy;

}
