<%@page import="cdc.util.CarrinhoDAO"%>
<%
    CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
    String id = (request.getSession().getAttribute("USU_ID") != null) ? request.getSession().getAttribute("USU_ID").toString() : "0";
    int idUsu = Integer.parseInt(id);
    int qtdCarrinho = carrinhoDAO.contaItensDoCarrinho(idUsu);

    String qtde = " ";

    if (qtdCarrinho > 0) {
        qtde = " " + String.valueOf(qtdCarrinho);
    }
%>    
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Compra Facil</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li role="presentation" class="focus"><a href="index.jsp">Inicio</a></li>

                <li role="presentation"><a href="./PainelDeControleUsuario.jsp">Painel de Controle</a></li>
                <li role="presentation"><a href="#">
                        <%
                            out.print((request.getSession().getAttribute("inputEmail") == null) ? "" : request.getSession().getAttribute("inputEmail"));
                        %></a></li>

                <li role="presentation">
                    <a href="./compras.jsp">
                        <span class="glyphicon glyphicon-shopping-cart"> </span><%=qtde%>
                    </a>
                </li>
                <li class="navbar-right" role="presentation"><a href="login.jsp">Login</a></li>
            </ul>


        </div> 
    </div>
</nav>

<!--<div class="header clearfix">
    <nav>
        <ul class="nav nav-pills pull-right">
            <li role="presentation" class="focus"><a href="index.jsp">Inicio</a></li>
            <li role="presentation"><a href="login.jsp">Login</a></li>
            <li role="presentation"><a href="./PainelDeControleUsuario.jsp">Painel de Controle</a></li>
            <li role="presentation"><a href="#">Contact</a></li>
            <li role="presentation"><a href="#">
<%
    out.print(request.getSession().getAttribute("inputEmail"));
%></a></li>
</ul>
</nav>
<h3 class="text-success">Compra Facil</h3>
</div>    -->