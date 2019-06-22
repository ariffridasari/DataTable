/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Employee;

/**
 *
 * @author WINDOWS 10
 */
public interface IEmployeeController {

    public List<Employee> getAll();

    public Employee getById(String id);

    public List<Employee> search(Object keyword);

    public String save(String Id, String firstName, String lastName, String email, String phoneNumber, String hireDate, String salary, String commissionPct, String department, String manager, String job);
    
    
    public String delete(String id);

}
