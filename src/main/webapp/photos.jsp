<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <style>
        #customers {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #customers td, #customers th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #customers tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        #customers tr:hover {
            background-color: #ddd;
        }

        #customers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #4CAF50;
            color: white;
        }
    </style>
    <title>Contact V10</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="img/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <!--===============================================================================================-->
</head>
<body>


<div class="container-contact100">

    <div class="wrap-contact100">
        <form class="contact100-form validate-form" method="POST" enctype="multipart/form-data" action="datos"
              name="subida-imagenes">
				<span class="contact100-form-title">
					Four Paws Citizens
				</span>
            <div class="wrap-input100 validate-input" data-validate="Please enter your description">
                <textarea class="input100" name="message" placeholder="Your Message"></textarea>
                <span class="focus-input100"></span>
            </div>
            <input type="file" name="imagen"/>
            <div class="container-contact100-form-btn">
                <button class="contact100-form-btn" href="printTable">
						<span>
							<i class="fa fa-paper-plane-o m-r-6" aria-hidden="true"></i>
							Send
						</span>
                </button>
            </div>
        </form>
    </div>
</div>
<div>
    <table id="customers" class="customers">
        <thead>
        <tr>
            <th>Fecha de carga</th>
            <th>Descripcion</th>
            <th>Fotografia</th>
        </tr>
        </thead>
        <tbody id="lines">
        <tr>
        </tr>
        </tbody>

    </table>

</div>
<script>
    function printTable(servlet) {
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                var data = JSON.parse(xhr.responseText);
                console.log(data)
                var res = document.querySelector('#lines');
                res.innerHTML = '';
                for (let item of data) {
                    res.innerHTML += '<tr>' + '<td>' + item.fecha + '</td>'
                        + '<td>' + item.descripcion + '</td>'
                        + '<td> <img src="fotos\\' + item.foto + '" width="360" height="200">' + '</td>' + '</tr>'
                }
            }
        }
        xhr.open('GET', '${pageContext.request.contextPath}/' + servlet, true);
        xhr.send(null);
    }

    printTable(servlet = 'GetCities')
</script>
<div id="dropDownSelect1"></div>


<!--===============================================================================================-->
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/daterangepicker/moment.min.js"></script>
<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="js/main.js"></script>

</body>
</html>