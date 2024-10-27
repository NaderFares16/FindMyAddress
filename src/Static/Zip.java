package Static;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Cursor;
import javax.swing.ImageIcon;

public class Zip extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_1;
	private JLabel lblEndereo_1;
	private JTextField textField_3;
	private JTextField textField_2;
	private JLabel lblUf;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Zip frame = new Zip();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Zip() {
		setResizable(false);
		setTitle("Find My Address");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Zip.class.getResource("/ZIP/local.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CEP:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(32, 45, 45, 13);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 10));
		textField.setBounds(137, 42, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setFont(new Font("Arial", Font.BOLD, 14));
		lblEndereo.setBounds(32, 103, 73, 13);
		contentPane.add(lblEndereo);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 10));
		textField_1.setColumns(10);
		textField_1.setBounds(137, 100, 332, 19);
		contentPane.add(textField_1);
		
		lblNewLabel_1 = new JLabel("Bairro:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(32, 161, 58, 13);
		contentPane.add(lblNewLabel_1);
		
		lblEndereo_1 = new JLabel("Cidade:");
		lblEndereo_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblEndereo_1.setBounds(32, 219, 82, 13);
		contentPane.add(lblEndereo_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 10));
		textField_3.setColumns(10);
		textField_3.setBounds(137, 158, 332, 19);
		contentPane.add(textField_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 10));
		textField_2.setColumns(10);
		textField_2.setBounds(142, 216, 178, 19);
		contentPane.add(textField_2);
		
		lblUf = new JLabel("UF:");
		lblUf.setFont(new Font("Arial", Font.BOLD, 14));
		lblUf.setBounds(341, 219, 25, 13);
		contentPane.add(lblUf);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(376, 215, 73, 21);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(32, 277, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(260, 41, 85, 21);
		contentPane.add(btnBuscar);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setToolTipText("Sobre");
		btnNewButton_1.setActionCommand("");
		btnNewButton_1.setIcon(new ImageIcon(Zip.class.getResource("/ZIP/about.png")));
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(SystemColor.control);
		btnNewButton_1.setBounds(new Rectangle(0, 0, 32, 32));
		btnNewButton_1.setBounds(376, 35, 32, 32);
		contentPane.add(btnNewButton_1);
	}
}
