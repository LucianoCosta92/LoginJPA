package com.luciano.telalogin.model.dao;

import java.util.List;

import javax.swing.JOptionPane;

import com.luciano.telalogin.model.Usuario;
import com.luciano.telalogin.util.JpaUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class UsuarioDAO {
	
	public void cadastrarUsuario(String nome, String email, String senha) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			
			em.persist(usuario);
			tx.commit();
		} catch (PersistenceException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e);
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}
	
	public void login(String email, String senha) {
		EntityManager em = JpaUtil.getEntityManager();
		
		try {
			email = email.trim().toLowerCase();
			Query query = em.createQuery("select u from Usuario u where u.email = :email").setParameter("email", email);
			System.out.println("\nEmail pesquisado: " + email);
			@SuppressWarnings("unchecked")
			List<Usuario> resultados = query.getResultList();
			
			if (!resultados.isEmpty()) {
				Usuario usuario = resultados.get(0);
				if (usuario.getSenha().equals(senha)) {
					JOptionPane.showMessageDialog(null, "Usuário cadastrado!");
				} else {
					JOptionPane.showConfirmDialog(null, "Senha incorreta!");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Usuário não cadastrado!");
			}
		} catch (PersistenceException e) {
			JOptionPane.showMessageDialog(null, "Erro: " +e);
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		
	}
	
	
}
