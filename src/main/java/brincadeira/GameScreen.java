package brincadeira;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;

public class GameScreen extends JFrame{
	
	LinkedHashMap<Integer, LinkedHashMap<String,String>> perguntas;
	int contador = 1;
	JButton nextButton;
	JTextAreaID txtrOla;
	JLabel imagem;
	ButtonGroup group ;
	 JLabel lblNewLabel_3;
	
	public GameScreen(LinkedHashMap<Integer, LinkedHashMap<String,String>> perguntas) {
		
		this.perguntas = perguntas;
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

				System.exit(0);
			}

		});
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		setResizable(false);
		setSize(new Dimension(1024, 671));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		
		imagem = new JLabel();
		imagem.setBounds(606, 124, 324, 320);
		imagem.setVerticalAlignment(SwingConstants.TOP);
		imagem.setHorizontalAlignment(SwingConstants.CENTER);
		imagem.setIcon(null);
		
		JLabel lblNewLabel = new JLabel("Conhecendo a Fam\u00EDlia");
		lblNewLabel.setBounds(33, 11, 529, 95);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 44));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		nextButton = new JButton("Proxima");
		nextButton.setBounds(802, 556, 169, 35);
		nextButton.setFont(new Font("Arial", Font.PLAIN, 22));
		nextButton.setEnabled(false);
		nextButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				nextQuestion();
				
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Quem sou eu?...");
		lblNewLabel_1.setBounds(679, 70, 219, 36);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 30));
		
		txtrOla = new JTextAreaID();
		txtrOla.setBounds(43, 124, 553, 190);
		txtrOla.setEnabled(false);
		txtrOla.setEditable(false);
		
		JLabel lblNewLabel_2 = new JLabel("Escolha abaixo:");
		lblNewLabel_2.setBounds(43, 332, 169, 28);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 24));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Anaile");
		rdbtnNewRadioButton.setBounds(43, 378, 85, 35);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		rdbtnNewRadioButton.setActionCommand("Anaile");
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Thais");
		rdbtnNewRadioButton_1.setBounds(43, 416, 77, 35);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		rdbtnNewRadioButton_1.setActionCommand("Thais");
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Fabiana");
		rdbtnNewRadioButton_2.setBounds(43, 454, 101, 35);
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		rdbtnNewRadioButton_2.setActionCommand("Fabiana");
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Livia");
		rdbtnNewRadioButton_3.setBounds(43, 492, 69, 35);
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		rdbtnNewRadioButton_3.setActionCommand("Livia");
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Valeria");
		rdbtnNewRadioButton_4.setBounds(43, 527, 93, 35);
		rdbtnNewRadioButton_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		rdbtnNewRadioButton_4.setActionCommand("Valeria");
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Marco");
		rdbtnNewRadioButton_5.setBounds(43, 565, 85, 35);
		rdbtnNewRadioButton_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		rdbtnNewRadioButton_5.setActionCommand("Marco");
		
		JButton btnNewButton = new JButton("Responder");
		btnNewButton.setBounds(305, 556, 190, 35);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 22));
		txtrOla.setFont(new Font("Arial", Font.ITALIC, 30));
		txtrOla.setForeground(Color.BLACK);
		txtrOla.setWrapStyleWord(true);
		txtrOla.setLineWrap(true);
		
		group = new ButtonGroup();
	    group.add(rdbtnNewRadioButton);
	    group.add(rdbtnNewRadioButton_1);
	    group.add(rdbtnNewRadioButton_2);
	    group.add(rdbtnNewRadioButton_3);
	    group.add(rdbtnNewRadioButton_4);
	    group.add(rdbtnNewRadioButton_5);
	    getContentPane().setLayout(null);
	    getContentPane().add(nextButton);
	    getContentPane().add(txtrOla);
	    getContentPane().add(lblNewLabel_2);
	    getContentPane().add(rdbtnNewRadioButton);
	    getContentPane().add(rdbtnNewRadioButton_1);
	    getContentPane().add(rdbtnNewRadioButton_2);
	    getContentPane().add(rdbtnNewRadioButton_3);
	    getContentPane().add(rdbtnNewRadioButton_4);
	    getContentPane().add(rdbtnNewRadioButton_5);
	    getContentPane().add(btnNewButton);
	    getContentPane().add(imagem);
	    getContentPane().add(lblNewLabel);
	    getContentPane().add(lblNewLabel_1);
	    
	     lblNewLabel_3 = new JLabel("");
	    lblNewLabel_3.setBounds(868, 11, 46, 14);
	    getContentPane().add(lblNewLabel_3);
	    
	    btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String nome = group.getSelection().getActionCommand();
				
				if(nome.equals(txtrOla.getNome())) {
					
					SwingWorker<Void, Void> executeProcess = new SwingWorker<Void, Void>() {
						@Override
			            protected Void doInBackground() 
			            {								
							
							imagem.setIcon(getImageIcon(txtrOla.getNome() + ".png", 300, 300));
						
							
							return null; 
			                
			            } 
			  
			            
			  
			            @Override
			            protected void done()  
			            { 
			            	
			            	nextButton.setEnabled(true);

			            } 
					};
					
					executeProcess.execute();
					
				}else {
					JLabel label = new JLabel("Errou!");
					label.setFont(new Font("Arial", Font.PLAIN, 28));
					JOptionPane.showMessageDialog(null,label);
				}
				
			}

			
		});
	    
	    nextQuestion();
		
	}

	private void nextQuestion() {
		
		SwingWorker<Void, Void> executeProcess = new SwingWorker<Void, Void>() {
			@Override
            protected Void doInBackground() 
            {								
				
				
				
				LinkedHashMap<String, String>pergunta = perguntas.get(contador);
				
				for (Map.Entry<String, String> entry : pergunta.entrySet()) {
					
					
					txtrOla.setText(entry.getValue(), entry.getKey());
					
				
				}
				
				 lblNewLabel_3.setText(String.valueOf(contador));
				
				contador++;
				return null; 
                
            } 
  
            
  
            @Override
            protected void done()  
            { 
            	imagem.setIcon(null);
            	nextButton.setEnabled(false);
            	group.clearSelection();

            } 
		};
		
		executeProcess.execute();

		
		
		
	}
	
	public static Image getImage(String resourcePath) {
		return Toolkit.getDefaultToolkit().getImage(GameScreen.class.getResource("/" + resourcePath));
	}
	
	public static ImageIcon getImageIcon(String resourcePath) {
		return new ImageIcon(getImage(resourcePath));
	}
	
	public static ImageIcon getImageIcon(String resourcePath, int width, int height) {
		return new ImageIcon(getImage(resourcePath).getScaledInstance(width, height, Image.SCALE_SMOOTH));
	}
}
