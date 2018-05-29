/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.SQLException;
import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Kenan
 */
@Controller
public class CustomerController {
        @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String createForm(ModelMap model) throws ClassNotFoundException{        
        model.addAttribute("customer", new Customer());
        model.addAttribute("customers1", Customer.allCustomers());
        return "customers";
    }
    
    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("customer") Customer customer, ModelMap model) throws ClassNotFoundException, SQLException{
        customer.insertCustomer();
        createForm(model);
        return "customers";
    }
}
