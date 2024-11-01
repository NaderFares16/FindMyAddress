package Static;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;

public class Zip extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCEP;
	private JTextField textAddress;
	private JLabel lblNewLabel_1;
	private JLabel lblEndereo_1;
	private JTextField textDistrict;
	private JTextField textCity;
	private JLabel lblUf;
	private JComboBox comboUF;
	private JLabel lblStatus;
	
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Zip.class.getResource("/ZIP/icon.png")));
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
		
		textCEP = new JTextField();
		textCEP.setFont(new Font("Arial", Font.PLAIN, 10));
		textCEP.setBounds(137, 42, 96, 19);
		contentPane.add(textCEP);
		textCEP.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setFont(new Font("Arial", Font.BOLD, 14));
		lblEndereo.setBounds(32, 103, 73, 13);
		contentPane.add(lblEndereo);
		
		textAddress = new JTextField();
		textAddress.setFont(new Font("Arial", Font.PLAIN, 10));
		textAddress.setColumns(10);
		textAddress.setBounds(137, 100, 332, 19);
		contentPane.add(textAddress);
		
		lblNewLabel_1 = new JLabel("Bairro:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(32, 161, 58, 13);
		contentPane.add(lblNewLabel_1);
		
		lblEndereo_1 = new JLabel("Cidade:");
		lblEndereo_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblEndereo_1.setBounds(32, 219, 82, 13);
		contentPane.add(lblEndereo_1);
		
		textDistrict = new JTextField();
		textDistrict.setFont(new Font("Arial", Font.PLAIN, 10));
		textDistrict.setColumns(10);
		textDistrict.setBounds(137, 158, 332, 19);
		contentPane.add(textDistrict);
		
		textCity = new JTextField();
		textCity.setFont(new Font("Arial", Font.PLAIN, 10));
		textCity.setColumns(10);
		textCity.setBounds(142, 216, 178, 19);
		contentPane.add(textCity);
		
		lblUf = new JLabel("UF:");
		lblUf.setFont(new Font("Arial", Font.BOLD, 14));
		lblUf.setBounds(341, 219, 25, 13);
		contentPane.add(lblUf);
		
		comboUF = new JComboBox();
		comboUF.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		comboUF.setBounds(376, 215, 73, 21);
		contentPane.add(comboUF);
		
		JButton btnClear = new JButton("Limpar");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				erase();
			}
		});
		btnClear.setBounds(32, 277, 85, 21);
		contentPane.add(btnClear);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textCEP.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o CEP");
					textCEP.requestFocus();
				} else {
					searchZIP();
				}
			}
		});
		btnBuscar.setBounds(316, 41, 85, 21);
		contentPane.add(btnBuscar);
		
		JButton btnAbout = new JButton("");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About about = new About();
				about.setVisible(true);
			}
		});
		btnAbout.setToolTipText("Sobre");
		btnAbout.setActionCommand("");
		btnAbout.setIcon(new ImageIcon(Zip.class.getResource("/ZIP/about.png")));
		btnAbout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAbout.setBorder(null);
		btnAbout.setBackground(SystemColor.control);
		btnAbout.setBounds(new Rectangle(0, 0, 32, 32));
		btnAbout.setBounds(432, 35, 32, 32);
		contentPane.add(btnAbout);
		
		// ATXY2K LIBRARY FOR TEXTFIELD VALIDATION
		
		RestrictedTextField validate = new RestrictedTextField(textCEP);
		validate.setOnlyNums(true);
		validate.setLimit(8);
		
	} // CONSTRUCTOR END
	
	private void searchZIP() {
		String street = "";
		String streetType = "";
		String result = null;
		String zip = textCEP.getText();
		
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + zip + "&formato=xml");
			SAXReader xml = new SAXReader();
			Document document = xml.read(url);
			Element root = document.getRootElement();
			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
		        Element element = it.next();
		        if (element.getQualifiedName().equals("cidade")) {
		        	textCity.setText(element.getText());
		        }
		        if (element.getQualifiedName().equals("bairro")) {
		        	textDistrict.setText(element.getText());
		        }
		        if (element.getQualifiedName().equals("uf")) {
		        	comboUF.setSelectedItem(element.getText());
		        }
		        if (element.getQualifiedName().equals("tipo_logradouro")) {
		        	streetType = element.getText();
		        }
		        if (element.getQualifiedName().equals("logradouro")) {
		        	street = element.getText();
		        }
		        if (element.getQualifiedName().equals("resultado")) {
		        	result = element.getText();
		        	if (result.equals("1")) {
		        		
		        	} else {
		        		JOptionPane.showMessageDialog(null, "CEP Não Encontrado");
		        	}
		        }
		    }
			
			// SET STREET
			
			textAddress.setText(streetType + " " + street);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	private void erase() {
		textCEP.setText(null);
		textAddress.setText(null);
		textDistrict.setText(null);
		textCity.setText(null);
		comboUF.setSelectedItem(null);
		textCEP.requestFocus();
	}
	
}
