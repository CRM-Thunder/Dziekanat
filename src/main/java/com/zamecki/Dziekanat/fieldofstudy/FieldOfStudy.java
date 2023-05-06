package com.zamecki.Dziekanat.fieldofstudy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FieldOfStudy {
    private String code;
    private Integer semester;
}
