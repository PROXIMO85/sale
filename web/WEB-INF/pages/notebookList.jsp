<%@ page import="java.util.List" %>
<%@ page import="az.orient.satish.model.Notebook" %><%--
  Created by IntelliJ IDEA.
  User: SONY-VAIO
  Date: 9/8/2017
  Time: 8:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<Notebook> notebookList= (List<Notebook>) request.getAttribute("notebookList");%>
<script type="text/javascript">
    $(function () {
        $('#notebookDataTableId').DataTable();

    });
</script>
<table id="notebookDataTableId" class="display" cellspacing="0" width="100%">
    <thead style="color: red">
    <tr>
        <th>№</th>
        <th>Name</th>
        <th>Model</th>
        <th>Display</th>
        <th>Processor</th>
        <th>Ram</th>
        <th>Videocard</th>
        <th>Price</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <%for (Notebook notebook: notebookList){%>
    <tr>
        <td><%=notebook.getId()%></td>
        <td><%=notebook.getName()%></td>
        <td><%=notebook.getModel()%></td>
        <td><%=notebook.getDisplay()%></td>
        <td><%=notebook.getProcessor()%></td>
        <td><%=notebook.getRam()%></td>
        <td><%=notebook.getVideocard()%></td>
        <td><%=notebook.getPrice()%></td>
        <td><a href="javascript:editNotebook('<%=notebook.getId()%>');">Edit</a> </td>
        <td><a href="javascript:deletenotebook('<%=notebook.getId()%>');">Delete</a> </td>
    </tr>
    <%}%>
    </tbody>


</table>
