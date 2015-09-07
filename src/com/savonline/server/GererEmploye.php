<?php
header('Access-Control-Allow-Origin: *');
require_once 'db.class.php';

function addEmploye($db,$obj){
	$nom=$obj->{'Nom'};
	$prenom=$obj->{'Prenom'};
	$adresse=$obj->{'Adresse'};
	$numTelPort=$obj->{'NumTelPort'};
	$numTelFix=$obj->{'NumTelFix'};
	$Email=$obj->{'Email'};
	$Pwd=$obj->{'Pwd'};
	
	$req="insert into employe (nom_Emp,prenom_Emp,adresse_Emp,numTelMobil,numTelFix,
	emailEmp,passwordEmp)
	values ('$nom','$prenom','$adresse','$numTelPort','$numTelFix','$Email','$Pwd')";
	$res=$db->rq($req);
	$lastIdEmploye=$db->last_id();
	echo $lastIdEmploye;
	$reqAttribRole="insert into attribution_role(id_employe,id_role) values ('$lastIdEmploye',2)";
	$execReq=$db->rq($reqAttribRole);
	echo "ok";
}

function DisplayLstEmploye($obj,$db){

	$req="select * from employe";

	$reqExe=$db->rq($req);
	$jsonEncode="";
	$fiches;
	while($fiches[]=$db->fetch($reqExe)){
	}

	$jsonEncode  = json_encode($fiches);

	echo "{"."\"d\"".":".$jsonEncode."}";

}

?>