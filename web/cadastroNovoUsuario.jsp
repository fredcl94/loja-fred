

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>Loja Cadastro</title>


        <%@include file="template/head.jsp" %>
       
    </head>
    <body class="fundo2">

        <form action="./controladorCadastro" method="POST">

            <div class="container">
               
                    <jsp:include page="template/cabecalho.jsp" >
                        <jsp:param name="atual" value="inicio" />
                    </jsp:include>
                 <div class ="formCadastro">
                    <div class="form-group">
                        <label for="inputNome">Seu Nome</label>
                        <input type="text" class="form-control" name="inputNome" placeholder="Seu Nome" required>
                    </div>

                    <div class="form-signin">
                        <label for="inputEmail" >Seu Email</label>
                        <input type="email" id="inputEmail" name="inputEmail" class="form-control" placeholder="Seu Email" required autofocus>

                        <label for="inputPassword" >Senha</label>
                        <input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="Sua Senha" required>
                    </div>

                    <div class="form-group">
                        <label for="inputTelefone">Seu Telefone</label>
                        <input type="text" class="form-control" name="inputTelefone" placeholder="Seu Telefone" required>


                        <label for="inputSexo">Seu Sexo</label>
                        <select class="form-control" id="inputSoxo" name="inputSexo">
                            <option>Selecione</option>
                            <option value="m">M</option>
                            <option value="f">F</option>                                            
                        </select>             

                        <label for="inputEndereco">Seu Endereço</label>
                        <input type="text" class="form-control" name="inputEndereco" placeholder="Seu Endereço" required>

                        <label for="inputCep">Seu CEP</label>
                        <input type="text" class="form-control" name="inputCep" placeholder="Seu Cep" required>

                        <label for="inputCidade">Sua Cidade</label>
                        <input type="text" class="form-control" name="inputCidade" placeholder="Sua Cidade" required>

                        <label for="inputEstado">Seu Estado</label>
                        <input type="text" class="form-control" name="inputEstado" placeholder="Seu Estado" required>

                    </div>
                    <button class="btn btn-lg btn-primary " type="submit">Cadastrar</button>

                    </form>
                </div>
            </div>
            <br></br>
            <%@include file="template/rodape.jsp" %>

    </body>
</html>
