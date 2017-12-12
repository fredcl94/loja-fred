
<%@page import="cdc.util.CarrinhoDAO"%>
<%@page import="model.Produto"%>
<%@page import="model.Produto"%>
<%@page import="java.util.List"%>
<%@page import="cdc.util.ProdutoDAO"%>
<%
    HttpSession sessao = request.getSession();//pegando a sessão ativa
    if (sessao.getAttribute("inputEmail") == null) {
        //dispacha o cabra pra tela de login
        response.sendRedirect("./login.jsp");
    }

    String resposta = (request.getAttribute("resposta") != null) ? request.getAttribute("resposta").toString() : "";
    //String resposta = request.getAttribute("resposta").toString();
    
   
%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="template/head.jsp" %>

    </head>
    <body class="fundo">
        <!-- início do corpo do site -->

        <div class="container">
            <!-- estas linhas abaixo são obrigatórias para chamar o cabeçalho, passando como parâmetro a página atual, para que possamos montar o menu superior -->
            <jsp:include page="template/cabecalho.jsp" >
                <jsp:param name="atual" value="inicio" />
            </jsp:include>
            <div class="row">
                <div class="col-md-3">
                    <%@include file="template/menu.jsp" %>
                </div>    

                <div class="col-md-9">
                    <div class="alert alert-success" role="alert"><%=resposta%></div>
                    <fieldset>
                        <legend><strong>Produtos Para Compra </strong></legend>
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered" id="tab-produto" align="center" border="1px" width="90%">
                                <tr>  
                                    <th>Codigo</th>
                                    <th>Nome</th>
                                    <th>Descrição</th>
                                    <th>Valor</th>
                                    <th>Quantidade</th>
                                    <th>Marca</th>
                                    <th>Categoria</th>
                                    <th>Comprar</th>
                                </tr>
                                <%

                                    ProdutoDAO produtoDAO = new ProdutoDAO();
                                    List<Produto> lista;
                                    lista = produtoDAO.listaTodos();

                                    for (Produto p : lista) {

                                %>
                                <tr>
                                    <td><%= p.getPRO_ID()%></td>
                                    <td><%= p.getPRO_NOME()%></td>
                                    <td><%= p.getPRO_DESCRICAO()%></td>
                                    <td><%= p.getPRO_VALOR()%></td>
                                    <td><%= p.getPRO_QUANTIDADE()%></td>
                                    <td><%= p.getPRO_MARCA()%></td>
                                    <td><%= p.getPRO_CATEGORIA()%></td>
                                    <td><form action="./compras" method="POST"> <input type="hidden" name="idProduto" id="idProduto" value="<%= p.getPRO_ID()%>"><button type="submit" name="acao" value="comprar" class="btn btn-sm btn-default" ><span class="glyphicon glyphicon-shopping-cart"></span></button></form></td>

                                </tr>
                                <%
                                    }
                                %>

                            </table>
                        </div>
                    </fieldset>
                </div>    
            </div>    

            <%@include file="template/rodape.jsp" %>
        </div>
        <!-- fim do corpo do site -->
    </body>
</html>
