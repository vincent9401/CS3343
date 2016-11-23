
public class ConnectedBlock {
	private int _startRow;
	private int _startColumn;
	private int _endRow;
	private int _endColumn;
	private String _connect_type;
	
	public ConnectedBlock(int startRow, int startColumn, int endRow, int endColumn, String connect_type) {
		
		this._startRow = startRow;
		this._startColumn = startColumn;
		this._endRow = endRow;
		this._endColumn = endColumn;
		this._connect_type = connect_type;
	}

	public int getStartRow() {
		return _startRow;
	}

	public int getStartColumn() {
		return _startColumn;
	}

	public int getEndRow() {
		return _endRow;
	}

	public int getEndColumn() {
		return _endColumn;
	}

	public String getConnect_type() {
		return _connect_type;
	}
	
}
