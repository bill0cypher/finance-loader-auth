package com.finance.auth.financeauth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegisterDTO  implements MessageDTO {

    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "email")
    private String email;
}
