package brincadeira;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class InformationScreen extends JDialog{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	public InformationScreen() {
		super((Window)null);
		setModal(true);
		
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quantidade de pessoas");
		lblNewLabel.setBounds(24, 24, 251, 20);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(24, 55, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Quantidade de perguntas");
		lblNewLabel_1.setBounds(24, 86, 251, 20);
		getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(24, 117, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Caminho planilha de perguntas");
		lblNewLabel_2.setBounds(24, 158, 367, 20);
		getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(24, 193, 391, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(326, 85, 89, 23);
		getContentPane().add(btnNewButton);
		setLocationRelativeTo(null);
		setResizable(false);
		setSize(new Dimension(450, 300));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				App.qtdePessoas = Integer.valueOf(textField.getText());
				App.qtdePerguntas = Integer.valueOf(textField_1.getText());
				App.caminhoPlanilha = textField_2.getText();
				
				dispose();
				
			}
		});
	
	}
}
