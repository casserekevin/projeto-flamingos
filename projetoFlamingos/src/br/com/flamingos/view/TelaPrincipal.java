package br.com.flamingos.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	private JMenuBar menuBar;

	private JMenu mnConfigurao;
	private JMenu mnCadastro;
	private JMenuItem mntmCliente;
	private JMenuItem mntmEventos;
	private JMenuItem mntmPacotes;
	private JMenu mnMovimento;
	private JMenu mnRelatrios;
	private JMenu mnUtilitrios;
	private JMenu mnAjuda;
	private JMenu mnSair;

	public TelaPrincipal() {
		initLeF();
		initComponents();

	}

	private void initLeF() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		setLocationRelativeTo(null);

		getContentPane().setLayout(null);

		initMenu();
	}

	private void initMenu() {
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnConfigurao = new JMenu("Configura\u00E7\u00E3o");
		menuBar.add(mnConfigurao);

		mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);

		mntmCliente = new JMenuItem("Cliente");
		mnCadastro.add(mntmCliente);

		mntmEventos = new JMenuItem("Eventos");
		mntmEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmEventosActionPerformed(e);
			}

		});
		mnCadastro.add(mntmEventos);

		mntmPacotes = new JMenuItem("Pacotes");
		mnCadastro.add(mntmPacotes);

		mnMovimento = new JMenu("Movimento");
		menuBar.add(mnMovimento);

		mnRelatrios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatrios);

		mnUtilitrios = new JMenu("Utilit\u00E1rios");
		menuBar.add(mnUtilitrios);

		mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);

		mnSair = new JMenu("Sair");
		menuBar.add(mnSair);
	}

	private void mntmEventosActionPerformed(ActionEvent e) {
		CadEventoView janela = new CadEventoView();
		janela.setVisible(true);
	}
}
