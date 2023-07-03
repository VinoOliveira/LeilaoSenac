import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validacoes {
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    public boolean validarID(int id){
        boolean encontrou = false;
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
}
