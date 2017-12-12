
<%
    HttpSession sessao = request.getSession();//pegando a sessão ativa
    if(sessao.getAttribute("statusLogin") == null){
        //dispacha o cabra pra tela de login
         RequestDispatcher rd = request.getRequestDispatcher("/login.jsp?respCadastro=nãoLogado");
        rd.forward(request, response);
       
    }
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <%@include file="template/head.jsp" %>
        <style>
            .btn-menu{
                width: 100%;
                margin-bottom: 2px;
                text-align: center;
            }
        </style>    
    </head>
    <body class="fundo">
        <!-- início do corpo do site -->
        <div class="container">
                    <!-- estas linhas abaixo são obrigatórias para chamar o cabeçalho, passando como parâmetro a página atual, para que possamos montar o menu superior -->
                    <jsp:include page="template/cabecalho.jsp" >
                        <jsp:param name="atual" value="conta" />
                    </jsp:include>        
            
           
            <div class="row">
                <div class="col-md-3">
                    <a href="CadastroDeProdutosParaVender.jsp" class="btn btn-success btn-menu" role="button">Cadastro de Produtos</a>
                    <a href="./compras.jsp" class="btn btn-success btn-menu" role="button">Meus Produtos - De Compras </a>
                    <a href="ControladorProdutos?cmd=listarProdutos" class="btn btn-success btn-menu" role="button">Meus Produtos - Para Vendas </a>
                    <a href="ControladorVendas.jsp?cmd=listarVendas" class="btn btn-success btn-menu" role="button">Minhas Vendas - </a>
                    
                </div>
                <div class="col-md-9">
                    <h3>Painel de controle - Cliente/Vendedor</h3>
                    
                        <%
                            if (request.getAttribute("mensagem")!=null) {                   
                        %>
                        <p style="color:red"><%= request.getAttribute("mensagem") %></p>
                        <%
                            }                
                        %>
                    
                </div>    
            </div>
            <%@include file="template/rodape.jsp" %>
        </div>
        <!-- fim do corpo do site -->
    </body>
</html>
