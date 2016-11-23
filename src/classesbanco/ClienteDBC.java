/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesbanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import classesprincipais.cliente;

/**
 *
 * @author lucas ansei
 */
public class ClienteDBC {
    Connection conexao;
    Statement stmt;
    ResultSet rs;


    public  Connection getConnection() throws ClassNotFoundException, SQLException{
       
        Class.forName("com.mysql.jdbc.Driver");

        conexao = DriverManager.getConnection( "jdbc:mysql://localhost:3306/moveis","root","e5d4c3d2a1");
        return conexao;
    }
 
    // método para gravar dados de um cliente
    public  void gravarCliente(cliente cliente) throws ClassNotFoundException, SQLException{
        String sql;
        conexao= getConnection();
        stmt=conexao.createStatement();
        sql= "INSERT INTO moveis.cliente (cpf, nome, nascimento, telefone, endereco, email) VALUES('" 
            +   cliente.getCpf()         +"','"
            +   cliente.getNome()        +"','" 
            +   cliente.getNascimento()  +"','"
            +   cliente.getTelefone()    +"','" 
            +   cliente.getEndereco()    +"','"
            +   cliente.getEmail()       +"')";
    
        stmt.executeUpdate(sql);
        JOptionPane.showMessageDialog(null, " Dados do Cliente gravados com sucesso!!!");
    }
    
    // método para excluir um cliente
    public void excluirCliente( String cpf ) throws ClassNotFoundException, SQLException{
        String sql;
        conexao = getConnection();
        stmt    = conexao.createStatement();

        sql="DELETE FROM moveis.cliente WHERE cpf = '"+cpf+"'";
        if(stmt.executeUpdate(sql)>0) {
          JOptionPane.showMessageDialog(null, "Cliente excluido");
        }
    }
    
    // método para alterar dados de um cliente
    public void alterarCliente(String cpf, cliente cliente) throws ClassNotFoundException, SQLException{
        String sql;
        conexao    = getConnection();
        stmt       = conexao.createStatement();

        sql="UPDATE moveis.cliente SET "
                + "nome = '"        + cliente.getNome()         + "',"
                + "nascimento = '"  + cliente.getNascimento()   + "',"
                + "telefone = '"    + cliente.getTelefone()     + "',"
                + "endereco = '"    + cliente.getEndereco()     + "',"
                + "email = '"       + cliente.getEmail()        + "'"
                + " WHERE cpf = '"+cpf+"'";
        
        stmt.executeUpdate(sql);
    
        if(stmt.executeUpdate(sql)>0) {
          JOptionPane.showMessageDialog(null, "Cliente modificado");
        }
    }
    
    // método para buscar um cliente
    public cliente buscarCliente(String cpf) throws ClassNotFoundException, SQLException{
    
        String sql;
        cliente cli = new cliente();
     
        conexao = getConnection();
        stmt    = conexao.createStatement();
        sql     = "select * from moveis.cliente where cpf = '"+cpf+"'";
        rs      = stmt.executeQuery(sql);
        
        while (rs.next()) {
            cli.setNome(rs.getString(2));
            cli.setNascimento(rs.getString(3));
            cli.setTelefone(rs.getString(4)); 
            cli.setEndereco(rs.getString(5));
            cli.setEmail(rs.getString(6));
        }
  
    return cli;
    }
}