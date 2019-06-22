/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.IDepartmentController;
import java.util.List;
import models.Department;
import models.Employee;
import models.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Arif Fridasari
 */
public class DepartmentController implements IDepartmentController {

    private GeneralDAO<Department> gdao;

    public DepartmentController(SessionFactory factory) {
        gdao = new GeneralDAO(factory, Department.class);
    }

    @Override
    public List<Department> getAll() {
        return gdao.getData("");
    }

    @Override
    public Department getById(String id) {
        return gdao.getById(new Short(id));
    }

    @Override
    public List<Department> search(Object keyword) {
        return gdao.getData(keyword);
    }

    @Override
    public String save(String id, String name, String manager_id, String location_id) {
        String result = "";
        Department department = new Department(new Short(id), name, new Employee(Integer.parseInt(manager_id)), new Location(new Short(location_id)));
        if (gdao.saveOrDelete(department, false)) {
            result = "Success";
        } else {
            result = "Failed";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        Department department = new Department(new Short(id));
        if (gdao.saveOrDelete(department, true)) {
            result = "Success";
        } else {
            result = "Failed";
        }
        return result;
    }

}
