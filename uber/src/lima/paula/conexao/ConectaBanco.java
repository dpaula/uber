package lima.paula.conexao;

import java.security.KeyStore.ProtectionParameter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectaBanco {

	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "uber";
	private String senha = "uber";

	public Connection conn;
	private PreparedStatement pstmt;
	private Statement stmt; // prepara e realiza as pesquisas no banco
	private ResultSet rs;// armazena os resultados da pesquisa

	public void abrirConexao() {
		try {
			conn = DriverManager.getConnection(url, user, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void fecharConexao() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		ConectaBanco c = new ConectaBanco();

		c.abrirConexao();

		try {
			PreparedStatement p = c.conn.prepareStatement("select * from corrida");
			ResultSet resultSet = p.executeQuery();

			while (resultSet.next()) {
				int int1 = resultSet.getInt("distancia_perc");
				System.out.println(int1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		c.fecharConexao();
	}

}
