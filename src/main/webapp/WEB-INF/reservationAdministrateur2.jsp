
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
<meta name="author" content="Guillaume et Theo">

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

					<h2 class="intro-text text-center">
						Plan du <strong>Restaurant</strong>
					</h2>

					<center>

						<img id="Image-Maps-Com-image-maps-2016-05-02-104002"
							src="http://www.image-maps.com/m/private/0/3e99fku1d63kg58bbkhi7uige5_tn_plan.png"
							border="0" width="410" height="358"  usemap="#image-maps-2016-05-02-104002" alt="" />
					</center>
					<map name="image-maps-2016-05-02-104002"
						id="ImageMapsCom-image-maps-2016-05-02-104002">
						<area id="T1" alt="" title="T1: 4 personnes "
							 shape="rect"
							coords="317,264,388,333" style="outline: none;" target="_self" />
						<area id="T2" alt="" title="T2" 
							shape="rect" coords="228,265,305,334" style="outline: none;"
							target="_self" />
						<area id="T3" alt="" title="T3" 
							shape="rect" coords="140,265,214,334" style="outline: none;"
							target="_self" />
						<area id="T4" alt="" title="T4" 
							shape="rect" coords="50,265,133,342" style="outline: none;"
							target="_self" />
						<area id="T5" alt="" title="T5" 
							shape="rect" coords="223,166,319,248" style="outline: none;"
							target="_self" />
						<area id="T6" alt="" title="T6" 
							shape="rect" coords="22,101,153,177" style="outline: none;"
							target="_self" />
						<area id="T7" alt="" title="T7" 
							shape="rect" coords="27,189,169,261" style="outline: none;"
							target="_self" />
						<area shape="rect" coords="408,356,410,358" alt="Image Map"
							style="outline: none;" title="Image Map"
							href="http://www.image-maps.com/index.php?aff=mapped_users_65231" />

					</map>


				</div>
				<div></div>
				<div class="col-md-4"></div>
				<div class="clearfix"></div>
			</div>
		</div>

		<div class="row">
			<div class="box">
				<div class="col-lg-12">
					<form method="post" action="ReservationAdministrateur2" class="form-horizontal"
						role="form">
						<h2 class="intro-text text-center">
							Votre <strong>Reservation</strong>
						</h2>
						<hr>
						<div class="container">





							<div class="form-group">
								<label for="country" class="col-sm-3 control-label">Table</label>
								<div class="col-sm-9">
									<select id="table" name="table" class="form-control"
										style="width: 300px;">

										<c:forEach var="table" items="${listeDeTable}">
											<option value="${table.idTable}">${table.nomTable}</option>
										</c:forEach>

									</select>
								</div>
							</div>

						</div>



						<!--  <div class="container"> 
    <div class="col-sm-6" style="height:130px;">
        <div class="form-group">
            <div class='input-group date' id='datetimepicker11'>
                <input type='text' class="form-control" />
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar">
                    </span>
                </span>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        $(function () {
            $('#datetimepicker11').datetimepicker({
                daysOfWeekDisabled: [0, 6]
            });
        });
    </script>
</div> */ -->






						<!-- /.form-group -->
						<div class="form-group">
							<div class="col-sm-9 col-sm-offset-3">
								<div class="checkbox"></div>
							</div>
						</div>
						<!-- /.form-group -->
						<div class="form-group">
							<div class="col-sm-9 col-sm-offset-3">
								<button type="submit" class="btn btn-primary btn-block"
									style="width: 300px;">Terminer ma Reservation</button>
								
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
	<script src="../js/jquery.js">
		jQuery(function($) {

			var settings = {
				thumbListId : "thumbs",
				imgViewerId : "viewer",
				activeClass : "active",
				activeTitle : "Photo en cours de visualisation",
				loaderTitle : "Chargement en cours",
				loaderImage : "images/loader.gif"
			};

			var thumbLinks = $("#" + settings.thumbListId).find("a"), firstThumbLink = thumbLinks
					.eq(0), highlight = function(elt) {
				thumbLinks.removeClass(settings.activeClass)
						.removeAttr("title");
				elt.addClass(settings.activeClass).attr("title",
						settings.activeTitle);
			}, loader = $(document.createElement("img/plan")).attr({
				alt : settings.loaderTitle,
				title : settings.loaderTitle,
				src : settings.loaderImage
			});

			highlight(firstThumbLink);

			$("#" + settings.thumbListId).after(
					$(document.createElement("p")).attr("id",
							settings.imgViewerId).append(
							$(document.createElement("img/plan")).attr({
								alt : "",
								src : firstThumbLink.attr("href")
							})));

			var imgViewer = $("#" + settings.imgViewerId), bigPic = imgViewer
					.children("img");

			thumbLinks.click(function(e) {
				e.preventDefault();
				var $this = $(this), target = $this.attr("href");
				if (bigPic.attr("src") == target)
					return;
				highlight($this);
				imgViewer.html(loader);
				bigPic.load(function() {
					imgViewer.html($(this).fadeIn(250));
				}).attr("src", target);
			});

		});
	</script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../js/bootstrap.min.js"></script>

</body>

</html>
