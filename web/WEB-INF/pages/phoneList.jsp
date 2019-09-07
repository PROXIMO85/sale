<%@ page import="java.util.List" %>
<%@ page import="az.orient.satish.model.Phone" %><%--
  Created by IntelliJ IDEA.
  User: SONY-VAIO
  Date: 9/8/2017
  Time: 8:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<Phone> phoneList= (List<Phone>) request.getAttribute("phoneList");%>
<script type="text/javascript">
    $(function () {
        $('#phoneDataTableId').DataTable();

    });
</script>
<table id="phoneDataTableId" class="display" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th>№</th>
        <th>Name</th>
        <th>Model</th>
        <th>Memory</th>
        <th>Price</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <%for (Phone phone:phoneList){%>
    <tr>
        <td><%=phone.getId()%></td>
        <td><%=phone.getName()%></td>
        <td><%=phone.getModel()%></td>
        <td><%=phone.getMemory()%></td>
        <td><%=phone.getPrice()%></td>
        <td><a href="javascript:editPhone('<%=phone.getId()%>');">Edit</a></td>
        <td><a href="javascript:deletePhone('<%=phone.getId()%>');">Delete</a> </td>
    </tr>
    <%}%>
    </tbody>
</table>