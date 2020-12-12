package tableexample;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import tableexample.TableItem.MyType;

public class TypeRenderer extends JLabel implements TableCellRenderer{
	private JComboBox comboBox;
	public TypeRenderer(JComboBox comboBox) {
		this.comboBox = comboBox;
		super.setOpaque(true);
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean isFocus, int row,
			int column) {
				MyType type = (MyType) value;
				if (type.toString().equals(comboBox.getSelectedItem())) {
					super.setBackground(Color.RED);
				}
				else
				{
					super.setBackground(Color.WHITE);
				}
				super.setText(type.toString());
				return this;
		// TODO Auto-generated method stub
				
		
	}
	

}
