/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cdc.util.CarrinhoDAO;
import cdc.util.ComprasDAO;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Compras;
import model.Produto;

/**
 *
 * @author Frede
 */
@WebServlet(name = "ControladoraCompras", urlPatterns = {"/compras"})
public class ControladoraCompras extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String acao = request.getParameter("acao");

            System.out.println("\n\n\n Ação: " + acao);
            if (acao.equals("comprar")) {
                int idProduto = Integer.parseInt((request.getParameter("idProduto") != null) ? request.getParameter("idProduto") : "");

                //add no carrinho de compras!!
                //persistir no BD
                int USU_ID = Integer.parseInt(request.getSession().getAttribute("USU_ID").toString());

                CarrinhoDAO carrinhoDAO = new CarrinhoDAO();

                boolean resp = carrinhoDAO.salvaItem(new Produto(idProduto), USU_ID);

                if (resp) {
                    request.setAttribute("resposta", "Produto adicionado no carrinho de compras!");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } else {
                    request.setAttribute("erro", "crie uma mensagem!");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);

                }

            } else if (acao.equals("finalizar")) {
                int idUsuario = (request.getSession().getAttribute("USU_ID") != null) ? Integer.parseInt(request.getSession().getAttribute("USU_ID").toString()) : 0;

                ComprasDAO compraDAO = new ComprasDAO();
                Compras comp = (Compras) compraDAO.listaCarrinhodoUsuario(idUsuario);

                comp.setUSUARIO_USU_ID(idUsuario);
                String forma = (request.getParameter("forma") != null) ? request.getParameter("forma").toString() : "";

                comp.setCOM_FORMA_PAGAMENTO(forma);

                System.out.println("\n\n\n\nCompra: " + comp.toString() + "\n\n\n");

                boolean resp = compraDAO.salvarCompra(comp);

                if (resp) {
                    request.setAttribute("resposta", "Compra efetuada com sucesso!");
                    
                } else {
                    request.setAttribute("erro", "crie uma mensagem!");
                }
            } else {
                String id = "";
                ArrayList<Produto> prods = (ArrayList<Produto>) request.getSession().getAttribute("carrinho");

                id += "\n\n";
                for (Produto prod : prods) {
                    id += String.valueOf(prod.getPRO_ID());
                    id += "\n\n";
                }

                System.out.println(id);
            }
        } catch (Exception e) {
            System.out.println("\n\n\nExceção: " + e.getMessage());
        }

    }
//    request.getRequestDispatcher("PainelDeControleUsuario.jsp");

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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraCompras.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraCompras.class.getName()).log(Level.SEVERE, null, ex);
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
