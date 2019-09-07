<%@ page import="az.orient.satish.model.Customer" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: SONY-VAIO
  Date: 9/8/2017
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<Customer> customerList= (List<Customer>) request.getAttribute("customerList");%>
<script type="text/javascript" >
    $(function () {
        $('#customerDataTableId').DataTable();
        
    });
</script>

<table id="customerDataTableId" class="display" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th>№</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Card</th>
        <th>Address</th>
        <th>Dob</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <%for (Customer customer: customerList ){%>
    <tr>
        <td><%=customer.getId()%></td>
        <td><%=customer.getName()%></td>
        <td><%=customer.getSurname()%></td>
        <td><%=customer.getCard()%></td>
        <td><%=customer.getAddress()%></td>
        <td><%=customer.getDob()%></td>
        <td><a href="javascript:editSatish('<%=customer.getId()%>');">Edit</a> </td>
        <td><a href="javascript:deleteSatish('<%=customer.getId()%>');">Delete</a> </td>
    </tr>
    <%}%>
    </tbody>


</table>
