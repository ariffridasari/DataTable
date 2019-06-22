/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import daos.GeneralDAO;
import icontrollers.ICountryController;
import java.util.List;
import models.Country;
import idaos.IGeneralDAO;
import org.hibernate.SessionFactory;

/**
 *
 * @author erik
 */
public class CountryController implements ICountryController{
    
    private GeneralDAO<Country> cdao;
    
public CountryController(SessionFactory factory) {
    cdao = new GeneralDAO(factory,Country.class);
}    
    
    @Override
    public List<Country> getAll() {
        return cdao.getData("");
    }

    @Override
    public Country getById(String id) {
        return cdao.getById(new Short(id));
    }

    @Override
    public List<Country> search(Object keyword) {
        return cdao.getData(keyword);
    }

    @Override
    public String save(String id, String name, String region) {
        String result = "data gagal disimpan";
        if(cdao.saveOrDelete(new Country(), true)) {
            result = "data berhasil disimpan";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "data gagal disimpan";
        if (cdao.saveOrDelete(new Country(), false)) {
        result = "data berhasil disimpan";
    }
    return result;
    }
    
}
