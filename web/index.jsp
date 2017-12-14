
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
            <!-- Seção Carrousel -->
            <section id="carrousel">
                <div class="container">
                    <div id="myCarousel" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                            <li data-target="#myCarousel" data-slide-to="1"></li>
                            <li data-target="#myCarousel" data-slide-to="2"></li>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner" role="listbox">

                            <div class="item active">
                                <img src="./img/nfs.jpg" alt="Need For Speed">
                                <div class="carousel-caption msg-carousel">
                                    <h3>Need For Speed</h3>
                                </div>
                            </div>

                            <div class="item">
                                <img src="./img/nitendo_wii.jpg" alt="Nitendo">
                                <div class="carousel-caption msg-carousel">
                                    <h3>Nitendo Wii</h3>
                                </div>  
                            </div>

                            <div class="item">
                                <img src="./img/xbox_one.jpg" alt="Xbox">
                                <div class="carousel-caption msg-carousel">
                                    <h3>Xbox one</h3>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- /Seção Carrousel -->

            <section class="container" id="destaques">
                <h3><span class="glyphicon glyphicon-tags" aria-hidden="true"> </span> Destaques</h3>
                <div class="row display-flex">
                    <!--linha destaques -->
                    <div class="col-sm-6 col-md-3 space-bottom-5">
                        <div class="thumbnail">
                            <img src="./img/xbox_one.jpg" class="img-responsive" alt="Martela Thor">
                            <div class="caption">
                                <h3>Martelo do Thor</h3>
                                <p>Excelente para enfrentar os mais diversos perigos</p>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-3 space-bottom-5">
                        <div class="thumbnail">
                            <img src="./img/xbox_one.jpg" class="img-responsive" alt="Livro comuna">
                            <div class="caption">
                                <h3>Livro contra-comunismo</h3>
                                <p>Bestseller nacional</p>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-3 space-bottom-5">
                        <div class="thumbnail">
                            <img src="./img/xbox_one.jpg" class="img-responsive" alt="Vestido Festa">
                            <div class="caption">
                                <h3>Vestido de Festa</h3>
                                <p>Excelente para comemorações fúnebres!</p>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-3 space-bottom-5">
                        <div class="thumbnail">
                            <img src="./img/xbox_one.jpg" class="img-responsive" alt="Dentadura">
                            <div class="caption">
                                <h3>Dentadura Completa</h3>
                                <p>Que tal mudar as mordidas?!</p>
                            </div>
                        </div>
                    </div>
                    <!--//linha destaques -->
                </div>
                <span id="emprestar"></span>
            </section>
            <%@include file="template/rodape.jsp" %>
        </div>






        <div class="row">
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
        <!-- fim do corpo do site -->
    </body>
</html>
