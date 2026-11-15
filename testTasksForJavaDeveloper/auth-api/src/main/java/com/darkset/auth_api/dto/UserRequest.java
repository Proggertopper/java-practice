package com.darkset.auth_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @Email @NotBlank @Size(max = 100)String email,
        @NotBlank String password
) {
}
