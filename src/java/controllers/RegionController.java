/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.IRegionController;
import java.math.BigDecimal;
import java.util.List;
import models.Region;
import org.hibernate.SessionFactory;

/**
 *
 * @author HP
 */
public class RegionController implements IRegionController {

    private GeneralDAO<Region> gdao;

    public RegionController(SessionFactory factory) {
        gdao = new GeneralDAO(factory, Region.class);
    }

    @Override
    public Region getById(String id) {
        return gdao.getById(new BigDecimal(id));
    }

    @Override
    public List<Region> getAll() {
        return gdao.getData("");
    }

    @Override
    public List<Region> search(Object keyword) {
        return gdao.getData(keyword);
    }

    @Override
    public String save(String id, String name) {
        String result = "";
        Region region = new Region(new BigDecimal(id), name);
        if (gdao.saveOrDelete(region, false)) {
            result = "Success";
        } else {
            result = "Failed";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        Region region = new Region(new BigDecimal(id));
        if (gdao.saveOrDelete(region, true)) {
            result = "Success";
        }else{
            result = "Failed";
        }
        return result;
    }
}