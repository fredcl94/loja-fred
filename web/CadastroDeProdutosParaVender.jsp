

<%
    HttpSession sessao = request.getSession();//pegando a sessão ativa
    if(sessao.getAttribute("statusLogin") == null){
        //dispacha o cabra pra tela de login
         RequestDispatcher rd = request.getRequestDispatcher("/login.jsp?respCadastro=nãoLogado");
        rd.forward(request, response);
       
    }
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>Compra Facil - CADASTRO DE PRODUTO</title>


        <%@include file="template/head.jsp" %>

    </head>
    <body class="fundo">

        <form action="./controladorCadastroDeProdutosParaVender" method="POST" enctype="multipart/form-data">

            <div class="container">
                <!-- estas linhas abaixo são obrigatórias para chamar o cabeçalho, passando como parâmetro a página atual, para que possamos montar o menu superior -->
                <jsp:include page="template/cabecalho.jsp" >
                    <jsp:param name="atual" value="conta" />
                </jsp:include>

                <div class="form-group">
                    <label for="inputNome">Nome do Produto</label>
                    <input type="text" class="form-control" name="inputNome" placeholder="Nome do Produto" required>
                                    
                    <label for="inputDescricao">Descrição do Produto</label>
                    <input type="text" class="form-control" name="inputDescricao" placeholder="Descriçao do Produto" required>

                   <label for="inputValor">Valor do Produto</label>
                    <input type="text" class="form-control" name="inputValor" placeholder="Valor do Produto" required>
                             
                    <label for="inputQuantidade">Quantidade do Produto</label>
                    <input type="text" class="form-control" name="inputQuantidade" placeholder="Quantidade do Produto" required>
                                                 
                    <label for="inputMarca">Marca do Produto</label>
                    <input type="text" class="form-control" name="inputMarca" placeholder="Marca do Produto" required>
                    
                    <label for="inputCategoria">Categoria do Produto</label>
                    <input type="text" class="form-control" name="inputCategoria" placeholder="Categoria do Produto" required>
                
                
                </div>
                <button class="btn btn-lg btn-primary " type="submit">Cadastrar</button>
                <button class="btn btn-lg btn-primary " type="reset">Limpar</button> 
                <button class="btn btn-lg btn-warning" type="cancel" onclick="history.go(-1)">Cancelar</button>
        </form>

    </div>
                <br></br>
    <%@include file="template/rodape.jsp" %>

</body>
</html>
