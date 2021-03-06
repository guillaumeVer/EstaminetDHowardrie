<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="fr">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Eviter le plantage sur InternetExplorer-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Eviter mauvaise taille smartphone-->

<meta name="description" content="Notre Site">
<meta name="author" content="Guillaume et Théo">

<title>Projet- Site Internet Estaminet Howardries</title>

<!-- Bootstrap Core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../css/business-casual.css" rel="stylesheet">

<!-- Fonts -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<div class="list-group">
  <a style="margin-top:15px; margin-left: 1650px; margin-right: 17px; text-align: center; opacity: 0.9; "  class="list-group-item disabled"> <strong>Bonjour ${user.nom}</strong>
  </a>
  
  <a style="margin-left: 1650px; margin-right: 17px; text-align: center; opacity: 0.7; " href="Deconnexion" class="list-group-item"> <strong> Se deconnecter </strong></a>

  
</div>


	<!-- <p style="font-size: 25px; text-align: right; margin-right: 10px; color: E6D3A8; ">  <a href="connexion.html"> Se connecter <span class="glyphicon glyphicon-off" aria-hidden="true"></span></a> </p>

<p style="font-size: 25px;text-align: right; margin-right: 10px; ">  <a href="inscription.html"> S'inscrire <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a> </p> 


 <!-- <p style="text-align: right; margin-top: 10px;" ><a href="connexion.html"> <button class="btn btn-lg btn-warning "style="width: 350px;">Se connecter</button></a> </p>
<p style="text-align: right; margin-top: 10px;" ><a href="inscrire.html"> <button class="btn btn-lg btn-warning "style="width: 350px;">S'inscrire</button></a> </p> -->

	<div class="brand">
		<a href="Intro" style="color: #FFFAF0;"> Estaminet d'Howardries </a>
	</div>
	<div class="address-bar">1199 rue Prevost 59226, Rumegies</div>

	<!-- Navigation -->
	<nav class="navbar navbar-default" role="navigation">
		<div class="container">

			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
				<a class="navbar-brand" href="Index">Estaminet d'Howardries</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="Index">Le Menu</a></li>
					<li><a href="Reservation">Réservation</a></li>
					<li><a href="Avis">Avis</a></li>
					<li><a href="Contact">Contact</a></li>
					<li><a href="MonProfil">Mon Profil</a></li>
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
					<hr>
					<h2 class="intro-text text-center">
						Notre <strong>Menu</strong>
					</h2>
					<hr>
					<img class="img-responsive img-border img-left"
						src="../img/intro-pic.jpg" alt="">
					<hr class="visible-xs">
					<p>
						<a href="../img/carte.jpg" style="margin-left: 185px;"> Découvrez
							notre carte <span class="glyphicon glyphicon-file"
							aria-hidden="true"></span>
						</a>
					</p>
					<p>Le Plat du Jour est: ${platDuJour.nomPlat}</p>
					<p>Prix : ${platDuJour.prixPlat} €</p>
					<p>Description : ${platDuJour.descriptionPlat}</p>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="box">
				<div class="col-lg-12">
					<hr>
					<h2 class="intro-text text-center">
						Nos <strong>Bières et Boissons</strong>
					</h2>
					<hr>
					<img class="img-responsive img-border img-left"
						src="../img/intro-pic.jpg" alt="">
					<p>
						<a href="../img/carte.jpg" style="margin-left: 185px;">
							Découvrez nos bières <span class="glyphicon glyphicon-grain"
							aria-hidden="true"></span>
						</a>
					</p>
					<p>Voici la bière du mois: ${boissonDuMois.nomBoisson}</p>
					<p>Prix : ${boissonDuMois.prix} €</p>
					<p>Description : ${boissonDuMois.descriptionBoisson}</p>
				</div>
			</div>
		</div>



		<div class="row">
			<div class="box">
				<div class="col-lg-12 text-center">
					<div id="carousel-example-generic" class="carousel slide">
						<!-- Indicators -->
						<ol class="carousel-indicators hidden-xs">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							<div class="item active">
								<img class="img-responsive img-full" src="../img/slide-1.jpg"
									alt="">
							</div>
							<div class="item">
								<img class="img-responsive img-full" src="../img/slide-2.jpg"
									alt="">
							</div>
							<div class="item">
								<img class="img-responsive img-full" src="../img/slide-3.jpg"
									alt="">
							</div>
						</div>

						<!-- Controls -->
						<a class="left carousel-control" href="#carousel-example-generic"
							data-slide="prev"> <span class="icon-prev"></span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" data-slide="next"> <span
							class="icon-next"></span>
						</a>
					</div>
					<h2 class="brand-before">
						<small>Voici quelques photos de</small>
					</h2>
					<h1 class="brand-name">L'Estaminet d'Howardries</h1>
					<hr class="tagline-divider">
					<h2>
						<small>Par <strong>J-P LAMBIN</strong>
						</small>
					</h2>
				</div>
			</div>
		</div>






	</div>
	<!-- /.container -->

	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<p>Copyright &copy; Droits</p>
				</div>
			</div>
		</div>
	</footer>

	<!-- jQuery -->
	<script src="../js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../js/bootstrap.min.js"></script>

	<!-- Script to Activate the Carousel -->
	<script>
		$('.carousel').carousel({
			interval : 2000
		//changes the speed
		})
	</script>

</body>

</html>
