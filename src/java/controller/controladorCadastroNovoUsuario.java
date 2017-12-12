
package controller;


import cdc.util.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;


@WebServlet(name = "controladorCadastro", urlPatterns = {"/controladorCadastro"})
public class controladorCadastroNovoUsuario extends HttpServlet {

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
        
         try (PrintWriter out = response.getWriter()) {
          String inputNome = request.getParameter("inputNome");
        String inputTelefone = request.getParameter("inputTelefone");
        String inputSexo = request.getParameter("inputSexo");
        String inputEndereco = request.getParameter("inputEndereco");
        String inputCep = request.getParameter("inputCep");
        String inputCidade = request.getParameter("inputCidade");
        String inputEstado = request.getParameter("inputEstado");
        
        String inputEmail = request.getParameter("inputEmail");
        String inputPassword = request.getParameter("inputPassword");
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
         
        
        

        Usuario usr  = new Usuario(0,inputNome,inputTelefone,inputSexo,inputEndereco,inputCep,inputCidade,inputEstado,inputEmail,inputPassword);            
          
        
        usuarioDAO.salvar(usr);     

        List<Usuario> lista = usuarioDAO.procura(usr);
        
        

        RequestDispatcher rd = request.getRequestDispatcher("/login.jsp?respCadastro=ok");
        rd.forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(controladorCadastroNovoUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(controladorCadastroNovoUsuario.class.getName()).log(Level.SEVERE, null, ex);
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