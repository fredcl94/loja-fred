DELIMITER $$
CREATE FUNCTION `function_compra`(
    fforma VARCHAR(2),
    fidUsu INT(11)) RETURNS int(11)
BEGIN
	INSERT INTO `compras`(`COM_FORMA_PAGAMENTO`, `USUARIO_USU_ID`)
    VALUES (fforma, fidUsu);
       return LAST_INSERT_ID();
END$$
DELIMITER ;



DELIMITER $$
CREATE FUNCTION `function_cadastraUsuarios`(
    fnome VARCHAR(100),
    fcpf VARCHAR(45),
    fendereco VARCHAR(100),
    ftelefone VARCHAR(45),
    femail VARCHAR(45),
    fsenha VARCHAR(45),
    ftipo INT) RETURNS int(11)
BEGIN
	INSERT INTO `usuarios`(`nome`, `cpf`, `endereco`, `telefone`, `email`, `senha`, `tipo`)
        values
        (fnome,fcpf,fendereco,ftelefone,femail,fsenha,ftipo);
       return LAST_INSERT_ID();
END$$
DELIMITER ;