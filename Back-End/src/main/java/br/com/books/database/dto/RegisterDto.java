package br.com.books.database.dto;

import jakarta.validation.constraints.NotNull;

public record RegisterDto(@NotNull String userName, @NotNull String password) {

}
