<%-- 
    Document   : lista
    Created on : 11/04/2023, 10:04:03 p. m.
    Author     : gabma
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ed.veterinaria.model.Felinos"%>
<%@page import="ed.veterinaria.model.Caninos"%>
<%@page import="ed.veterinaria.model.Mascota"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/fc3ff67d7b.js" crossorigin="anonymous"></script>
        <link href="design.css" rel="stylesheet" type="text/css"/>
        <title>Lista</title>
    </head>
    <body>
        <h1 class="titulo"><i class="fa-solid fa-list"></i> Lista de mascotas</h1>
        <% double promPerros = (Double) request.getAttribute("promPerros");
        double promGatos = (Double) request.getAttribute("promGatos");%>
        <div class="tabla">
        <table >
            <caption><h3> <i class="fa-solid fa-shield-dog"></i> Lista Perros</h3></caption>
            <thead>
                <tr>
                    <th>N°</th>
                    <th>Nombre</th>
                    <th>Raza</th>
                    <th>Color</th>
                    <th>Edad</th>
                    <th>Entrenamiento</th>
                    <th>Acción</th>
                </tr>
            </thead>
            <tbody>
                <% List<Caninos> listaPerros = (List<Caninos>) request.getAttribute("perros");
                int contPerro = 0;int numPerro = 1;
                for (Caninos animal : listaPerros) {%>
                <tr>
                    <td><%= numPerro%></td>
                    <td><%= animal.getNombre()%></td>
                    <td><%= animal.getRaza()%></td>
                    <td><%= animal.getColor()%></td>
                    <td><%= animal.getEdad()%></td>
                    <td><%= animal.getEntrenamiento()%></td>
                    <td><form action="Servlet" method="post">
                        <input type="hidden" name="instruccion" value="eliminar">
                        <input type="hidden" name="eliminar" value="perro">
                        <input type="hidden" name="indice" value="<%=contPerro%>">
                        <button class="botonlista" type="submit"><i class="fa-regular fa-trash-can"></i></button>
                    </form></td>
                </tr>
                <% contPerro++; numPerro++;}%>
            </tbody>
        </table>
            
        <table>
            <caption><h3> <i class="fa-solid fa-shield-cat"></i> Lista Gatos</h3></caption>
            <thead>
                <tr>
                    <th>N°</th>
                    <th>Nombre</th>
                    <th>Raza</th>
                    <th>Color</th>
                    <th>Edad</th>
                    <th>Enfermo</th>
                    <th>Acción</th>
                </tr>
            </thead>
            <tbody>
                <% List<Felinos> listaGatos = (List<Felinos>) request.getAttribute("gatos");
                    int contGato = 0; int numGato = 1;
                    for (Felinos animal : listaGatos) {%>
                <tr>
                    <td><%= numGato%></td>
                    <td><%= animal.getNombre()%></td>
                    <td><%= animal.getRaza()%></td>
                    <td><%= animal.getColor()%></td>
                    <td><%= animal.getEdad()%></td>
                    <td><%= animal.getEnfermedad() ? "Si" : "No" %></td>
                    <td><form action="Servlet" method="post">
                        <input type="hidden" name="instruccion" value="eliminar">
                        <input type="hidden" name="eliminar" value="gato">
                        <input type="hidden" name="indice" value="<%=contGato%>">
                        <button class="botonlista" type="submit"><i class="fa-regular fa-trash-can"></i></button>
                    </form></td>
                </tr>
                <% contGato++; numGato++;}%>
            </tbody>
        </table>

        <h2>Promedio de edad: <a><%=promPerros%></a></h2>
        <h2>Promedio de edad <a><%=promGatos%></a></h2>
        </div>
        
        <form action="index.html" class="centro">
            <button type="submit"><i class="fa-solid fa-rotate-left"></i> Volver a inicio</button>
        </form>
        
    </body>
</html>