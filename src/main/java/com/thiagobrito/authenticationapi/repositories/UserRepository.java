package com.thiagobrito.authenticationapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.thiagobrito.authenticationapi.domain.user.User;

public interface UserRepository extends JpaRepository<User, String> {

    UserDetails findByLogin(String login);

}
