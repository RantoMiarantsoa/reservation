package main.java;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import GestionReservation.Booking;

public class ListeVolFrame extends JFrame {
    private final JTable table;
    private final DefaultTableModel model;

    public ListeVolFrame(Booking bookingService) {
        setTitle("Liste des vols");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] colonnes = {"N° vol", "Compagnie", "Départ", "Arrivée"};
        model = new DefaultTableModel(colonnes, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        ListeVolListener listener = new ListeVolListener(bookingService, this);
        listener.actionPerformed(null);
    }

    public void viderTableau() {
        model.setRowCount(0);
    }

    public void ajouterLigneVol(String id, String compagnie,
            String depart, String arrivee) {
        model.addRow(new Object[]{id, compagnie, depart, arrivee});
    }
}
