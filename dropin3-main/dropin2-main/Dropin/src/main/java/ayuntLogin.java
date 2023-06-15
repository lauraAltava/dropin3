import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ayuntLogin extends JFrame {

    public ayuntLogin() {
        // Configurar la pantalla
        setTitle("Map Buttons");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        // Crear botones
        JButton castellonButton = new JButton("Castellón de la Plana");
        JButton vilaRealButton = new JButton("Vila-real");
        JButton vallDUixoButton = new JButton("Vall d'Uixó");
        JButton benicassimButton = new JButton("Benicàssim");
        JButton atrasButton = new JButton("Atrás"); // Botón "Atrás"

        // Establecer colores personalizados
        Color backgroundColor = new Color(85, 211, 83);
        Color buttonColor = new Color(255, 255, 255);
        Color textColor = new Color(85, 211, 83);

        // Configurar estilo de los botones
        castellonButton.setBackground(buttonColor);
        castellonButton.setForeground(textColor);
        vilaRealButton.setBackground(buttonColor);
        vilaRealButton.setForeground(textColor);
        vallDUixoButton.setBackground(buttonColor);
        vallDUixoButton.setForeground(textColor);
        benicassimButton.setBackground(buttonColor);
        benicassimButton.setForeground(textColor);
        atrasButton.setBackground(buttonColor); // Color de fondo para el botón "Atrás"
        atrasButton.setForeground(textColor); // Color del texto para el botón "Atrás"

        Font buttonFont = new Font("Arial", Font.BOLD, 18);
        castellonButton.setFont(buttonFont);
        vilaRealButton.setFont(buttonFont);
        vallDUixoButton.setFont(buttonFont);
        benicassimButton.setFont(buttonFont);
        atrasButton.setFont(buttonFont); // Fuente para el botón "Atrás"

        // Crear panel para los botones
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 10, 10)); // Se cambió el GridLayout a 5 filas para agregar el botón "Atrás"
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.setBackground(backgroundColor);
        buttonPanel.add(castellonButton);
        buttonPanel.add(vilaRealButton);
        buttonPanel.add(vallDUixoButton);
        buttonPanel.add(benicassimButton);
        buttonPanel.add(atrasButton); // Agregar el botón "Atrás" al panel

        // Establecer tamaño preferido para el botón "Atrás"
        Dimension backButtonSize = new Dimension(50, 30);
        atrasButton.setPreferredSize(backButtonSize);

        // Agregar panel al marco
        add(buttonPanel);

        // Acciones de los botones
        castellonButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ayuntNombre panelAyuntamiento = new ayuntNombre("castellon");
                panelAyuntamiento.setNombre("castellon");
                panelAyuntamiento.setVisible(true);
                dispose(); // Cierra la ventana actual de AyuntLogin

            }
        });

        vilaRealButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ayuntNombre panelAyuntamiento = new ayuntNombre("vila");
                panelAyuntamiento.setNombre("vila");
                panelAyuntamiento.setVisible(true);
                dispose(); // Cierra la ventana actual de AyuntLogin

            }
        });

        vallDUixoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ayuntNombre panelAyuntamiento = new ayuntNombre("vall");
                panelAyuntamiento.setNombre("vall");
                panelAyuntamiento.setVisible(true);
                dispose(); // Cierra la ventana actual de AyuntLogin

            }
        });

        benicassimButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ayuntNombre panelAyuntamiento = new ayuntNombre("beni");
                panelAyuntamiento.setNombre("beni");
                panelAyuntamiento.setVisible(true);
                dispose(); // Cierra la ventana actual de AyuntLogin
            }
        });

        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para la acción "Atrás"
                tipoUsuario tipoUsuario = new tipoUsuario();
                tipoUsuario.setVisible(true);

                // Cerrar la ventana actual de AyuntLogin
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ayuntLogin mapButtons = new ayuntLogin();
                mapButtons.setVisible(true);
            }
        });
    }
}
