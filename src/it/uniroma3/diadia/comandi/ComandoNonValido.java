package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando{
	
	private String parametro;
	private IO io;
	private final static String NOME = "non valido";
	
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Comando sconosciuto");  // si desidera smettere
	}

	@Override
	public void setIO(IO io) {
		this.io = io;
	}
	
	@Override
	public void setParametro(String parametro) {
	}
	
	@Override
	public String getNome() {
		return this.NOME;
	}
	
	@Override
	public String getParametro() {
		return null;
	}

}
