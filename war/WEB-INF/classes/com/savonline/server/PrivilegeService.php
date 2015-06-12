<?php

if(isset($_POST['jsonObj'])){
	
	$obj = json_decode($_POST['jsonObj']);
	$priv=$obj->{'privilege'};
	
$res=mysql_connect("127.0.0.1","root","") or die("probleme a la connexion au serveur") .mysql_error();
$res=mysql_select_db("db_sav") or die("erreur de selection de la base de données") .mysql_error();
$res="insert into fonctionnalite(privilege) values('$priv')";

$result = mysql_query($res);


if (!$result)
{
	echo "echec d insertion";
}
else
{
	echo "insertion avec succes";
}
	
	
}else{
	echo "missed";
}




function ajoutfiche($obj){
	
	
	//traitement
	
	return 
	
}

?>