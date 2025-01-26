package com.luciano.telalogin.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.luciano.telalogin.controller.UsuarioController;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CadastroView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomeCadastro;
	private JTextField textEmailCadastro;
	private JTextField textSenhaCadastro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroView frame = new CadastroView();
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
	public CadastroView() {
		setTitle("Cadastro Novo Usuário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(44, 12, 51, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("E-mail");
		lblNewLabel_1.setBounds(44, 86, 51, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setBounds(44, 155, 51, 15);
		contentPane.add(lblNewLabel_2);
		
		textNomeCadastro = new JTextField();
		textNomeCadastro.setBounds(44, 42, 279, 19);
		contentPane.add(textNomeCadastro);
		textNomeCadastro.setColumns(10);
		
		textEmailCadastro = new JTextField();
		textEmailCadastro.setBounds(44, 113, 279, 19);
		contentPane.add(textEmailCadastro);
		textEmailCadastro.setColumns(10);
		
		textSenhaCadastro = new JTextField();
		textSenhaCadastro.setBounds(42, 182, 273, 19);
		contentPane.add(textSenhaCadastro);
		textSenhaCadastro.setColumns(10);
		
		JButton btnCadastroUsuario = new JButton("CADASTRAR");
		btnCadastroUsuario.addActionListener(e -> {
			if (textNomeCadastro.getText().matches("")||
					textEmailCadastro.getText().matches("") ||
					textSenhaCadastro.getText().matches("")) {
				JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos!");
			} else {
				try {
					UsuarioController cadastro = new UsuarioController();
					cadastro.cadastroUsuario(this);
					JOptionPane.showMessageDialog(rootPane, "Usuário cadastrado com sucesso!");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(rootPane, "Erro ao tentar cadastrar: " + e2);
				}
				dispose(); // fecha a janela
			}
		});
		btnCadastroUsuario.setBounds(137, 223, 115, 25);
		contentPane.add(btnCadastroUsuario);
	}

	public JTextField getTextNomeCadastro() {
		return textNomeCadastro;
	}

	public void setTextNomeCadastro(JTextField textNomeCadastro) {
		this.textNomeCadastro = textNomeCadastro;
	}

	public JTextField getTextEmailCadastro() {
		return textEmailCadastro;
	}

	public void setTextEmailCadastro(JTextField textEmailCadastro) {
		this.textEmailCadastro = textEmailCadastro;
	}

	public JTextField getTextSenhaCadastro() {
		return textSenhaCadastro;
	}

	public void setTextSenhaCadastro(JTextField textSenhaCadastro) {
		this.textSenhaCadastro = textSenhaCadastro;
	}
	
	

}
