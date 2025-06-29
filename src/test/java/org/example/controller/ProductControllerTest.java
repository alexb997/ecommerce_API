package org.example.controller;

import org.example.dto.ProductDTO;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.*;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Test
    void getAllProducts_shouldReturnList() throws Exception {
        List<ProductDTO> products = List.of(new ProductDTO(1L, "Monitor", "HD", 200.0, 8));
        when(productService.getAllProducts()).thenReturn(products);

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1));
    }

    @Test
    void createProduct_shouldReturnCreatedProduct() throws Exception {
        ProductDTO dto = new ProductDTO(null, "TV", "Smart TV", 500.0, 3);
        ProductDTO saved = new ProductDTO(1L, "TV", "Smart TV", 500.0, 3);

        when(productService.createProduct(any())).thenReturn(saved);

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("TV"));
   }
}
