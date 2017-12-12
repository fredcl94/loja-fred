/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Carrinho;
import model.Compras;
import model.Produto;

/**
 *
 * @author Frede
 */
public class CarrinhoDAO implements DAO {

    public boolean salvaItem(Object ob, int USU_ID) throws Exception {
        Produto produto = (Produto) ob;
        PreparedStatement ps = null;
        Connection conn = null;
   System.out.println("pessei");
        Boolean adicionou = false;
        if (produto == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }

        try {

            conn = ConnectionDAO.getConnection();
            String SQL = "INSERT INTO `produto_has_usuario` (`PRODUTO_PRO_ID`, `USUARIO_USU_ID`) VALUES (?, ?);";

            ps = conn.prepareStatement(SQL);
            ps.setInt(1, produto.getPRO_ID());
            ps.setInt(2, USU_ID);

            int retorno = ps.executeUpdate();

            adicionou = true;
        } catch (SQLException sqle) {
            System.out.println("erro bd: " + sqle.getMessage());
            throw new Exception("Erro ao inserir dados do produto: \n" + sqle);

        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
        return adicionou;
    }

    public int contaItensDoCarrinho(int USU_ID) throws Exception {
        int qtde = 0;

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDAO.getConnection();
            ps = conn.prepareStatement("SELECT COUNT(`PRODUTO_PRO_ID`) FROM `produto_has_usuario` WHERE `USUARIO_USU_ID` = (?) ");
            ps.setInt(1, USU_ID);
            rs = ps.executeQuery();
            while (rs.next()) {
                qtde = rs.getInt(1);
            }
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
        return qtde;
    }

    @Override
    public void atualizar(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listaTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List procura(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvar(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
