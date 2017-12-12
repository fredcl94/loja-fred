

<%@page import="cdc.util.ItemCarrinho"%>
<%@page import="javax.websocket.Session"%>
<%@page import="cdc.util.FotoDAO"%>
<%@page import="model.Foto"%>
<%@page import="java.util.List"%>
<%@page import="model.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cdc.util.ProdutoDAO"%>

<%
//    int id_pro = Integer.parseInt(request.getParameter("PRO_ID"));
//    String cmd = request.getParameter("cmd");
//    if(cmd.equalsIgnoreCase("compra")){
//        HttpSession sessao = request.getSession();
//        List<ItemCarrinho> carrinho = new ArrayList<ItemCarrinho>();
//        carrinho = (ArrayList<ItemCarrinho>) sessao.getAttribute("carrinho");
//        
//        carrinho.add(new ItemCarrinho(new Produto(id_pro, null, null, 0.0, 0, null, null)));
//        
//        sessao.setAttribute("carrinho", carrinho);
//    }
    
String categoria = request.getParameter("categoria");

ProdutoDAO produtoDAO = new ProdutoDAO();
List<Produto> lista;
lista = produtoDAO.listaCategoria(categoria);

FotoDAO fotoDAO = new FotoDAO();
List<Foto> fotoliList;
fotoliList = fotoDAO.listaTodos();
%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="template/head.jsp" %>
        
    </head>
    <body>
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

                    <fieldset>
                        
                        <legend><strong><%= categoria %></strong></legend>
                    <% if(lista.size()>0) { %>    
                        <table align="center" border="1px" width="90%">
                        <tr>  
                            <th>Codigo</th>
                            <th>Nome</th>
                            <th>Imagem</th>
                            <th>Descrição</th>
                            <th>Valor</th>
                            <th>Quantidade</th>
                            <th>Marca</th>
                            <th>Categoria</th>
                            <th>Exclur</th>
                            
                            
                         </tr>
                         <%                                                                                                            
                            for(Produto p: lista ){
                                int idProduto = p.getPRO_ID(); 
                                fotoliList = fotoDAO.procura(new Foto(0, null, idProduto));
                                String srcFoto;
                                if (fotoliList.size()>0)
                                    srcFoto = "img/imgupload/"+idProduto+"/"+fotoliList.get(0).getFOTO_NOME();
                                else
                                    srcFoto = "img/imgupload/semfoto.jpg";
                                             
                        %>
                        <tr>
                            <th><%= p.getPRO_ID() %></th>
                            <th><%= p.getPRO_NOME() %></th>
                            <th><img width="50" height="50" src="<%= srcFoto %>"/></th>
                            <th><%= p.getPRO_DESCRICAO() %></th>
                            <th><%= p.getPRO_VALOR() %></th>
                            <th><%= p.getPRO_QUANTIDADE() %></th>
                            <th><%= p.getPRO_MARCA() %></th>
                            <th><%= p.getPRO_CATEGORIA() %></th>
                            <td><a href="mostrador.jsp?cmd=compra&PRO_ID=<%= p.getPRO_ID() %>">Adicionar ao Carrinho </a></td>
                        </tr>
                        <%      
                          }
                        %>
                        </table>
                <% }else{ out.println("<h2>Nenhum Produto Encontrado.</h2>");} %>        
                    </fieldset>

                </div>    
            </div>    
            
            <%@include file="template/rodape.jsp" %>
        </div>
        <!-- fim do corpo do site -->
    </body>
</html>
