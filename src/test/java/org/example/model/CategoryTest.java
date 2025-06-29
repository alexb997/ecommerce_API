package org.example.model;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void testNoArgsConstructor() {
        Category category = new Category();
        assertNotNull(category);
    }

    @Test
    void testAllArgsConstructor() throws Exception {
        Category category = new Category(1L, "Electronics");

        Field idField = Category.class.getDeclaredField("id");
        idField.setAccessible(true);
        assertEquals(1L, idField.get(category));

        Field nameField = Category.class.getDeclaredField("name");
        nameField.setAccessible(true);
        assertEquals("Electronics", nameField.get(category));
    }
}