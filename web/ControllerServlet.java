package az.orient.satish.web;

import az.orient.satish.dao.SatishDao;
import az.orient.satish.dao.SatishDaoImpl;
import az.orient.satish.model.Customer;
import az.orient.satish.model.Notebook;
import az.orient.satish.model.Phone;
import az.orient.satish.model.TV;
import az.orient.satish.service.SatishService;
import az.orient.satish.service.SatishServiceImpl;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "ControllerServlet",urlPatterns = "/cs")
public class ControllerServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        processRequest(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        processRequest(request,response);
    }

    protected void processRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String action=null;
        String address=null;
        SatishDao satishDao= new SatishDaoImpl();
        SatishService satishService=new SatishServiceImpl(satishDao);
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        if(request.getParameter("action")!=null){
          action=  request.getParameter("action");
        }
        try {

            if (action.equalsIgnoreCase("getCustomerList")) {

                List<Customer> customerList = satishService.getCustomerList();
                request.setAttribute("customerList", customerList);
                address = "WEB-INF/pages/customerList.jsp";

            } else if (action.equalsIgnoreCase("getNotebookList")) {
                List<Notebook> notebookList = satishService.getNotebookList();
                request.setAttribute("notebookList", notebookList);
                address = "WEB-INF/pages/notebookList.jsp";
            } else if (action.equalsIgnoreCase("getPhoneList")) {
                List<Phone> phoneList = satishService.getPhoneList();
                request.setAttribute("phoneList", phoneList);
                address = "WEB-INF/pages/phoneList.jsp";
            } else if (action.equalsIgnoreCase("getTVList")) {
                List<TV> tvList = satishService.getTVList();
                request.setAttribute("tvList", tvList);
                address = "WEB-INF/pages/tvList.jsp";
            } else if (action.equalsIgnoreCase("addCustomer")) {
                String customerName = request.getParameter("customerName");
                String customerSurname = request.getParameter("customerSurname");
                String card = request.getParameter("card");
                String address1 = request.getParameter("address1");
                Date dob = dateFormat.parse(request.getParameter("dob"));
                Customer customer = new Customer();
                customer.setName(customerName);
                customer.setSurname(customerSurname);
                customer.setCard(card);
                customer.setAddress(address1);
                customer.setDob(dob);
                String result = satishService.addCustomer(customer);
                request.setAttribute("result", result);
            } else if (action.equalsIgnoreCase("getNotebookById")) {
                long notebookId = Long.parseLong(request.getParameter("notebookId"));
                Notebook notebook = satishService.getNotebookById(notebookId);
                request.setAttribute("notebook", notebook);
                address = "WEB-INF/pages/editNotebook.jsp";
            } else if (action.equalsIgnoreCase("updateNotebook")) {
                String notebookname = request.getParameter("notebookname");
                String notebookmodel = request.getParameter("notebookmodel");
                int display = Integer.parseInt(request.getParameter("display"));
                String processor = request.getParameter("processor");
                int ram = Integer.parseInt(request.getParameter("ram"));
                String videocard = request.getParameter("videocard");
                int price = Integer.parseInt(request.getParameter("price"));
                long notebookId=Long.parseLong(request.getParameter("notebookId"));
                Notebook notebook = new Notebook();
                notebook.setName(notebookname);
                notebook.setModel(notebookmodel);
                notebook.setDisplay(display);
                notebook.setProcessor(processor);
                notebook.setRam(ram);
                notebook.setVideocard(videocard);
                String result= satishService.updateNotebook(notebook, notebookId);
                response.setContentType("text/html");

            }else if (action.equalsIgnoreCase("deletenotebook")){
                long notebookId=Long.parseLong(request.getParameter("notebookId"));
                String result=satishService.deletenotebook(notebookId);
                response.setContentType("text/html");

            }
            if (address!=null){
                RequestDispatcher dispatcher= request.getRequestDispatcher(address);
                dispatcher.forward(request,response);
            }

        }catch (Exception ex) {
            ex.printStackTrace();

        }

    }
}
