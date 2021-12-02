package ast;

import datastructures.GramaticaVariavel;

public class CommandLeitura extends AbstractCommand {

	private String id;
	private GramaticaVariavel var;
	
	public CommandLeitura (String id, GramaticaVariavel var) {
		this.id = id;
		this.var = var;
	}
	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		return id +"= _key." + (var.getType()==GramaticaVariavel.NUMBER? "nextDouble();": "nextLine();");
	}
	@Override
	public String toString() {
		return "Comando Leitura | id = " + id + " |";
	}

}
