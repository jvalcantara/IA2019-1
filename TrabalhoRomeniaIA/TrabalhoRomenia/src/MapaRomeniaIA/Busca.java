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

public interface Busca {

	public LinkedList<Node> buscar(Problema problema, Estado estadoInicial);

	public LinkedList<Node> expandir(Node no);

	public void mostrarCaminho();

	public LinkedList<Node> getBorda();

	public LinkedList<Node> getHistorico();
}
