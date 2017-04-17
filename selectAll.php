<?php

include ("connect.php");

$sql = "SELECT * FROM usuario";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
	$array_usuario = Array();
    while($row = $result->fetch_assoc()) {
        $array_usuario[] = $row;
    }
	echo json_encode($array_usuario);
} else {
	$myObj = new stdClass();
	$myObj->status = "0";
    echo json_encode($myObj);
}
$conn->close();

?>