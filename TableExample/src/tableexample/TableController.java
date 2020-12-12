package tableexample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableController {
	private TableModel model;
	private TableView view;
	
	public TableController(TableModel model, TableView view)
	{
		this.model = model;
		this.view = view;
		this.view.addListenerToAddButton(new AddListener());
		this.view.addListenerToComboBox(new TypeBoxListener() );
		this.view.setModelOfTable(model);
	}
	
	class AddListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			model.addNewTableItem();
		}
	}
	
	class TypeBoxListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int rowCount = model.getRowCount();
			for(int i=0; i<rowCount; i++) {
				if (view.getSelectedComboBox().equals(model.getValueAt(i, 1).toString())) {
					model.fireTableCellUpdated(i, 1);
				}
				
			}
		}
		
	}
}
