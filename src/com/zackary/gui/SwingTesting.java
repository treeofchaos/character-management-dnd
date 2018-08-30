package com.zackary.gui;
import java.awt.*;        // Using AWT layouts.
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.*;     // Using Swing components and containers

// A Swing GUI application inherits from top-level container javax.swing.JFrame
public class SwingTesting extends JFrame 
{
	// Private instance variables
	private JTextField tfcount;
	private JButton buttoncount;
	private int count=0;

	// Constructor to setup the GUI components and event handlers
	public SwingTesting() {
		// Retrieve the top-level content-pane from JFrame
		Container cp = getContentPane();

		// Content-pane sets layout
		cp.setLayout(new FlowLayout());

		// Allocate the GUI components
		cp.add(new JLabel("Counter"));
		tfcount=new JTextField("0");
		tfcount.setEditable(false);
		cp.add(tfcount);

		// Content-pane adds components
		buttoncount=new JButton("count");
		cp.add(buttoncount);

		// Source object adds listener
		buttoncount.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent evt)
			{
				++count;
				tfcount.setText(count+"");
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Exit the program when the close-window button clicked
		setTitle("Dungeons and Dragons Character Management");  // "super" JFrame sets title
		setSize(1500, 1000);   // "super" JFrame sets initial size
		setVisible(true);    // "super" JFrame shows
	}

	// The entry main() method
	public static void main(String[] args) {
		// Run GUI codes in Event-Dispatching thread for thread-safety
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingTesting();  // Let the constructor do the job
			}
		});
	}
}
