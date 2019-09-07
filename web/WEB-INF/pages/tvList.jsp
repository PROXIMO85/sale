<%@ page import="java.util.List" %>
<%@ page import="az.orient.satish.model.TV" %><%--
  Created by IntelliJ IDEA.
  User: SONY-VAIO
  Date: 1/25/2019
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<TV> tvList= (List<TV>) request.getAttribute("tvList");%>
<script type="text/javascript">
    $(function () {
        $('#tvDataTableId').DataTable();
    })
</script>

<table id="tvDataTableId" class="display" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th>№</th>
        <th>name</th>
        <th>model</th>
        <th>screen</th>
        <th>price</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <%for (TV tv:tvList){%>
    <tr>
        <td><%=tv.getId()%></td>
        <td><%=tv.getName()%></td>
        <td><%=tv.getModel()%></td>
        <td><%=tv.getScreen()%></td>
        <td><%=tv.getPrice()%></td>
        <td><a href="javascript:editTV('<%=tv.getId()%>');">Edit</a> </td>
        <td><<a href="javascript:deleteTV('<%=tv.getId()%>');">Delete</a>></td>
    </tr>

    <%}%>

    </tbody>

</table>
