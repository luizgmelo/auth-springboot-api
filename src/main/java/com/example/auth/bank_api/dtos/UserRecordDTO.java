package com.example.auth.bank_api.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserRecordDTO(@NotBlank String login, @NotBlank String password) {
}
