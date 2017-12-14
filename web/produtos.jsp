

<%@page import="cdc.util.FotosDAO"%>
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
                <div class="col-md-3">
                    <a href="CadastroDeProdutosParaVender.jsp" class="btn btn-success btn-menu" role="button">Cadastro de Produtos</a>
                    <a href="./compras.jsp" class="btn btn-success btn-menu" role="button">Meus Produtos - De Compras </a>
                    <a href="ControladorVendas.jsp?cmd=listarVendas" class="btn btn-success btn-menu" role="button">Minhas Vendas</a>
                </div>
                <div class="col-md-9">
                    <fieldset>
                        <legend><strong>Lista de Produtos</strong></legend>
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
                                    <th>Foto</th>
                                </tr>
                                <%
                                    ProdutoDAO produtoDAO = new ProdutoDAO();
                                    List<Produto> lista;
                                    lista = produtoDAO.listaTodos();
                                    for (Produto p : lista) {
                                        FotosDAO fotoDao = new FotosDAO(); 
                                        boolean temFoto = fotoDao.verificaSeExisteFotoDoProduto(p.getPRO_ID()); 
                                %>
                                <tr>
                                    <td><%= p.getPRO_ID()%></td>
                                    <td><%= p.getPRO_NOME()%></td>
                                    <td><%= p.getPRO_DESCRICAO()%></td>
                                    <td><%= p.getPRO_VALOR()%></td>
                                    <td><%= p.getPRO_QUANTIDADE()%></td>
                                    <td><%= p.getPRO_MARCA()%></td>
                                    <td><%= p.getPRO_CATEGORIA()%></td>
                                    <td><button type="button" id="img" onclick="abreGerenciadorFotos(<%= p.getPRO_ID()%>);" class="btn btn-sm <%= (temFoto == true) ? "btn-success" : "btn-danger"%>" ><span class="glyphicon glyphicon-camera"></span></button></td>
                                </tr>
                                <%
                                    }
                                %>
                            </table>
                        </div>
                    </fieldset>
                </div>    
            </div>
        </div>
        <!-- Modal -->
        <div class="modal fade" id ="janelaFotos">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h4 class="modal-title">Upload de Imagem do Produto</h4>
                    </div>
                    <form action ="./fotos" name ="frmproduto" method="post" enctype="multipart/form-data">
                        <div class="modal-body">
                            <div class="container">
                                <input type="hidden" id="idProduto-modal" name="idProduto" value="" />           
                                <div class="form-group row">
                                    <div class="">
                                        <input id="file" class="btn btn-primary form-control" type="file" name="inputImagem"><p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type ="submit" class="btn btn-primary " value="salvar" >Salvar</button>
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Modal -->    
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
