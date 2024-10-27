package Static;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.ImageIcon;

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
		setResizable(false);
		setTitle("About");
		setIconImage(Toolkit.getDefaultToolkit().getImage(About.class.getResource("/ZIP/local.png")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Find My Address - v0.1");
		lblNewLabel.setBounds(21, 42, 237, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("@Author: Nader Ali Fares");
		lblNewLabel_1.setBounds(21, 97, 155, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("API Service:");
		lblNewLabel_2.setBounds(21, 152, 182, 13);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("republicavirtual.com.br");
		lblNewLabel_3.setForeground(SystemColor.textHighlight);
		lblNewLabel_3.setBounds(96, 152, 107, 13);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("GitHub");
		btnNewButton.setIcon(new ImageIcon(About.class.getResource("/ZIP/github.png")));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(21, 202, 32, 32);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setToolTipText("GitHub");
		btnNewButton_1.setIcon(new ImageIcon(About.class.getResource("/ZIP/linkedin.png")));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBounds(63, 202, 32, 32);
		getContentPane().add(btnNewButton_1);

	}

}
