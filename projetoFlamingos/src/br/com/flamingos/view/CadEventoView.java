package br.com.flamingos.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import br.com.flamingos.controller.ConnectionDB;

@SuppressWarnings("serial")
public class CadEventoView extends JDialog {
	private JTabbedPane tabbedPane;
	private JPanel panel_produtos;
	private JPanel panel_eventos;
	private JLabel lbl_cadastroEventos;
	private JScrollPane scrollPane;
	private JTable tbl_eventos;
	private JTextField txtf_salvarEvento;
	private JButton btn_salvarEvento;
	private JButton btn_excluirEvento;
	private JLabel lbl_dicaCad;
	private JLabel lbl_dicaExcl;
	private JLabel lbl_dicaEdit;

	public static void main(String[] args) {
		CadEventoView dialog = new CadEventoView();
		dialog.setVisible(true);
	}

	public CadEventoView() {
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
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 562);
		setLocationRelativeTo(null);
		setModal(true);

		getContentPane().setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1350, 729);
		getContentPane().add(tabbedPane);

		panel_produtos = new JPanel();
		tabbedPane.addTab("Produtos", null, panel_produtos, null);
		panel_produtos.setLayout(null);

		panel_eventos = new JPanel();
		panel_eventos.setName("");
		tabbedPane.addTab("Eventos", null, panel_eventos, null);

		lbl_cadastroEventos = new JLabel("Cadastro de Eventos");
		lbl_cadastroEventos.setBounds(291, 11, 307, 31);
		lbl_cadastroEventos.setFont(new Font("Tahoma", Font.BOLD, 30));

		scrollPane = new JScrollPane();
		scrollPane.setBounds(173, 62, 552, 300);

		createTable();

		txtf_salvarEvento = new JTextField();
		txtf_salvarEvento.setBounds(173, 373, 403, 30);
		txtf_salvarEvento.setColumns(10);

		btn_salvarEvento = new JButton("Salvar Evento");
		btn_salvarEvento.setBounds(614, 373, 111, 30);
		btn_salvarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_salvarEventoActionPerformed(e);

			}
		});
		getRootPane().setDefaultButton(btn_salvarEvento);

		btn_excluirEvento = new JButton("Excluir Evento");
		btn_excluirEvento.setBounds(614, 414, 111, 30);
		btn_excluirEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_excluirEventoActionPerformed(e);
			}
		});
		panel_eventos.setLayout(null);
		panel_eventos.add(lbl_cadastroEventos);
		panel_eventos.add(scrollPane);
		panel_eventos.add(txtf_salvarEvento);
		panel_eventos.add(btn_salvarEvento);
		panel_eventos.add(btn_excluirEvento);

		lbl_dicaCad = new JLabel("- Para incluir um evento, preencha a caixa acima e clique em \"Salvar Evento\"");
		lbl_dicaCad.setForeground(Color.RED);
		lbl_dicaCad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_dicaCad.setBounds(173, 414, 403, 14);
		panel_eventos.add(lbl_dicaCad);

		lbl_dicaExcl = new JLabel("- Para excluir, selecione um evento na tabela acima e clique em \"Excluir Evento\"");
		lbl_dicaExcl.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_dicaExcl.setForeground(Color.RED);
		lbl_dicaExcl.setBounds(173, 430, 403, 14);
		panel_eventos.add(lbl_dicaExcl);

		lbl_dicaEdit = new JLabel("- Para editar, exclua o evento e cadastre novamente");
		lbl_dicaEdit.setForeground(Color.RED);
		lbl_dicaEdit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_dicaEdit.setBounds(173, 446, 403, 14);
		panel_eventos.add(lbl_dicaEdit);
	}

	private void atualizaTabela() {
		try {
			Connection connection = new ConnectionDB().createConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT nome FROM eventos");
			ResultSet rs = stmt.executeQuery();

			DefaultTableModel model = (DefaultTableModel) tbl_eventos.getModel();
			model.setNumRows(0);
			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("nome") });
			}

			rs.close();
			stmt.close();
			connection.close();

		} catch (ClassNotFoundException e) {
			System.out.println("Driver - Erro de driver! - Tabela");
		} catch (SQLException e) {
			System.out.println("SQL - Erro de SQL! - Tabela");
		}
	}

	private void createTable() {
		tbl_eventos = new JTable();
		DefaultTableCellRenderer Renderer = new DefaultTableCellRenderer();
		Renderer.setHorizontalAlignment(SwingConstants.LEFT);
		tbl_eventos.setDefaultRenderer(Integer.class, Renderer);
		tbl_eventos.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Descri\u00E7\u00E3o do Evento" }) {
			Class[] columnTypes = new Class[] { String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tbl_eventos.getColumnModel().getColumn(0).setPreferredWidth(115);
		DefaultTableModel modelo = (DefaultTableModel) tbl_eventos.getModel();
		tbl_eventos.setRowSorter(new TableRowSorter<DefaultTableModel>(modelo));
		scrollPane.setViewportView(tbl_eventos);

		atualizaTabela();
	}

	private void btn_salvarEventoActionPerformed(ActionEvent e) {
		if (isAccentuated(txtf_salvarEvento.getText())) {
			JOptionPane.showMessageDialog(null, "Palavra acentuada", "Erro", JOptionPane.ERROR_MESSAGE);
		} else if (isExistingInTable(txtf_salvarEvento.getText())) {
			JOptionPane.showMessageDialog(null, "Evento ja existente", "Erro", JOptionPane.ERROR_MESSAGE);
		} else if (txtf_salvarEvento.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Nome inválido", "Erro", JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				Connection connection = new ConnectionDB().createConnection();
				PreparedStatement stmt = connection.prepareStatement("INSERT INTO eventos (nome) VALUES (?)");
				stmt.setString(1, txtf_salvarEvento.getText());
				stmt.executeUpdate();

				stmt.close();
				connection.close();
			} catch (ClassNotFoundException ex) {
				System.out.println("Driver - Erro de driver! - Botão Salvar");
			} catch (SQLException ex) {
				System.out.println("SQL - Erro de SQL! - Botão Salvar");
			}

			atualizaTabela();

		}
	}

	private void btn_excluirEventoActionPerformed(ActionEvent e) {
		System.out.println((String) tbl_eventos.getModel().getValueAt(tbl_eventos.getSelectedRow(), 0));
		try {
			Connection connection = new ConnectionDB().createConnection();
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM eventos WHERE nome = ?");
			stmt.setString(1, (String) tbl_eventos.getModel().getValueAt(tbl_eventos.getSelectedRow(), 0));
			stmt.executeUpdate();

			stmt.close();
			connection.close();
		} catch (ClassNotFoundException ex) {
			System.out.println("Driver - Erro de driver! - Botão Excluir");
		} catch (SQLException ex) {
			System.out.println("SQL - Erro de SQL! - Botão Excluir");
		}

		atualizaTabela();
	}

	private boolean isExistingInTable(String s) {
		boolean value = false;
		try {
			Connection connection = new ConnectionDB().createConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT nome FROM eventos");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String string = rs.getString("nome");
				if (string.equalsIgnoreCase(s)) {
					value = true;
				}
			}

			rs.close();
			stmt.close();
			connection.close();

		} catch (ClassNotFoundException e) {
			System.out.println("Driver - Erro de driver! - isExistingInTable");
		} catch (SQLException e) {
			System.out.println("SQL - Erro de SQL! - isExistingInTable");
		}
		return value;
	}

	private boolean isAccentuated(String s) {
		for (int i = 0; i < s.length(); i++) {
			int chari = (int) s.charAt(i);
			if (chari < 32 || chari > 126) {
				return true;
			}
		}
		return false;
	}
}
