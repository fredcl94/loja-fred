

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">
        <title>Loja Login</title>

        <%@include file="template/head.jsp" %>

    </head>

    <body class="fundo">
       
        <div class="container">
            <!-- estas linhas abaixo são obrigatórias para chamar o cabeçalho, passando como parâmetro a página atual, para que possamos montar o menu superior -->
            <jsp:include page="template/cabecalho.jsp" >
                <jsp:param name="atual" value="login" />
            </jsp:include>
        </div>
            
        <div class="container">

            <%
                //recebendo parâmetro enviado pelo controlador de cadastro de novo usuário para dar mensagem de sucesso no cadastro

                String resp = request.getParameter("respCadastro");
                try {
                    if (resp.equals("ok")) {
            %>
            <script>alert("Cadastro efetuado com sucesso!");</script>
            <%
                }
                if (resp.equals("nãoLogado")) {
            %>
            <script>alert("Por Favor faça Login para Acessar essa Página");</script>
            <%
                    }
                } catch (Exception e) {

                }

            %>    
           
            <div class="formulario">
                <form class="form-signin" action="./controladorLogin" method="POST">
                    <h2 class="form-signin-heading">Login</h2>
                    <label for="inputEmail" class="sr-only">Email</label>
                    <input type="email" id="inputEmail" name="inputEmail" class="form-control" placeholder="Seu Email" required autofocus>
                    <label for="inputPassword" class="sr-only">Senha</label>
                    <input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="Sua Senha" required>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" value="remember-me"> Lembre-se de mim neste aparelho.

                        </label>
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
                </form>

                <center> <h3> <a href="cadastroNovoUsuario.jsp">Cadastrar</a> </h3> </center>
            </div>

        </div> <!-- /container -->
        
       
        <%@include file="template/rodape.jsp" %>

        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
