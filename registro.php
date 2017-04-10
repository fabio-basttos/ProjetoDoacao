<?php
    $con = mysqli_connect("mysql.hostinger.com.br", "u510759690_opet", "projetodoacao", "u510759690_doadb");
    
    $nome = $_POST["nome"];
	$sobrenome = $_POST["sobrenome"];
    $nome_usuario = $_POST["nome_usuario"];
    $senha = $_POST["senha"];
	$idade = $_POST["idade"];
	
    $statement = mysqli_prepare($con, "INSERT INTO usuario (nome, sobrenome, nome_usuario, senha, idade) VALUES (?, ?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "ssssi", $nome, $sobrenome, $idade, $nome_usuario, $senha);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["sucesso"] = true;  
    
    echo json_encode($response);
?>