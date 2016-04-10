package com.karma.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.karma.workhistory.model.Transaction;
import com.karma.workhistory.service.TransactionService;

@Controller
public class LoginController {
    
    
    @Autowired
    private TransactionService transactionService;
    
    @RequestMapping(value = "/submitLoginDetails", method = RequestMethod.POST)
    public ModelAndView submitLogin(@RequestParam("userName") String userName,@RequestParam("password") String password ) {

            ModelAndView model = new ModelAndView();
            model.setViewName("login");
            System.out.println(userName + password);
            
            Transaction t = new Transaction();
            t.setId(3);
            transactionService.persistTransaction(t);
            return model;


    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

          
            return "login";

    }
}
