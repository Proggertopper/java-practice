package com.darkset.auth_api.dto;

public record UserRequest(
        String email,
        String password
) {
}
