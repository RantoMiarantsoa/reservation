package main.java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import GestionReservation.Booking;
import GestionReservation.Vol;
public class ListeVolListener implements ActionListener{
    Booking bookingService;
    private ListeVolFrame fenetre;

    public ListeVolListener(Booking bookingService, ListeVolFrame fenetre) {
        this.bookingService = bookingService;
        this.fenetre = fenetre;
    }

   @Override
public void actionPerformed(ActionEvent e) {

    Vol[] vols;

    try {
        fenetre.viderTableau();
        vols = bookingService.getListeVols();

    } catch (Exception ex) {

        JOptionPane.showMessageDialog(
            fenetre,
            "Erreur lors de l'appel CORBA : " + ex.getMessage(),
            "Erreur CORBA",
            JOptionPane.ERROR_MESSAGE
        );

        ex.printStackTrace();
        return;
    }

    for (Vol v : vols) {
        fenetre.ajouterLigneVol(
            v.idVol,
            v.companie,
            v.dateDepart,
            v.dateArrivee
        );
    }

    JOptionPane.showMessageDialog(
        fenetre,
        vols.length + " vols chargés avec succès depuis le serveur C++ !",
        "Succès",
        JOptionPane.INFORMATION_MESSAGE
    );
}
 
}
