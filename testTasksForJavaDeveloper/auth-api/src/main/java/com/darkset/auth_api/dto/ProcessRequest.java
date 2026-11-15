package com.darkset.auth_api.dto;

import jakarta.validation.constraints.NotNull;

public record ProcessRequest(
       @NotNull String text
) {
}
