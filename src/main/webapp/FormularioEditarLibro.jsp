<%@ page import="java.util.List" %>
<%@ page import="com.arqjava.bo.Libro" %>
<%@ page import="com.arqjava.bo.Categoria" %>
<%
    Libro libro = (Libro) request.getAttribute("libro");
%>
<!-- cabecera y javascript omitido-->
<body>
<form id="formularioEdicion" action="ModificarLibro">
    <fieldset>
        <legend>Formulario alta libro</legend>
        <p>
            <label for="isbn">ISBN:</label> <input type="text" id="isbn"
                                                   name="isbn" value="<%=libro.getIsbn()%>"/>
        </p>
        <p>
            <label for="titulo">Titulo:</label><input type="text" id="titulo"
                                                      name="titulo" value="<%=libro.getTitulo()%>"/>
        </p>
        <p>
            <label for="categoria">Categoria :</label> <select name="categoria" id="categoria">
            <%
                List<Categoria> categorias = null;
                categorias = (List<Categoria>) request.getAttribute("categorias");
                for (Categoria categoria : categorias) {
                    if (libro.getCategoria().equals(categoria)) {
            %>
            <option value="<%=categoria.getId()%>" selected="selected">
                <%=categoria.getDescripcion()%>
            </option>
            <%} else {%>
            <option value="<%=categoria.getId()%>"><%=categoria.getDescripcion()%>
            </option>
            <%
                    }
                }
            %>
        </select> <br/>
        </p>
        <p>
            <input type="submit" value="Salvar"/>
        </p>
    </fieldset>
</form>
</body>
</html>