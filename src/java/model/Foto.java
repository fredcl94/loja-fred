/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Foto {
    private final int FOTO_ID;
    private final String FOTO_NOME;
    private final int FOTO_ID_PRO;
    public Foto(int id, String nome, int id_pro){
        FOTO_ID = id;
        FOTO_NOME = nome;
        FOTO_ID_PRO = id_pro;
    }

    /**
     * @return the FOTO_ID
     */
    public int getFOTO_ID() {
        return FOTO_ID;
    }

    /**
     * @return the FOTO_NOME
     */
    public String getFOTO_NOME() {
        return FOTO_NOME;
    }

    /**
     * @return the FOTO_ID_PRO
     */
    public int getFOTO_ID_PRO() {
        return FOTO_ID_PRO;
    }
}
