package com.stdiosoft.controller;

import com.stdiosoft.dao.ShopDAO;
import com.stdiosoft.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/shops")
public class ShopsController {

    @Autowired
    private ShopDAO shopDAO;

    @RequestMapping("/layout")
    public String getPartial() {
        return "shops/layout";
    }

    @RequestMapping(value = "/getAllShops", method = RequestMethod.GET)
    public @ResponseBody List<Shop> getShopList() {
        List<Shop> listShops= shopDAO.getShopList();
        return listShops;
    }

    @RequestMapping(value = "/newShop", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void getShopList(@RequestBody Shop _newShop) {
        shopDAO.newShop(_newShop);
    }

    @RequestMapping(value = "/deleteShop", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void deleteShop(@RequestBody Shop _shop) {
        shopDAO.deleteShop(_shop);
    }

    @RequestMapping(value = "/editShop", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void editShop(@RequestBody Shop _shop) {
        shopDAO.editShop(_shop);
    }
}
