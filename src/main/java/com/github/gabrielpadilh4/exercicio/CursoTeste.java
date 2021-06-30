package com.github.gabrielpadilh4.exercicio;

import java.util.List;

public class CursoTeste {

    public static void main(String[] args) {

        /* Curso curso = new Curso("Trabalhando com Banco de Dado utilizando JDBC e JPA", 2);
        Curso curso1 = new Curso("JPA", 2);
        Curso curso2 = new Curso("Banco de Dados", 2);
        Curso curso3 = new Curso("Tests", 2); */

        CursoDAO cursoDAO = new CursoDAO();

        /*
        // cursoDAO.create(curso);
        // cursoDAO.create(curso1);
        // cursoDAO.create(curso2);
        // cursoDAO.create(curso3);

        List<Curso> cursoList = cursoDAO.list();

        for (Curso c : cursoList) {
            System.out.println(c);
        }

        System.out.println(cursoDAO.getById(6L));
        */
        Curso cursoAtualizado = new Curso(6L, "Curso Java Atualizado", 4);

        Curso curso = cursoDAO.update(cursoAtualizado);

        cursoDAO.delete(curso);

    }
}
