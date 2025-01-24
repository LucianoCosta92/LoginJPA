package com.luciano.telalogin.controller;

import com.luciano.telalogin.model.dao.UsuarioDAO;
import com.luciano.telalogin.view.CadastroView;
import com.luciano.telalogin.view.LoginView;

public class UsuarioController {
	
	public void cadastroUsuario(CadastroView view) {
		UsuarioDAO cadastro = new UsuarioDAO();
		cadastro.cadastrarUsuario(view.getTextNomeCadastro().getText(), 
				view.getTextEmailCadastro().getText(), 
				view.getTextSenhaCadastro().getText());
	}
	
	public void loginUsuario(LoginView view) {
		UsuarioDAO login = new UsuarioDAO();
		login.login(view.getTextUsuario().getText(), 
				view.getTextSenha().getText());
	}
}
