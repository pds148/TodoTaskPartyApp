package com.sparta.todotaskpartyapp.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class TodosResponseDTO {

    private String message;
    private Integer statusCode;
}
