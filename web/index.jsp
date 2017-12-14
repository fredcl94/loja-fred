
<%@page import="model.ProdutoComFoto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cdc.util.FotosDAO"%>
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

        <%            ProdutoDAO prodDao = new ProdutoDAO();
            ArrayList<ProdutoComFoto> produtos = (ArrayList<ProdutoComFoto>) prodDao.buscaProdutos();
        %>
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
                            <%
                                for (int i = 0; i < produtos.size(); i++) {
                                    if (i == 0) {
                                        out.print("<li data-target='#myCarousel' data-slide-to='" + i + "' class='active'></li>");
                                    } else {
                                        out.print("<li data-target='#myCarousel' data-slide-to='" + i + "'></li>");
                                    }
                                }

                            %>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner" role="listbox">
                            <%                                int i = 0;

                                for (ProdutoComFoto p : produtos) {
                                    if (i == 0) {
                                        out.print("<div class='item active'>"
                                                + " <img src='./img/" + p.getFoto().getFOTO_NOME() + "' alt='" + p.getProduto().getPRO_NOME() + "'>"
                                                + " <div class='carousel-caption msg-carousel'>"
                                                + " <h2>" + p.getProduto().getPRO_NOME() + "</h2>"
                                                + " </div>"
                                                + " </div>");
                                    } else {
                                        out.print("<div class='item'>"
                                                + " <img src='./img/" + p.getFoto().getFOTO_NOME() + "' alt='" + p.getProduto().getPRO_NOME() + "'>"
                                                + " <div class='carousel-caption msg-carousel'>"
                                                + " <h2>" + p.getProduto().getPRO_NOME() + "</h2>"
                                                + " </div>"
                                                + " </div>");
                                    }
                                    i++;
                                }
                            %>
                        </div>
                    </div>
                </div>
            </section>
            <!-- /Seção Carrousel -->
        </div>
        <div class="container">
            <section  id="destaques">
                <%= (produtos.size() > 0) ? "<h3><span class='glyphicon glyphicon-tags' aria-hidden='true'> </span> Produtos disponíveis para compra</h3>" : "<h3>Não há produtos disponíveis para compra</h3>"%>
                <div class="row display-flex">
                    <!--linha destaques -->

                    <%
                        for (ProdutoComFoto p : produtos) {

                            String botaoCarrinho = "";

                            ProdutoDAO produtoDao = new ProdutoDAO();
                            String id = (request.getSession().getAttribute("USU_ID") != null) ? request.getSession().getAttribute("USU_ID").toString() : "0";

                            boolean existe = produtoDao.verificaSeProdutoExisteNoCarrinho(p.getProduto().getPRO_ID(), Integer.parseInt(id));

                            if (existe) {
                                //continua sem montar o botã para comprar o produto. 
                            } else {
                                botaoCarrinho = "<form action='./compras' method='POST'> <input type='hidden' name='idProduto' id='idProduto' value='" + p.getProduto().getPRO_ID() + "'><center><button type='submit' name='acao' value='comprar' class='btn btn-sm btn-default' >+<span class='glyphicon glyphicon-shopping-cart'></span></button></center></form>";

                            }
                            out.print("<div class='col-sm-6 col-md-3 space-bottom-5'>"
                                    + " <div class='thumbnail'> "
                                    + "<img src='./img/" + p.getFoto().getFOTO_NOME() + "' class='img-responsive' alt='" + p.getProduto().getPRO_NOME() + "'>"
                                    + "<div class='caption'>"
                                    + "<center><h4>" + p.getProduto().getPRO_NOME() + "</h4></center>"
                                    + "<center><h5>Descrição: " + p.getProduto().getPRO_DESCRICAO() + "</h5></center>"
                                    + "<center><h5>Marca: " + p.getProduto().getPRO_MARCA() + "</h5></center>"
                                    + "<center><h5>Valor: " + p.getProduto().getPRO_VALOR() + "</h5></center>"
                                    + botaoCarrinho
                                    + " </div>"
                                    + "</div> </div>");
                        }
                    %>
                </div>
                <span id="emprestar"></span>
            </section>
            <%@include file="template/rodape.jsp" %>
        </div>


    </body>
</html>
