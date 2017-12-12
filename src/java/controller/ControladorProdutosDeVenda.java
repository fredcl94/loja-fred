/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cdc.util.ProdutoDAO;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import model.Produto;
import org.json.simple.JSONObject;
import org.json.simple.JsonArray;

/**
 *
 * @author Frede
 */
@WebServlet(name = "ControladorProdutosDeVenda", urlPatterns = {"/produtodevenda"})
public class ControladorProdutosDeVenda extends HttpServlet {

    HttpServletRequest request;
    HttpServletResponse response;

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            this.request = request;
            this.response = response;
            String cmd = (request.getParameter("action") != null) ? request.getParameter("action").toLowerCase().toString() : "";

           
            String pro_nome = null; String pro_descricao = null; double pro_valor=0;
            int pro_quantidade=0; String pro_marca = null; String pro_categoria = null;
            int pro_id = Integer.parseInt(request.getParameter("id"));
            if(cmd.equals("edit")){
                pro_nome = request.getParameter("nome");
                pro_descricao = request.getParameter("descricao");
                pro_valor = Double.parseDouble(request.getParameter("valor"));
                pro_quantidade = Integer.parseInt(request.getParameter("quantidade"));
                pro_marca = request.getParameter("marca");
                pro_categoria = request.getParameter("categoria");
            }
            JSONObject dado = new JSONObject();
            
            System.out.println(cmd);
            switch (cmd) {
                case "edit":

                    try {
                        this.atualizar(new Produto(pro_id, pro_nome, pro_descricao, pro_valor, pro_quantidade, pro_marca, pro_categoria));
                        dado.put("dados", "ok");
                        out.println(dado);

                    } catch (Exception e) {
                            dado.put("erro", e.getMessage());
                        out.println(dado);
                    }

                    break;

                case "delete":
                    try {
                        this.excluir(new Produto(pro_id));
                        dado.put("dados", "ok");
                        out.println(dado);

                    } catch (Exception e) {
                        dado.put("erro", e.getMessage());
                        out.println(dado);
                    }

                    break;

                case "restore":

                    break;
                case "listarProdutos":
                    this.listarProdutos(request, response);
                    break;
                default:

            }
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

    private Boolean atualizar(Produto produto) {
        Boolean salvou = true;
        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();

            produtoDAO.atualizar(produto);

        } catch (Exception e) {
            salvou = false;
        }

        return salvou;
    }

    private Boolean excluir(Produto est) {
        Boolean removeu = true;
        try {

            ProdutoDAO produtoDAO = new ProdutoDAO();

            produtoDAO.excluir(est);

        } catch (Exception e) {
            removeu = false;
        }

        return removeu;
    }


    private void listarProdutos(HttpServletRequest request, HttpServletResponse response) {

        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            ArrayList<Produto> produtos = null;

            produtos = (ArrayList<Produto>) produtoDAO.listaTodos();

            JSONObject dados = new JSONObject();
            JSONObject pai = new JSONObject();
            JsonArray filhos = new JsonArray();

            for (Produto produto : produtos) {
                dados = new JSONObject();
                dados.put("PRO_ID", produto.getPRO_ID());
                dados.put("PRO_NOME", produto.getPRO_NOME());
                dados.put("PRO_DESCRICAO", produto.getPRO_DESCRICAO());
                dados.put("PRO_VALOR", produto.getPRO_VALOR());
                dados.put("PRO_MARCA", produto.getPRO_MARCA());
                dados.put("PRO_DESCRICAO", produto.getPRO_DESCRICAO());
                dados.put("PRO_CATEGORIA", produto.getPRO_CATEGORIA());

                filhos.add(dados);
            }

            pai.put("data", filhos);

            response.getWriter().print(pai);
        } catch (Exception e) {

        }

    }

}
