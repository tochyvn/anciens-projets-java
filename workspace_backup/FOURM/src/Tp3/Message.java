package Tp3;

public abstract class Message {

	private Fourmi exp;
	private String msg;
	
	public Message(){}
	
	public abstract void evenement();

	public Fourmi getExp() {
		return exp;
	}

	public void setExp(Fourmi exp) {
		this.exp = exp;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
