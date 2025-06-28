package org.example.model;

import jakarta.persistence.*;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;

    private String username;

    private String password;

    private Set<String> roles;
}
