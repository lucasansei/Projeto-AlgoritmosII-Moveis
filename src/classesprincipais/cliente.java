/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesprincipais;

/**
 *
 * @author lucas
 */
public class cliente {
    String cpf, nome, nascimento, telefone, endereco, email;

    public cliente () {
        
    }

    public cliente (String cpf, String nome, String nascimento, String telefone, String endereco, String email) {
        this.cpf        = cpf;
        this.nome       = nome;
        this.nascimento = nascimento;
        this.telefone   = telefone;
        this.endereco   = endereco;
        this.email      = email;
   }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
