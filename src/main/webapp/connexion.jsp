<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<title>Projet</title>

	<!-- Google Fonts -->
	<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="css/animate.css">
	<!-- Custom Stylesheet -->
	<link rel="stylesheet" href="css/style.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</head>

<body>


	<div class="container">
	 <!-- <p style="font-size: 30px;  ">  <a href="index.html"> Retour au site </a> </p> -->
		<div class="top">
			<h1 id="title" class="hidden"><span id="logo">L'Estaminet d'Howardries <span>Connexion</span></span></h1>
		</div>
		<div class="login-box animated fadeInUp">
		
			<form class="form-horizontal" role="form" method="post" action="Connexion">
			<div class="box-header">
				<h2 style="font-size: 35px;">Connectez Vous</h2>
			</div>
            <br/>
			
			<label for="username" style="font-size: 25px;">Adresse mail</label>
			<br/>
			<input type="email" id="username" name="username">
			<br/>
			<label for="password" style="font-size: 25px;">Mot de passe</label>
			<br/>
			<input type="password" id="password" name="password">
			<br/>
			<button type="submit" style="font-size: 25px;">Connexion</button>
			<br/>
			
			</form>
			<a href="Inscription"><p style="font-size: 25px;" >S'inscrire</p></a>
			<p style="font-size:20px;"> ou </p>
			<a href="Intro"><p style="font-size: 25px;" >Revenir au site</p></a>
		</div>
	</div>
</body>

<script>
	$(document).ready(function () {
    	$('#logo').addClass('animated fadeInDown');
    	$("input:text:visible:first").focus();
	});
	$('#username').focus(function() {
		$('label[for="username"]').addClass('selected');
	});
	$('#username').blur(function() {
		$('label[for="username"]').removeClass('selected');
	});
	$('#password').focus(function() {
		$('label[for="password"]').addClass('selected');
	});
	$('#password').blur(function() {
		$('label[for="password"]').removeClass('selected');
	});
</script>

</html>