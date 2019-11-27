package moc.mape.onishchenko.restaurantspringboot.mapper;

import moc.mape.onishchenko.restaurantspringboot.dto.ProductDto;
import moc.mape.onishchenko.restaurantspringboot.entity.Product;

public final class Mapper {
    private Mapper() {
    }

    public static Product toProduct(ProductDto productDto) {
        if (productDto==null) {
            return Product.builder().build();
        }

        return Product.builder()
                .id(productDto.getId())
                .title(productDto.getTitle())
                .description(productDto.getDescription())
                .build();
    }

    public static ProductDto toProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .title(product.getTitle())
                .description(product.getDescription())
                .build();
    }

}
