package controller;

import javax.persistence.Query;
import javax.swing.JOptionPane;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.AlunoModel;

public class AlunoController implements Serializable {
	EntityManagerFactory emf;
	EntityManager em;

	public AlunoController() {
		emf = Persistence.createEntityManagerFactory("aluno");
		em = emf.createEntityManager();

	}

	public void Salvar(AlunoModel _aluno) {
		try {
			em.getTransaction().begin();
			em.merge(_aluno);
			em.getTransaction().commit();
			emf.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO CONEXÃO" + e, "ERRO SALVAR/ATUALIZAR",
					JOptionPane.WARNING_MESSAGE);

		}
	}

	public void Remover(AlunoModel _aluno) {
		try {
			em.getTransaction().begin();
			Query q = em.createNativeQuery("DELETE aluno FROM aluno WHERE id = " + _aluno.getId());
			q.executeUpdate();
			em.getTransaction().commit();
			emf.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO CONEXÃO" + e, "ERRO REMOVER", JOptionPane.WARNING_MESSAGE);

		}
	}

	

}
