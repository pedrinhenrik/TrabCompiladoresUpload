package datastructures;

public abstract class GramaticaSimbolo {
	
	protected String name;
	
	public abstract String generateJavaCode();
	public GramaticaSimbolo(String name) {
		this.name = name;
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "GramaticaSimbolo [name=" + name + "]";
	}
	
	
	

}
