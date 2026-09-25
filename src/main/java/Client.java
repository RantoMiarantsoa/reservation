package main.java;

import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.SwingUtilities;

import org.omg.CORBA.ORB;

import GestionReservation.Booking;
import GestionReservation.BookingHelper;

public class Client {
    public static void main(String[] args) {
        try {
            
      
      ORB orb = ORB.init(args,null);

    String iorFile = System.getProperty("reservation.ior", "config/reservation.ior");
    String ior = new String(Files.readAllBytes(Paths.get(iorFile))).trim();

        org.omg.CORBA.Object obj = orb.string_to_object(ior);

    Booking bookingService = BookingHelper.narrow(obj);
if (bookingService == null) {
                System.err.println(" Erreur : Impossible de convertir la référence IOR vers l'interface Booking.");
                return;
            }

            // 5. Appeler la méthode distante getListeVols() 
          SwingUtilities.invokeLater(() -> {
                ListeVolFrame fenetre = new ListeVolFrame(bookingService);
                fenetre.setVisible(true);
            });

        } catch (Exception e) {
            System.err.println(" Erreur lors de l'exécution du client :");
            e.printStackTrace();
        }
        }
}


