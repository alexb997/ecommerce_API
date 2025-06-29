package org.example.model;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testNoArgsConstructor() {
        User user = new User();
        assertNotNull(user);
    }

    @Test
    void testAllArgsConstructor() throws Exception {
        Set<String> roles = Set.of("CUSTOMER", "ADMIN");
        User user = new User(1L, "axel", "pass", roles);

        Field idField = User.class.getDeclaredField("id");
        idField.setAccessible(true);
        assertEquals(1L, idField.get(user));

        Field usernameField = User.class.getDeclaredField("username");
        usernameField.setAccessible(true);
        assertEquals("axel", usernameField.get(user));

        Field passwordField = User.class.getDeclaredField("password");
        passwordField.setAccessible(true);
        assertEquals("pass", passwordField.get(user));

        Field rolesField = User.class.getDeclaredField("roles");
        rolesField.setAccessible(true);
        assertEquals(roles, rolesField.get(user));
    }
}