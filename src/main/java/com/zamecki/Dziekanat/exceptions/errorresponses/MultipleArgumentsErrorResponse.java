package com.zamecki.Dziekanat.exceptions.errorresponses;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MultipleArgumentsErrorResponse {

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
        private String timestamp;
        private Integer errorCode;
        private String status;
        private List<String> errorMessages;
}
