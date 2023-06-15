import javax.swing.*;
import java.awt.*;

public class usuarioLogin extends JFrame {
    public usuarioLogin() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(280, 200);
        setLocationRelativeTo(null);

        // Establecer colores personalizados
        Color backgroundColor = new Color(85, 211, 83);
        Color buttonColor = new Color(255, 255, 255);
        Color textColor = new Color(85, 211, 83);

        JPanel loginPanel = new JPanel(new BorderLayout());
        loginPanel.setBackground(backgroundColor);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(backgroundColor);

        JButton backButton = new JButton("Atrás");
        backButton.setBackground(buttonColor);
        backButton.setForeground(textColor);
        backButton.setFont(new Font("Arial", Font.BOLD, 14));

        JButton registerButton = new JButton("Register");
        registerButton.setBackground(buttonColor);
        registerButton.setForeground(textColor);
        registerButton.setFont(new Font("Arial", Font.BOLD, 14));

        JButton loginButton = new JButton("Login");
        loginButton.setBackground(buttonColor);
        loginButton.setForeground(textColor);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));

        buttonPanel.add(backButton);
        buttonPanel.add(registerButton);
        buttonPanel.add(loginButton);

        loginPanel.add(buttonPanel, BorderLayout.SOUTH);

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JPanel fieldPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        fieldPanel.setBackground(backgroundColor);
        fieldPanel.add(usernameLabel);
        fieldPanel.add(usernameField);
        fieldPanel.add(passwordLabel);
        fieldPanel.add(passwordField);

        loginPanel.add(fieldPanel, BorderLayout.CENTER);

        add(loginPanel);

        loginButton.addActionListener(e -> openPanelUsuario());
        registerButton.addActionListener(e -> openRegistrationScreen());
        backButton.addActionListener(e -> openTipoUsuarioScreen());
    }

    public void openPanelUsuario() {
        SwingUtilities.invokeLater(() -> {
            usuarioOpciones panelUsuario = new usuarioOpciones();
            panelUsuario.setVisible(true);
            dispose(); // Cierra la ventana de inicio de sesión al abrir la pantalla de usuario
        });
    }

    public void openRegistrationScreen() {
        SwingUtilities.invokeLater(() -> {
            usuarioRegister registration = new usuarioRegister();
            registration.setVisible(true);
            dispose(); // Cierra la ventana de inicio de sesión al abrir la ventana de registro
        });
    }

    public void openTipoUsuarioScreen() {
        SwingUtilities.invokeLater(() -> {
            tipoUsuario tipoUsuario = new tipoUsuario();
            tipoUsuario.setVisible(true);
            dispose(); // Cierra la ventana de inicio de sesión al volver a la pantalla de TipoUsuario
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            usuarioLogin login = new usuarioLogin();
            login.setVisible(true);
        });
    }
}
