/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        conn = new conectaDAO().connectDB();
        String sql = "INSERT INTO produtos (`nome`, `valor`, `status`) VALUES (?,?,?)";
        try {
            prep = conn.prepareStatement(sql);
            prep.setString(1,produto.getNome());
            prep.setInt(2,produto.getValor());
            prep.setString(3, produto.getStatus());
            prep.executeUpdate();
            JOptionPane.showMessageDialog(null, "cadastro realizado com sucesso");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"erro ao cadastrar produto, " + e.getMessage());
        }
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        conn = new conectaDAO().connectDB();
        String sql = "SELECT * FROM produtos";
            try {
                prep = conn.prepareStatement(sql);
                ResultSet resultado = prep.executeQuery();
                while (resultado.next()){
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(resultado.getInt("id"));
                produto.setNome(resultado.getString("nome"));
                produto.setValor(resultado.getInt("valor"));
                produto.setStatus(resultado.getString("status"));
                listagem.add(produto);
        }
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null,"erro ao listar produtos, " + e.getMessage());
    }
        return listagem;
    }
    public ArrayList<ProdutosDTO> listarProdutosVendidos(){
        conn = new conectaDAO().connectDB();
        String sql = "SELECT * FROM produtos WHERE status = 'Vendido'";
        try {
            prep = conn.prepareStatement(sql);
            ResultSet resultado = prep.executeQuery();
            while (resultado.next()){
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(resultado.getInt("id"));
                produto.setNome(resultado.getString("nome"));
                produto.setValor(resultado.getInt("valor"));
                produto.setStatus(resultado.getString("status"));
                listagem.add(produto);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"erro ao listar produtos vendidos, " + e.getMessage());
        }
        return listagem;
    }
    public void venderProduto(int id){
        String sql = "UPDATE produtos SET status = 'Vendido' WHERE id = ?";
        conn = new conectaDAO().connectDB();
        try{
            prep = conn.prepareStatement(sql);
            prep.setInt(1,id);
            prep.executeUpdate();
            JOptionPane.showMessageDialog(null,"Venda realizada com sucesso!");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"erro ao vender produto, " + e.getMessage());
        }

    }
}

