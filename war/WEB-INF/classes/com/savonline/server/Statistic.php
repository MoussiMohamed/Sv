<?php
header('Access-Control-Allow-Origin: *');
header('Content-type: text/json');
header('Content-type: application/json');
require_once 'db.class.php';



function getFichestatus($db){



	$req="SELECT nom_etat, count(aef.id_etat_fiche) as count_fiches  FROM attribution_etat_fiche aef, etat_fiche et
			  WHERE aef.id_etat_fiche = et.id_etat_fiche group by nom_etat;";

	$reqExe=$db->rq($req);


	$jsonEncode="";
	$etat_fiches;
	while($etat_fiches[]=$db->fetch($reqExe)){

	}

	$jsonEncode  = json_encode($etat_fiches);

	echo "{"."\"d\"".":".$jsonEncode."}";


}






?>