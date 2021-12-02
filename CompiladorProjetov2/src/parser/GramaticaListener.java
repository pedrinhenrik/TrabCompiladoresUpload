// Generated from Gramatica.g4 by ANTLR 4.9.2
package parser;

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

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GramaticaParser}.
 */
public interface GramaticaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(GramaticaParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(GramaticaParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(GramaticaParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(GramaticaParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#end}.
	 * @param ctx the parse tree
	 */
	void enterEnd(GramaticaParser.EndContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#end}.
	 * @param ctx the parse tree
	 */
	void exitEnd(GramaticaParser.EndContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(GramaticaParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(GramaticaParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(GramaticaParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(GramaticaParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaravar(GramaticaParser.DeclaravarContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaravar(GramaticaParser.DeclaravarContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(GramaticaParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(GramaticaParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(GramaticaParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(GramaticaParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(GramaticaParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(GramaticaParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdleitura(GramaticaParser.CmdleituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdleitura(GramaticaParser.CmdleituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdescrita(GramaticaParser.CmdescritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdescrita(GramaticaParser.CmdescritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdattrib(GramaticaParser.CmdattribContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdattrib(GramaticaParser.CmdattribContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void enterCmdselecao(GramaticaParser.CmdselecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void exitCmdselecao(GramaticaParser.CmdselecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#cmdboolean}.
	 * @param ctx the parse tree
	 */
	void enterCmdboolean(GramaticaParser.CmdbooleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#cmdboolean}.
	 * @param ctx the parse tree
	 */
	void exitCmdboolean(GramaticaParser.CmdbooleanContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#cmdreturn}.
	 * @param ctx the parse tree
	 */
	void enterCmdreturn(GramaticaParser.CmdreturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#cmdreturn}.
	 * @param ctx the parse tree
	 */
	void exitCmdreturn(GramaticaParser.CmdreturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(GramaticaParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(GramaticaParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(GramaticaParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(GramaticaParser.TermoContext ctx);
}