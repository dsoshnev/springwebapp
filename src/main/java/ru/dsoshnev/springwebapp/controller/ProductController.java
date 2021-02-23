package ru.dsoshnev.springwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dsoshnev.springwebapp.model.Product;
import ru.dsoshnev.springwebapp.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @PostMapping("/save")
    public String addNewBox(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/products/index";
    }
}
