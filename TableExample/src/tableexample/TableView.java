package tableexample;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import tableexample.TableItem.MyType;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;

public class TableView extends JFrame{
	private JButton addButton;
	private JTable table;
	private JFrame frame;
	private JPanel newContentPane;
	private JScrollPane scrollPane;
	private JComboBox<String> typeComboBox;
	private String[] typeStrings = {"lt", "mt", "sn", "watt" };
			
	public TableView() {
		frame = new JFrame("TableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        newContentPane = new JPanel();
        typeComboBox = new JComboBox<>(typeStrings);
        typeComboBox.setSelectedIndex(1);
        
        table = new JTable();        
        table.setPreferredScrollableViewportSize(new Dimension(300, 200));
        table.setFillsViewportHeight(true);
        table.setDefaultRenderer(MyType.class, new TypeRenderer(typeComboBox));
 
        //Create the scroll pane and add the table to it.
        scrollPane = new JScrollPane(table);
 
        //Add the scroll pane to this panel.
        newContentPane.add(typeComboBox);
        newContentPane.add(scrollPane);
        
        addButton = new JButton("Add random");
        
        scrollPane.setRowHeaderView(addButton);
        
        
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
	}
	
	public void setModelOfTable(TableModel tm) {
		table.setModel(tm);
	}
	
	public void addListenerToAddButton(ActionListener listenForAddButton) {
		addButton.addActionListener(listenForAddButton);
	}
	
	public void addListenerToComboBox(ActionListener listenForTypeComboBox) {
		typeComboBox.addActionListener(listenForTypeComboBox);
	}
	
	public Object getSelectedComboBox() {
		return typeComboBox.getSelectedItem();
	}

	
	
}