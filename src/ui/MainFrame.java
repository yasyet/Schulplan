package ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    // Author: Yasin Holzenkämpfer
    // Created: 2024-06-15
    // Description: Main application frame for the UI

    public MainFrame() {
        setTitle("Java Schulplan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);

        initUi();
    }

    private void initUi() {
        setLayout(new BorderLayout());

        // Menu
        setJMenuBar(createMenuBar());

        // Stundenplan Panel
        add(new StundenplanPanel(), BorderLayout.CENTER);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu datei = new JMenu("Datei");
        datei.add(new JMenuItem("Öffnen"));
        datei.add(new JMenuItem("Speichern"));
        datei.addSeparator();
        datei.add(new JMenuItem("Beenden"));
        menuBar.add(datei);

        JMenu bearbeiten = new JMenu("Bearbeiten");
        bearbeiten.add(new JMenuItem("Stunde hinzufügen"));
        bearbeiten.add(new JMenuItem("Stunde bearbeiten"));
        bearbeiten.add(new JMenuItem("Stunde löschen"));
        menuBar.add(bearbeiten);

        return menuBar;
    }
}
