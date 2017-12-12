/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

public class Compras {

    private int COM_ID;
    private String COM_FORMA_PAGAMENTO;
    private int USUARIO_USU_ID;
    private ArrayList<Produto> produtos; 

    public Compras(int COM_ID, String COM_FORMA_PAGAMENTO, int USUARIO_USU_ID, ArrayList<Produto> produtos) {
        this.COM_ID = COM_ID;
        this.COM_FORMA_PAGAMENTO = COM_FORMA_PAGAMENTO;
        this.USUARIO_USU_ID = USUARIO_USU_ID;
        this.produtos = produtos;
    }

    public Compras(String COM_FORMA_PAGAMENTO, int USUARIO_USU_ID) {
        this.COM_FORMA_PAGAMENTO = COM_FORMA_PAGAMENTO;
        this.USUARIO_USU_ID = USUARIO_USU_ID;
    }

    public Compras(int COM_ID) {
        this.COM_ID = COM_ID;
    }

    public int getCOM_ID() {
        return COM_ID;
    }

    public void setCOM_ID(int COM_ID) {
        this.COM_ID = COM_ID;
    }

    public String getCOM_FORMA_PAGAMENTO() {
        return COM_FORMA_PAGAMENTO;
    }

    public void setCOM_FORMA_PAGAMENTO(String COM_FORMA_PAGAMENTO) {
        this.COM_FORMA_PAGAMENTO = COM_FORMA_PAGAMENTO;
    }

    public int getUSUARIO_USU_ID() {
        return USUARIO_USU_ID;
    }

    public void setUSUARIO_USU_ID(int USUARIO_USU_ID) {
        this.USUARIO_USU_ID = USUARIO_USU_ID;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Compras{" + "COM_ID=" + COM_ID + ", COM_FORMA_PAGAMENTO=" + COM_FORMA_PAGAMENTO + ", USUARIO_USU_ID=" + USUARIO_USU_ID + ", produtos=" + produtos + '}';
    }
    
    

       

}
