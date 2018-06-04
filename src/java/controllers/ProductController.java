/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.SQLException;
import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Kenan
 */
@Controller
public class ProductController {

//    @RequestMapping(value = "/products", method = RequestMethod.GET)
//    public String newForm(Model model) {
//        model.addAttribute("product", new Product());
//
//        return "products";
//    }
//
//    @RequestMapping(value = "/products", method = RequestMethod.POST)
//    public String sum(@ModelAttribute("product") Product product, BindingResult result, ModelMap model) {
//
//        model.addAttribute("id", product.getId());
//        model.addAttribute("name", product.getName());
//        model.addAttribute("price", product.getPrice());
//
//        return "products";
//
//    }
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String createForm(ModelMap model) throws ClassNotFoundException {
        model.addAttribute("product", new Product());
        model.addAttribute("products1", Product.allProducts());
        return "products";
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product, ModelMap model) throws ClassNotFoundException, SQLException {
        product.insertProduct();
        createForm(model);
        return "products";
    }


}
