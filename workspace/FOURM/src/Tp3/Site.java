package Tp3;

public class Site {
	
	private String description;
    private int qte = 100;
	private int position;
	
    public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Site(int pos) {
		this.setPosition(pos);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQte() {
		return qte;
	}

	public void dcQte() {
		this.qte--;
	}
    
    
}
