package com.example.shoppingExamPrep.service.impl;

import com.example.shoppingExamPrep.model.entities.CategoryName;
import com.example.shoppingExamPrep.model.entities.Product;
import com.example.shoppingExamPrep.model.service.ProductServiceModel;
import com.example.shoppingExamPrep.model.view.ProductViewModel;
import com.example.shoppingExamPrep.repository.ProductRepository;
import com.example.shoppingExamPrep.service.CategoryService;
import com.example.shoppingExamPrep.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public boolean saveProduct(ProductServiceModel productServiceModel) {
        try {
            Product product=modelMapper.map(productServiceModel,Product.class);
            product.setCategory(categoryService.findByCategoryEnumName(productServiceModel.getCategory()));
            productRepository.save(product);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public BigDecimal totalAmount() {


        return productRepository.totalAmountOfAllProduct();
    }

    @Override
    public List<ProductViewModel> findProductsByCategoryName(CategoryName categoryName) {
      return   productRepository.findAllByCategory_Name(categoryName).stream()
                .map(product -> modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void buy(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAll() {
        productRepository.deleteAll();
    }
}
