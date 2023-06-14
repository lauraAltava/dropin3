import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Saldo extends JFrame {
    private JLabel saldoLabel;

    public Saldo() {
        // Configurar la pantalla "Saldo"
        setTitle("Saldo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 450);
        setLocationRelativeTo(null);

        // Crear componentes
        saldoLabel = new JLabel();

        // Establecer colores personalizados
        Color backgroundColor = new Color(85, 211, 83);
        Color buttonColor = new Color(255, 255, 255);
        Color textColor = new Color(85, 211, 83);

        // Configurar estilo de los componentes
        saldoLabel.setForeground(buttonColor);
        saldoLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        // Crear botón "Atrás"
        JButton backButton = new JButton("Atrás");
        backButton.setBackground(buttonColor);
        backButton.setForeground(textColor);
        backButton.setFont(new Font("Arial", Font.BOLD, 18));

        // Crear un panel para contener los componentes
        JPanel saldoPanel = new JPanel(new BorderLayout());
        saldoPanel.setBackground(backgroundColor);
        saldoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        saldoPanel.add(saldoLabel, BorderLayout.CENTER);
        saldoPanel.add(backButton, BorderLayout.SOUTH);

        // Agregar el panel al marco
        add(saldoPanel);

        // Obtener el saldo inicial
        double saldoInicial = generarSaldoAleatorio();
        saldoLabel.setText("Saldo: $" + saldoInicial);

        // Actualizar el saldo cada 10 segundos
        Timer timer = new Timer(10000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double saldoActualizado = generarSaldoAleatorio();
                saldoLabel.setText("Saldo: $" + saldoActualizado);
            }
        });
        timer.start();

        // Acción del botón "Atrás"
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    usuarioOpciones usuarioOpciones = new usuarioOpciones();
                    usuarioOpciones.setVisible(true);
                    dispose(); // Cierra la ventana actual
                });
            }
        });
    }

    private double generarSaldoAleatorio() {
        // Generar un saldo aleatorio entre 0 y 1000
        return Math.random() * 1000;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Saldo saldo = new Saldo();
                saldo.setVisible(true);
            }
        });
    }
}
