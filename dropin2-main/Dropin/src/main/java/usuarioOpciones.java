import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class usuarioOpciones extends JFrame {
    public usuarioOpciones() {
        // Configurar la pantalla siguiente
        setTitle("Pantalla siguiente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 450);
        setLocationRelativeTo(null);

        // Crear componentes
        JButton saldoButton = new JButton("Saldo");
        JButton reciclarButton = new JButton("Reciclar");
        JButton backButton = new JButton("Atrás");

        // Establecer colores personalizados
        Color backgroundColor = new Color(85, 211, 83);
        Color buttonColor = new Color(255, 255, 255);
        Color textColor = new Color(85, 211, 83);

        // Configurar estilo de los botones
        Font buttonFont = new Font("Arial", Font.BOLD, 12);

        saldoButton.setBackground(buttonColor);
        saldoButton.setForeground(textColor);
        saldoButton.setFont(buttonFont);

        reciclarButton.setBackground(buttonColor);
        reciclarButton.setForeground(textColor);
        reciclarButton.setFont(buttonFont);

        backButton.setBackground(buttonColor);
        backButton.setForeground(textColor);
        backButton.setFont(buttonFont);

        // Crear un panel para contener los botones
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBackground(backgroundColor);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(100, 50, 100, 50));

        // Agregar botones al panel
        buttonPanel.add(saldoButton);
        buttonPanel.add(reciclarButton);
        buttonPanel.add(backButton);

        // Agregar el panel al marco
        add(buttonPanel);

        // Acción del botón Saldo
        saldoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    Saldo saldo = new Saldo();
                    saldo.setVisible(true);
                    dispose(); // Cierra la ventana actual
                });
            }
        });

        // Acción del botón Reciclar
        reciclarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    Reciclar reciclar = new Reciclar();
                    reciclar.setVisible(true);
                    dispose(); // Cierra la ventana actual
                });
            }
        });

        // Acción del botón Atrás
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    usuarioLogin usuarioLogin = new usuarioLogin();
                    usuarioLogin.setVisible(true);
                    dispose(); // Cierra la ventana actual
                });
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                usuarioOpciones panelUsuario = new usuarioOpciones();
                panelUsuario.setVisible(true);
            }
        });
    }
}
