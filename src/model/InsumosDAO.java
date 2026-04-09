package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InsumosDAO {
	
	public void adicionarInsumo(Insumos insumo) {
        String sql = "INSERT INTO insumos (nome, marca, fornecedora, descricao, valor, quantidade, codBarras) VALUES (?,?,?,?,?,?)";

        try (Connection conexao = BancoDeDados.conectar();
             PreparedStatement pstm = conexao.prepareStatement(sql)) {

            
            pstm.setString(1, insumo.getNome());
            pstm.setString(2, insumo.getMarca());
            pstm.setString(3, insumo.getFornecedora());
            pstm.setString(4,insumo.getDescricao());
            pstm.setFloat(5, insumo.getValor());
            pstm.setInt(6, insumo.getQuantidade());
            pstm.setInt(7, insumo.getCodBarras());
            

            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Insumos> listarInsumos() {
        List<Insumos> lista = new ArrayList<>();
        String sql = "SELECT * FROM insumos";

        try (Connection conexao = BancoDeDados.conectar();
             PreparedStatement pstm = conexao.prepareStatement(sql);
             ResultSet rset = pstm.executeQuery()) {

            while (rset.next()) {
                Insumos insumo = new Insumos(
           
                        rset.getString("nome"),
                        rset.getString("marca"),
                        rset.getString("fornecedora"),
                        rset.getString("descricao"),
                        rset.getFloat("valor"),
                        rset.getInt("quantidade"),
                        rset.getInt("codBarras")
                        
                );
                lista.add(insumo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
	
	
	

}
