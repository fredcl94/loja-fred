/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Usuario {
    private int USU_ID;
    private String USU_NOME;
    private String USU_TELEFONE;
    private String USU_SEXO;
    private String USU_ENDERECO;
    private String USU_CEP;
    private String USU_CIDADE;
    private String USU_ESTADO;
    private String USU_EMAIL;
    private String USU_SENHA;
    
    public Usuario(int USU_ID, String USU_NOME, String USU_TELEFONE, String USU_SEXO, String USU_ENDERECO, String USU_CEP, String USU_CIDADE, String USU_ESTADO, String USU_EMAIL, String USU_SENHA) {
        this.USU_ID = USU_ID;
        this.USU_NOME = USU_NOME;
        this.USU_TELEFONE = USU_TELEFONE;
        this.USU_SEXO = USU_SEXO;
        this.USU_ENDERECO = USU_ENDERECO;
        this.USU_CEP = USU_CEP;
        this.USU_CIDADE = USU_CIDADE;
        this.USU_ESTADO = USU_ESTADO;
        this.USU_EMAIL = USU_EMAIL;
        this.USU_SENHA = USU_SENHA;
    }

    public String getUSU_EMAIL() {
        return USU_EMAIL;
    }

    public void setUSU_EMAIL(String USU_EMAIL) {
        this.USU_EMAIL = USU_EMAIL;
    }

    public String getUSU_SENHA() {
        return USU_SENHA;
    }

    public void setUSU_SENHA(String USU_SENHA) {
        this.USU_SENHA = USU_SENHA;
    }

    public int getUSU_ID() {
        return USU_ID;
    }

    public void setUSU_ID(int USU_ID) {
        this.USU_ID = USU_ID;
    }

    public String getUSU_NOME() {
        return USU_NOME;
    }

    public void setUSU_NOME(String USU_NOME) {
        this.USU_NOME = USU_NOME;
    }

    public String getUSU_TELEFONE() {
        return USU_TELEFONE;
    }

    public void setUSU_TELEFONE(String USU_TELEFONE) {
        this.USU_TELEFONE = USU_TELEFONE;
    }

    public String getUSU_SEXO() {
        return USU_SEXO;
    }

    public void setUSU_SEXO(String USU_SEXO) {
        this.USU_SEXO = USU_SEXO;
    }

    public String getUSU_ENDERECO() {
        return USU_ENDERECO;
    }

    public void setUSU_ENDERECO(String USU_ENDERECO) {
        this.USU_ENDERECO = USU_ENDERECO;
    }

    public String getUSU_CEP() {
        return USU_CEP;
    }

    public void setUSU_CEP(String USU_CEP) {
        this.USU_CEP = USU_CEP;
    }

    public String getUSU_CIDADE() {
        return USU_CIDADE;
    }

    public void setUSU_CIDADE(String USU_CIDADE) {
        this.USU_CIDADE = USU_CIDADE;
    }

    public String getUSU_ESTADO() {
        return USU_ESTADO;
    }

    public void setUSU_ESTADO(String USU_ESTADO) {
        this.USU_ESTADO = USU_ESTADO;
    }

    
    
}
