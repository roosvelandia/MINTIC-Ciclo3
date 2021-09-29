<%-- 
   
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Productos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" crossorigin="anonymous">
    </head>
    <body style="font-family: arial;">
        <div class="d-flex"> 
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador_producto?menu=Productos" method = "POST" class="needs-validation" novalidate>
                        <input type = "file" name="nombre" accept=".csv"
                               class="form-group" size ="50">
                        <br/>
                        <input type="submit" name="accion" value="Cargar" class="btn btn-success m-3" style="background-color: #26A69A;">        
                    </form>                  
                </div>
            </div>
            <div class="col-sm-8">
                <table border="0" cellspacing="5" cellpading="5"class=" table table-striped">
                    <thead>
                        <tr>
                            <th>CODIGO</th>
                            <th>NOMBRE</th>
                            <th>PROVEEDOR</th>
                            <th>PRECIO COMPRA</th>
                            <th>IVA</th>
                            <th>PRECIO VENTA</th>
                    </thead>
                    <tbody>
                        <c:forEach var="e" items="${productos}">
                            <tr>
                                <td>${e.codigo}</td>
                                <td>${e.nombre}</td>
                                <td>${e.nitproveedor}</td>
                                <td>${e.precio_compra}</td>
                                <td>${e.iva}</td>
                                <td>${e.precio_venta}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" 
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" 
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" 
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" 
        crossorigin="anonymous"></script>
        <script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function () {
        'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.prototype.slice.call(forms)
        .forEach(function (form) {
        form.addEventListener('submit', function (event) {
        if (!form.checkValidity()) {
        event.preventDefault()
        event.stopPropagation()
        }
        form.classList.add('was-validated')
        }, false)
        })
        })()
    </script>
    </body>
</html>
