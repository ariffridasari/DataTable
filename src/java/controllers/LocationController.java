/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.ILocationController;
import idaos.IGeneralDAO;
import java.util.List;
import models.Country;
import models.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author ACER
 */
public class LocationController implements ILocationController {
    
    private IGeneralDAO<Location> gdao;

    public LocationController(SessionFactory factory) {
        gdao = new GeneralDAO(factory, Location.class);
    }

    @Override
    public List<Location> getAll() {
        return gdao.getData("");
    }

    @Override
    public Location getById(String id) {
        return gdao.getById(Short.parseShort(id));
    }

    @Override
    public List<Location> search(Object keyword) {
        return gdao.getData(keyword);
    }

    @Override
    public String save(String id, String country, String state, String postal, String street, String city) {
        String result = "";
        
        Location location = new Location(Short.parseShort(id), street, postal, city, state, new Country(id));
        if (gdao.saveOrDelete(location, false)) {
            result = "Success";
        } else {
            result = "Failed";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        Location location = new Location(Short.parseShort(id));
        if (gdao.saveOrDelete(location, true)) {
            result = "Success";
        }else{
            result = "Failed";
        }
        return result;
    }

    
    
}
