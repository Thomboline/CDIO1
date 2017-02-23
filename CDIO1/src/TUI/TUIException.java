package TUI;

public class TUIException extends Exception {
	
	private static final long serialVersionUID = 735541824633673921L;
	
	private int type;
	
	public TUIException(String msg, Throwable e) 
	{
		super(msg,e);
	}
	
	public TUIException(String msg, int type) 
	{
		super(msg);
		this.type = type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public int getType() {
		return this.type;
	}
	

}
