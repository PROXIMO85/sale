
globBtnId='';
globalNotebookId=0;

function getCustomerList() {
    $.ajax({

        url:'cs?action=getCustomerList',
        type:'GET',
        dataType:'html',
        success:function (data) {
           $('#customerTableId').html(data);

        }

    });
    
}
function getNotebookList() {
    $.ajax({
       url:'cs?action=getNotebookList',
        type:'GET',
        dataType:'html',
        success:function (data) {
           $('#notebookTableId').html(data);

        }

    });

}
function getTVList() {

$.ajax({
    url:'cs?action=getTVList',
    type:'GET',
    dataType:'html',
    success:function (data) {
        $('#tvTableId').html(data);
    }
});



}

function getPhoneList() {
    $.ajax({
        url:'cs?action=getPhoneList',
        type:'GET',
        dataType:'html',
        success:function (data) {
            $('#phoneTableId').html(data);
        }
    });
}

function addCustomer() {

    var customerName= $('#cusnameId').val();
    var customerSurname= $('#cussurnameId').val();
    var card= $('#cuscardId').val();
    var address= $('#cusaddressId').val();
    var dob= $('#cusdobid').val();

    var data={
        customerName: customerName,
        customerSurname: customerSurname,
        card: card,
        address: address,
        dob: dob

    };

    $.ajax({
        url:'cs?action=addCustomer',
        type:'POST',
        dataType:'text',
        data: data,
        complete:function (data) {
            alert('customer was added successfully');
            getCustomerList();
        }

    });
    
}

function editNotebook(notebookId) {
    globalNotebookId=notebookId;
    $.ajax({
        url:'cs?action=getNotebookById',
        type:'GET',
        data:'notebookId='+notebookId,
        dataType:'html',
        success:function (data) {
            $('#editNotebookDialogId').html(data),
                $('#editNotebookDialogId').dialog('open');
        }
    });

}

function updateNotebook() {
    var Name=$('#nameId1').val();
    var Model=$('#modelId1').val();
    var Display=$('#displayId1').val();
    var Processor=$('#processorId1').val();
    var Ram=$('#ramId1').val();
    var Videocard=$('#videocardId1').val();
    var Price=$('#priceId1').val();

    var data={
        Name:Name,
        Model:Model,
        Display:Display,
        Processor:Processor,
        Ram:Ram,
        Videocard:Videocard,
        Price:Price,
        notebookId:globalNotebookId
    };

    $.ajax({
        url:'cs?action=updateNotebook',
        type:'POST',
        dataType:'text',
        data:data,
        complete:function (data) {
                alert('Information has changed')
                getNotebookList();

        }
    });

}

function deletenotebook(notebookId) {
    var isDelete=confirm("Delete Notebook?")

    if (isDelete==true){
        $.ajax({
            url:'cs?action=deletenotebook',
            type:'POST',
            data:'notebookId='+notebookId,
            dataType:'text',
            success:function (data) {
                alert('Deleted');
                getNotebookList();
                
            }
        });
    }else {
        alert('could not be deleted')
    }

}