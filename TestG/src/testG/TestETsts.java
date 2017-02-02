package testG;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToolBar;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("unused")
public class TestETsts {

	public JFrame frame;

	static public JButton btnHit;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestETsts window = new TestETsts();
					btnHit.setEnabled(true);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	}

	public void buttonToggle(JButton button){
	
		button.setEnabled(true);
	}
	
	
	
	
	
	/**
	 * Create the application.
	 */
	public TestETsts() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Blackjack");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmRestart = new JMenuItem("Restart");
		mnNewMenu.add(mntmRestart);
		
		btnHit.setEnabled(false);
		btnHit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  TestG.input = "lol";
			}
		});
		
		JButton btnStand = new JButton("Stand");
		btnStand.setEnabled(false);
		
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPane.setText("2");
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPane_1.setText("2");
		
		JLabel lblYou = new JLabel("You");
		
		JLabel lblDealer = new JLabel("Dealer");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(77)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnHit)
						.addComponent(lblYou)
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDealer)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnStand)))
					.addGap(72))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(43, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblYou)
						.addComponent(lblDealer))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textPane_1)
						.addComponent(textPane))
					.addGap(104)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnStand)
						.addComponent(btnHit))
					.addGap(25))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
