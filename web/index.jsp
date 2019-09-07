<%--
  Created by IntelliJ IDEA.
  User: SONY-VAIO
  Date: 9/6/2017
  Time: 6:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>From USA</title>
  <script type="text/javascript" src="js/jquery/jquery-3.2.1.min.js"></script>
  <script type="text/javascript" src="js/jquery/jquery-latest.js"></script>
  <script type="text/javascript" src="js/jquery/jquery.layout-latest.js"></script>
  <script type="text/javascript" src="js/jquery/jquery-ui.js"/>
  <script type="text/javascript" src="js/jquery/jquery.dataTables.min.js"></script>
  <script type="text/javascript" src="js/main.js"></script>

  <link rel="stylesheet" type="text/css" href="css/main.css"/>
  <link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
  <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.min.css"/>


  <script type="text/javascript">

      $(document).ready(function () {
          $('body').layout({ applyDemoStyles: true });



      $('#customerDataBtnId').click(function () {

          $('#customerTableId').show();
          $('#notebookTableId').hide();
          $('#phoneTableId').hide();
          $('#tvTableId').hide();
          getCustomerList();
      });
      $('#notebookDataBtnId').click(function () {
          $('#notebookTableId').show();
          $('#customerTableId').hide();
          $('#phoneTableId').hide();
          $('#tvTableId').hide();
          getNotebookList();
      });
      $('#phoneDataBtnId').click(function () {
          $('#phoneTableId').show();
          $('#notebookTableId').hide();
          $('#customerTableId').hide();
          $('#tvTableId').hide();
          getPhoneList();
      });
      $('#tvDataBtnId').click(function () {
          $('#tvTableId').show();
          $('#phoneTableId').hide();
          $('#notebookTableId').hide();
          $('#customerTableId').hide();
          getTVList();
      });
      $('#newCustomerDialogId').dialog({
         title: 'New Customer',
          height: 400,
          width: 500,
          autoOpen: false,
          modal: true,
          buttons: {
             'Save': function () {
                 addCustomer();
                 $(this).dialog('close');
             },
              'Close': function () {
               $(this).dialog('close');
              }
          }
      });
      $('#newBtnId').click(function () {
          alert(globBtnId);
          $('#newCustomerDialogId').load('views/newCustomer.jsp',function () {
              $(this).dialog('open')
          });

      });

      $('.btnDesign').click(function () {
          var btnId=$(this).attr('id');
          globBtnId=btnId;
      })

      });
      $('#editNotebookDialogId').dialog({
          title:'Edit Notebook',
          height:400,
          width:500,
          autoOpen:false,
          modal:true,
          buttons:{
              'Change':function () {
                  updateNotebook();
                  $(this).dialog('close');
              },
              'Close':function () {
                  $(this).dialog('close');
              }
          }
      });

  </script>



</head>
<body>
<div class="ui-layout-center">
  <div id="customerTableId" style="display: none">

  </div>
  <div id="notebookTableId" style="display: none">

  </div>
  <div id="phoneTableId" style="display: none">

  </div>
  <div id="tvTableId" style="display: none">

  </div>
  <div id="newCustomerDialogId" style="display: none">
  </div>
  <div id="editNotebookDialogId" style="display: none">

  </div>

</div>
<div class="ui-layout-north">
  <h1 style="text-align: center" >Brands from USA</h1>
  <input type="button" value="Customers" id="customerDataBtnId" class="btnDesign"/>
  <input type="button" value="Notebooks" id="notebookDataBtnId" class="btnDesign"/>
  <input type="button" value="Phones" id="phoneDataBtnId" class="btnDesign"/>
  <input type="button"value="Tvs" id="tvDataBtnId" class="btnDesign"/> &nbsp;
  <input type="button" value="Add New" id="newBtnId" class="btnDesign"/>
</div>
<div class="ui-layout-south">South</div>
<div class="ui-layout-east">
  east
</div>
<div class="ui-layout-west">

</div>
</body>
</html>