package Static;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class About extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About dialog = new About();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public About() {
		setModal(true);
		setResizable(false);
		setTitle("About");
		setIconImage(Toolkit.getDefaultToolkit().getImage(About.class.getResource("/ZIP/icon.png")));
		setBounds(150, 150, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Find My Address - v0.1");
		lblNewLabel.setBounds(21, 42, 237, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("@Author: Nader Ali Fares");
		lblNewLabel_1.setBounds(21, 97, 155, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("API Service:");
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblNewLabel_3.setBounds(21, 152, 74, 13);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblAPIServices = new JLabel("republicavirtual.com.br");
		lblAPIServices.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				link("https://republicavirtual.com.br/");
			}
		});
		lblAPIServices.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAPIServices.setForeground(SystemColor.textHighlight);
		lblAPIServices.setBounds(96, 152, 149, 13);
		getContentPane().add(lblAPIServices);
		
		JButton btnGithub = new JButton("");
		btnGithub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://github.com/NaderFares16");
			}
		});
		btnGithub.setToolTipText("GitHub");
		btnGithub.setIcon(new ImageIcon(About.class.getResource("/ZIP/github.png")));
		btnGithub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGithub.setBorder(null);
		btnGithub.setBounds(21, 202, 32, 32);
		getContentPane().add(btnGithub);
		
		JButton btnLinked = new JButton("");
		btnLinked.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://www.linkedin.com/in/nader-ali-fares/");
			}
		});
		btnLinked.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLinked.setToolTipText("GitHub");
		btnLinked.setIcon(new ImageIcon(About.class.getResource("/ZIP/linkedin.png")));
		btnLinked.setBorder(null);
		btnLinked.setBounds(63, 202, 32, 32);
		getContentPane().add(btnLinked);
		

	} // CONSTRUCTOR END
	
	private void link(String website) {
		Desktop desktop = Desktop.getDesktop();
		try {
			URI uri = new URI(website);
			desktop.browse(uri);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
