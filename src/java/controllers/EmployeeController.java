package controllers;

import icontrollers.IEmployeeController;
import idaos.IGeneralDAO;
import daos.GeneralDAO;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Department;
import models.Employee;
import models.Job;
import org.hibernate.SessionFactory;

public class EmployeeController implements IEmployeeController {

    Date date = new Date(); // this object contains the current date value 
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    private IGeneralDAO<Employee> gdao;

    public EmployeeController(SessionFactory factory) {
        gdao = new GeneralDAO(factory, Employee.class);
    }

    @Override
    public List<Employee> getAll() {
        return gdao.getData("");
    }

    @Override
    public Employee getById(String id) {
        return gdao.getById(new Integer(id));
    }

//    @Override
    public List<Employee> search(Object keyword) {
        return gdao.getData(keyword);
    }

    @Override
    public String delete(String id) {
        if (gdao.saveOrDelete(new Employee(new Integer(id)), true)) {
            return "Data berhasil dihapus";
        } else {
            return "Data gagal dihapus";
        }
    }

    @Override
    public String save(String Id, String firstName, String lastName, String email, String phoneNumber, String hireDate, String salary, String commissionPct, String department, String manager, String job) {
        String result = "Data gagal disimpan";
        try {
            date = formatter.parse(hireDate);
            if (gdao.saveOrDelete(new Employee(Integer.parseInt(Id), firstName, lastName, email, phoneNumber, new java.sql.Date(date.getTime()), new BigDecimal(salary), new BigDecimal(commissionPct), new Department(Short.parseShort(department)), new Employee(Integer.parseInt(manager)), new Job(job)), false)) {
                result = "Data berhasil di simpan";
            }
        } catch (ParseException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
//        if (gdao.saveOrDelete(new Employee(id, firstName, lastName, email, phoneNumber, new java.sql.Date(date.getTime()), new BigDecimal(salary), new BigDecimal(commissionPct), new Department(Short.parseShort(department)), new Employee(Integer.parseInt(manager)), new Job(job)) {
//            return "Data berhasil ditambahkan";
//        }else{
//            return result
//        }    

}
