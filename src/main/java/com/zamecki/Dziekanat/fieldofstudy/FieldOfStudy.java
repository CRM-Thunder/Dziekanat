package com.zamecki.Dziekanat.fieldofstudy;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class FieldOfStudy {

    private String code;
    @Range(min=1, max=12)
    private Integer semester;
}
