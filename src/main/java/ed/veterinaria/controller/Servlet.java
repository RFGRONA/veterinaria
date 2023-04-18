package ed.veterinaria.controller;

import ed.veterinaria.model.Caninos;
import ed.veterinaria.model.Felinos;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {

    private final Felinos felinos = new Felinos();
    private final Caninos caninos = new Caninos();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        caninos.inicializar();
        felinos.inicializar();
        request.setAttribute("perros", caninos.getLista());
        request.setAttribute("gatos", felinos.getLista());
        calculo(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        caninos.inicializar();
        felinos.inicializar();
        String instruccion = request.getParameter("instruccion");
        if(instruccion.equals("agregar"))
            agregar(request, response);
        if(instruccion.equals("eliminar"))
            eliminar(request, response);
        calculo(request, response);
    }

    protected void agregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String color = request.getParameter("color");
        String raza = request.getParameter("raza");
        String tipo = request.getParameter("tipo");
        double edad = Double.parseDouble(request.getParameter("edad"));
        int entrenamiento = Integer.parseInt(request.getParameter("entrenamiento"));
        boolean enfermedad = Boolean.parseBoolean(request.getParameter("enfermedad"));

        if (tipo.equals("perro")) {
            Caninos perro = new Caninos(entrenamiento, nombre, color, edad, raza);
            caninos.setLista(perro);
        } else {
            Felinos gato = new Felinos(enfermedad, nombre, color, edad, raza);
            felinos.setLista(gato);
        }
        
        request.setAttribute("perros", caninos.getLista());
        request.setAttribute("gatos", felinos.getLista());
    }
    
    protected void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String eliminar = request.getParameter("eliminar");
        int indice = Integer.parseInt(request.getParameter("indice"));
        
        if (eliminar.equals("perro")) {
            caninos.delLista(indice);
        } else {
            felinos.delLista(indice);
        }

        request.setAttribute("perros", caninos.getLista());
        request.setAttribute("gatos", felinos.getLista());
    }
    
    protected void calculo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("promPerros", caninos.calculo());
        request.setAttribute("promGatos", felinos.calculo());
        request.getRequestDispatcher("lista.jsp").forward(request, response);
    }
}
