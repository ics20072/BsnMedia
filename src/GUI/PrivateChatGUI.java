package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import entities.Conversation;
import entities.User;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;

public class PrivateChatGUI {

	private JFrame frame;
	private static User receiver;
	private static User sender;
	private static Conversation convo; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrivateChatGUI window = new PrivateChatGUI(receiver, sender, convo);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrivateChatGUI(User aReceiver, User aSender, Conversation aConvo) {
		receiver = aReceiver;
		sender = aSender;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 685, 840);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Go to User Profile");
		btnNewButton.setBounds(522, 14, 133, 25);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Your messages are encrypted");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(50, 17, 215, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Private Conversation with \" \"");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(12, 46, 593, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 84, 643, 652);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 13, 619, 493);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 519, 521, 120);
		panel.add(panel_2);
		
		Icon send = new ImageIcon("Buttons_backgrounds/email_send_32px.png");
		JButton btnNewButton_1_1_1 = new JButton(send);
		btnNewButton_1_1_1.setBounds(569, 601, 46, 38);
		panel.add(btnNewButton_1_1_1);
		
		Icon help = new ImageIcon("Buttons_backgrounds/customer_support_40px.png");
		JButton btnNewButton_1_1 = new JButton(help);
		btnNewButton_1_1.setBounds(609, 749, 46, 38);
		frame.getContentPane().add(btnNewButton_1_1);
	}
}
