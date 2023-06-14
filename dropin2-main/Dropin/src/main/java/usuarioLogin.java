import javax.swing.*;
import java.awt.*;

public class usuarioLogin extends JFrame {
    public usuarioLogin() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel loginPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JButton registerButton = new JButton("Register");
        JButton loginButton = new JButton("Login");

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(registerButton);
        loginPanel.add(loginButton);

        add(loginPanel);

        loginButton.addActionListener(e -> openPanelUsuario());
        registerButton.addActionListener(e -> openRegistrationScreen());
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            usuarioLogin login = new usuarioLogin();
            login.setVisible(true);
        });
    }
}
