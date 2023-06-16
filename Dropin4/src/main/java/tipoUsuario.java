import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class tipoUsuario extends JFrame {
    private JButton ayuntamientoButton;
    private JButton usuarioButton;
    private usuarioLogin loginScreen; // Pantalla de inicio de sesión



    public tipoUsuario() {
        // Configuración de la ventana
        setTitle("Dropp-in");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        // Crear componente de título
        JLabel titleLabel = new JLabel("Drop-in");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setHorizontalAlignment(JLabel.LEFT);

        // Crear componente de imagen
        JLabel imageLabel = new JLabel();
        ImageIcon arbolitoImage = new ImageIcon("IMAGES/arbolito.png"); // Reemplaza "ruta/relativa/de/la/imagen.png" con la ruta de la imagen

        // Modificar el tamaño de la imagen
        Image scaledImage = arbolitoImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Establecer la imagen en el componente JLabel
        imageLabel.setIcon(scaledIcon);

        // Crear componentes de la interfaz
        ayuntamientoButton = new JButton("Ayuntamiento");
        usuarioButton = new JButton("Usuario");

        // Establecer colores personalizados
        Color backgroundColor = new Color(85, 211, 83);
        Color buttonColor = new Color(255, 255, 255);

        Color textColor = new Color(255, 255, 255);

        // Configurar estilo del título y de los botones
        titleLabel.setForeground(textColor);
        ayuntamientoButton.setBackground(buttonColor);
        usuarioButton.setBackground(buttonColor);
        ayuntamientoButton.setForeground(backgroundColor);
        usuarioButton.setForeground(backgroundColor);

        // Establecer fuente personalizada para el título y los botones
        Font titleFont = new Font("Arial", Font.BOLD, 40);
        Font buttonFont = new Font("Arial", Font.BOLD, 18);
        titleLabel.setFont(titleFont);
        ayuntamientoButton.setFont(buttonFont);
        usuarioButton.setFont(buttonFont);

        // Agregar componentes al panel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(backgroundColor);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 50)); // Márgenes

        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(backgroundColor);
        titlePanel.add(titleLabel, BorderLayout.WEST);
        titlePanel.add(imageLabel, BorderLayout.EAST);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 50)); // Margen izquierdo

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(backgroundColor);
        buttonPanel.add(ayuntamientoButton);
        buttonPanel.add(usuarioButton);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 10, 0)); // Margen superior e inferior

        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Agregar el panel principal a la ventana
        setContentPane(mainPanel);

        // Agregar eventos a los botones
        ayuntamientoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ayuntLogin ayuntLogin = new ayuntLogin();
                ayuntLogin.setVisible(true);
                dispose(); // Cerrar la ventana actual
            }
        });

        usuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la pantalla de inicio de sesión
                loginScreen = new usuarioLogin();
                loginScreen.setVisible(true);
                dispose(); // Cerrar la ventana actual
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                tipoUsuario app = new tipoUsuario();
                app.setVisible(true);
            }
        });
    }
}
