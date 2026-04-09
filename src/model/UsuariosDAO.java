package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAO {
	
	public void adicionarDados(Usuarios usuario) {

		String sql = "INSERT INTO usuarios (nome, cpf, usuario, adm) VALUES (?,?,?,?)";
		
		Connection conexao = null;
		PreparedStatement pstm = null;

		try {
			
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getCpf());
			pstm.setString(3, usuario.getUsuario());
			pstm.setBoolean(4,usuario.isAdm());
			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		finally {
		    try {
		        if (pstm != null) pstm.close();
		        if (conexao != null) conexao.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
	}
	
	public List<Usuarios> listarUsuarios() {
        String sql = "SELECT * FROM usuarios";
        List<Usuarios> usuarios = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null; // Objeto que guarda o resultado da consulta

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            rset = pstm.executeQuery();


            while (rset.next()) {

                Usuarios usuario = new Usuarios(
                    rset.getString("cpf"),
                    rset.getString("nome"),
                    rset.getString("usuario"),
                    rset.getBoolean("adm")
                );

                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) rset.close();
                if (pstm != null) pstm.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return usuarios;
    }



}
