/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cdc.util.FotosDAO;
import cdc.util.ProdutoDAO;
import cdc.util.Upload;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Foto;
import model.Produto;

@WebServlet(name = "controladorCadastroDeProdutosParaVender", urlPatterns = {"/controladorCadastroDeProdutosParaVender"})
@MultipartConfig
public class controladorCadastroDeProdutosParaVender extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        request.setCharacterEncoding("ISO-8859-1");
        RequestDispatcher despachador = null;
        int lastID = ProdutoDAO.pegaUltimoID();
        lastID++;

        try {
            
            String inputNome = (String) request.getParameter("inputNome");
            String inputDescricao = (String) request.getParameter("inputDescricao");
            String inputValor = (String) request.getParameter("inputValor");
            String inputQuantidade = (String) request.getParameter("inputQuantidade");
            String inputMarca = (String) request.getParameter("inputMarca");
            String inputCategoria = (String) request.getParameter("inputCategoria");

            ProdutoDAO produtoDAO = new ProdutoDAO();

            Produto pro = new Produto(0, inputNome, inputDescricao, Double.valueOf(inputValor).doubleValue(), Integer.valueOf(inputQuantidade).intValue(), inputMarca, inputCategoria);

            produtoDAO.salvar(pro);

        } catch (Exception e) {
            e.printStackTrace();
        }

        despachador = request.getRequestDispatcher("PainelDeControleUsuario.jsp");

        despachador.forward(request, response);
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
        request.setCharacterEncoding("ISO-8859-1");
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(controladorCadastroDeProdutosParaVender.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        request.setCharacterEncoding("ISO-8859-1");
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(controladorCadastroDeProdutosParaVender.class.getName()).log(Level.SEVERE, null, ex);
        }
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
