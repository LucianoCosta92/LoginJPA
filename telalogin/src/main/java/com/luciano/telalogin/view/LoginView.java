package com.luciano.telalogin.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.luciano.telalogin.controller.UsuarioController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Usuário");
		lblNewLabel_1.setBounds(122, 25, 51, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setBounds(122, 92, 51, 15);
		contentPane.add(lblNewLabel_2);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textUsuario.getText().matches("") || textSenha.getText().matches("")) {
					JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos!");
				} else {
					try {
						UsuarioController controller = new UsuarioController();
						controller.loginUsuario(LoginView.this);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Erro: " + e);
					}
				}
				textUsuario.setText(null);
				textSenha.setText(null);
			}
		});
		btnEntrar.setBounds(197, 175, 96, 25);
		contentPane.add(btnEntrar);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(122, 52, 240, 19);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		textSenha = new JTextField();
		textSenha.setBounds(122, 119, 240, 19);
		contentPane.add(textSenha);
		textSenha.setColumns(10);
		
		JButton btnCadastro = new JButton("Realizar cadastro");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroView telaDeCadastro = new CadastroView();
				telaDeCadastro.setVisible(true);
			}
		});
		btnCadastro.setBounds(181, 212, 125, 25);
		contentPane.add(btnCadastro);
	}

	public JTextField getTextUsuario() {
		return textUsuario;
	}

	public void setTextUsuario(JTextField textUsuario) {
		this.textUsuario = textUsuario;
	}

	public JTextField getTextSenha() {
		return textSenha;
	}

	public void setTextSenha(JTextField textSenha) {
		this.textSenha = textSenha;
	}
	
	
	
	
}
