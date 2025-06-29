package org.example.model;


import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

class ProductTest {

    @Test
    void testNoArgsConstructor() {
        Product product = new Product();
        assertNotNull(product);
    }

    @Test
    void testAllArgsConstructor() throws Exception {
        Product product = new Product(1L, "Laptop", "High-end laptop", 1500.0, 10);

        Field idField = Product.class.getDeclaredField("id");
        idField.setAccessible(true);
        assertEquals(1L, idField.get(product));

        Field nameField = Product.class.getDeclaredField("name");
        nameField.setAccessible(true);
        assertEquals("Laptop", nameField.get(product));

        Field descField = Product.class.getDeclaredField("description");
        descField.setAccessible(true);
        assertEquals("High-end laptop", descField.get(product));

        Field priceField = Product.class.getDeclaredField("price");
        priceField.setAccessible(true);
        assertEquals(1500.0, priceField.get(product));

        Field stockField = Product.class.getDeclaredField("stock");
        stockField.setAccessible(true);
        assertEquals(10, stockField.get(product));
    }
}
