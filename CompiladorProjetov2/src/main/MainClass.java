package main;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import exceptions.GramaticaExcecoesSemanticas;
import parser.GramaticaLexer;
import parser.GramaticaParser;

/* esta é a classe que é responsável por criar a interação com o usuário
 * instanciando nosso parser e apontando para o arquivo fonte
 * 
 * Arquivo fonte: extensao .isi
 * 
 */
public class MainClass {
	public static void main(String[] args) {
		try {
			GramaticaLexer lexer;
			GramaticaParser parser;
			
			// leio o arquivo "input.isi" e isso é entrada para o Analisador Lexico
			lexer = new GramaticaLexer(CharStreams.fromFileName("input.isi"));
			
			// crio um "fluxo de tokens" para passar para o PARSER
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			
			// crio meu parser a partir desse tokenStream
			parser = new GramaticaParser(tokenStream);
			
			parser.prog();
			
			System.out.println("\nCompilação Feita!\n");
			
			parser.exibeComandos();
			
			parser.generateCode();
			
		}
		catch(GramaticaExcecoesSemanticas ex) {
			System.err.println("Erro Sintatico - "+ex.getMessage());
		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.err.println("ERROR "+ex.getMessage());
		}
		
	}

}
