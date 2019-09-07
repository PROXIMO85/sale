package az.orient.satish.dao;

import az.orient.satish.model.Customer;
import az.orient.satish.model.Notebook;
import az.orient.satish.model.Phone;
import az.orient.satish.model.TV;
import az.orient.satish.util.JdbcUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SatishDaoImpl implements SatishDao {
    @Override
    public List<Notebook> getNotebookList() throws Exception {
        List<Notebook> notebookList=new ArrayList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql=" SELECT ID,NAME,MODEL,DISPLAY,PROCESSOR,RAM,VIDEOCARD,PRICE FROM NOTEBOOKS\n" +
                    " WHERE ACTIVE=1 ";
        try {
            c=DBHelper.getConnection();
            if (c!=null){
                ps=c.prepareStatement(sql);
                rs=ps.executeQuery();
                while (rs.next()){
                    Notebook notebook= new Notebook();
                    notebook.setId(rs.getLong("ID"));
                    notebook.setName(rs.getString("NAME"));
                    notebook.setModel(rs.getString("MODEL"));
                    notebook.setDisplay(rs.getInt("DISPLAY"));
                    notebook.setProcessor(rs.getString("PROCESSOR"));
                    notebook.setRam(rs.getInt("RAM"));
                    notebook.setVideocard(rs.getString("VIDEOCARD"));
                    notebook.setPrice(rs.getInt("PRICE"));
                    notebookList.add(notebook);
                }

            }else {
                System.out.println("connection is null");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            JdbcUtility.close(c,ps,rs);
        }
        return notebookList;
    }

    @Override
    public List<Customer> getCustomerList() throws Exception {
        List<Customer> customerList=new ArrayList<>();

        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="SELECT ID,NAME,SURNAME,CARD,ADDRESS,DOB FROM CUSTOMER\n" +
                " WHERE ACTIVE=1 ";
        try {
            c=DBHelper.getConnection();
            if (c!=null){
                ps=c.prepareStatement(sql);
                rs=ps.executeQuery();
                while (rs.next()){
                    Customer customer=new Customer();
                    customer.setId(rs.getLong("ID"));
                    customer.setName(rs.getString("NAME"));
                    customer.setSurname(rs.getString("SURNAME"));
                    customer.setCard(rs.getString("CARD"));
                    customer.setAddress(rs.getString("ADDRESS"));
                    customer.setDob(rs.getDate("DOB"));
                    customerList.add(customer);

                }
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            JdbcUtility.close(c,ps,rs);
        }
        return customerList;
    }

    @Override
    public List<TV> getTVList() throws Exception {
        List<TV> TVList= new ArrayList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql=" SELECT ID,NAME,MODEL,SCREEN,PRICE FROM TV\n" +
                " WHERE ACTIVE=1 ";
        try {
            c=DBHelper.getConnection();

            if (c!=null){
                ps=c.prepareStatement(sql);
                rs=ps.executeQuery();
                while (rs.next()) {
                    TV tv= new TV();
                    tv.setId(rs.getLong("ID"));
                    tv.setName(rs.getString("NAME"));
                    tv.setModel(rs.getString("MODEL"));
                    tv.setScreen(rs.getInt("SCREEN"));
                    tv.setPrice(rs.getInt("PRICE"));
                    TVList.add(tv);

                }

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            JdbcUtility.close(c,ps,rs);
        }
        return TVList;
    }

    @Override
    public List<Phone> getPhoneList() throws Exception {
        List<Phone> phoneList= new ArrayList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql=" SELECT ID,NAME,MODEL,MEMORY,PRICE FROM PHONE\n" +
                   " WHERE ACTIVE=1 ";
        try {
            c=DBHelper.getConnection();
            if (c!=null){

                ps=c.prepareStatement(sql);
                rs=ps.executeQuery();
                while (rs.next()) {
                    Phone phone=new Phone();
                    phone.setId(rs.getLong("ID"));
                    phone.setName(rs.getString("NAME"));
                    phone.setModel(rs.getString("MODEL"));
                    phone.setMemory(rs.getInt("MEMORY"));
                    phone.setPrice(rs.getInt("PRICE"));
                    phoneList.add(phone);
                }

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return phoneList;
    }

    @Override
    public String addNotebook(Notebook notebook) throws Exception {
        String result=null;
        String sql="INSERT INTO NOTEBOOKS(ID,NAME,MODEL,DISPLAY,PROCESSOR,RAM,VIDEOCARD,PRICE)"+
                "VALUES(NOTEBOOKS_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
        try(Connection c=DBHelper.getConnection(); PreparedStatement ps=c.prepareStatement(sql);) {
            ps.setString(1,notebook.getName());
            ps.setString(2,notebook.getModel());
            ps.setInt(3,notebook.getDisplay());
            ps.setString(4,notebook.getProcessor());
            ps.setInt(5,notebook.getRam());
            ps.setString(6,notebook.getVideocard());
            ps.setInt(7,notebook.getPrice());

            ps.execute();
            result="success";

        }catch (Exception ex){
            ex.printStackTrace();
            result="error";
        }

        return result;
    }

    @Override
    public String addCustomer(Customer customer) throws Exception {
        String result=null;
        String sql="INSERT INTO CUSTOMER(ID,NAME,SURNAME,CARD,ADDRESS,DOB)"+
                "VALUES(CUSTOMER_SEQ.NEXTVAL,?,?,?,?,?,?)";
        try(Connection c=DBHelper.getConnection(); PreparedStatement ps=c.prepareStatement(sql);){
            ps.setString(1,customer.getName());
            ps.setString(2,customer.getSurname());
            ps.setString(3,customer.getCard());
            ps.setString(4,customer.getAddress());
            ps.setDate(5,new java.sql.Date(customer.getDob().getTime()));
            ps.execute();
            result="success";

        }catch (Exception ex){
            ex.printStackTrace();
            result="error";
        }
        return result;
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
        String result=null;
        String sql=" UPDATE NOTEBOOKS SET NAME=?,MODEL=?,DISPLAY=?,PROCESSOR=?,RAM=?,VIDEOCARD=?,PRICE=? "+
                " WHERE ID=? ";
        try(Connection c=DBHelper.getConnection(); PreparedStatement ps=c.prepareStatement(sql);) {
            ps.setString(1,notebook.getName());
            ps.setString(2,notebook.getModel());
            ps.setInt(3,notebook.getDisplay());
            ps.setString(4,notebook.getProcessor());
            ps.setInt(5,notebook.getRam());
            ps.setString(6,notebook.getVideocard());
            ps.setInt(7,notebook.getPrice());
            ps.setLong(8,notebook.getId());
            ps.executeUpdate();
            result="success";

        }catch (Exception ex){
            ex.printStackTrace();
            result="error";
        }

        return result;
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
        String result=null;
        String sql=" UPDATE NOTEBOOKS SET ACTIVE=0 WHERE ID=? ";
        try (Connection c=DBHelper.getConnection(); PreparedStatement ps=c.prepareStatement(sql);){
            ps.setLong(1,notebookId);
            ps.executeUpdate();
            result="succes";

        }catch (Exception ex){
            ex.printStackTrace();
            result="error";
        }
        return result;
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
