<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="com.arqjava.bo.Libro" %>
<%@ page import="java.util.List" %>
<%@ page import="com.arqjava.bo.Categoria" %>
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
        List<Categoria> categorias = null;
        categorias = (List<Categoria>) request.getAttribute("listaDeCategorias");
        for (Categoria categoria : categorias) {
    %>
    <option value="<%=categoria.getId()%>">
        <%=categoria.getDescripcion()%>
    </option>
    <%}%>
</select>
<button onclick="filtrar()">Filtrar</button>
<br>
<%
    List<Libro> libros = (List<Libro>) request.getAttribute("listaDeLibros");
    for (Libro libro : libros) {%>
<%=libro.getIsbn()%>
<%=libro.getTitulo()%>
<%=libro.getCategoria().getDescripcion()%>
<a href="BorrarLibro?isbn=<%=libro.getIsbn()%>">Borrar</a>
<a href="FormularioEditarLibro?isbn=<%=libro.getIsbn()%>">Editar</a>
<br/>
<%}%>
<a href="FormularioInsertarLibro">Insertar Libro</a>
<a href="../index.jsp">Volver</a>
<script type="text/javascript" src="../js/MostrarLibros.js"></script>
</body>
</html>
