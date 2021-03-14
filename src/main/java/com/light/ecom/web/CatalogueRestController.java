package com.light.ecom.web;

import com.light.ecom.dao.ProductRepository;
import com.light.ecom.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class CatalogueRestController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping(path="/photoProduct/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto( @PathVariable("id") Long id) throws IOException {
        Product p=productRepository.findById(id).get();
        System.out.println("test :"+System.getProperty("user.home")+"/ecom/products/"+p.getPhotoName());
        //path vers la photo
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ecom/products/"+p.getPhotoName()));


    }

}
