package com.zamecki.Dziekanat.student.dto;

import com.zamecki.Dziekanat.fieldofstudy.FieldOfStudy;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "pesel cannot be null!")
    private String pesel;
    @Pattern(regexp = "\\d{6}", message = "wrong index number pattern!")
    private String indexNumber;
    @Length(min=2, max=20, message = "wrong name length!")
    @Pattern(regexp = "[a-zA-ZąćęłńóśźżĄĆĘŁŃÓŚŹŻ]+", message = "wrong name pattern!")
    private String name;
    @Length(min=2, max=20, message = "wrong surname length!")
    @Pattern(regexp = "[a-zA-ZąćęłńóśźżĄĆĘŁŃÓŚŹŻ]+", message = "wrong surname pattern!")
    private String surname;
    @Length(min=2, max=30, message="wrong nationality length!")
    @Pattern(regexp = "[a-zA-ZąćęłńóśźżĄĆĘŁŃÓŚŹŻ]+", message = "wrong nationality pattern!")
    private String nationality;
    private Boolean isMale;
    @Email(regexp ="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",message = "wrong email pattern!")
    private String email;
    @Pattern(regexp = "\\d{9}", message = "wrong phone number pattern!")
    private String phoneNumber;
    @Valid
    private List<FieldOfStudy> fieldsOfStudy;

}
