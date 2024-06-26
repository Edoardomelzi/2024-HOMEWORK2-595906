package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	
	private IO io;
	private String direzione;
	private final static String NOME = "vai";

	@Override
	public void setIO(IO io) {
		this.io = io;
	}

	@Override
	public void esegui(Partita partita) {

		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;

		if (this.direzione == null) {

			io.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
			return;
		}

		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);

		if (prossimaStanza == null) {
			io.mostraMessaggio("Direzione inesistente");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		int cfu = partita.getGiocatore().getCfu();
		partita.getGiocatore().setCfu(--cfu);
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
	
	@Override
	public String getNome() {
		return this.NOME;
	}
	
	@Override
	public String getParametro() {
		return this.direzione;
	}
}