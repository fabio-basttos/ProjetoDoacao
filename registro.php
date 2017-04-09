<?php
    $con = mysqli_connect("fabastos.000webhostapp.com", "id1248671_doacaodb", "projetodoacao", "id1248671_projetodoacao");
    
    $nome = $_POST["nome"];
	$sobrenome = $_POST["sobrenome"];
    $idade = $_POST["idade"];
    $nome_usuario = $_POST["nome_usuario"];
    $senha = $_POST["senha"];
	
    $statement = mysqli_prepare($con, "INSERT INTO usuario (nome, sobrenome, idade, nome_usuario, senha) VALUES (?, ?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "siss", $nome, $sobrenome, $idade, $nome_usuario, $senha);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["sucesso"] = true;  
    
    echo json_encode($response);
?>