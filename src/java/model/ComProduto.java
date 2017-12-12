/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class ComProduto {
    private int COM_PRO_ID;
    private int PRO_ID; 
    private int COM_ID;

    public ComProduto(int COM_PRO_ID, int PRO_ID, int COM_ID) {
        this.COM_PRO_ID = COM_PRO_ID;
        this.PRO_ID = PRO_ID;
        this.COM_ID = COM_ID;
    }
    
    

    public int getCOM_PRO_ID() {
        return COM_PRO_ID;
    }

    public void setCOM_PRO_ID(int COM_PRO_ID) {
        this.COM_PRO_ID = COM_PRO_ID;
    }

    public int getPRO_ID() {
        return PRO_ID;
    }

    public void setPRO_ID(int PRO_ID) {
        this.PRO_ID = PRO_ID;
    }

    public int getCOM_ID() {
        return COM_ID;
    }

    public void setCOM_ID(int COM_ID) {
        this.COM_ID = COM_ID;
    }
    
    
}
