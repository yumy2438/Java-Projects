package tableexample;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TableView extends JFrame{
	private JButton addButton;
	private JTable table;
	private JFrame frame;
	private JPanel newContentPane;
	private JScrollPane scrollPane;
	
	public TableView() {
		frame = new JFrame("Table Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        newContentPane = new JPanel();
        table = new JTable();        
        table.setPreferredScrollableViewportSize(new Dimension(300, 200));
        table.setFillsViewportHeight(true);
 
        //Create the scroll pane and add the table to it.
        scrollPane = new JScrollPane(table);
 
        //Add the scroll pane to this panel.
        newContentPane.add(scrollPane);
        
        addButton = new JButton("Add random");
        
        scrollPane.setRowHeaderView(addButton);
        
        
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
	}
	
	public void setModelOfTable(TableModel tm)
	{
		table.setModel(tm);
	}
	
	public void addListenerToAddButton(ActionListener listenForAddButton)
	{
		addButton.addActionListener(listenForAddButton);
	}
	
}