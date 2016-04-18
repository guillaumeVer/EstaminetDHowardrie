
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="fr">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Eviter le plantage sur InternetExplorer-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Eviter mauvaise taille smartphone-->

    <meta name="description" content="Notre Site">
    <meta name="author" content="Guillaume et Theo">

    <title>Projet- Site Internet Estaminet Howardries</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<div class="list-group">
  <a style=" text-align: center; opacity: 0.9; position: absolute; right: 50px; width: 150px; "  class="list-group-item disabled"> <strong>Connexion</strong>
 
  </a>
  <a style=" text-align: center; opacity: 0.7; position: absolute; right: 50px; top: 62px; width: 150px; " href="connexion.html" class="list-group-item"> <strong> Se connecter </strong></a>
 
</div>
  <div  class="brand" > <a href="Intro" style="color: #FFFAF0;"> Estaminet d'Howardries </a> </div>
    <div class="address-bar">1199 rue Prevost 59226, Rumegies</div>

    <!-- Navigation -->
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
                <a class="navbar-brand" href="Index">Estaminet d'Howardries</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="index.html">Les Plats</a>
                    </li>
                     <li>
                        <a href="connexion.html">Les Boissons</a>
                    </li>
                    <li>
                        <a href="AcceuilAdministrateur">Reservation</a>
                    </li>
                   
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    <div class="container">

        <div class="row">
            <div class="box">
                
                <div class="col-lg-12">
                     <h2>Reservation à venir</h2>
             
  <table class="table">
    <thead>
      <tr>
        <th>Nom</th>
        <th>Date</th>
        <th>Table</th>
        <th>Horaire</th>
        <th>Nombre De Personne</th>
      </tr>
    </thead>
    
    <tbody>
   		 <c:forEach var="reservation" items="${listedeReservation}">
      <tr class="success">
        <td>${reservation.nomReservation}</td>
        <td>${reservation.date}</td>
        <td>${reservation.table.nomTable}</td>
        <td>${reservation.horaire.intervalle}</td>
        <td>${reservation.nbPersonne}</td>
      </tr>
      	</c:forEach>
    
    </tbody>
  </table>
                </div>
                <div class="col-lg-12">
                   
                </div>
                <div class="clearfix"></div>
            </div>
        </div>

        
            </div>
        </div>

    </div>
    <!-- /.container -->

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p>Copyright &copy; Notre site</p>
                </div>
            </div>
        </div>
    </footer>

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
