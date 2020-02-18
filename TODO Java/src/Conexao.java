
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Conexao {

    private Connection connect = null;
    private PreparedStatement ps;

    public Connection getConexao() {
        return this.connect;
    }

    public Conexao() {
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:todo.db");
            CriaEstrutura(connect);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não é possível iniciar conexão com o banco de dados.\n\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void CriaEstrutura(Connection conn) {
        try {
            PreparedStatement ps = conn.prepareStatement("CREATE TABLE IF NOT EXISTS eventos("
                    + "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                    + "data VARCHAR(10) NOT NULL,"
                    + "hora VARCHAR(5) NOT NULL,"
                    + "titulo VARCHAR(200) NOT NULL,"
                    + "observacoes TEXT DEFAULT NULL)");
            ps.executeUpdate();
            ps.close();
            System.out.println("[OK]");
        } catch (Exception ex) {
            System.out.println("[ERRO]");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível criar o banco de dados.\n\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }
    
}
