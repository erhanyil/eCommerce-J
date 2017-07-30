package com.stdiosoft.controller;

import com.stdiosoft.dao.ExampleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    @RequestMapping("/layout")
    public String getPartial() {
        return "cars/layout";
    }

}
