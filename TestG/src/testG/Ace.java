package testG;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Point;

public class Ace extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Ace dialog = new Ace();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Ace() {
		setAlwaysOnTop(true);
		setResizable(false);
		setMinimumSize(new Dimension(230, 130));
		setMaximumSize(new Dimension(230, 130));
		setBounds(100, 100, 232, 132);
		getContentPane().setLayout(new MigLayout("", "[434px,grow]", "[grow][][]"));
		{
			JTextPane txtpnAce = new JTextPane();
			txtpnAce.setEditable(false);
			txtpnAce.setBackground(SystemColor.menu);
			txtpnAce.setText("Ace!");
			getContentPane().add(txtpnAce, "cell 0 0,alignx center,aligny center");
		}
		{
			JButton button = new JButton("1");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Cards.aceInt = 1;
					TestETsts.threadCards();
					Cards.ace.setVisible(false);
				}
			});
			getContentPane().add(button, "cell 0 1,alignx center");
		}
		{
			JButton button = new JButton("11");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Cards.aceInt = 11;
					TestETsts.threadCards();
					Cards.ace.setVisible(false);
				}
			});
			getContentPane().add(button, "cell 0 2,alignx center");
		}
	}

}
