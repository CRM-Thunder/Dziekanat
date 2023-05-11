package com.zamecki.Dziekanat.student;

import com.zamecki.Dziekanat.fieldofstudy.FieldOfStudy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document("Students")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    @Id
    private String id;
    private String createdAt;

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
