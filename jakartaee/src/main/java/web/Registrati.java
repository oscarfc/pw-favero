/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oscar.favero
 */
@WebServlet(urlPatterns = "/registrati")
public class Registrati extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");   
        System.out.println(String.format("nome %s, cognome %s", nome, cognome));
        PrintWriter out = response.getWriter();
        out.println("<h1>Registrazione effettuata. Grazie!</h1>");
        out.flush();
    }
    
}
