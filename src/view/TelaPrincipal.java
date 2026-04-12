package view;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardlayout;
	private String panelAtual;
	JPanel panelTelas = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		this.cardlayout = new CardLayout();
		this.panelTelas.setLayout(cardlayout);
		this.setSize(1060,640);
		this.setLocationRelativeTo(null);
		
		contentPane.add(panelTelas, BorderLayout.CENTER);
		
	}
	
	public String getPanelAtual() {
		return panelAtual;
	}
	public void setPanelAtual(String panelAtual) {
		this.panelAtual = panelAtual;
	}
	
	public void adicionarTela(String nome, JPanel tela){
		this.panelTelas.add(tela, nome);
	}
	
	public void mostrarTela(String nome) {
		this.cardlayout.show(this.panelTelas, nome);
		this.panelAtual = nome;
		
	}
	
	

}
