package com.stdiosoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/railwaystations")
public class RailwayStationController {

    @RequestMapping("/layout")
    public String getPartial(ModelMap modelMap) {
        return "railwaystations/layout";
    }
}
