package frames;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author  Lucas 7992765
 */
class ProdutoAcessaBD {
     Connection conexao;
    Statement stmt;
    ResultSet rs;
    private String codigo;
    
    
       public  Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection con;
     //  Class.forName("org.apache.derby.jdbc.InternalDriver.class");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ProdutoBD", "root", "");
            return con; 
            
       }
    public  void gravarDadosProduto(Produto produto) throws ClassNotFoundException, SQLException{
    String sql;
    conexao = getConnection();
    stmt = conexao.createStatement();
    sql= "INSERT INTO Produtos(Codigo,Produto,Quantidade,Cor) VALUES('"
            +produto.getCodigo()+"','"
            +produto.getProduto()+"',"
            +produto.getQuantidade()+",'"
            +produto.getCor()+"')"; 
     
        stmt.executeUpdate(sql);
        JOptionPane.showMessageDialog(null, " Dados do produto salvo com sucesso!!!");
    
    
    }

    public Produto buscarDadosProduto(String codigo) throws ClassNotFoundException, SQLException{
    
     String sql;
     Produto prod = new Produto();
     
    conexao= getConnection();
    stmt=conexao.createStatement();
    sql= "SELECT * FROM Produtos WHERE codigo='"+codigo+"'";
    rs= stmt.executeQuery(sql);
    
    
    
        while (rs.next()) {
    prod.setCodigo(rs.getString(1));
    prod.setProduto(rs.getString(2));
    prod.setQuantidade(rs.getInt(3));
    prod.setCor(rs.getString(4));
        }
        
    return prod;
    
    }
       public void editarDadosProduto(String codigo, Produto produto) throws ClassNotFoundException, SQLException{
    String sql;
    conexao= getConnection();
    stmt=conexao.createStatement();

    sql="UPDATE Produtos"
            + "SET produto='"+produto.getProduto()+"'"
            +",quantidade = "+produto.getQuantidade()
            +",cor = "+produto.getCor()
            +" WHERE  codigo='"+produto.getProduto()+"'";
    if(stmt.executeUpdate(sql)> 0);
    
     JOptionPane.showMessageDialog(null, " Dados do Produto alterados com sucesso!!!");
    
     
     
        }
          public void excluirDadosCliente(String codigo) throws ClassNotFoundException, SQLException{
    
    String sql;
    conexao= getConnection();
    stmt=conexao.createStatement();

    sql="DELETE FROM Produtos WHERE codigo= '"+codigo+"'";
    if(stmt.executeUpdate(sql)>0)
    {
          JOptionPane.showMessageDialog(null, " Produto excluído com sucesso!!!");
    }

    
         }
           
}//Fim