import Data.DataControl;
import GUI.EditArmada;
import GUI.EditJadwal;
import GUI.ListJadwal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Main extends JFrame implements ActionListener {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel timePanel;
    private JPanel buttonPanel;
    private DataControl dataControl;

    public Main() {
        dataControl = new DataControl();

        setTitle("Manajemen Bus");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        EditArmada editArmadaPanel = new EditArmada(dataControl);
        EditJadwal editJadwalPanel = new EditJadwal(dataControl);
        ListJadwal listJadwalPanel = new ListJadwal(dataControl);

        cardPanel.add(editArmadaPanel.getEditArmadaPanel(), "Edit Armada");
        cardPanel.add(editJadwalPanel.getEditJadwalPanel(), "Edit Jadwal");
        cardPanel.add(listJadwalPanel.getListJadwalPanel(), "Daftar Jadwal");

        timePanel = new JPanel(new BorderLayout());
        TimeClock clock = new TimeClock();
        timePanel.add(clock, BorderLayout.CENTER);

        buttonPanel = new JPanel();

        JButton button1 = new JButton("Edit Armada");
        JButton button2 = new JButton("Edit Jadwal");
        JButton button3 = new JButton("Daftar Jadwal");

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        setLayout(new BorderLayout());
        add(cardPanel, BorderLayout.CENTER);
        add(timePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Edit Armada")) {
            cardLayout.show(cardPanel, "Edit Armada");
        } else if (e.getActionCommand().equals("Edit Jadwal")) {
            cardLayout.show(cardPanel, "Edit Jadwal");
        } else if (e.getActionCommand().equals("Daftar Jadwal")){
            cardLayout.show(cardPanel, "Daftar Jadwal");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main mainFrame = new Main();
            mainFrame.setVisible(true);
        });
    }
}
