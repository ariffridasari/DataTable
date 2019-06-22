/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import icontrollers.IJobController;
import java.util.List;
import models.Job;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Sekar Ayu Safitri
 */
public class JobController implements IJobController {

    private GeneralDAO<Job> gdao;

    public JobController(SessionFactory factory) {
        gdao = new GeneralDAO(factory, Job.class);
    }

    @Override
    public List<Job> getAll() {
        return gdao.getData("");
    }

    @Override
    public Job getById(String id) {
        return gdao.getById(id);
    }

    @Override
    public List<Job> search(Object keyword) {
        return gdao.getData(keyword);
    }

    @Override
    public String save(String id, String title, String minSalary, String maxSalary) {
        String result = "Failed";
        if (gdao.saveOrDelete(new Job(), true)) {
            result = "Success";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "Failed";
        if (gdao.saveOrDelete(new Job(), false)) {
            result = "Success";
        }
        return result;
    }
}
