/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Frede
 */
public class Carrinho {
    private int PRODUTO_PRO_ID;
    private int USUARIO_USU_ID;

    public Carrinho(int PRODUTO_PRO_ID, int USUARIO_USU_ID) {
        this.PRODUTO_PRO_ID = PRODUTO_PRO_ID;
        this.USUARIO_USU_ID = USUARIO_USU_ID;
    }

    public int getPRODUTO_PRO_ID() {
        return PRODUTO_PRO_ID;
    }

    public void setPRODUTO_PRO_ID(int PRODUTO_PRO_ID) {
        this.PRODUTO_PRO_ID = PRODUTO_PRO_ID;
    }

    public int getUSUARIO_USU_ID() {
        return USUARIO_USU_ID;
    }

    public void setUSUARIO_USU_ID(int USUARIO_USU_ID) {
        this.USUARIO_USU_ID = USUARIO_USU_ID;
    }
    
    
}
