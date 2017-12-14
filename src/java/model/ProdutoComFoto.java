
package model;

/**
 *
 * @author Frede
 */
public class ProdutoComFoto {
    private Produto produto; 
    private Foto foto; 

    public ProdutoComFoto(Produto produto, Foto foto) {
        this.produto = produto;
        this.foto = foto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }
    
    
}
