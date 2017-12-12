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
import javax.swing.JOptionPane;
import model.Produto;

public class ProdutoDAO implements DAO {

    private Connection conn;
    private PreparedStatement ps = null;

    public ProdutoDAO() throws Exception {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro de conexão:" + e.getMessage());
        }
    }

    @Override
    public void atualizar(Object ob) throws Exception {

        Produto produto = (Produto) ob;

        PreparedStatement ps = null;
        Connection conn = null;
        conn = ConnectionDAO.getConnection();

        if (produto == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            ps = conn.prepareStatement(" UPDATE `produto` SET `PRO_NOME`= ?,`PRO_DESCRICAO`= ?,`PRO_VALOR`= ?,`PRO_QUANTIDADE`= ?,`PRO_MARCA`= ?,`PRO_CATEGORIA`= ? WHERE `PRO_ID`= ?");

            ps.setString(1, produto.getPRO_NOME());
            ps.setString(2, produto.getPRO_DESCRICAO());
            ps.setDouble(3, produto.getPRO_VALOR());
            ps.setInt(4, produto.getPRO_QUANTIDADE());
            ps.setString(5, produto.getPRO_MARCA());
            ps.setString(6, produto.getPRO_CATEGORIA());
            ps.setInt(7, produto.getPRO_ID());

            ps.executeUpdate();

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage());
            throw new Exception("Erro ao atualizar dados: " + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }

    }

    @Override
    public void excluir(Object ob) throws Exception {
        Produto produto = (Produto) ob;
        Connection conn = null;
        if (produto == null) {

            throw new Exception("O valor passado não pode ser nulo");

        }
        try {
            conn = this.conn;
            ps = conn.prepareStatement("DELETE FROM produto WHERE PRO_ID=?");
            ps.setInt(1, produto.getPRO_ID());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados: " + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }

    }

    @Override
    public List listaTodos() throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * FROM produto");
            rs = ps.executeQuery();
            List<Produto> list = new ArrayList<Produto>();
            while (rs.next()) {
                Integer pro_id = rs.getInt(1);
                String pro_nome = rs.getString(2);
                String pro_descricao = rs.getString(3);
                double pro_valor = rs.getDouble(4);
                Integer pro_quatidade = rs.getInt(5);
                // byte[] pro_fotos = rs.getBytes(6);
                String pro_marca = rs.getString(7);
                String pro_categoria = rs.getString(8);
                list.add(new Produto(pro_id, pro_nome, pro_descricao, pro_valor, pro_quatidade, pro_marca, pro_categoria));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    public List buscarProduto(Object ob) throws Exception {
        Produto produto = (Produto) ob;

        PreparedStatement ps = null;
        Connection conn = null;
        conn = ConnectionDAO.getConnection();
        ResultSet rs = null;
        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * FROM produto WHERE PRO_ID = ? ");
            ps.setInt(1, produto.getPRO_ID());
            rs = ps.executeQuery();
            List<Produto> list = new ArrayList<Produto>();
            while (rs.next()) {
                Integer pro_id = rs.getInt(1);
                String pro_nome = rs.getString(2);
                String pro_descricao = rs.getString(3);
                double pro_valor = rs.getDouble(4);
                Integer pro_quatidade = rs.getInt(5);
                // byte[] pro_fotos = rs.getBytes(6);
                String pro_marca = rs.getString(7);
                String pro_categoria = rs.getString(8);
                list.add(new Produto(pro_id, pro_nome, pro_descricao, pro_valor, pro_quatidade, pro_marca, pro_categoria));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    public static int pegaUltimoID() throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        int id = 0;
        try {
            conn = ConnectionDAO.getConnection();
            String SQL = "SELECT * FROM produto ORDER BY PRO_ID DESC LIMIT 0,1";
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException sqle) {
            //}catch(Exception e){
            throw new Exception("Erro SQL:" + sqle);
            //throw new Exception();
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
        return id;
    }

    public List<Produto> listaCategoria(String categoria) throws Exception {
        List<Produto> list = new ArrayList<Produto>();
        ResultSet rs = null;

        if (categoria == null) {
            categoria = "";
        }
        try {
            conn = ConnectionDAO.getConnection();
            String SQL = "SELECT * FROM produto WHERE PRO_CATEGORIA LIKE '%" + categoria + "%'";

            ps = conn.prepareStatement(SQL);
            //ps.setString(1, categoria);

            rs = ps.executeQuery();

            while (rs.next()) {
                Integer pro_id = rs.getInt(1);
                String pro_nome = rs.getString(2);
                String pro_descricao = rs.getString(3);
                double pro_valor = rs.getDouble(4);
                Integer pro_quatidade = rs.getInt(5);
                // byte[] pro_fotos = rs.getBytes(6);
                String pro_marca = rs.getString(7);
                String pro_categoria = rs.getString(8);
                list.add(new Produto(pro_id, pro_nome, pro_descricao, pro_valor, pro_quatidade, pro_marca, pro_categoria));
            }

        } catch (SQLException sqle) {
            //}catch(Exception e){
            throw new Exception("Erro SQL:" + sqle);
            //throw new Exception();
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }

        return list;
    }

    @Override
    public List procura(Object ob) throws Exception {
        List<Produto> list = new ArrayList<Produto>();

        Produto produto = (Produto) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        if (produto == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            conn = ConnectionDAO.getConnection();
            String SQL = "SELECT * FROM produto ";
            String where = "";
            boolean checa = false;
            if (produto.getPRO_ID() != 0 || produto.getPRO_NOME() != null || produto.getPRO_DESCRICAO() != null || produto.getPRO_VALOR() != 0 || produto.getPRO_QUANTIDADE() != 0 || produto.getPRO_MARCA() != null || produto.getPRO_CATEGORIA() != null) {
                where = "WHERE ";
                if (produto.getPRO_ID() != 0) {
                    where += "PRO_ID=? ";
                    checa = true;
                }
                if (produto.getPRO_NOME() != null) {
                    if (checa) {
                        where += "AND";
                    }
                    where += " PRO_NOME=? ";
                    checa = true;
                }
                if (produto.getPRO_DESCRICAO() != null) {
                    if (checa) {
                        where += "AND";
                    }
                    where += " PRO_DESCRICAO=? ";
                    checa = true;
                }
                if (produto.getPRO_VALOR() != null) {
                    if (checa) {
                        where += "AND";
                    }
                    where += " PRO_VALOR=? ";
                    checa = true;
                }
                if (produto.getPRO_QUANTIDADE() >= 0) {
                    if (checa) {
                        where += "AND";
                    }
                    where += " PRO_QUANTIDADE=? ";
                    checa = true;
                }
                if (produto.getPRO_MARCA() != null) {
                    if (checa) {
                        where += "AND";
                    }
                    where += " PRO_MARCA=? ";
                    checa = true;
                }
                if (produto.getPRO_CATEGORIA() != null) {
                    if (checa) {
                        where += "AND";
                    }
                    where += " PRO_CATEGORIA=? ";
                    checa = true;
                }
            }
            ps = conn.prepareStatement(SQL + where);
            int contaCampos = 1;
            if (produto.getPRO_ID() != 0 || produto.getPRO_NOME() != null || produto.getPRO_DESCRICAO() != null || produto.getPRO_VALOR() != 0 || produto.getPRO_QUANTIDADE() != 0 || produto.getPRO_MARCA() != null || produto.getPRO_CATEGORIA() != null) {
                if (produto.getPRO_ID() != 0) {
                    ps.setInt(contaCampos, produto.getPRO_ID());
                    contaCampos++;
                }
                if (produto.getPRO_NOME() != null) {
                    ps.setString(contaCampos, produto.getPRO_NOME());
                    contaCampos++;
                }
                if (produto.getPRO_DESCRICAO() != null) {
                    if (checa) {
                        where += "AND";
                    }
                    ps.setString(contaCampos, produto.getPRO_DESCRICAO());
                    contaCampos++;
                }
                if (produto.getPRO_VALOR() != null) {
                    ps.setDouble(contaCampos, produto.getPRO_VALOR());
                    contaCampos++;
                }
                if (produto.getPRO_QUANTIDADE() >= 0) {
                    ps.setInt(contaCampos, produto.getPRO_QUANTIDADE());
                    contaCampos++;
                }
                if (produto.getPRO_MARCA() != null) {
                    ps.setString(contaCampos, produto.getPRO_MARCA());
                    contaCampos++;
                }
                if (produto.getPRO_CATEGORIA() != null) {
                    ps.setString(contaCampos, produto.getPRO_CATEGORIA());
                    contaCampos++;
                }
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                Integer pro_id = rs.getInt(1);
                String pro_nome = rs.getString(2);
                String pro_descricao = rs.getString(3);
                double pro_valor = rs.getDouble(4);
                Integer pro_quatidade = rs.getInt(5);
                // byte[] pro_fotos = rs.getBytes(6);
                String pro_marca = rs.getString(6);
                String pro_categoria = rs.getString(7);
                list.add(new Produto(pro_id, pro_nome, pro_descricao, pro_valor, pro_quatidade, pro_marca, pro_categoria));
            }

        } catch (SQLException sqle) {
            //}catch(Exception e){
            throw new Exception("Erro SQL:" + sqle);
            //throw new Exception();
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
        return list;

    }

    @Override
    public void salvar(Object ob) throws Exception {

        Produto produto;
        produto = (Produto) ob;
        PreparedStatement ps = null;
        Connection conn = null;

        if (produto == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }

        try {
            String SQL = "INSERT INTO `produto` (`PRO_ID`, `PRO_NOME`, `PRO_DESCRICAO`, `PRO_VALOR`, `PRO_QUANTIDADE`, `PRO_FOTOS` ,"
                    + "`PRO_MARCA`, `PRO_CATEGORIA`) VALUES (NULL, ?, ?, ?, ?, NULL, ?, ?)";

            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, produto.getPRO_NOME());
            ps.setString(2, produto.getPRO_DESCRICAO());
            ps.setDouble(3, produto.getPRO_VALOR());
            ps.setInt(4, produto.getPRO_QUANTIDADE());
            // ps.setBytes(5, produto.getPRO_FOTOS());
            ps.setString(5, produto.getPRO_MARCA());
            ps.setString(6, produto.getPRO_CATEGORIA());
            ps.executeUpdate();

        } catch (SQLException sqle) {

            throw new Exception("Erro ao inserir dados do produto: \n" + sqle);

        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }

    }

}
