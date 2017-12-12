/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cdc.util.DAO;
import cdc.util.FotoDAO;
import cdc.util.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Foto;
import model.Produto;


@WebServlet(name = "ControladorProdutos", urlPatterns = {"/ControladorProdutos"})
public class ControladorProdutos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("ISO-8859-1");
        String cmd = request.getParameter("cmd");

        DAO ProdutoDAO;
        DAO FotoDAO;

        
        if (cmd == null) {
            cmd = "listar";
        }

        try {
            ProdutoDAO = new ProdutoDAO();
            FotoDAO = new FotoDAO();
            RequestDispatcher rd = null;
            
            if (cmd.equalsIgnoreCase("listarProdutos")) {
                List produtoList = ProdutoDAO.listaTodos();
                request.setAttribute("produtoList", produtoList);
                rd = request.getRequestDispatcher("/produtos.jsp");
          
            } else if (cmd.equalsIgnoreCase("del")) {
                Integer id = Integer.parseInt(request.getParameter("PRO_ID"));

                Foto foto = new Foto(0, null, id);
                Produto produto = new Produto(id, null, null, null, 0, null, null);
                FotoDAO.excluir(foto);
                ProdutoDAO.excluir(produto);
                rd = request.getRequestDispatcher("/produtos.jsp");

            }

            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
