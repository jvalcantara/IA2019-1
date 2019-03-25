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

public class BuscaEmSuperficie {

	Busca busca1; // Inicia da origem
	Busca busca2; // Inicia do objetivo
	Node noInicial;
	Node noObjetivo;

	Problema problema;
	LinkedList<Node> caminho = new LinkedList<>();

	public LinkedList<Node> buscar(Problema problema, String nomeBusca1, String nomeBusca2) {
		// TODO Auto-generated method stub

		this.problema = problema;

		noInicial = new Node(problema.getEstadoInicial());
		noObjetivo = new Node(problema.getObejetivo());

		busca1 = identificaBusca(nomeBusca1);
		busca2 = identificaBusca(nomeBusca2);

		while (verificaInterseccao(busca1.getHistorico(), busca2.getHistorico())[0] == -1) {

			busca1.buscar(problema, noInicial.estado);
			busca2.buscar(problema, noObjetivo.estado);
		}

		gerarCaminho();
		mostrarCaminho(); // Constroi o caminho

		return caminho;
	}

	public void mostrarCaminho() {
		// TODO Auto-generated method stub

		System.out.println("INICIO: ---> " + problema.getNomeEstadoInicial());
		System.out.println("OBJETIVO: ---> " + problema.getNomeObjetivo());

		System.out.println("...........................");
		for (int i = 0; i < caminho.size(); i++)
			if (i + 1 < caminho.size())
				System.out.println(caminho.get(i).estado.nome + " --> " + caminho.get(i + 1).estado.nome);
		System.out.println("...........................");

		System.out.println("OBJETIVO ALCANCADO");

	}

	
	private Busca identificaBusca(String nomeBusca) {

		Busca busca;

		if (nomeBusca.toUpperCase().equals("LARGURA")) {
			busca = new AprofundamentoIterativo();
			return busca;
		} else if (nomeBusca.toUpperCase().equals("PROFUNDIDADE")) {
			busca = new BuscaProfundidade();
			return busca;
		}

		System.out.println("Busca < " + nomeBusca + " > nao existe");
		return null;

	}

	
	private int[] verificaInterseccao(LinkedList<Node> borda1, LinkedList<Node> borda2) {
		// System.out.println("Testando " + borda1.size() + " " +
		// borda2.size());
		int[] indexes = { -1, -1 };
		for (int i = 0; i < borda1.size(); i++) {
			for (int j = 0; j < borda2.size(); j++) {
				if (borda1.get(i).estado.equals(borda2.get(j).estado)) {
					indexes[0] = i;
					indexes[1] = j;
				}
			}
		}
		return indexes;
	}

	private LinkedList<Node> gerarCaminho() {

		Node noAux;
		int[] indexes = verificaInterseccao(busca1.getHistorico(), busca2.getHistorico());

	
		noAux = busca1.getHistorico().get(indexes[0]);
		while (noAux != null) {
			caminho.addFirst(noAux);
			noAux = noAux.pai;
		}

		
		noAux = busca2.getHistorico().get(indexes[1]).pai;
		while (noAux != null) {
			caminho.addLast(noAux);
			noAux = noAux.pai;
		}

		return caminho;
	}

	public static void main(String[] args) {

		Problema problema = new MapaRomenia("Arad", "Bucareste");
		BuscaEmSuperficie agente = new BuscaEmSuperficie();
		agente.buscar(problema, "Largura", "Largura");

	}

}
