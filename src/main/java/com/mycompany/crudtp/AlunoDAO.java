/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudtp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mafec
 */
public class AlunoDAO {
    public List<Aluno> listarAlunos() {

        List<Aluno> lista = new ArrayList<>();

        String sql = "SELECT * FROM tb_aluno";

        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Aluno aluno = new Aluno();

                aluno.setCdAluno(rs.getInt("cd_aluno"));
                aluno.setRm(rs.getString("cd_rm_aluno"));
                aluno.setNome(rs.getString("nm_aluno"));
                aluno.setIdade(rs.getInt("nr_idade_aluno"));
                aluno.setEmail(rs.getString("email_aluno"));
                aluno.setSenha(rs.getString("senha_aluno"));

                lista.add(aluno);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar alunos", e);
        }

        return lista;
    }

    // UPDATE - Atualizar aluno
    public boolean atualizarAluno(Aluno aluno) {

        String sql = "UPDATE tb_aluno SET "
                + "cd_rm_aluno = ?, "
                + "nm_aluno = ?, "
                + "nr_idade_aluno = ?, "
                + "email_aluno = ?, "
                + "senha_aluno = ? "
                + "WHERE cd_aluno = ?";

        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getRm());
            stmt.setString(2, aluno.getNome());
            stmt.setInt(3, aluno.getIdade());
            stmt.setString(4, aluno.getEmail());
            stmt.setString(5, aluno.getSenha());
            stmt.setInt(6, aluno.getCdAluno());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar aluno", e);
        }
    }

    // DELETE - Excluir aluno
    public boolean deletarAluno(int cdAluno) {

        String sql = "DELETE FROM tb_aluno WHERE cd_aluno = ?";

        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cdAluno);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar aluno", e);
        }
    }
}
