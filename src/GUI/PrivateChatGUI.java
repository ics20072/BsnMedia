package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import entities.Conversation;
import entities.Message;
import entities.Post;
import entities.Storage;
import entities.User;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class PrivateChatGUI {

	private JFrame frame;
	private static User receiver;
	private static User sender;
	private static Conversation convo;

	

	/**
	 * Create the application.
	 */
	public PrivateChatGUI(User aReceiver, User aSender, Conversation aConvo) {
		receiver = aReceiver;
		sender = aSender;
		convo = aConvo;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 250, 240));
		frame.setBounds(100, 100, 686, 795);
		frame.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		ImageIcon logoimage = new ImageIcon("label_backgrounds/bsn_32px.jpg");
		frame.setIconImage(logoimage.getImage());
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel informationLabel = new JLabel("Your messages are encrypted");
		informationLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		informationLabel.setBounds(70, 23, 215, 20);
		frame.getContentPane().add(informationLabel);
		
		JLabel chatWithLabel = new JLabel("Private Conversation with "+receiver.getFirstName());
		chatWithLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chatWithLabel.setBounds(12, 56, 593, 25);
		frame.getContentPane().add(chatWithLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(60, 179, 113));
		panel.setBounds(12, 84, 643, 652);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 13, 619, 493);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea allMessagesTextArea = new JTextArea();
		allMessagesTextArea.setEditable(false);
		allMessagesTextArea.setLineWrap(true);
		allMessagesTextArea.setWrapStyleWord(true);
		allMessagesTextArea.setText("");
		
		ArrayList<String> ourMessages = new ArrayList<>();
		ourMessages= Storage.retrieveConversation(convo);
		for(int i=0;i<ourMessages.size();i++)
		{
			allMessagesTextArea.append(ourMessages.get(i)+ "\n\r");
		}
		allMessagesTextArea.setBackground(Color.WHITE);
		allMessagesTextArea.setBounds(0, 0, 619, 493);
		panel_1.add(allMessagesTextArea);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 519, 521, 120);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JTextArea newMessageTextArea = new JTextArea();
		newMessageTextArea.setLineWrap(true);
		newMessageTextArea.setWrapStyleWord(true);
		newMessageTextArea.setBounds(0, 0, 521, 120);
		panel_2.add(newMessageTextArea);
		
		Icon send = new ImageIcon("Buttons_backgrounds/email_send_60px.png");
		JButton sendMessageButton = new JButton(send);
		sendMessageButton.setContentAreaFilled(false); 
		sendMessageButton.setFocusPainted(false); 
		sendMessageButton.setOpaque(false);
		sendMessageButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sendMessageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String myText = newMessageTextArea.getText();
				Message myMessage = new Message(myText,sender);
				convo.addMessage(myMessage);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		        String formatDateTime = myMessage.getTimesent().format(formatter);
				allMessagesTextArea.append(myMessage.getContent()+" | Date:"+formatDateTime+" | "+myMessage.getSender().getMyAccount().getUsername()+" | \n");
				newMessageTextArea.setText("");
			}
		});
		sendMessageButton.setBounds(556, 555, 62, 62);
		panel.add(sendMessageButton);
		
		Icon lock = new ImageIcon("label_backgrounds/lock_32px.png");
		JLabel lblNewLabel_2 = new JLabel(lock);
		lblNewLabel_2.setBounds(12, 14, 46, 38);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("(Write in English characters)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(462, 11, 193, 14);
		frame.getContentPane().add(lblNewLabel);
	}
}
