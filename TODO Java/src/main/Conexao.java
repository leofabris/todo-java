package main;


import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class Conexao {

    private Connection connect = null;
    private PreparedStatement ps;

    /**
     * Retorna o objeto da conexão com o banco de dados
     * @return 
     */
    public Connection getConexao() {
        return this.connect;
    }

    /**
     * Constrói um novo objeto para conexão com o banco de dados.
     * Atualmente está usando SQLite.
     */
    public Conexao() {
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:todo.db");
            CriaEstrutura(connect);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não é possível iniciar conexão com o banco de dados.\n\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Este método verifica a estrutura do banco de dados.
     * Caso não exita as tabelas, será criara.
     * PS.: Não verifica a estrutura se está correta.
     * @param conn 
     */
    public static void CriaEstrutura(Connection conn) {
        try {
            System.out.print("Verificando estrutura do banco de dados... ");
            PreparedStatement ps = conn.prepareStatement("CREATE TABLE IF NOT EXISTS eventos("
                    + "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                    + "data DATE NOT NULL,"
                    + "hora VARCHAR(5) NOT NULL,"
                    + "titulo VARCHAR(200) NOT NULL,"
                    + "observacoes TEXT DEFAULT NULL)");
            ps.executeUpdate();
            ps.close();
            System.out.println("[OK]");
        } catch (Exception ex) {
            System.out.println("[ERRO]\n" + ex);
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível criar o banco de dados.\n\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

}
