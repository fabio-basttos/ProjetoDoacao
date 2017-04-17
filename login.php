<?php
    $con = mysqli_connect("mysql.hostinger.com.br", "u785734729_opet", "projetodoacao", "u785734729_doadb");
    
    $nome_usuario = $_POST["nome_usuario"];
    $senha = $_POST["senha"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM usuario WHERE nome_usuario = ? AND senha = ?");
    mysqli_stmt_bind_param($statement, "ss", $nome_usuario, $senha);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $id_usuario, $nome, $sobrenome, $nome_usuario, $senha, $idade);
    
    $response = array();
    $response["sucesso"] = false;  
    
    while(mysqli_stmt_fetch($statement)){
        $response["sucesso"] = true;  
        $response["nome"] = $nome;
		$responde["sobrenome"] = $sobrenome;
		$response["nome_usuario"] = $nome_usuario;
		$response["senha"] = $senha;
        $response["idade"] = $idade;
    }
	//echo $nome_usuario;
	echo json_encode($response);
?>