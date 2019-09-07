package az.orient.satish.dao;

import az.orient.satish.model.Customer;
import az.orient.satish.model.Notebook;
import az.orient.satish.model.Phone;
import az.orient.satish.model.TV;

import java.util.List;

public interface SatishDao {

    List<Notebook> getNotebookList() throws Exception;
    List<Customer> getCustomerList() throws Exception;
    List<TV> getTVList() throws Exception;
    List<Phone> getPhoneList() throws Exception;
    String addNotebook(Notebook notebook) throws Exception;
    String addCustomer(Customer customer) throws Exception;
    String addTV(TV tv) throws Exception;
    String addPhone(Phone phone) throws  Exception;
    String updateCustomer(Customer customer,long customerId) throws Exception;
    String updateNotebook(Notebook notebook,long notebookId) throws Exception;
    Notebook getNotebookById(long notebookId) throws Exception;
    Customer getCustomerById(long customerId) throws Exception;
    TV getTvById(long tvId) throws Exception;
    Phone getPhoneById(long phoneId) throws  Exception;
    String deletecustomer(long customerId) throws Exception;
    String deletenotebook(long notebookId) throws Exception;
    String deleteTV(long tvId) throws Exception;
    String deletephone(long phoneId) throws Exception;




}
