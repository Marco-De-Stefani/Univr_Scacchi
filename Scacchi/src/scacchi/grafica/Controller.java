package scacchi.grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import scacchi.Colore;
import scacchi.Position;
import scacchi.Scacchiera;

/**
 * Classe controller: componente controller del design pattern mvc
 * 
 * @author Tommaso Dal Fior (detto Beppe), Marco De Stefani, Davide Miglioranzi
 *
 */
public class Controller {

	boolean evidenziate = false;
	Position oldPos;
	
	/**
	 * Componente controller del design pattern mvc
	 * Vengono creati due listener:
	 * 	-per il PanelScacchiera, che prende le coordinate x,y, le ridimensiona alla dimensione del pannello e
	 * 		agisce sulla scacchiera vera e propria in base alla posizione e ai casi
	 * 	-per il bottone "Ricomincia", che permette di ri-iniziare una nuova partita in qualunque momento del gioco
	 * 
	 * @param ps PanelScacchiera con la grafica della scacchiera
	 * @param pi PanelInformazioni con la grafica delle infrmazioni
	 * @param scacchiera la struttura dati usata per memorizzare la situazione corrente della scacchiera
	 */
	public Controller(PanelScacchiera ps, PanelInformazioni pi, Scacchiera scacchiera) {
		
		//listener dela scacchiera (ps PanelScacchiera)
		ps.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Atttenzione! Il listener del mouse ritorna le coordinate x,y ma noi ragioniamo per riga,colonna
				//Quindi la x è intesa come colonna, e la y come riga
				int colonna = e.getX();
				int riga = e.getY();
				//passaggio da coordinate in pixel a numero di riga e colonna (da 0 a 7)
				colonna /= 50;
				riga /= 50;
				
				if (!evidenziate) {
					
					//se clicco in una casella senza pedina
					if(scacchiera.getScacchiera()[riga][colonna] == null){	
						return;
					}
					
					//si sceglie la pedina da muovere (evidenziate = false)
					evidenziate = true;
					oldPos = new Position(riga,colonna);	//salvo la posizione attuale
					ps.setEvidenziate(scacchiera.getMoves(new Position(riga,colonna)),evidenziate);
					ps.repaint();
				} else {	//caso evidenziate = true
					
					//se la posizione (x,y) è permessa (codici 1 o 2, no 0)
					if (ps.getEvidenziate()[riga][colonna] != 0) {
						
						//se avviene una mossa
						if (scacchiera.move(oldPos, new Position(riga, colonna),ps) == true) {
							pi.setPedineMangiate(scacchiera.getPedineMangiate());	//possibili pedine mangiate
							pi.repaint();
						}
						//il metodo move() passa il turno, quindi bisogna cancellare le caselle evidenziate
						ps.setEvidenziate(new int[8][8],evidenziate);
						ps.repaint();
						evidenziate = false;
					} else {	//se la posizione (x,y) non è permessa (codice 0)
						if (scacchiera.getScacchiera()[riga][colonna] != null &&
								scacchiera.getScacchiera()[riga][colonna].getColore().equals(scacchiera.getTurno())) {
								evidenziate = true;
							oldPos = new Position(riga,colonna);
							ps.setEvidenziate(scacchiera.getMoves(new Position(riga,colonna)),evidenziate);
							ps.repaint();
						} else {	//mossa invalida
							ps.repaint();
						}
					}
					
					
					int scacco=scacchiera.scacco();
					boolean sm=false;	//sm = scacco matto
					if(scacco!=0){
						sm=scacchiera.scaccoMatto();
						pi.setScacco(true);
					}else{
						pi.setScacco(false);
					}
					if(scacco!=0 && sm){
						Colore turno;
						//se c'è scacco matto, ha vinto l'avversario
						if (scacchiera.getTurno().equals(Colore.BIANCO))
							turno = Colore.NERO;
						else {
							turno = Colore.BIANCO;
						}
						int confirm = JOptionPane.showConfirmDialog(null,"Complimenti giocatore " +turno+" hai vinto!\nVuoi cominciare una nuova partita?","Scacco Matto",JOptionPane.YES_NO_OPTION);

						
						if(confirm == 0){
							scacchiera.restart();
							ps.repaint();
							pi.repaint();
						}else{System.exit(0);}
					}

				}
				
				
				
			}
		});

		//listener del  bottone per iniziare una nuova partita (ps PanelInformazioni)
		pi.jBrestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null,"Sicuro di voler iniziare una nuova partita?","Nuova partita",JOptionPane.YES_NO_OPTION);
				if(confirm == 0){	//0 = l'utente ha cliccato si: inizia una nuova partita
					scacchiera.restart();
					pi.repaint();
					ps.repaint();
				}
			}
		});
	}
}
