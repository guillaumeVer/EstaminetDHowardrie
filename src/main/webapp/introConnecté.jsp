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
    <meta name="author" content="Guillaume et ThÃ©o">

    <title>Projet- Site Internet Estaminet Howardries</title>

    <!-- Bootstrap Core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../css/business-casual.css" rel="stylesheet">

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

<body class="intro">


<div class="list-group">
  <a style="margin-top:15px; margin-left: 1650px; margin-right: 17px; text-align: center; opacity: 0.9; "  class="list-group-item disabled"> <strong>Bonjour <% 
            String attribut = (String) request.getAttribute("nom");
            out.println( attribut );
            %></strong>
  </a>
  <a style="margin-left: 1650px; margin-right: 17px; text-align: center; opacity: 0.7; " href="Deconnexion" class="list-group-item"> <strong> Se deconnecter </strong></a>

  
</div>
    <div class="brand">Estaminet d'Howardries</div>
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
           

            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

   


       

       <div class="container">
	<div class="row">
        
               
           
                      
            			<p style="text-align: center; margin-top: 70px;" ><a href="Index"> <button class="btn btn-lg btn-warning "style="width: 550px; height: 80px; font-size:26px; "> Consulter notre menu  <span class="glyphicon glyphicon-home" aria-hidden="true"></span> </button></a> </p>
            			<p style="text-align: center; margin-top: 70px;"> <a href="Reservation"><button class="btn btn-lg btn-danger" style="width: 550px; height: 80px; font-size:26px;">Reserver une table <span class="glyphicon glyphicon-phone-alt" aria-hidden="true"></span></button> </a></p>
                   
                		<p style="text-align: center; margin-top: 70px;"> <a href="Connexion"><button class="btn btn-lg btn-progress" style="width: 550px; height: 80px; font-size:26px;">Donner et voir les avis <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button> </a></p>
            			
            			
              
              
               
           
		</div>
	</div>
</div>



  

 
  <!--* <p style="text-align: center; margin-top: 150px; "> <a class="btn btn-primary btn-lg" href="index.html" role="button" style="width: 450px; background-color:#C94503; border-color: #000000 ;" >Voir le Menu</a> </p>
 <p style="text-align: center; margin-top:25px; "> <a class="btn btn-primary btn-lg" href="reservation.html" role="button" style="width: 450px; background-color:#AB3A01; border-color: #000000;" >Faire une reservation</a> </p>
 <p style="text-align: center; margin-top: 25px; "> <a class="btn btn-primary btn-lg" href="inscription.html" role="button" style="width: 450px; background-color:#9B3401; border-color: #000000;" >Consulter les avis</a> </p>
 <p style="text-align: center; margin-top: 25px; "> <a class="btn btn-primary btn-lg" href="contact.html" role="button" style="width: 450px; background-color:#873207; border-color: #000000;" >En savoir plus</a> </p> -->






    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p>Copyright &copy; Droits</p>
                </div>
            </div>
        </div>
    </footer>



    </div>
    <!-- /.container -->

   

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Script to Activate the Carousel -->
   

</body>

</html>
