

<%@page import="model.Compras"%>
<%@page import="cdc.util.ComprasDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cdc.util.ProdutoDAO"%>


<%
    HttpSession sessao = request.getSession();//pegando a sessão ativa
    if (sessao.getAttribute("statusLogin") == null) {
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
        </div>    

        <div class="container"> 

            <div class="row">
                <form action="./compras" method="POST">
                    <div class="col-md-3">
                        <a href="CadastroDeProdutosParaVender.jsp" class="btn btn-success btn-menu" role="button">Cadastro de Produtos</a>
                        <a href="ControladorProdutos?cmd=listarProdutos" class="btn btn-success btn-menu" role="button">Meus Produtos - Para Vendas </a>
                        <a href="ControladorVendas.jsp?cmd=listarVendas" class="btn btn-success btn-menu" role="button">Minhas Vendas</a>

                    </div>

                    <div class="col-md-9">
                        <fieldset>
                            <legend><strong>Lista de Produtos Comprados</strong></legend>
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered" id="tab-pr" align="center" border="1px" width="90%">
                                    <tr>  
                                        <th>Codigo</th>
                                        <th>Nome</th>
                                        <th>Descrição</th>
                                        <th>Valor</th>
                                        <!--                                    <th>Quantidade</th>
                                                                            <th>Marca</th>
                                                                            <th>Categoria</th>
                                                                            <th>Foto</th>-->
                                    </tr>
                                    <%
                                        int idUsuario = (request.getSession().getAttribute("USU_ID") != null) ? Integer.parseInt(request.getSession().getAttribute("USU_ID").toString()) : 0;

                                        ComprasDAO compraDAO = new ComprasDAO();
                                        Compras compra = (Compras) compraDAO.listaCarrinhodoUsuario(idUsuario);

                                        compra.setUSUARIO_USU_ID(idUsuario);

                                        if (compra.getProdutos().size() > 0) {
                                            //continua
                                        } else {
                                            request.getRequestDispatcher("PainelDeControleUsuario.jsp");
                                        }
                                        
                                        request.setAttribute("compra", compra);
                                        for (Produto p : compra.getProdutos()) {
                                            System.out.print(compra.getProdutos().size());
                                    %>
                                    <tr>
                                        <td><%= p.getPRO_ID()%></td>
                                        <td><%= p.getPRO_NOME()%></td>
                                        <td><%= p.getPRO_DESCRICAO()%></td>
                                        <td><%= p.getPRO_VALOR()%></td>
    <!--                                    <td><%= p.getPRO_QUANTIDADE()%></td>
                                        <td><%= p.getPRO_MARCA()%></td>
                                        <td><%= p.getPRO_CATEGORIA()%></td>
                                        <td><button type="button" onclick="abreGerenciadorFotos(<%= p.getPRO_ID()%>);" class="btn btn-sm btn-default" ><span class="glyphicon glyphicon-camera"></span></button></td>-->

                                    </tr>
                                    <%
                                        }
                                    %>

                                </table>
                            </div>
                        </fieldset>
                    </div> 
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Forma de Pagamento</label>
                        <div class="col-xs-5 selectContainer">
                            <select class="form-control" name="forma">
                                <option value="">Forma de pagamento</option>
                                <option value="C">Cartao de credito</option>
                                <option value="D">Debito em conta</option>
                                <option value="B">Boleto</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-5 col-xs-offset-3">
                            <button type="submit" name="acao" id="acao" value="finalizar" class="btn btn-default">Adicionar</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
         
        <footer>
            <%@include file="template/rodape.jsp" %>
        </footer>    
        <!-- fim do corpo do site -->
        <script src="https://markcell.github.io/jquery-tabledit/assets/js/jquery.min.js"></script>
        <script src="https://markcell.github.io/jquery-tabledit/assets/js/bootstrap.min.js"></script>       
        <script src="https://markcell.github.io/jquery-tabledit/assets/js/prettify.min.js" type="text/javascript"></script>
        <script src="https://markcell.github.io/jquery-tabledit/assets/js/tabledit.min.js"></script>
        <script src="https://markcell.github.io/jquery-tabledit/assets/js/custom.js"></script>
        <script src="./js/jsListaProdutos.js" type="text/javascript"></script>
    </body>
</html>
