package br.com.books.database.dto;

import jakarta.validation.constraints.NotNull;

public record AuthenticationDto(@NotNull String userName, @NotNull String password) {

}
