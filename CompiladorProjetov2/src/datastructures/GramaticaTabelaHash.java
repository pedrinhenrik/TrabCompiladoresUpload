package datastructures;

import java.util.ArrayList;
import java.util.HashMap;

public class GramaticaTabelaHash {
	
	private HashMap<String, GramaticaSimbolo> map;
	
	public GramaticaTabelaHash() {
		map = new HashMap<String, GramaticaSimbolo>();
		
	}
	
	public void add(GramaticaSimbolo symbol) {
		map.put(symbol.getName(), symbol);
	}
	
	public boolean exists(String symbolName) {
		return map.get(symbolName) != null;
	}
	
	public GramaticaSimbolo get(String symbolName) {
		return map.get(symbolName);
	}
	
	public ArrayList<GramaticaSimbolo> getAll(){
		ArrayList<GramaticaSimbolo> lista = new ArrayList<GramaticaSimbolo>();
		for (GramaticaSimbolo symbol : map.values()) {
			lista.add(symbol);
		}
		return lista;
	}

	
	
}
