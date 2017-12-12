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
import model.Compras;
import model.Produto;

public class ComprasDAO implements DAO {

    private Connection conn;
    private PreparedStatement ps = null;

    public ComprasDAO() throws Exception {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro de conexão:" + e.getMessage());
        }
    }

    @Override
    public void atualizar(Object ob) throws Exception {

    }

    @Override
    public void excluir(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Compras listaCarrinhodoUsuario(int USU_ID) throws Exception {

        System.out.println("\n\n\n usuID: " + USU_ID);
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        ArrayList<Produto> list = new ArrayList<Produto>();
        try {
            conn = ConnectionDAO.getConnection();
            ps = conn.prepareStatement(" SELECT `PRO_ID`,`PRO_NOME`,`PRO_DESCRICAO`,`PRO_VALOR`\n"
                    + " FROM `produto_has_usuario`\n"
                    + " INNER JOIN `produto` \n"
                    + "	ON `produto`.`PRO_ID` = `produto_has_usuario`.`PRODUTO_PRO_ID`\n"
                    + " WHERE `USUARIO_USU_ID` = ? ");
            ps.setInt(1, USU_ID);

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Produto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), 0, null, null));
            }

        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
        return new Compras(0, null, 0, list);
    }

    @Override
    public List procura(Object ob) throws Exception {
        List<Compras> list = new ArrayList<Compras>();

        Compras compras = (Compras) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        if (compras == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            conn = ConnectionDAO.getConnection();
            String SQL = "SELECT * FROM COMPRAS ";
            String where = "";
            boolean checa = false;
            if (compras.getCOM_ID() != 0 || compras.getCOM_FORMA_PAGAMENTO() != null || compras.getUSUARIO_USU_ID() != 0) {
                where = "WHERE ";
                if (compras.getCOM_ID() != 0) {
                    where += "COM_ID=? ";
                    checa = true;
                }

                if (compras.getCOM_FORMA_PAGAMENTO() != null) {
                    if (checa) {
                        where += "AND";
                    }
                    where += " COM_FORMA_PAGAMENTO=? ";
                    checa = true;
                }
                if (compras.getUSUARIO_USU_ID() != 0) {
                    if (checa) {
                        where += "AND";
                    }
                    where += " USUARIO_USU_ID=? ";
                    checa = true;
                }

            }
            ps = conn.prepareStatement(SQL + where);
            int compraCampos = 1;
            if (compras.getCOM_ID() != 0 || compras.getCOM_FORMA_PAGAMENTO() != null || compras.getUSUARIO_USU_ID() != 0) {
                if (compras.getCOM_ID() != 0) {
                    ps.setInt(compraCampos, compras.getCOM_ID());
                    compraCampos++;
                }

                if (compras.getCOM_FORMA_PAGAMENTO() != null) {
                    ps.setString(compraCampos, compras.getCOM_FORMA_PAGAMENTO());
                    compraCampos++;
                }
                if (compras.getUSUARIO_USU_ID() >= 0) {
                    ps.setInt(compraCampos, compras.getUSUARIO_USU_ID());
                    compraCampos++;
                }

            }

            rs = ps.executeQuery();

            while (rs.next()) {
                Integer com_id = rs.getInt(1);
                String com_forma_pagamento = rs.getString(2);
                Integer usuario_usu_id = rs.getInt(3);

//                list.add(new Compras(com_id, com_forma_pagamento, usuario_usu_id));
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
        Compras compras;
        compras = (Compras) ob;
        PreparedStatement ps = null;
        Connection conn = null;

        if (compras == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }

        try {
            String SQL = "INSERT INTO `Loja-Online`.`COMPRAS` (`COM_ID`, `COM_FORMA_PAGAMENTO`, `USUARIO_USU_ID`) "
                    + "VALUES (NULL, ?, ?)";

            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, compras.getCOM_FORMA_PAGAMENTO());
            ps.setInt(2, compras.getUSUARIO_USU_ID());

        } catch (SQLException sqle) {

            throw new Exception("Erro ao inserir dados do produto: \n" + sqle);

        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public Boolean salvarCompra(Object ob) throws Exception {
        Boolean deucerto = false; 
        Compras compra = (Compras) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        int idCompra = 0;
        try {
            conn = ConnectionDAO.getConnection();
            conn.setAutoCommit(false);

            ps = conn.prepareStatement(" select `function_compra`(?, ?)");

            ps.setString(1, compra.getCOM_FORMA_PAGAMENTO());
            ps.setInt(2, compra.getUSUARIO_USU_ID());
            rs = ps.executeQuery();

            while (rs.next()) {
                idCompra = rs.getInt(1);
            }

            for (Produto prod : compra.getProdutos()) {
                ps = conn.prepareStatement(" INSERT INTO `com_produto`(`PRO_ID`, `COM_ID`) VALUES (?, ?)");
                ps.setInt(1, prod.getPRO_ID());
                ps.setInt(2, idCompra);
                ps.executeUpdate();
            }

            for (Produto prod : compra.getProdutos()) {
                ps = conn.prepareStatement(" DELETE FROM `produto_has_usuario` WHERE `produto_has_usuario`.`PRODUTO_PRO_ID` = ? AND `produto_has_usuario`.`USUARIO_USU_ID` = ? ");
                ps.setInt(1, prod.getPRO_ID());
                ps.setInt(2, compra.getUSUARIO_USU_ID());
                ps.executeUpdate();
            }
            conn.commit();
            deucerto = true; 
        } catch (SQLException sqle) {
            System.out.println("\n\nErro transação: " + sqle.getMessage());
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
            ConnectionDAO.closeConnection(conn, ps);
        }
        return deucerto; 
    }

    @Override
    public List listaTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
