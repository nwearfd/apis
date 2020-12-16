package com.junil.apis.route;

import com.junil.apis.model.Product;
import com.junil.apis.model.User;
import com.junil.apis.service.ProductService;
import com.junil.apis.vo.ProductRegisterVO;
import com.junil.apis.vo.UserRegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductRoute {
    private final ProductService productService;

    @Autowired
    public ProductRoute(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    @ResponseBody
    public List<User> getProducts() { return this.productService.findAll(); }

    @GetMapping("/{product_id}")
    @ResponseBody
    public Product getProduct(@PathVariable(value="product_id") String productId) throws Exception {
        return this.productService.find(Integer.parseInt(productId));
    }

    @PostMapping("")
    public int createProduct(ProductRegisterVO product) {
        return this.productService.createProduct(product);
    }

    @GetMapping("/initialize")
    public void initializeProducts() {
        this.productService.initializeProducts();
    }

    @DeleteMapping("/{product_id}")
    public void deleteProduct(@PathVariable(value = "product_id") String productId) {
        this.productService.deleteProduct(Integer.parseInt(productId));
    }
}
