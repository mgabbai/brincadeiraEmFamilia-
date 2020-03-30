package brincadeira;

import javax.swing.JTextArea;

public class JTextAreaID extends JTextArea{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5070413007245393862L;
	
	private String nome = "";

	public JTextAreaID () {
		super();
	}
	

	public void setText(String t, String nome) {
		super.setText(t);
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
}
