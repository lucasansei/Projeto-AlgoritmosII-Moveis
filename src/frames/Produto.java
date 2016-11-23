package frames;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucas Martins 7992765
 */
public class Produto {
    String codigo;
    String produto;
    Integer quantidade;
   String cor;
   
public Produto(String codigo, String produto, Integer quantidade, String cor){
    this.codigo= codigo;
    this.produto = produto;
    this.quantidade = quantidade;
    this.cor = cor;
    
}
    public Produto(){}

//metodos para garantir o encapsulamento
//set & get (set = pegar, get = saida)

public String getCodigo(){
    return codigo;
}
public void setCodigo(String codigo){
    this.codigo = codigo;
}

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

     public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    
    
}//Fim
