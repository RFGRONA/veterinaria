package ed.veterinaria.controller;

import ed.veterinaria.model.Caninos;
import ed.veterinaria.model.Felinos;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {

    private Felinos felinos = new Felinos();
    private Caninos caninos = new Caninos();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        caninos.inicializar();
        felinos.inicializar();
        calculo(request, response);
        request.setAttribute("perros", caninos.getCaninos());
        request.setAttribute("gatos", felinos.getFelinos());
        request.getRequestDispatcher("lista.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        caninos.inicializar();
        felinos.inicializar();
        String instruccion = request.getParameter("instruccion");
        calculo(request, response);
        if(instruccion.equals("agregar"))
            agregar(request, response);
        if(instruccion.equals("eliminar"))
            eliminar(request, response);
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
            caninos.setCaninos(perro);
        } else {
            Felinos gato = new Felinos(enfermedad, nombre, color, edad, raza);
            felinos.setFelinos(gato);
        }
        
        request.setAttribute("perros", caninos.getCaninos());
        request.setAttribute("gatos", felinos.getFelinos());
        request.getRequestDispatcher("lista.jsp").forward(request, response);
    }
    
    protected void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String eliminar = request.getParameter("eliminar");
        int indice = Integer.parseInt(request.getParameter("indice"));
        
        if (eliminar.equals("perro")) {
            caninos.delCaninos(indice);
        } else {
            felinos.delFelinos(indice);
        }

        request.setAttribute("perros", caninos.getCaninos());
        request.setAttribute("gatos", felinos.getFelinos());
        request.getRequestDispatcher("lista.jsp").forward(request, response);
    }
    
    protected void calculo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("promPerros", caninos.calculo());
        request.setAttribute("promGatos", felinos.calculo());
    }
}
