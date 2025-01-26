package com.luciano.telalogin.model.dao;

import java.util.List;

import javax.swing.JOptionPane;

import org.jasypt.util.password.BasicPasswordEncryptor;

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
			String senhaEncriptada = encripta(senha);
			
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setSenha(senhaEncriptada);
			
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
			senha = senha.trim().toLowerCase();
			
			Query query = em.createQuery("select u from Usuario u where u.email = :email").setParameter("email", email);
			System.out.println("\nEmail pesquisado: " + email);
			@SuppressWarnings("unchecked")
			List<Usuario> resultados = query.getResultList();
			
			if (!resultados.isEmpty()) {
				Usuario usuario = resultados.get(0);
				String senhaBanco  = usuario.getSenha();
				boolean verifica = verificaSenha(senha, senhaBanco);
				if (verifica) {
					JOptionPane.showMessageDialog(null, "Usuário cadastrado!");
				} else {
					JOptionPane.showMessageDialog(null, "Senha incorreta!");
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
	
	private static String encripta(String senhaCripto) {
		  BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		  String senhaCriptografada = passwordEncryptor.encryptPassword(senhaCripto);
		  return senhaCriptografada;
	}
	
	@SuppressWarnings("unused")
	private static boolean verificaSenha(String senhaCripto, String senhaBanco) {
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		boolean resultado = passwordEncryptor.checkPassword(senhaCripto, senhaBanco);
		return resultado;
	}
	
	
}
