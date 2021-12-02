grammar Gramatica;

@header{
	import datastructures.GramaticaSimbolo;
	import datastructures.GramaticaVariavel;
	import datastructures.GramaticaTabelaHash;
	import exceptions.GramaticaExcecoesSemanticas;
	import ast.CommandPrograma;
	import ast.AbstractCommand;
	import ast.CommandLeitura;
	import ast.CommandEscrita;
	import ast.CommandAtribuicao;
	import ast.CommandDecisao;
	import java.util.ArrayList;
	import java.util.Stack;
}

@members{
	private int _tipo;
	private String _varName;
	private String _varValue;
	private GramaticaTabelaHash symbolTable = new GramaticaTabelaHash();
	private GramaticaSimbolo symbol;
	private CommandPrograma program = new CommandPrograma();
	private ArrayList<AbstractCommand> curThread;
	private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
	private String _readID;
	private String _writeID;
	private String _exprID;
	private String _exprContent;
	private String _exprDecision;
	private ArrayList<AbstractCommand> listaTrue;
	private ArrayList<AbstractCommand> listaFalse;
	
	public void verificaID(String id){
		if (!symbolTable.exists(id)){
		    throw new GramaticaExcecoesSemanticas("O simbolo "+id+" não foi declarado");
			//throw new GramaticaExecoesSemanticas("Symbol "+id+" not declared");
		}
	}
	
	public void exibeComandos(){
		for (AbstractCommand c: program.getComandos()){
			System.out.println(c);
		}
	}
	
	public void generateCode(){
		program.generateTarget();
	}
}

prog	: start 'public static void main(String[] args){' decl bloco  '}' end
           {  program.setVarTable(symbolTable);
           	  program.setComandos(stack.pop());
           	 
           } 
		;

start   : 'public class Programa{'
        ;

end     : '}'
        ;
		
decl    :  (declaravar)+
        ;

number	: 'int' | 'float' | 'double'
        ;
        
declaravar :  tipo ID  {
	                  _varName = _input.LT(-1).getText();
	                  _varValue = null;
	                  symbol = new GramaticaVariavel(_varName, _tipo, _varValue);
	                  if (!symbolTable.exists(_varName)){
	                     symbolTable.add(symbol);	
	                  }
	                  else{
	                  	 throw new GramaticaExcecoesSemanticas("O simbolo "+_varName+" ja foi declarado");
	                  }
                    } 
              (  VIR 
              	 ID {
	                  _varName = _input.LT(-1).getText();
	                  _varValue = null;
	                  symbol = new GramaticaVariavel(_varName, _tipo, _varValue);
	                  if (!symbolTable.exists(_varName)){
	                     symbolTable.add(symbol);	
	                  }
	                  else{
	                       throw new GramaticaExcecoesSemanticas("O simbolo "+_varName+" não foi declarado");
	                  	 //throw new GramaticaExcecoesSemanticas("Symbol "+_varName+" already declared");
	                  }
                    }
              )* 
               SC
           ;
           
tipo       : 'int' { _tipo = GramaticaVariavel.NUMBER;  }
           | 'char'  { _tipo = GramaticaVariavel.TEXT;  }
           | 'float' { _tipo = GramaticaVariavel.NUMBER;  }
           | 'double' { _tipo = GramaticaVariavel.NUMBER;  }
           ;
        
bloco	: { curThread = new ArrayList<AbstractCommand>(); 
	        stack.push(curThread);  
          }
          (cmd)+
		;
		

cmd		:  cmdleitura  { System.out.println(" Reconhecido um comando de leitura");	    }
 		|  cmdescrita  { System.out.println(" Reconhecido um comando de escrita");       }
 		|  cmdattrib   { System.out.println(" Reconhecido um comando de atribuicao"); }
 		|  cmdselecao
 		|  cmdreturn
 		|  cmdboolean
		;


cmdleitura	: 'Scanner entrada'
                     ATTR
                     'new Scanner'
                     AP
                     ID { verificaID(_input.LT(-1).getText());
                     	  _readID = _input.LT(-1).getText();
                        } 
                     FP 
                     SC 
                     
              {
              	GramaticaVariavel var = (GramaticaVariavel)symbolTable.get(_readID);
              	CommandLeitura cmd = new CommandLeitura(_readID, var);
              	stack.peek().add(cmd);
              }   
			;
			
cmdescrita	: 'System.out.println'
                 AP
                 ASP
                 ID { verificaID(_input.LT(-1).getText());
	                  _writeID = _input.LT(-1).getText();
                     } 
                 ASP
                 FP
                 SC
               {
               	  CommandEscrita cmd = new CommandEscrita(_writeID);
               	  stack.peek().add(cmd);
               }
			;
			
cmdattrib	:  ID { verificaID(_input.LT(-1).getText());
                    _exprID = _input.LT(-1).getText();
                   } 
               ATTR { _exprContent = ""; } 
               expr 
               SC
               {
               	 CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
               	 stack.peek().add(cmd);
               }
			;
			
			
cmdselecao  :  'if' AP
                    ID    { _exprDecision = _input.LT(-1).getText(); }
                    OPR { _exprDecision += _input.LT(-1).getText(); }
                    (ID | NUMBER) {_exprDecision += _input.LT(-1).getText(); }
                    FP 
                    ACH 
                    { curThread = new ArrayList<AbstractCommand>(); 
                      stack.push(curThread);
                    }
                    (cmd)+ 
                    
                    FCH 
                    {
                       listaTrue = stack.pop();	
                    } 
                   ('else'
                   	 ACH
                   	 {
                   	 	curThread = new ArrayList<AbstractCommand>();
                   	 	stack.push(curThread);
                   	 } 
                   	(cmd+) 
                   	FCH
                   	{
                   		listaFalse = stack.pop();
                   		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
                   		stack.peek().add(cmd);
                   	}
                   )?
                   SC
            ;

cmdboolean  :   'boolean' ID { verificaID(_varName = _input.LT(-1).getText());}
                 (TRUE | FALSE) SC
            ;

cmdreturn   : 'return' (ID { verificaID(_varName = _input.LT(-1).getText()); }
                | NUMBER) SC
            ;

			
expr		:  termo ( 
	             OP  { _exprContent += _input.LT(-1).getText();}
	            termo
	            )*
			;
			
termo		: ID { verificaID(_input.LT(-1).getText());
	               _exprContent += _input.LT(-1).getText();
                 } 
            | 
              NUMBER
              {
              	_exprContent += _input.LT(-1).getText();
              }
			;
			
	
AP	: '('
	;
	
FP	: ')'
	;

ASP    : '"'
        ;

SC	: ';'
	;
	
OP	: '+' | '-' | '*' | '/'
	;

OPR : '>' | '<' | '>=' | '<=' | '==' | '!='
    ;

OPM : '++'
    ;

OPL : '--'
    ;
	
ATTR : '='
	 ;
	 
VIR  : ','
     ;
     
ACH  : '{'
     ;
     
FCH  : '}'
     ;

TRUE  : 'true'
       ;

FALSE : 'false'
      ;

ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;
	
NUMBER	: [0-9]+ ('.' [0-9]+)?
		;
		
WS	: (' ' | '\t' | '\n' | '\r') -> skip;