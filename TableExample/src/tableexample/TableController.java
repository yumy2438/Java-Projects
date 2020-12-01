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
		this.view.setModelOfTable(model);
	}
	
	class AddListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			model.addNewTableItem();
		}
		
	}
}
