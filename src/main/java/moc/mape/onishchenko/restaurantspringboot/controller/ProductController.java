package moc.mape.onishchenko.restaurantspringboot.controller;

import moc.mape.onishchenko.restaurantspringboot.dto.ProductDto;
import moc.mape.onishchenko.restaurantspringboot.entity.Product;
import moc.mape.onishchenko.restaurantspringboot.mapper.Mapper;
import moc.mape.onishchenko.restaurantspringboot.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/admin/products")
    public ModelAndView getAll(@PageableDefault(sort = {"title"}) Pageable page,
                               ModelAndView modelAndView) {
        Page<Product> pageProduct = productService.findAll(page);
        List<ProductDto> products = pageProduct
                .getContent()
                .stream()
                .map(Mapper::toProductDto)
                .collect(toList());
        PageImpl<ProductDto> result = new PageImpl<>(products, page, pageProduct.getTotalElements());
        modelAndView.addObject("products", result);
        modelAndView.setViewName("products/productsAll");

        return modelAndView;
    }

    @PostMapping("/admin/products")
    public ModelAndView create(@ModelAttribute("product") ProductDto productDto,
                               ModelAndView modelAndView) {
        productService.create(Mapper.toProduct(productDto));

        useDefaultRedirectedUrl(modelAndView);
        return modelAndView;
    }

    @PutMapping("/admin/products/{id}")
    public ModelAndView change(@PathVariable Long id,
                               @ModelAttribute("product") ProductDto productDto,
                               ModelAndView modelAndView) {
        productDto.setId(id);
        productService.update(Mapper.toProduct(productDto));

        useDefaultRedirectedUrl(modelAndView);
        return modelAndView;
    }

    @DeleteMapping("/admin/products/{id}")
    public ModelAndView delete(@PathVariable Long id,
                               ModelAndView modelAndView) {
        productService.deleteById(id);

        useDefaultRedirectedUrl(modelAndView);
        return modelAndView;
    }

    private void useDefaultRedirectedUrl(ModelAndView modelAndView) {
        modelAndView.setView(new RedirectView("products/productsAll"));
    }
}
