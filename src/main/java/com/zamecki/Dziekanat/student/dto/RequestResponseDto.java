package com.zamecki.Dziekanat.student.dto;

import com.zamecki.Dziekanat.fieldofstudy.FieldOfStudy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestResponseDto {
    private String pesel;
    private String indexNumber;
    private String name;
    private String surname;
    private String nationality;
    private Boolean isMale;
    private String email;
    private String phoneNumber;
    private List<FieldOfStudy> fieldsOfStudy;

}
