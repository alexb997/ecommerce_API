package org.example.service;

import org.example.dto.ProductDTO;
import org.example.model.Product;
import org.example.repository.ProductRepository;
import org.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private ProductDTO mapToDTO(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getDescription(),
                product.getPrice(), product.getStock());
    }

    private Product mapToEntity(ProductDTO dto) {
        return new Product(dto.getId(), dto.getName(), dto.getDescription(),
                dto.getPrice(), dto.getStock());
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) {
        Product product = productRepository.save(mapToEntity(dto));
        return mapToDTO(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream().map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(Long id) {
        return productRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());

        return mapToDTO(productRepository.save(product));
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
