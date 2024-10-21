package com.zamecki.Dziekanat.fieldofstudy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class FieldOfStudy {

    private String code;
    @Range(min=1, max=12)
    private Integer semester;
}
