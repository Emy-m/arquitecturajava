<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="com.arqjava.bo.Libro" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Formulario Libro</title>
</head>
<body>
<select name="categoria" id="categoria">
    <option value="seleccionar">Seleccionar</option>
    <%
        List<String> categorias = null;
        categorias = (List<String>) request.getAttribute("listaDeCategorias");
        for (String categoria : categorias) {
    %>
    <option value="<%=categoria%>"><%=categoria%>
    </option>
    <%
        }
    %>
</select>
<button onclick="filtrar()">Filtrar</button>
<br>
<%
    List<Libro> libros = (List<Libro>) request.getAttribute("listaDeLibros");
    for (Libro libro : libros) {%>
<%=libro.getIsbn()%>
<%=libro.getTitulo()%>
<%=libro.getCategoria()%>
<a href="BorrarLibro?isbn=<%=libro.getIsbn()%>">Borrar</a>
<a href="FormularioEditarLibro?isbn=<%=libro.getIsbn()%>">Editar</a>
<br/>
<%}%>
<a href="FormularioInsertarLibro">Insertar Libro</a>
<a href="../index.jsp">Volver</a>
<script type="text/javascript" src="../js/MostrarLibros.js"></script>
</body>
</html>
