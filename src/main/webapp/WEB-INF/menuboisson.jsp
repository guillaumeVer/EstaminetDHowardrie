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
<meta name="author" content="Guillaume et ThÃ©o">

<title>Projet- Site Internet Estaminet Howardries</title>

<!-- Bootstrap Core CSS -->
<link href="../../css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../../css/business-casual.css" rel="stylesheet">

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
		<a
			style="text-align: center; opacity: 0.9; position: absolute; right: 50px; width: 200px;"
			class="list-group-item disabled"> <strong>Bienvenue sur
				la page administrateur</strong>

		</a> <a
			style="text-align: center; opacity: 0.7; position: absolute; right: 50px; top: 82px; width: 200px;"
			href="Deconnexion" class="list-group-item"> <strong> Se
				Deconnecter </strong></a> <a
			style="text-align: center; opacity: 0.7; position: absolute; right: 50px; top: 125px; width: 200px;"
			href="ProfilAdministrateur" class="list-group-item"> <strong>
				Mon Profil </strong></a>

	</div>
	<div class="brand">
		<a href="AcceuilAdministrateur" style="color: #FFFAF0;"> Estaminet
			d'Howardries </a>
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
				<a class="navbar-brand" href="AcceuilAdministrateur">Estaminet
					d'Howardries</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="Plats">Les Plats</a></li>
					<li><a href="Boissons">Les Boissons</a></li>
					<li><a href="AcceuilAdministrateur">Réservation</a></li>
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
						Le Menu <strong>Boisson</strong>
					</h2>
					<hr>
				</div>
				<div class="col-lg-12">


					<table class="table">
						<thead>
							<tr>
								<th>Plat</th>
								<th>Prix</th>
								<th>Description</th>
								<th>Modifier</th>
								<th>Supprimer</th>
								<th>Plat du jour</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="boisson" items="${listeDeBoisson}">
								<tr>
									<td>${boisson.nomBoisson}</td>
									<td>${boisson.prix}</td>
									<td>${boisson.descriptionBoisson}</td>
									<td><a href="ModifierBoisson?id=${boisson.idBoisson}"
										class="btn btn-default btn-lg" role="button"
										style="width: 200px;"> Modifier </a></td>
									<td><a href="SupprimerBoisson?id=${boisson.idBoisson}"
										class="btn btn-default btn-lg" role="button"
										style="width: 200px;"> Supprimer </a></td>
									<td><c:if test="${boisson.boissonDuMois != true}">
											<a href="BoissonDuMois?id=${boisson.idBoisson}"
												class="btn btn-default btn-lg" role="button"
												style="width: 200px;"> Boisson Du Mois </a>
												</c:if>
												</td>
										
								</tr>
							</c:forEach>
							</tbody>
					</table>


				</div>
				<div class="clearfix"></div>
			</div>
		</div>

		<div class="row">
			<div class="box">
				<div class="col-lg-12">
					<hr>
					<h2 class="intro-text text-center">
						Ajouter <strong>Une boisson</strong>
					</h2>
					<hr>
					<div class="container">


						<form class="form-horizontal" role="form" method="post" action="Boissons" accept-charset="UTF-8">

							<div class="form-group">
								<label for="Nom" class="col-sm-3 control-label">Nom de la boisson</label>
								<div class="col-sm-9">
									<input type="text" id="Nom" name="Nom" placeholder="Nom"
										class="form-control" autofocus style="width: 300px;" required>


								</div>
							</div>

							<div class="form-group">
								<label for="PrÃ©nom" class="col-sm-3 control-label">Description</label>
								<div class="col-sm-9">
									<input type="text" id="Description" name="Description" placeholder="Description"
										class="form-control" autofocus style="width: 300px;" required>


								</div>
							</div>


							<div class="form-group">
								<label for="PrÃ©nom" class="col-sm-3 control-label">Prix</label>
								<div class="col-sm-9">
									<input type="number" step="0.01" id="Prix" name="Prix" placeholder="Prix"
										class="form-control" autofocus style="width: 300px;" required>


								</div>
							</div>


							

						
							
							




							<!-- /.form-group -->

							<div class="form-group">
								<div class="col-sm-9 col-sm-offset-3">
									<button type="submit" class="btn btn-primary btn-block"
										style="width: 150px;">Ajouter</button>
								
								</div>
							</div>
						</form>
						<!-- /form -->
					</div>
					<!-- ./container -->
					<hr>

				</div>

			</div>
		</div>
	</div>

	
	<!-- /.container -->

	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<p>Copyright &copy; Your Website 2014</p>
				</div>
			</div>
		</div>
	</footer>

	<!-- jQuery -->
	<script src="../../js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../../js/bootstrap.min.js"></script>

</body>

</html>
