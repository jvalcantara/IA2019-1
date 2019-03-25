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

public class Estado {
	
	public String nome;
	
	/* Representa as acoes associadas a certo estado */
	public LinkedList<Estado> acoes = new LinkedList<>();

}
