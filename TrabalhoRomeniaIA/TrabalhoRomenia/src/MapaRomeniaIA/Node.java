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
public class Node {
	
	public Estado estado;
	public Estado acao;
	public Node pai;
	public Integer profundidade;
	public Integer custoDePasso;
	
	public Node(Estado estado) {
		super();
		this.estado = estado;
	}
}
