<%--
  Created by IntelliJ IDEA.
  User: SONY-VAIO
  Date: 3/26/2019
  Time: 8:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">
    $(function () {
        $('#cusDobId').datepicker({
           changeMonth:true,
           changeYear:true
        });
    });
</script>

<div class="namedesign">Name</div>              <input type="text" id="cusnameId" placeholder="name"/>
<div class="namedesign">Surname</div>           <input type="text" id="cussurnameId" placeholder="surname"/>
<div class="namedesign">Card</div>              <input type="text" id="cuscardId" placeholder="card"/>
<div class="namedesign">Address</div>           <input type="text" id="cusaddressId" placeholder="address"/>
<div class="namedesign">Date of Birth</div>           <input type="text" id="cusDobId" placeholder="date of birth"/>


