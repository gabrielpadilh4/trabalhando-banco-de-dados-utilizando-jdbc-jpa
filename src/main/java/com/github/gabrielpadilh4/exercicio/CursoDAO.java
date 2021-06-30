package com.github.gabrielpadilh4.exercicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    public void create(final Curso curso) {

        if (curso != null) return;

        try (Connection connection = ConnectionFactory.getConnection()) {

            String sql = "INSERT INTO curso(nome, duracao_horas) VALUES (?, ?)";

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, curso.getNome());
            pstmt.setInt(2, curso.getDuracaoHoras());

            int rowsAffected = pstmt.executeUpdate();

            System.out.printf("%d linhas afetadas", rowsAffected);

        } catch (SQLException sqlException) {
            System.out.println("Erro ao acessar banco de dados!");
            System.out.println(sqlException.getMessage());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public List<Curso> list() {
        try (Connection connection = ConnectionFactory.getConnection()) {

            System.out.println("Buscando lista de cursos no banco de dados...");

            List<Curso> cursoList = new ArrayList<>();

            String sql = "SELECT id, nome, duracao_horas FROM curso";

            PreparedStatement pstmt = connection.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                cursoList.add(new Curso(rs.getInt("id"), rs.getString("nome"), rs.getInt("duracao_horas")));
            }

            return cursoList;

        } catch (SQLException sqlException) {
            System.out.println("Erro ao acessar banco de dados!");
            System.out.println(sqlException.getMessage());
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return null;
    }

    public Curso getById(final long id) {
        try (Connection connection = ConnectionFactory.getConnection()) {

            System.out.println("Buscando curso por id no banco de dados...");

            List<Curso> cursoList = new ArrayList<>();

            String sql = "SELECT id, nome, duracao_horas FROM curso WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);

            ResultSet rs = pstmt.executeQuery();

            Curso c = null;

            if (rs.next()) {
                c = new Curso(rs.getInt("id"), rs.getString("nome"), rs.getInt("duracao_horas"));
            }

            return c;

        } catch (SQLException sqlException) {
            System.out.println("Erro ao acessar banco de dados!");
            System.out.println(sqlException.getMessage());
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return null;
    }

    public Curso update(final Curso curso) {

        System.out.println("Atualizando curso por id no banco de dados...");
        System.out.println("[OLD] -> " + getById(curso.getId()));

        try (Connection connection = ConnectionFactory.getConnection()) {

            String sql = "UPDATE curso SET nome = ? , duracao_horas = ? WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, curso.getNome());
            pstmt.setInt(2, curso.getDuracaoHoras());
            pstmt.setLong(3, curso.getId());

            int linhasAfetadas = pstmt.executeUpdate();

            System.out.printf("%d linhas afetadas! \n", linhasAfetadas);

            Curso c = getById(curso.getId());

            System.out.println("[NEW] -> " + c);

            return c;

        } catch (SQLException sqlException) {
            System.out.println("Erro ao acessar banco de dados!");
            System.out.println(sqlException.getMessage());
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return null;
    }

    public void delete(final Curso curso) {
        System.out.println("Apagando curso no banco de dados...");
        System.out.println("[TO_DELETE] -> " + getById(curso.getId()));

        try (Connection connection = ConnectionFactory.getConnection()) {

            String sql = "DELETE FROM curso WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, curso.getId());

            int linhasAfetadas = pstmt.executeUpdate();

            System.out.printf("%d linhas afetadas! \n", linhasAfetadas);

        } catch (SQLException sqlException) {
            System.out.println("Erro ao acessar banco de dados!");
            System.out.println(sqlException.getMessage());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
