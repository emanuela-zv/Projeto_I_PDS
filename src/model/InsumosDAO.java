package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InsumosDAO {

	public void adicionarInsumo(Insumos insumo) {
		String sql = "INSERT INTO insumos (nome, marca, fornecedora, descricao, valor, quantidade, codigoBarras) VALUES (?,?,?,?,?,?,?)";

		try (Connection conexao = BancoDeDados.conectar(); PreparedStatement pstm = conexao.prepareStatement(sql)) {

			pstm.setString(1, insumo.getNome());
			pstm.setString(2, insumo.getMarca());
			pstm.setString(3, insumo.getFornecedora());
			pstm.setString(4, insumo.getDescricao());
			pstm.setFloat(5, insumo.getValor());
			pstm.setInt(6, insumo.getQuantidade());
			pstm.setInt(7, insumo.getCodigoBarras());

			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Insumos> listarInsumos() {
		List<Insumos> lista = new ArrayList<>();
		String sql = "SELECT nome, marca, fornecedora, descricao, valor, quantidade, codigoBarras FROM insumos";
		;

		try (Connection conexao = BancoDeDados.conectar();
				PreparedStatement pstm = conexao.prepareStatement(sql);
				ResultSet rset = pstm.executeQuery()) {

			while (rset.next()) {
				Insumos insumo = new Insumos(

						rset.getString("nome"), rset.getString("marca"), rset.getString("fornecedora"),
						rset.getString("descricao"), rset.getFloat("valor"), rset.getInt("quantidade"),
						rset.getInt("codigoBarras")

				);

				lista.add(insumo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public void atualizar(Insumos insumo) {

		String sql = "UPDATE insumos SET nome=?, marca=?, fornecedora=?, quantidade=?, valor=?, descricao=? WHERE codigoBarras=?";

		try (Connection conexao = BancoDeDados.conectar(); PreparedStatement pstm = conexao.prepareStatement(sql)) {

			pstm.setString(1, insumo.getNome());
			pstm.setString(2, insumo.getMarca());
			pstm.setString(3, insumo.getFornecedora());
			pstm.setInt(4, insumo.getQuantidade());
			pstm.setDouble(5, insumo.getValor());
			pstm.setString(6, insumo.getDescricao());
			pstm.setInt(7, insumo.getCodigoBarras());

			pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void remover(int codigoBarras) {

		String sql = "DELETE FROM insumos WHERE codigoBarras = ?";

		try (Connection conexao = BancoDeDados.conectar(); PreparedStatement pstm = conexao.prepareStatement(sql)) {

			pstm.setInt(1, codigoBarras);
			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
