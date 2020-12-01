package tableexample;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel{
	private ArrayList<TableItem> tableItems;
	private String[] columnNames;
	
	public TableModel()
	{
		this.tableItems = new ArrayList<TableItem>();
		String [] columnNames = {"id", "type", "value"};
		this.columnNames = columnNames;
	}
	
	public TableModel(ArrayList<TableItem> tableItems, String[] columnNames) {
		this.tableItems = tableItems;
		this.columnNames = columnNames;
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return tableItems.size();
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnNames[column];
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch(columnIndex) {
			case 0:
				return tableItems.get(rowIndex).getId();
			case 1:
				return tableItems.get(rowIndex).getType();
			default://case 2
				return tableItems.get(rowIndex).getValue();
		}
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch(columnIndex) {
			case 1:
				tableItems.get(rowIndex).setType((String) aValue);
				break;
			default://case 2
				tableItems.get(rowIndex).setValue((String) aValue);
				break;
	}
		fireTableCellUpdated(rowIndex, columnIndex);
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if(columnIndex<1){
			return false;
		} else {
			return true;
		}
	}
	
	public void addNewTableItem() {
		int lastItemId = this.getRowCount() + 1;
		TableItem tableItem = new TableItem(lastItemId, "t"+lastItemId, "v"+lastItemId);
		this.tableItems.add(tableItem);
		fireTableDataChanged();
	}
	
	public int searchTableItem(int id) throws Exception {
		int index = 0;
		for(TableItem tableItem: tableItems) {
			if(tableItem.equals(id)) {
				return index;
			}
			index += 1;
		}
		throw new Exception("An item with the given id does not exist.");
	}
	
	public void removeTableItem(int id) {
		try {
			int index = searchTableItem(id);
			tableItems.remove(index);
			fireTableDataChanged();
		} catch (Exception e) {
		}
	}
}
