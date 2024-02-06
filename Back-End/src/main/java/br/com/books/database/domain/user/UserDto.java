package br.com.books.database.domain.user;

import jakarta.validation.constraints.NotBlank;

public record UserDto(@NotBlank String userName, @NotBlank String password, @NotBlank boolean accountNonExpired, boolean accountNonLocked) {

}
