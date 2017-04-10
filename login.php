<?php
    $con = mysqli_connect("mysql.hostinger.com.br", "u510759690_opet", "projetodoacao", "u510759690_doadb");
    
    $usuario = $_POST["usuario"];
    $senha = $_POST["senha"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM usuario WHERE nome_usuario = ? AND senha = ?");
    mysqli_stmt_bind_param($statement, "ss", $usuario, $senha);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $id_usuario, $nome, $sobrenome, $idade, $nome_usuario, $senha);
    
    $response = array();
    $response["sucesso"] = false;  
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;  
        $response["nome"] = $nome;
		$responde["sobrenome"] = $sobrenome;
        $response["idade"] = $idade;
        $response["usuario"] = $nome_usuario;
        $response["senha"] = $senha;
    }
    
    echo json_encode($response);
?>