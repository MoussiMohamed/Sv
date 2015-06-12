<?php

// header('Content-Type');
// header('application/x-www-form-urlencoded');

 header('Content-type: text/json');
 header('Content-type: application/json');
//  Header set Access-Control-Allow-Origin "*"
//  Header set Access-Control-Allow-Headers "X-Requested-With"



//$obj = json_decode($_POST['jsonObj']);
//$priv=$obj->{'privilege'};

$res=mysql_connect("127.0.0.1","root","") or die("probleme a la connexion au serveur") .mysql_error();
$res=mysql_select_db("db_sav") or die("erreur de selection de la base de données") .mysql_error();
$res="select * from fonctionnalite";

$result = mysql_query($res);
//var $jsonResponse;
if (!$result)
{
	echo "echec d insertion";
}
else
{
	$nb=mysql_num_rows($result);
// 	for($i=0;$i<$nb;$i++)
// 	{
// 		//$privilege=mysql_result($result,$i,"privilege");
// 		//$privilege = mysql_fetch_assoc($result);
// 		$row = mysql_fetch_array($result);
// 		//print_r($privilege);
// 		var_dump($row);
		
// 		//echo $privilege;

// 	}

	
	while($row = mysql_fetch_assoc($result))
	{
		$row_set[] = $row;
	}
	echo json_encode($row_set);
	//echo "response server";
	
	 
	
}
mysql_close();
	?>