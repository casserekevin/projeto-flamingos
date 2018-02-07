package br.com.flamingos.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class JCadFestaView extends JDialog {

	// ------------------------------------------------------>CONTENT_PANEL
	private JPanel panel_sup;
	// --------------------------------------------------->PANEL_SUP
	private JLabel lbl_cadFesta;

	private JPanel panel_middle;
	// --------------------------------------------------->PANEL_MIDDLE
	private JPanel panel_m_left;
	// --------------------------------------------->PANEL M_LEFT
	private JPanel panel_m_l_sup;
	// --------------------------------------->PANEL M_L_SUP
	private JLabel lbl_valor;
	private JLabel lbl_n_convidados;
	private JLabel lbl_data;
	private JLabel lbl_hora;

	private JTextField txtf_valor;
	private JTextField txtf_n_convidados;
	private JTextField txtf_data;
	private JTextField txtf_hora;

	private JPanel panel_m_l_inf;
	// --------------------------------------->PANEL M_L_INF
	private JLabel lbl_desc;

	private JTextField txtf_desc;

	private JPanel panel_m_right;
	// --------------------------------------------->PANEL M_RIGHT
	private JPanel panel_m_r_sup;
	// --------------------------------------->PANEL M_R_SUP
	JLabel lbl_decoracao;
	JLabel lbl_buffet;
	JLabel lbl_seguranca;

	JComboBox cb_decoracao;
	JComboBox cb_buffet;
	JComboBox cb_seguranca;

	private JPanel panel_m_r_inf;
	// --------------------------------------->PANEL M_R_INF
	private JLabel lbl_tipo_festa;

	private JComboBox cb_tipo_festa;

	private JPanel panel_m_button;
	// --------------------------------------------->PANEL M_BUTTON
	private JButton btn_cadastrar;
	private JButton btn_limpar;

	private JPanel panel_inf;
	// --------------------------------------------------->PANEL_INF

	public JCadFestaView(boolean modal) {

		// ----------------------------------------------------------->JANELA_PRINCIPAL
		// Configurações da Janela Principal
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setTitle("Cadastro de Festa ");
		setBounds(100, 100, 675, 650);
		setModal(modal);

		// ----------------------------------------------------------->CONTENT_PANEL
		// Configuracoes PANEL_SUP
		panel_sup = new JPanel();
		panel_sup.setBackground(Color.DARK_GRAY);

		// Configuracoes PANEL_MIDDLE
		panel_middle = new JPanel();
		panel_middle.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados da Festa", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));

		// Configuracoes PANEL_INF
		panel_inf = new JPanel();
		panel_inf.setBackground(Color.DARK_GRAY);

		// Configuração de Layout CONTENT_PANEL
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_inf, GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_sup, GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_middle, GroupLayout.PREFERRED_SIZE, 636, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_sup, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_middle, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_inf, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
		);
		getContentPane().setLayout(groupLayout);

		// ------------------------------------------------------------->PANEL_SUP
		// Configuracao LBL_CADFESTA
		lbl_cadFesta = new JLabel("Cadastro de Festa");
		lbl_cadFesta.setForeground(new Color(255, 215, 0));
		lbl_cadFesta.setFont(new Font("Trebuchet MS", Font.BOLD, 36));

		// Configuração de Layout PANEL_SUP
		GroupLayout gl_panel_sup = new GroupLayout(panel_sup);
		gl_panel_sup.setHorizontalGroup(
			gl_panel_sup.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_sup.createSequentialGroup()
					.addGap(168)
					.addComponent(lbl_cadFesta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(193))
		);
		gl_panel_sup.setVerticalGroup(
			gl_panel_sup.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_sup.createSequentialGroup()
					.addGap(31)
					.addComponent(lbl_cadFesta)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		panel_sup.setLayout(gl_panel_sup);

		// ----------------------------------------------------------->PANEL_MIDDLE
		// Configuracoes PANEL_M_RIGHT
		panel_m_right = new JPanel();

		// Configuracoes PANEL_M_LEFT
		panel_m_left = new JPanel();

		// Configuracoes PANEL_M_BUTTON
		panel_m_button = new JPanel();

		// Configurações do Layout PANEL_MIDDLE
		GroupLayout gl_panel_middle = new GroupLayout(panel_middle);
		gl_panel_middle.setHorizontalGroup(
			gl_panel_middle.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_middle.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_middle.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_m_button, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panel_middle.createSequentialGroup()
							.addComponent(panel_m_left, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_m_right, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_middle.setVerticalGroup(
			gl_panel_middle.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_middle.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel_middle.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_m_right, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
						.addComponent(panel_m_left, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_m_button, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_middle.setLayout(gl_panel_middle);

		// ------------------------------------------------------------->PANEL_M_LEFT
		// Configuracoes PANEL_M_L_SUP
		panel_m_l_sup = new JPanel();

		// Configuracoes PANEL_M_L_INF
		panel_m_l_inf = new JPanel();

		// Configurações do Layout PANEL_M_LEFT
		GroupLayout gl_panel_m_left = new GroupLayout(panel_m_left);
		gl_panel_m_left.setHorizontalGroup(gl_panel_m_left.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel_m_left.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_m_left.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_m_l_sup, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE).addComponent(panel_m_l_inf,
										Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
						.addContainerGap()));
		gl_panel_m_left.setVerticalGroup(gl_panel_m_left.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_m_left.createSequentialGroup().addContainerGap().addComponent(panel_m_l_sup, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(panel_m_l_inf, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		panel_m_left.setLayout(gl_panel_m_left);

		// ------------------------------------------------------------->PANEL_M_L_SUP
		// Configuracoes LBL_VALOR
		lbl_valor = new JLabel("Valor total:");

		// Configuracoes TXTF_VALOR
		txtf_valor = new JTextField();
		txtf_valor.setColumns(10);

		// Configuracoes LBL_N_CONVIDADOS
		lbl_n_convidados = new JLabel("N\u00BA de convidados:");

		// Configuracoes TXTF_N_CONVIDADOS
		txtf_n_convidados = new JTextField();
		txtf_n_convidados.setColumns(10);

		// Configuracoes LBL_DATA
		lbl_data = new JLabel("Data:");

		// Configuracoes TXTF_DATA
		txtf_data = new JTextField();
		txtf_data.setColumns(10);

		// Configuracoes LBL_HORA
		lbl_hora = new JLabel("Hora:");

		// Configuracoes TXTF_HORA
		txtf_hora = new JTextField();
		txtf_hora.setColumns(10);

		// Configurações do Layout PANEL_M_L_SUP
		GroupLayout gl_panel_m_l_sup = new GroupLayout(panel_m_l_sup);
		gl_panel_m_l_sup.setHorizontalGroup(gl_panel_m_l_sup.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_m_l_sup.createSequentialGroup().addGap(40)
						.addGroup(gl_panel_m_l_sup.createParallelGroup(Alignment.TRAILING).addComponent(lbl_valor).addComponent(lbl_data))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_m_l_sup.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtf_valor, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE).addComponent(txtf_data,
										GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
						.addGap(18).addGroup(gl_panel_m_l_sup.createParallelGroup(Alignment.TRAILING).addComponent(lbl_n_convidados).addComponent(lbl_hora))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_m_l_sup.createParallelGroup(Alignment.LEADING)
								.addComponent(txtf_n_convidados, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtf_hora, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(37, Short.MAX_VALUE)));
		gl_panel_m_l_sup
				.setVerticalGroup(
						gl_panel_m_l_sup.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_m_l_sup.createSequentialGroup().addGap(22)
										.addGroup(gl_panel_m_l_sup.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_m_l_sup.createSequentialGroup()
												.addGroup(gl_panel_m_l_sup.createParallelGroup(Alignment.BASELINE).addComponent(lbl_n_convidados).addComponent(
														txtf_n_convidados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGap(53)
												.addGroup(gl_panel_m_l_sup.createParallelGroup(Alignment.BASELINE)
														.addComponent(txtf_hora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lbl_hora)))
												.addGroup(gl_panel_m_l_sup.createSequentialGroup()
														.addGroup(gl_panel_m_l_sup.createParallelGroup(Alignment.LEADING)
																.addComponent(txtf_valor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(lbl_valor))
														.addGap(53)
														.addGroup(gl_panel_m_l_sup.createParallelGroup(Alignment.LEADING).addComponent(lbl_data).addComponent(
																txtf_data, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(24, Short.MAX_VALUE)));
		panel_m_l_sup.setLayout(gl_panel_m_l_sup);

		// ------------------------------------------------------------->PANEL_M_L_INF
		// Configuracoes LBL_DESC
		lbl_desc = new JLabel("Descri\u00E7\u00E3o:");

		// Configuracoes TXTF_DESC
		txtf_desc = new JTextField();
		txtf_desc.setColumns(10);

		// Configurações do Layout PANEL_M_L_INF
		GroupLayout gl_panel_m_l_inf = new GroupLayout(panel_m_l_inf);
		gl_panel_m_l_inf.setHorizontalGroup(gl_panel_m_l_inf.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_m_l_inf.createSequentialGroup().addContainerGap().addComponent(lbl_desc).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtf_desc, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE).addContainerGap(15, Short.MAX_VALUE)));
		gl_panel_m_l_inf.setVerticalGroup(gl_panel_m_l_inf.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_m_l_inf
						.createSequentialGroup().addGap(20).addGroup(gl_panel_m_l_inf.createParallelGroup(Alignment.BASELINE).addComponent(lbl_desc)
								.addComponent(txtf_desc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(27, Short.MAX_VALUE)));
		panel_m_l_inf.setLayout(gl_panel_m_l_inf);

		// ------------------------------------------------------------->PANEL_M_RIGHT
		// Configuracoes PANEL_M_R_SUP
		panel_m_r_sup = new JPanel();

		// configuracoes PANEL_M_R_INF
		panel_m_r_inf = new JPanel();

		// Configurações do Layout PANEL_M_RIGHT
		GroupLayout gl_panel_m_right = new GroupLayout(panel_m_right);
		gl_panel_m_right.setHorizontalGroup(
			gl_panel_m_right.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_m_right.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_panel_m_right.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_m_r_sup, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
						.addComponent(panel_m_r_inf, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_m_right.setVerticalGroup(
			gl_panel_m_right.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_m_right.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_m_r_sup, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
					.addComponent(panel_m_r_inf, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_m_right.setLayout(gl_panel_m_right);

		// ------------------------------------------------------------->PANEL_M_R_SUP
		// Configuracoes LBL_DECORACAO
		lbl_decoracao = new JLabel("Decora\u00E7\u00E3o:");

		// Configuracoes CB_DECORACAO
		cb_decoracao = new JComboBox();
		cb_decoracao.setModel(new DefaultComboBoxModel(new String[] { "N\u00E3o", "Sim" }));
		cb_decoracao.setSelectedIndex(0);

		// Configuracoes LBL_BUFFET
		lbl_buffet = new JLabel("Buffet:");

		// Configuracoes CB_BUFFET
		cb_buffet = new JComboBox();
		cb_buffet.setModel(new DefaultComboBoxModel(new String[] { "N\u00E3o", "Sim" }));
		cb_buffet.setSelectedIndex(0);

		// Configuracoes LBL_SEGURANCA
		lbl_seguranca = new JLabel("Seguran\u00E7a:");

		// Configuracoes CB_SEGURANCA
		cb_seguranca = new JComboBox();
		cb_seguranca.setModel(new DefaultComboBoxModel(new String[] { "N\u00E3o", "Sim" }));
		cb_seguranca.setSelectedIndex(0);
		
		JLabel lblDj = new JLabel("DJ:");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"N\u00E3o", "Sim"}));

		// Configurações do Layout PANEL_M_R_SUP
		GroupLayout gl_panel_m_r_sup = new GroupLayout(panel_m_r_sup);
		gl_panel_m_r_sup.setHorizontalGroup(
			gl_panel_m_r_sup.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_m_r_sup.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel_m_r_sup.createParallelGroup(Alignment.TRAILING)
						.addComponent(lbl_seguranca)
						.addComponent(lbl_buffet)
						.addComponent(lbl_decoracao)
						.addComponent(lblDj))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_m_r_sup.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_m_r_sup.createParallelGroup(Alignment.TRAILING)
							.addComponent(cb_decoracao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(cb_buffet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(cb_seguranca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(81, Short.MAX_VALUE))
		);
		gl_panel_m_r_sup.setVerticalGroup(
			gl_panel_m_r_sup.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_m_r_sup.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel_m_r_sup.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_decoracao)
						.addComponent(cb_decoracao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_m_r_sup.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_buffet)
						.addComponent(cb_buffet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_m_r_sup.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_seguranca)
						.addComponent(cb_seguranca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_m_r_sup.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDj)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		panel_m_r_sup.setLayout(gl_panel_m_r_sup);

		// ------------------------------------------------------------->PANEL_M_R_INF
		// Configuracoes LBL_TIPO_FESTA
		lbl_tipo_festa = new JLabel("Tipo de festa:");

		// Configuracoes CB_TIPO_FESTA
		cb_tipo_festa = new JComboBox();
		cb_tipo_festa.setModel(new DefaultComboBoxModel(new String[] { "Infantil", "15 Anos", "Casamento", "Formatura", "Ch\u00E1 de fralda", "Outros" }));

		// Configurações do Layout PANEL_M_R_INF
		GroupLayout gl_panel_m_r_inf = new GroupLayout(panel_m_r_inf);
		gl_panel_m_r_inf.setHorizontalGroup(gl_panel_m_r_inf.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_m_r_inf.createSequentialGroup().addContainerGap().addComponent(lbl_tipo_festa).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cb_tipo_festa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addContainerGap(36,
								Short.MAX_VALUE)));
		gl_panel_m_r_inf.setVerticalGroup(gl_panel_m_r_inf.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_m_r_inf
						.createSequentialGroup().addGap(19).addGroup(gl_panel_m_r_inf.createParallelGroup(Alignment.BASELINE).addComponent(lbl_tipo_festa)
								.addComponent(cb_tipo_festa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(27, Short.MAX_VALUE)));
		panel_m_r_inf.setLayout(gl_panel_m_r_inf);

		// ------------------------------------------------------------->PANEL_M_BUTTON
		// Configuracoes BTN_CADASTRAR
		btn_cadastrar = new JButton("Cadastrar");
		btn_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					Class.forName("com.mysql.jdbc.Driver");

					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/controle_festas", "root", "kevi1810");

					String query = "INSERT INTO festas (valor, nr_conv, decoracao, buffet, seguranca, data, hora, tipoFesta, descricao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

					PreparedStatement stmt = connection.prepareStatement(query);

					stmt.setString(1, txtf_valor.getText());
					stmt.setString(2, txtf_n_convidados.getText());
					stmt.setInt(3, cb_decoracao.getSelectedIndex());
					stmt.setInt(4, cb_buffet.getSelectedIndex());
					stmt.setInt(5, cb_seguranca.getSelectedIndex());
					stmt.setString(6, txtf_data.getText());
					stmt.setString(7, txtf_hora.getText());
					stmt.setString(8, (String) cb_tipo_festa.getSelectedItem());
					stmt.setString(9, txtf_desc.getText());

					stmt.executeUpdate();

					stmt.close();
					connection.close();

				} catch (ClassNotFoundException e1) {
					System.out.println("Cadastrar - Não foi possível encontrar a classe Driver");
				} catch (SQLException e2) {
					System.out.println("Cadastrar - Ocorreu erro de SQL");
				}
			}
		});

		// Configuracoes BTN_LIMPAR
		btn_limpar = new JButton("Limpar");

		// Configurações do Layout PANEL_M_BUTTON
		GroupLayout gl_panel_m_button = new GroupLayout(panel_m_button);
		gl_panel_m_button.setHorizontalGroup(gl_panel_m_button.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_m_button.createSequentialGroup()
				.addGap(160).addComponent(btn_limpar).addGap(18).addComponent(btn_cadastrar).addContainerGap(282, Short.MAX_VALUE)));
		gl_panel_m_button.setVerticalGroup(gl_panel_m_button.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_m_button.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_m_button.createParallelGroup(Alignment.BASELINE).addComponent(btn_cadastrar).addComponent(btn_limpar))
						.addContainerGap(29, Short.MAX_VALUE)));
		panel_m_button.setLayout(gl_panel_m_button);
	}
}
