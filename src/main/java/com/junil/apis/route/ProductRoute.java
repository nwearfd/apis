package com.junil.apis.route;

import com.junil.apis.model.Product;
import com.junil.apis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductRoute {
    private final ProductService productService;

    @Autowired
    public ProductRoute(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{product_id}")
    @ResponseBody
    public Product getProduct(@PathVariable(value="product_id") String productId) throws  Exception{
        return this.productService.find(Integer.parseInt(productId));
    }

    @GetMapping("/initialize")
    public void initializeProducts(){
    this.productService.initializeProducts();
    }

}

