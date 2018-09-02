package com.gohorse.view;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.gohorse.database.model.Cities;
import com.gohorse.database.model.Users;
import com.gohorse.lib.FileManipulation;

public class MainWindow extends JFrame {
	
	private JScrollPane scroll;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable table = new JTable(modelo);
	private int cont;
	
	private JMenuBar menu ;
	private JMenu mAlunos;
	private JMenu mCidades;
	private JMenu mUsuarios;
	private JMenuItem smListarCidade;
	private JMenuItem smListarAluno;
	private JMenuItem smListarUsuario;
	
	private JButton btnCadastroCidade;
	private JButton btnCadastroAluno;
	private JButton btnCadastroUsuario;
	private JButton btnEditarCidade;
	private JButton btnEditarAluno;
	private JButton btnEditarUsuario;
	private JButton btnDeletarCidade;
	private JButton btnDeletarAluno;
	private JButton btnDeletarUsuario;
	
	private JPanel regCity;
	private JLabel lbCity;
	private JTextField txfCity; 
	private JLabel lbState;
	private JTextField txfState;
	private JLabel lbCountry;
	private JTextField txfCountry;
	
	private JButton btnregCityister;
	
	public MainWindow (Users user) {
		
		setSize(600,600);
		setTitle("Menu");
		setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        CreateCitiesComponents();
        CreateStudentsComponents();
        CreateUsersComponents();
        CreateMenucomponents();
        
	}
	
	
	public void CreateMenucomponents() {
		
		 menu = new  JMenuBar();
		 
		 setJMenuBar(menu);
		 
		 mAlunos 			= new JMenu("Alunos");
		 mCidades			= new JMenu("Cidades");
		 mUsuarios			= new JMenu("Usuarios");
		 
		 menu.add(mAlunos);
		 menu.add(mCidades);
		 menu.add(mUsuarios);
		 
		 //db screens acesses
		 smListarAluno = new JMenuItem(new AbstractAction("Listar") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				StudentsWindow();
				
			}
			
		 });
		 
		 smListarCidade= new JMenuItem(new AbstractAction("Listar") {
				
			@Override
			public void actionPerformed(ActionEvent e) {

				
				CitiesWindow();
				
			}
			
		 });
		 
		 smListarUsuario= new JMenuItem(new AbstractAction("Listar") {
				
			@Override
			public void actionPerformed(ActionEvent e) {

				UsersWindow();
				
			}
		 });
		 
		 
		 mAlunos.add(smListarAluno);
		 mCidades.add(smListarCidade);
		 mUsuarios.add(smListarUsuario);
		 
	}
	
	public void CreateCitiesComponents() {
		
		//cities add
		btnCadastroCidade = new JButton(new AbstractAction("Cadastrar Cidade") {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				regCity.setVisible(true);
				
			}
			
		});
		btnCadastroCidade.setBounds(30, 20, 140, 30);    	
		getContentPane().add(btnCadastroCidade);
		
		
		//cities edit
    	btnEditarCidade = new JButton(new AbstractAction("Editar Cidade") {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("futuramente uma edi��o");
				
			}
			
		});
    	btnEditarCidade.setBounds(230, 20, 140, 30);    	
    	getContentPane().add(btnEditarCidade);
    	
    	
		//cities delete
    	btnDeletarCidade = new JButton(new AbstractAction("Deletar Cidade") {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("futuramente uma exclus�o");
				
			}
			
		});
    	btnDeletarCidade.setBounds(430, 20, 140, 30); 	
    	getContentPane().add(btnDeletarCidade);
		
    	//hide button after initializing
		btnCadastroCidade.setVisible(false);
    	btnEditarCidade.setVisible(false);
    	btnDeletarCidade.setVisible(false);
    	
    	regCity = new JPanel();
		regCity.setLayout(null);
		regCity.setBounds(200, 80, 210, 280);
		regCity.setBorder(BorderFactory.createTitledBorder("Nova Cidade"));
		getContentPane().add(regCity);
		regCity.setVisible(false);
		
    	lbCity = new JLabel();
    	lbCity.setText("Cidade:");
    	lbCity.setBounds(40, 40, 125, 20);
    	regCity.add(lbCity);
    	
    	txfCity = new JTextField();
    	txfCity.setBounds(40, 60, 125, 20);
    	regCity.add(txfCity);
    	
    	lbState = new JLabel();
    	lbState.setText("Estado:");
    	lbState.setBounds(40, 100, 125, 20);
    	regCity.add(lbState);
    	
    	txfState = new JTextField();
    	txfState.setBounds(40, 120, 125, 20);
    	regCity.add(txfState);
    	
    	lbCountry = new JLabel();
    	lbCountry.setText("Pais:");
    	lbCountry.setBounds(40, 160, 125, 20);
    	regCity.add(lbCountry);
    	
    	txfCountry = new JTextField();
    	txfCountry.setBounds(40, 180, 125, 20);
    	regCity.add(txfCountry);
    	
    	btnregCityister = new JButton(new AbstractAction("Cadastrar") {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		btnregCityister.setBounds(40, 230, 125, 20);   	
    	regCity.add(btnregCityister);
    	
    	getContentPane().add(regCity);
    	
	}
	
	public void CreateStudentsComponents() {
		
		//students add
		btnCadastroAluno = new JButton(new AbstractAction("Cadastrar Aluno") {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("futuramente um cadastro");
				
			}
			
		});
		btnCadastroAluno.setBounds(30, 20, 140, 30);    	
		getContentPane().add(btnCadastroAluno);
		
		
		//students edit
    	btnEditarAluno = new JButton(new AbstractAction("Editar Aluno") {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("futuramente uma edi��o");
				
			}
			
		});
    	btnEditarAluno.setBounds(230, 20, 140, 30);    	
    	getContentPane().add(btnEditarAluno);
    	
    	
		//students delete
    	btnDeletarAluno = new JButton(new AbstractAction("Deletar Aluno") {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("futuramente uma exclus�o");
				
			}
			
		});
    	btnDeletarAluno.setBounds(430, 20, 140, 30); 	
    	getContentPane().add(btnDeletarAluno);
		
		btnCadastroAluno.setVisible(false);
		btnEditarAluno.setVisible(false);
    	btnDeletarAluno.setVisible(false);
		
    	
	}
	
	public void CreateUsersComponents() {
		
		//user add
		btnCadastroUsuario = new JButton(new AbstractAction("Cadastrar Usuario") {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("futuramente um cadastro");
				
			}
			
		});
		btnCadastroUsuario.setBounds(30, 20, 140, 30);    	
		getContentPane().add(btnCadastroUsuario);
		
		
		//user edit
    	btnEditarUsuario = new JButton(new AbstractAction("Editar Usuario") {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("futuramente uma edi��o");
				
			}
			
		});
    	btnEditarUsuario.setBounds(230, 20, 140, 30);    	
    	getContentPane().add(btnEditarUsuario);
    	
    	
		//user delete
    	btnDeletarUsuario = new JButton(new AbstractAction("Deletar Usuario") {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("futuramente uma exclus�o");
				
			}
			
		});
    	btnDeletarUsuario.setBounds(430, 20, 140, 30); 	
    	getContentPane().add(btnDeletarUsuario);
		
    	btnCadastroUsuario.setVisible(false);
    	btnEditarUsuario.setVisible(false);
    	btnDeletarUsuario.setVisible(false);
		
	}

	public void CitiesWindow() {
		
		btnCadastroUsuario.setVisible(false);
		btnCadastroAluno.setVisible(false);
		btnCadastroCidade.setVisible(true);
		
		btnEditarUsuario.setVisible(false);
		btnEditarAluno.setVisible(false);
		btnEditarCidade.setVisible(true);
		
		btnDeletarUsuario.setVisible(false);
		btnDeletarAluno.setVisible(false);
		btnDeletarCidade.setVisible(true);
		
	}

	public void StudentsWindow() {

		btnCadastroUsuario.setVisible(false);
		btnCadastroCidade.setVisible(false);
		btnCadastroAluno.setVisible(true);
		
		btnEditarUsuario.setVisible(false);
		btnEditarCidade.setVisible(false);
		btnEditarAluno.setVisible(true);
		
		btnDeletarUsuario.setVisible(false);
		btnDeletarCidade.setVisible(false);
		btnDeletarAluno.setVisible(true);
		
	}
	
	public void UsersWindow() {
		
		btnCadastroCidade.setVisible(false);
		btnCadastroAluno.setVisible(false);
		btnCadastroUsuario.setVisible(true);
		
		btnEditarCidade.setVisible(false);
		btnEditarAluno.setVisible(false);
		btnEditarUsuario.setVisible(true);
		
		btnDeletarCidade.setVisible(false);
		btnDeletarAluno.setVisible(false);
		btnDeletarUsuario.setVisible(true);
		
	}
	
	public void CreateColuna (String coluna, int tamcoluna) {
        modelo.addColumn(coluna);
        table.getColumnModel().getColumn(1).setPreferredWidth(tamcoluna);
		cont++;
	}

	
	public static void main(String[] args) {
		
		new MainWindow(null).setVisible(true);
		
	}

}