<%@ page import="java.util.List" %>
<%@ page import="com.arqjava.bo.Libro" %>
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
                List<String> categorias = null;
                categorias = (List<String>) request.getAttribute("categorias");
                for (String categoria : categorias) {
                    if (libro.getCategoria().equals(categoria)) {
            %>
            <option value="<%=categoria%>" selected="selected">
                <%=categoria%>
            </option>
            <%} else {%>
            <option value="<%=categoria%>"><%=categoria%>
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