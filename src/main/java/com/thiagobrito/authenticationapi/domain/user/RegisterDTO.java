package com.thiagobrito.authenticationapi.domain.user;

public record RegisterDTO(String login, String password, UserRole role){
}