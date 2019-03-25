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
public class Custo {

	public Estado estadoInicial;
	public Estado estadoFinal;
	public Integer custoDeIda;
	
	public Custo(Estado estadoInicial, Estado estadoFinal, Integer custoDeIda) {
		super();
		this.estadoInicial = estadoInicial;
		this.estadoFinal = estadoFinal;
		this.custoDeIda = custoDeIda;
	}
}
