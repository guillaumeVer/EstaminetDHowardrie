
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
    <meta name="author" content="Guillaume et Théo">

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
    <link href="css/jq/jquery-ui.css" rel="stylesheet">
    
    <script src="js/jquery-ui.js" type="text/javascript"></script>
    
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js" type="text/javascript"></script>
<script src="gallery.js" type="text/javascript"></script>

</head>

<body>
<div class="list-group">
  <a style=" text-align: center; opacity: 0.9; position: absolute; right: 50px; width: 150px; "  class="list-group-item disabled"> <strong>Connexion</strong>
 
  </a>
  <a style=" text-align: center; opacity: 0.7; position: absolute; right: 50px; top: 62px; width: 150px; " href="Connexion" class="list-group-item"> <strong> Se connecter </strong></a>
  <a  style=" text-align: center; opacity: 0.7; position:absolute; right: 50px; top:105px; width: 150px; " href="Inscription" class="list-group-item"> <strong> S'inscrire </strong></a>
  
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
                        <a href="Index">Le Menu</a>
                    </li>
                    <li>
                        <a href="Reservation">Réservation</a>
                    </li>
                    <li>
                        <a href="Connexion">Avis</a>
                    </li>
                    <li>
                        <a href="Contact">Contact</a>
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
                    <h2 class="intro-text text-center">Votre
                        <strong>Réservation</strong>
                    </h2>
                    <hr>
                   <div class="container">
                   <p style="font-size: 12px;">  <a href="Connexion"> <span class="glyphicon glyphicon-off" aria-hidden="true"></span>  Se connecter</a> </p >


 				<form method="post" action="Reservation" class="form-horizontal" role="form" >
            

           
                
                <div class="form-group">
                    <label for="Nom" class="col-sm-3 control-label">Nom</label>
                    <div class="col-sm-9">
                        <input type="text" id="Nom" required="required" name="Nom" placeholder="Nom" class="form-control" autofocus  style="width:300px;">
                        
                    </div>
                </div>
                 <div class="form-group">
                    <label for="Prénom" class="col-sm-3 control-label">Prénom</label>
                    <div class="col-sm-9">
                        <input type="text" id="Prénom" name="Prenom" placeholder="Prénom" class="form-control" autofocus style="width:300px;">
                        
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">Email</label>
                    <div class="col-sm-9">
                        <input type="email" id="email" name="email" placeholder="Email" class="form-control" style="width:300px;" >
                          <span class="erreur">${erreurs}</span> <br />
                    </div>
                  
                </div>
                    <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <div class="checkbox">
                            
                                
                                 <label>
                                <input type="checkbox" id="creationcompte" name="creationcompte" value ="oui">Créer un compte
                            </label>
                        </div>
                    </div>
                </div> <!-- /.form-group -->


               
                <div class="form-group">
                    <label for="birthDate" class="col-sm-3 control-label">Date de la réservation</label>
                    <div class="col-sm-9">
                     <input type="date" name="bookDate" required id="date" value="" class="col-sm-3 control-label"  autofocus  style="width:300px;" />
 
                        </div>
                </div>
               

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.0/jquery.min.js"></script>
<script src="js/jquery-ui.js"></script>
<script>
   (function() {
      var elem = document.createElement('input');
      elem.setAttribute('type', 'date');
 
      if ( elem.type === 'text' ) {
         $('#date').datepicker(); 
      }
   })();
 
</script>

                   <div class="form-group">
                    <label for="country" class="col-sm-3 control-label">Nombre de personnes</label>
                    <div class="col-sm-9">
                        <select id="nb" name="nb" class="form-control" style="width:300px;">
                           
<option>1</option>
<option>2</option>
<option>3</option>
<option>4</option>

</select>

</div>
</div>

                

                <div class="form-group">
                	<label for="country" class="col-sm-3 control-label">Horaire</label>
                	 <div class="col-sm-9">
              			 <select id="horaire" required name="horaire" class="form-control" style="width:300px;">
                        
							<c:forEach var="horaire" items="${listedHoraires}">
									<option value="${horaire.idHoraire}">${horaire.intervalle}</option>
								</c:forEach>
								
						</select>
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


                

                    
               
              
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                      <button type="submit" class="btn btn-primary btn-block" style="width:300px;" >Réserver</button>
                    </div>
                </div>
            </form> <!-- /form -->
        </div> <!-- ./container -->
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
    <script src="js/jquery.js">
    jQuery(function($){

  var settings = {
    thumbListId: "thumbs",
    imgViewerId: "viewer",
    activeClass: "active",
    activeTitle: "Photo en cours de visualisation",
    loaderTitle: "Chargement en cours",
    loaderImage: "images/loader.gif"
  };

  var thumbLinks = $("#"+settings.thumbListId).find("a"),
    firstThumbLink = thumbLinks.eq(0),
    highlight = function(elt){
      thumbLinks.removeClass(settings.activeClass).removeAttr("title");
      elt.addClass(settings.activeClass).attr("title",settings.activeTitle);
    },
    loader = $(document.createElement("img/plan")).attr({
      alt: settings.loaderTitle,
      title: settings.loaderTitle,
      src: settings.loaderImage
    });

  highlight(firstThumbLink);

  $("#"+settings.thumbListId).after(
    $(document.createElement("p"))
      .attr("id",settings.imgViewerId)
      .append(
        $(document.createElement("img/plan")).attr({
          alt: "",
          src: firstThumbLink.attr("href")
        })
      )
  );

  var imgViewer = $("#"+settings.imgViewerId),
    bigPic = imgViewer.children("img");

  thumbLinks
    .click(function(e){
      e.preventDefault();
      var $this = $(this),
        target = $this.attr("href");
      if (bigPic.attr("src") == target) return;
      highlight($this);
      imgViewer.html(loader);
      bigPic
        .load(function(){
          imgViewer.html($(this).fadeIn(250));
        })
        .attr("src",target);
    });

});
</script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
