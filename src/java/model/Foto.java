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
    
    public Foto(int id, String nome, int pro_id){
        FOTO_ID = id;
        FOTO_NOME = nome;
        FOTO_PRO_ID = pro_id;
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
     * @return the FOTO_PRO_ID
     */
    public int getFOTO_PRO_ID() {
        return FOTO_PRO_ID;
    }
}
