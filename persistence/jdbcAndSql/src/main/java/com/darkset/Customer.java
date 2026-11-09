package com.darkset;

public record Customer(
        int id,
        String fullName,
        String email,
        String city
) {
}
