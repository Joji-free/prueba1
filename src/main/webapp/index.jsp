<%--
  Created by IntelliJ IDEA.
  User: ander
  Date: 13/5/2025
  Time: 8:24
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.Map" %>

<%
    @SuppressWarnings("unchecked")
    Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");
    String resultado = (String) request.getAttribute("resultado"); // Recuperar el resultado
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Números Primos</title>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/estilos.css"/>
</head>
<style>

</style>
<body>

<h1>Números Primos</h1>
<h3>Ingrese solo números positivos</h3>

<form action="/prueba1/registro" method="post">
    <div class="form-group">
        <label for="numero1">Número 1 (Inicio del rango):</label>
        <input type="number" name="numero1" id="numero1" required />
    </div>

    <div class="form-group">
        <label for="numero2">Número 2 (Fin del rango):</label>
        <input type="number" name="numero2" id="numero2" required />
    </div>

    <div class="form-group submit">
        <button type="submit">Calcular</button>
    </div>
</form>

<% if (errores != null && !errores.isEmpty()) { %>
<div class="errores" style="color: red;">
    <h4>Errores:</h4>
    <ul>
        <% for (String error : errores.values()) { %>
        <li><%= error %></li>
        <% } %>
    </ul>
</div>
<% } %>

<% if (resultado != null) { %>
<div class="resultado">
    <h4>Resultado:</h4>
    <p><%= resultado %></p>
</div>
<% } %>
</body>
</html>