/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Location;

/**
 *
 * @author ACER
 */
public interface ILocationController {
    
    public List<Location> getAll();
    
    public Location getById(String id);
    
    public List<Location> search(Object keyword);
    
    public String save(String id, String country, String state, String postal, String street, String  city);
    
    public String delete(String id);
    
}
