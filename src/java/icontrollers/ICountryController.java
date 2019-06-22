/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Country;
import idaos.IGeneralDAO;


/**
 *
 * @author erik
 */
public interface ICountryController {
    public List<Country> getAll();
    
    public Country getById(String id);
    
    public List<Country> search(Object keyword);
    
    public String save (String id, String name, String region);
    
    public String delete(String id);
}
