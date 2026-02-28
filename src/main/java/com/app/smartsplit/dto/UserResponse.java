package com.app.smartsplit.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonPropertyOrder({"id", "name", "email"})
public class UserResponse {
    private Long id;
    private String name;
    private String email;

}
