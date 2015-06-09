<?php 

header('Access-Control-Allow-Origin: *');
require_once 'db.class.php';

function AddPrivilege($db,$obj){
	$privilege=$obj->{'Privilege'};
	$req="insert into privilege (privilege) values('$privilege')";
	$res=$db->rq($req);
	$MySqlClose=$db->close();
}

function AffichePrivilege($db,$obj){

	$req="select * from privilege";

	$reqExe=$db->rq($req);
	$jsonEncode="";
	$fiches;
	while($fiches[]=$db->fetch($reqExe)){

	}

	$jsonEncode  = json_encode($fiches);

	echo "{"."\"d\"".":".$jsonEncode."}";
	$MySqlClose=$db->close();
}

function deletePrivilege($db,$obj){
	echo "test";
	$id_privilege=$obj->{'Id_Privilege'};
	$req="Delete from privilege where id_privilege='$id_privilege'";
	$res=$db->rq($req);
	$MySqlClose=$db->close();
}

?>