<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.arqjava.bo.Categoria" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Formulario Libro</title>
</head>
<body>
<form id="form" action="InsertarLibro">
    <fieldset>
        <legend>Formulario alta libro</legend>

        <label for="isbn">ISBN:</label> <input type="text" name="isbn" id="isbn"/><br/>

        <label for="titulo">Titulo:</label> <input type="text" name="titulo" id="titulo"/><br/>

        <label for="categoria">Categoria:</label> <select name="categoria" id="categoria">
        <option value="seleccionar">Seleccionar</option>
        <%
            List<Categoria> categorias = null;
            categorias = (List<Categoria>) request.getAttribute("listaDeCategorias");
            for (Categoria categoria : categorias) {
        %>
        <option value="<%=categoria.getId()%>">
            <%=categoria.getDescripcion()%>
        </option>
        <%}%>
    </select><br> <input type="button" value="Insertar"
                         onclick="validacion()"/>
    </fieldset>
</form>
<a href="../index.jsp">Volver</a>
<script type="text/javascript" src="../js/FormularioInsertarLibro.js"></script>
</body>
</html>
