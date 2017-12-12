/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Produto {
    private int PRO_ID;
    private String PRO_NOME;
    private String PRO_DESCRICAO;
    private Double PRO_VALOR;
    private int PRO_QUANTIDADE;
   // private  byte[] PRO_FOTOS;
    private String PRO_MARCA;
    private String PRO_CATEGORIA;

    public Produto(int PRO_ID) {
        this.PRO_ID = PRO_ID;
    }
    

    public Produto(int PRO_ID, String PRO_NOME, String PRO_DESCRICAO, Double PRO_VALOR, int PRO_QUANTIDADE, String PRO_MARCA, String PRO_CATEGORIA) {
        this.PRO_ID = PRO_ID;
        this.PRO_NOME = PRO_NOME;
        this.PRO_DESCRICAO = PRO_DESCRICAO;
        this.PRO_VALOR = PRO_VALOR;
        this.PRO_QUANTIDADE = PRO_QUANTIDADE;
     //   this.PRO_FOTOS = PRO_FOTOS;
        this.PRO_MARCA = PRO_MARCA;
        this.PRO_CATEGORIA = PRO_CATEGORIA;
    }

    public Produto(Integer id, String nome, String uf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

       
    public int getPRO_ID() {
        return PRO_ID;
    }

    public void setPRO_ID(int PRO_ID) {
        this.PRO_ID = PRO_ID;
    }

    public String getPRO_NOME() {
        return PRO_NOME;
    }

    public void setPRO_NOME(String PRO_NOME) {
        this.PRO_NOME = PRO_NOME;
    }

    public String getPRO_DESCRICAO() {
        return PRO_DESCRICAO;
    }

    public void setPRO_DESCRICAO(String PRO_DESCRICAO) {
        this.PRO_DESCRICAO = PRO_DESCRICAO;
    }

    public Double getPRO_VALOR() {
        return PRO_VALOR;
    }

    public void setPRO_VALOR(Double PRO_VALOR) {
        this.PRO_VALOR = PRO_VALOR;
    }

    public int getPRO_QUANTIDADE() {
        return PRO_QUANTIDADE;
    }

    public void setPRO_QUANTIDADE(int PRO_QUANTIDADE) {
        this.PRO_QUANTIDADE = PRO_QUANTIDADE;
    }

    //public byte[] getPRO_FOTOS() {
      //  return PRO_FOTOS;
    //}

    //public void setPRO_FOTOS(byte[] PRO_FOTOS) {
     //   this.PRO_FOTOS = PRO_FOTOS;
    //}

    public String getPRO_MARCA() {
        return PRO_MARCA;
    }

    public void setPRO_MARCA(String PRO_MARCA) {
        this.PRO_MARCA = PRO_MARCA;
    }

    public String getPRO_CATEGORIA() {
        return PRO_CATEGORIA;
    }

    public void setPRO_CATEGORIA(String PRO_CATEGORIA) {
        this.PRO_CATEGORIA = PRO_CATEGORIA;
    }

    @Override
    public String toString() {
        return "Produto{" + "PRO_ID=" + PRO_ID + ", PRO_NOME=" + PRO_NOME + ", PRO_DESCRICAO=" + PRO_DESCRICAO + ", PRO_VALOR=" + PRO_VALOR + ", PRO_QUANTIDADE=" + PRO_QUANTIDADE + ", PRO_MARCA=" + PRO_MARCA + ", PRO_CATEGORIA=" + PRO_CATEGORIA + '}';
    }

    
   
}