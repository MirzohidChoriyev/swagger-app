package com.example.swaggerapp.service;

import com.example.swaggerapp.entity.Product;
import com.example.swaggerapp.payload.ApiResponse;
import com.example.swaggerapp.payload.ProductDto;
import com.example.swaggerapp.repository.CategoryRepository;
import com.example.swaggerapp.repository.ProductRepository;
import com.example.swaggerapp.repository.ProductWithRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductWithRepository productWithRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public ApiResponse save(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setIncomePrice(productDto.getIncomePrice());
        product.setCount(productDto.getCount());
        product.setCount_active(productDto.getCount_active());
        product.setSalePrice(productDto.getSalePrice());
        product.setCount_note(productDto.getCount_note());
        product.setDescription(productDto.getDescription());
        product.setValyuta(productDto.getValyuta());
        product.setCategory_id(productDto.getCategory_id());

        productRepository.save(product);
        return new ApiResponse("Save product", true, product);
    }

    public ApiResponse edit(ProductDto productDto, Integer id) {
        Product product = productRepository.findByIdProduct(id);
        product.setName(productDto.getName());
        product.setIncomePrice(productDto.getIncomePrice());
        product.setCount(productDto.getCount());
        product.setCount_note(productDto.getCount_note());
        product.setSalePrice(productDto.getSalePrice());
        product.setDescription(productDto.getDescription());
        product.setValyuta(productDto.getValyuta());

        productRepository.save(product);
        return new ApiResponse("Save product", true, product);
    }

    public ApiResponse getAll(){
        List<Product> products = productRepository.getAllByProducts();
        return new ApiResponse("Get all", true, products);
    }

    public ApiResponse getNeedAll(){
        List<Product> products = productRepository.getNeedAllByProducts();
        return new ApiResponse("Get need all", true, products);
    }

    public ApiResponse getById(Integer id) {
        Product product = productRepository.findByIdProduct(id);
        return new ApiResponse("Get by id", true, product);
    }

    public ApiResponse delete(Integer id) {
        productRepository.deleteById(id);
        return new ApiResponse("Delete product", true);
    }

    public void updateNoteChar(){
        List<Product> products = productRepository.getAllByProducts();
        for (Product product : products) {
            if(product.getCount_note() >= product.getCount()){
                Integer id = product.getId();
                Product product1 = productRepository.findByIdProduct(id);
                product1.setCount_active("P");
                productRepository.save(product1);
            } else {
                Integer id = product.getId();
                Product product1 = productRepository.findByIdProduct(id);
                product1.setCount_active("A");
                productRepository.save(product1);
            }
        }
    }

    public Integer getByProductsCount(){
        return productRepository.all_products_count();
    }
}
