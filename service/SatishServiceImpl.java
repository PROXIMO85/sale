package az.orient.satish.service;

import az.orient.satish.dao.SatishDao;
import az.orient.satish.model.Customer;
import az.orient.satish.model.Notebook;
import az.orient.satish.model.Phone;
import az.orient.satish.model.TV;

import java.util.List;

public class SatishServiceImpl implements SatishService {

    private SatishDao satishDao;

    public SatishServiceImpl(SatishDao satishDao) {
        this.satishDao = satishDao;
    }

    @Override
    public List<Notebook> getNotebookList() throws Exception {
        return satishDao.getNotebookList();
    }

    @Override
    public List<Customer> getCustomerList() throws Exception {
        return satishDao.getCustomerList();
    }

    @Override
    public List<TV> getTVList() throws Exception {
        return satishDao.getTVList();
    }

    @Override
    public List<Phone> getPhoneList() throws Exception {
        return satishDao.getPhoneList();
    }

    @Override
    public String addNotebook(Notebook notebook) throws Exception {
        return null;
    }

    @Override
    public String addCustomer(Customer customer) throws Exception {
        return null;
    }

    @Override
    public String addTV(TV tv) throws Exception {
        return null;
    }

    @Override
    public String addPhone(Phone phone) throws Exception {
        return null;
    }

    @Override
    public String updateCustomer(Customer customer, long customerId) throws Exception {
        return null;
    }

    @Override
    public String updateNotebook(Notebook notebook, long notebookId) throws Exception {
        return null;
    }

    @Override
    public Notebook getNotebookById(long notebookId) throws Exception {
        return null;
    }

    @Override
    public Customer getCustomerById(long customerId) throws Exception {
        return null;
    }

    @Override
    public TV getTvById(long tvId) throws Exception {
        return null;
    }

    @Override
    public Phone getPhoneById(long phoneId) throws Exception {
        return null;
    }

    @Override
    public String deletecustomer(long customerId) throws Exception {
        return null;
    }

    @Override
    public String deletenotebook(long notebookId) throws Exception {
        return null;
    }

    @Override
    public String deleteTV(long tvId) throws Exception {
        return null;
    }

    @Override
    public String deletephone(long phoneId) throws Exception {
        return null;
    }
}
