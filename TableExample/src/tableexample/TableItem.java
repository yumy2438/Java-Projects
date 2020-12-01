package tableexample;

public class TableItem {
	
	private int id;
	private String type;
	private String value;
	
	public TableItem(int id, String type, String value) {
		this.id = id;
		this.type = type;
		this.value = value;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id + " " + this.type + " " + this.value;
	}
	
	public boolean equals(TableItem tableItem) {
		// TODO Auto-generated method stub
		return this.id == tableItem.id;
	}
	
	public boolean equals(int id) {
		// TODO Auto-generated method stub
		return this.id == id;
	}
	
}
