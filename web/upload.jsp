
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="template/head.jsp" %>
    </head>
    <body>
        <div class="container">
            <form action ="./fotos" name ="frmproduto" method="post" enctype="multipart/form-data">
                <input type="hidden" name="idProduto" value="" />
                <!--                
                                <input class="btn btn-primary" type="file" name="inputImagem"><p>-->
                <div class="form-group row">
                    <label for="inputImagem">Imagem do Produto</label>
                    <div class="">
                        <input class="btn btn-primary" type="file" name="inputImagem"><p>
                    </div>
                </div>
                <div class="form-group row">
                    <button type ="submit" class="btn btn-primary " value="salvar" >Salvar</button>
                </div>
            </form>
        </div>
    </body>
</html>
