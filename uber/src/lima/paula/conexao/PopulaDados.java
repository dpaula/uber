/**
 * 
 */
package lima.paula.conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lima.paula.relacional.Corrida;
import lima.paula.relacional.Driver;
import lima.paula.relacional.Veiculo;

/**
 * @author ferna
 *
 */
public class PopulaDados {

	public ArrayList<Corrida> corridas = new ArrayList<Corrida>();
	
	private PopulaDados() {
		
	}
	
	private static PopulaDados instancia = null;
	
	public static PopulaDados getInstance() {
		if(instancia == null) {
			instancia = new PopulaDados();
			instancia.populaDados();
		}
		return instancia;
	}

	private void populaDados() {

		ConectaBanco conectaBanco = new ConectaBanco();

		conectaBanco.abrirConexao();

		ArrayList<Driver> motoristas = carregaDrivers(conectaBanco.conn);
		ArrayList<Veiculo> veiculos = carregaVeiculos(conectaBanco.conn);

		corridas = carregaCorridas(conectaBanco.conn, motoristas, veiculos);

		conectaBanco.fecharConexao();

	}

	private ArrayList<Corrida> carregaCorridas(Connection conn, ArrayList<Driver> motoristas,
			ArrayList<Veiculo> veiculos) {

		ArrayList<Corrida> corridas = new ArrayList<Corrida>();

		try {

			/*
			 * id_corrida number(7) not null, id_driver number(7) not null, id_veiculo
			 * number(7) not null, distancia_perc number(10), autonomia number(2,2),
			 * dia_corrida date, ganho_bruto_dia number(4,2), horas_trab number(2,1),
			 */

			ResultSet rs = conn.prepareStatement("SELECT * FROM CORRIDA").executeQuery();

			while (rs.next()) {

				Corrida corrida = new Corrida();

				corrida.setId(rs.getInt("id_corrida"));
				corrida.setMotorista(retornaMotorista(rs.getInt("id_driver"), motoristas));
				corrida.setVeiculo(retornaVeiculo(rs.getInt("id_veiculo"), veiculos));
				corrida.setDistPercorrida(rs.getInt("distancia_perc"));
				;
				corrida.setAutonomia(rs.getDouble("autonomia"));
				corrida.setDia(rs.getDate("dia_corrida"));
				corrida.setGanhoBruto(rs.getDouble("ganho_bruto_dia"));
				corrida.setHorasTrabalhadas(rs.getFloat("horas_trab"));

				corridas.add(corrida);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return corridas;
	}

	private Veiculo retornaVeiculo(int id, ArrayList<Veiculo> veiculos) {

		for (Veiculo veiculo : veiculos) {
			if (veiculo.getId() == id) {
				return veiculo;
			}
		}

		return null;
	}

	private Driver retornaMotorista(int id, ArrayList<Driver> motoristas) {
		for (Driver motorista : motoristas) {
			if (motorista.getIdDriver() == id) {
				return motorista;
			}
		}
		return null;
	}

	private ArrayList<Veiculo> carregaVeiculos(Connection conn) {
		ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

		try {

			/*
			 * id_veiculo number(7) not null, marca varchar2(30) not null, modelo
			 * varchar2(30) not null, valor_depre number, ano date,
			 */

			ResultSet rs = conn.prepareStatement("SELECT * FROM VEICULO").executeQuery();

			while (rs.next()) {
				veiculos.add(new Veiculo(rs.getInt("id_veiculo"), rs.getString("marca"), rs.getString("modelo"),
						rs.getDouble("valor_depre"), rs.getString("ano")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return veiculos;
	}

	private ArrayList<Driver> carregaDrivers(Connection conn) {

		ArrayList<Driver> motoristas = new ArrayList<Driver>();

		try {

			/*
			 * id_driver number(7) not null, nome varchar2(200) not null unique,
			 */
			ResultSet rs = conn.prepareStatement("SELECT * FROM DRIVER").executeQuery();

			while (rs.next()) {
				motoristas.add(new Driver(rs.getInt("id_driver"), rs.getString("nome")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return motoristas;
	}

}
