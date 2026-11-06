/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudtp;

import java.util.List;

/**
 *
 * @author mafec
 */
public class AlunoController {
    
    private AlunoDAO dao = new AlunoDAO();

    public List<Aluno> listarAlunos() {
        return dao.listarAlunos();
    }

    public boolean atualizarAluno(Aluno aluno) {
        return dao.atualizarAluno(aluno);
    }

    public boolean deletarAluno(int cdAluno) {
        return dao.deletarAluno(cdAluno);
    }
    
}
