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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JToolBar;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;

@SuppressWarnings("unused")
public class TestETsts {

	public JFrame frame;

	static JButton btnHit = new JButton("Hit");
	static JButton btnStand = new JButton("Stand");
	static JTextPane textPane = new JTextPane();
	static JTextPane textPane_1 = new JTextPane();
	static JButton btnRestart = new JButton("Restart");
	static JTextPane txtpnAce = new JTextPane();
	/**
	 * @wbp.nonvisual location=195,129
	 */
	private final Component horizontalGlue = Box.createHorizontalGlue();
	private final JButton button1 = new JButton("1");
	private final JButton button11 = new JButton("11");
	
	static void threadTestG(){
		synchronized(TestG.class){
		    TestG.class.notify();
		}
	}
	
	static void threadCards(){
		synchronized(Cards.class){
		    Cards.class.notify();
		}
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestETsts window = new TestETsts();
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
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cards.aceInt = 1;
			}
		});
		button11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cards.aceInt = 11;
			}
		});
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Blackjack");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmRestart = new JMenuItem("Restart");
		mntmRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TestG.reset = "Y";
			}
		});
		mnNewMenu.add(mntmRestart);
		
		
		btnHit.setEnabled(true);
		btnHit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TestG.input = "Hit";
				threadTestG();
			}
		});
		
		btnStand.setEnabled(true);
		btnStand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TestG.input = "Stand";
				threadTestG();
			}
		});
		
		
		
		
		textPane.setEditable(false);
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		textPane_1.setEditable(false);
		textPane_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblYou = new JLabel("You");
		
		JLabel lblDealer = new JLabel("Dealer");
		
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TestG.reset = "Y";
				threadTestG();
			}
		});
		
		
		btnRestart.setVisible(false);
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(77)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnHit)
								.addComponent(lblYou)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblDealer)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(btnStand))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(32)
							.addComponent(txtpnAce, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(button11)
								.addComponent(button1))))
					.addGap(59))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(157)
					.addComponent(btnRestart)
					.addContainerGap(208, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(32, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblYou)
								.addComponent(lblDealer))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(button1)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(11)
									.addComponent(btnRestart)
									.addGap(29)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnStand)
										.addComponent(btnHit)))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(button11)))
							.addGap(25))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(txtpnAce, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(101))))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
