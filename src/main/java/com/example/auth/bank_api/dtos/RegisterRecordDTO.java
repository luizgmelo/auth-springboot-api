package com.example.auth.bank_api.dtos;

import com.example.auth.bank_api.models.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterRecordDTO(@NotBlank  String login, @NotBlank String password, @NotNull UserRole role) {
}
