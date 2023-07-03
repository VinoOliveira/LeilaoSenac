import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Validacoes {
    private Connection conn;
   private PreparedStatement prep;
   private  ResultSet resultset;

   /*valida se o id informado existe no banco de dados*/
    public boolean validarID(int id){
        conn = new conectaDAO().connectDB();
        ProdutosDTO produto = new ProdutosDTO();
        String sql = "SELECT * FROM produtos WHERE id = ?";
        try {
            prep = conn.prepareStatement(sql);
            prep.setInt(1,id);
            resultset = prep.executeQuery();
            return resultset.next();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
            return false;
        }
    }
    /*um novo lance sempre deve ser maior que o lance atual*/
    public boolean validarLance(int valor, int id){
        ProdutosDAO produtosDao = new ProdutosDAO();
        ArrayList<ProdutosDTO> produtos = produtosDao.listarProdutos();
        try {
            if(validarID(id) == false){
                throw new Exception("Produto não encontrado, confira o ID");
            }
            for(ProdutosDTO produto : produtos){
                if(produto.getId() == id){
                    if(produto.getLanceAtual() < valor){
                        return true;
                    }
                }
            }
        }catch (Exception e){
        }
        return false;
    }

}
