/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapaRomeniaIA;

/**
 *
* @author Joao Vitor R.
 */
import java.util.LinkedList;


public class AprofundamentoIterativo implements Busca {

	public Node no;
	public int profunfidadeGeral = -1;
	public boolean encontrou = false;
	int count = 0;
	Problema problema;
	LinkedList<Node> borda = new LinkedList<>();
	LinkedList<Node> caminho = new LinkedList<>();
	LinkedList<Estado> explorados = new LinkedList<>();

	LinkedList<Node> historico = new LinkedList<>();

	@Override
	public LinkedList<Node> buscar(Problema problema, Estado estadoInicial) {
		// TODO Auto-generated method stub

		if (count == 0) {
			this.problema = problema;
			this.borda.add(new Node(estadoInicial));
		}

		if (this.borda.isEmpty()) {
			// System.err.println("FALHA -->");
			return null;
		}

		this.no = this.borda.removeFirst();
		historico.add(no);
		no.profundidade = ++profunfidadeGeral;
		explorados.add(no.estado);

		// if (problema.testeDeObjetivo(no.estado)) {
		// encontrou = true;
		// mostrarCaminho();
		// System.out.println("-----------------------------------");
		// System.out.println("Objetivo alcancado!!!");
		// System.out.println("-----------------------------------");
		// return caminho;
		// }

		LinkedList<Node> expandidos = expandir(no);

		for (int i = 0; i < expandidos.size(); i++)
			if (!this.explorados.contains(expandidos.get(i).estado))
				this.borda.addLast(expandir(no).get(i));

		count++;
		return null;
	}

	@Override
	public LinkedList<Node> expandir(Node no) {
		// TODO Auto-generated method stub

		LinkedList<Node> sucessores = new LinkedList<Node>();

		for (int i = 0; i < problema.funcaoSucessora(no.estado).size(); i++) {
			Node s = new Node(problema.funcaoSucessora(no.estado).get(i));
			s.estado = problema.funcaoSucessora(no.estado).get(i);
			s.pai = no;
			s.acao = problema.funcaoSucessora(no.estado).get(i);
			s.profundidade = profunfidadeGeral + 1;
			sucessores.add(s);
		}
		return sucessores;
	}

	@Override
	public void mostrarCaminho() {
		// TODO Auto-generated method stub
		Node noAux = no;

		while (noAux != null) {
			caminho.addFirst(noAux);
			noAux = noAux.pai;
		}

		System.out.println("-----------------------------------");
		System.out.println("Estado inicial: " + this.problema.getNomeEstadoInicial());
		System.out.println("Objetivo: " + this.problema.getNomeObjetivo());
		System.out.println("-----------------------------------");

		for (int i = 0; i < caminho.size(); i++) {
			if (i + 1 < caminho.size()) {
				System.out.println(caminho.get(i).estado.nome + " --> " + caminho.get(i + 1).estado.nome);
			}
		}
		System.out.println("Profundidade: " + no.profundidade);

		/* Temporario */

		System.out.println("Historioco\n\n\n");
		for (int i = 0; i < historico.size(); i++) {
			System.out.println(historico.get(i).estado.nome);

		}
	}

	@Override
	public LinkedList<Node> getBorda() {
		// TODO Auto-generated method stub
		return borda;
	}

	@Override
	public LinkedList<Node> getHistorico() {
		// TODO Auto-generated method stub
		return historico;
	}

}
