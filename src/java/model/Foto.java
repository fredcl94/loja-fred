/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Foto {

    private final int FOTO_ID;
    private final String FOTO_NOME;
    private final int FOTO_PRO_ID;

    public Foto(int FOTO_ID, String FOTO_NOME, int FOTO_PRO_ID) {
        this.FOTO_ID = FOTO_ID;
        this.FOTO_NOME = FOTO_NOME;
        this.FOTO_PRO_ID = FOTO_PRO_ID;
    }

    public int getFOTO_ID() {
        return FOTO_ID;
    }

    public String getFOTO_NOME() {
        return FOTO_NOME;
    }

    public int getFOTO_PRO_ID() {
        return FOTO_PRO_ID;
    }

}
