package moc.mape.onishchenko.restaurantspringboot.service;

import moc.mape.onishchenko.restaurantspringboot.entity.Product;
import moc.mape.onishchenko.restaurantspringboot.exception.RestaurantException;
import moc.mape.onishchenko.restaurantspringboot.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Page<Product> findAll(Pageable page) {
        return productRepository.findAll(page);
    }

    public Product create(Product product) {
        productRepository.findByTitle(product.getTitle())
                .ifPresent(c -> {
                    throw new RestaurantException("product.exception.duplicate");
                });
        var newProduct = Product.builder()
                .title(product.getTitle())
                .description(product.getDescription())
                .build();

        return productRepository.saveAndFlush(newProduct);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }


    public void update(Product newData) {
        Product product = productRepository
                .findById(newData.getId())
                .orElseThrow(() -> {
                    throw new RestaurantException("product.exception.notFound");
                });

        product.setTitle(newData.getTitle());
        product.setDescription(newData.getDescription());
        productRepository.saveAndFlush(product);
    }
}
