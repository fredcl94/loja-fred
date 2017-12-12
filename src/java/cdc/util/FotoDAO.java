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
import model.Foto;


public class FotoDAO implements DAO {

    private Connection conn;
    private PreparedStatement ps = null;
    
    public FotoDAO() throws Exception {
        try {
            this.conn = ConnectionDAO.getConnection();
            
        } catch (Exception e) {
            throw new Exception("Erro de conexão:" + e.getMessage());
        }
    }


    @Override
    public void atualizar(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Object ob) throws Exception {
        Foto foto = (Foto) ob;
        Connection conn = null;
        if (foto == null) {

            throw new Exception("O valor passado não pode ser nulo");

        }
        try {
            conn = this.conn;
            ps = conn.prepareStatement("DELETE FROM FOTO WHERE FOTO_ID_PRO=?");
            ps.setInt(1, foto.getFOTO_ID_PRO());
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
        try{
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * FROM FOTO");
            rs = ps.executeQuery();
            List<Foto> list = new ArrayList<Foto>();
            while(rs.next()){
                Integer foto_id = rs.getInt(1);
                String foto_nome = rs.getString(2);
                Integer foto_id_pro = rs.getInt(3);
                                
                list.add(new Foto(foto_id, foto_nome,foto_id_pro));
            }
            return list;
        }catch(SQLException sqle){
            throw new Exception(sqle);
        }finally{
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    @Override
    public List procura(Object ob) throws Exception {
        List<Foto> list = new ArrayList<Foto>();

        Foto foto = (Foto) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        if (foto == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            conn = ConnectionDAO.getConnection();
            String SQL = "SELECT * FROM FOTO ";
            String where = "";
            boolean checa = false;
            if (foto.getFOTO_ID() != 0 || foto.getFOTO_NOME() != null || foto.getFOTO_ID_PRO() != 0) {
                where = "WHERE ";
                if (foto.getFOTO_ID() != 0) {
                    where += "FOTO_ID=? ";
                    checa = true;
                }
                if (foto.getFOTO_NOME() != null) {
                    if (checa) {
                        where += "AND";
                    }
                    where += " FOTO_NOME=? ";
                    checa = true;
                }
                if (foto.getFOTO_ID_PRO() != 0) {
                    if (checa) {
                        where += "AND";
                    }
                    where += " FOTO_ID_PRO=? ";
                    checa = true;
                }
            }
            ps = conn.prepareStatement(SQL + where);
            int contaCampos = 1;
            if (foto.getFOTO_ID() != 0 || foto.getFOTO_NOME() != null || foto.getFOTO_ID_PRO() != 0) {
                if (foto.getFOTO_ID() != 0) {
                    ps.setInt(contaCampos, foto.getFOTO_ID());
                    contaCampos++;
                }
                if (foto.getFOTO_NOME() != null) {
                    ps.setString(contaCampos, foto.getFOTO_NOME());
                    contaCampos++;
                }
                if (foto.getFOTO_ID_PRO() != 0) {
                    ps.setInt(contaCampos, foto.getFOTO_ID_PRO());
                    contaCampos++;
                }
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                int foto_id = rs.getInt(1);
                String foto_nome = rs.getString(2);
                int foto_id_pro = rs.getInt(3);
                list.add(new Foto(foto_id, foto_nome, foto_id_pro));
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
        Foto foto;
        foto = (Foto) ob;
        PreparedStatement ps = null;
        Connection conn = null;

        if (foto == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }

        try {
            String SQL = "INSERT INTO `Loja-Online`.`FOTO` (`FOTO_ID`, `FOTO_NOME`, `FOTO_ID_PRO`) VALUES (NULL, ?, ?)";

            conn = ConnectionDAO.getConnection();
            ps = conn.prepareStatement(SQL);
            ps.setString(1, foto.getFOTO_NOME());
            ps.setInt(2, foto.getFOTO_ID_PRO());
            ps.executeUpdate();

        } catch (SQLException sqle) {

            throw new Exception("Erro ao inserir dados da foto: \n" + sqle);

        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

}
