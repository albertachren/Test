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
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.SystemColor;
import javax.swing.JDesktopPane;
import java.awt.Frame;
import java.awt.Toolkit;

@SuppressWarnings("unused")
public class TestETsts {

	public JFrame frmBlackjack;

	static JButton btnHit = new JButton("Hit");
	static JButton btnStand = new JButton("Stand");
	static JTextPane textPane = new JTextPane();
	static JTextPane textPane_1 = new JTextPane();
	static JMenuItem mntmRestart = new JMenuItem("Restart");
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
		try {
			// Set System L&F
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
			System.out.println("LFEx");
		} catch (ClassNotFoundException e) {
			System.out.println("LFEx");
		} catch (InstantiationException e) {
			System.out.println("LFEx");
		} catch (IllegalAccessException e) {
			System.out.println("LFEx");
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestETsts window = new TestETsts();
					window.frmBlackjack.setVisible(true);
					
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
		frmBlackjack = new JFrame();
		frmBlackjack.setIconImage(Toolkit.getDefaultToolkit().getImage(TestETsts.class.getResource("/testG/icon.png")));
		frmBlackjack.setAlwaysOnTop(true);
		frmBlackjack.setTitle("Blackjack");
		frmBlackjack.setResizable(false);
		frmBlackjack.setBounds(100, 100, 300, 200);
		frmBlackjack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmBlackjack.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Blackjack");
		menuBar.add(mnNewMenu);
		mntmRestart.setEnabled(false);
		
		
		mntmRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TestG.reset = "Y";
				threadTestG();
			}
		});
		mnNewMenu.add(mntmRestart);
		btnHit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TestG.input = "Hit";
				System.out.println("HIT");
				threadTestG();
			}
		});
		
		btnStand.setEnabled(true);
		btnStand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TestG.input = "Stand";
				System.out.println("STAND");
				threadTestG();
			}
		});
		frmBlackjack.getContentPane().setLayout(new MigLayout("", "[][grow,left][pref!,center][grow][]", "[grow][30.00,grow][30.00,grow][][grow]"));
		
		JLabel lblYou = new JLabel("You");
		lblYou.setAlignmentX(Component.CENTER_ALIGNMENT);
		frmBlackjack.getContentPane().add(lblYou, "cell 1 0,alignx center,growy");
		
		JLabel lblDealer = new JLabel("Dealer");
		lblDealer.setAlignmentX(Component.CENTER_ALIGNMENT);
		frmBlackjack.getContentPane().add(lblDealer, "cell 3 0,alignx center,growy");
		textPane.setBackground(SystemColor.menu);
		
		
		
		
		textPane.setEditable(false);
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frmBlackjack.getContentPane().add(textPane, "cell 1 1 1 2,alignx center,aligny center");
		textPane_1.setBackground(SystemColor.menu);
		
		
		textPane_1.setEditable(false);
		textPane_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frmBlackjack.getContentPane().add(textPane_1, "cell 3 1 1 2,alignx center,aligny center");
		frmBlackjack.getContentPane().add(btnHit, "cell 1 4,alignx center,aligny center");
		frmBlackjack.getContentPane().add(btnStand, "cell 3 4,alignx center,aligny center");
	}
}
