
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action ="UploadController" name ="frmproduto" method="post" enctype="multipart/form-data">
                        <legend>Novo produto</legend>
                        <input type="hidden" name="id" value="10" />
                        <input type="text" name="nome" />
                        <label for="pais" class="cor-label">Imagem</label>
                        <input type ="file" name ="arquivo"/>
                        <input type ="submit" class ="btn btn-primary" value="Registar"/>
        </form>
    </body>
</html>
