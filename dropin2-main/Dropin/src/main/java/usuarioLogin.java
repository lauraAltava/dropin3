import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class usuarioLogin extends JFrame {

    JTextField usernameField;
    private JTextField passwordField;
    public usuarioLogin() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel loginPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

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
            String resultado="";
            if((usernameField.getText().isEmpty() || passwordField.getText().isEmpty())) {
                JOptionPane.showMessageDialog(usuarioLogin.this, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);

            }
            else{
            try {
                //C:\Users\Alejandro\IdeaProjects\dropin2-main\Dropin\src\main\resources\baseDropin

                Connection connection = DriverManager.getConnection("jdbc:sqlite:/home/INFORMATICA/alu10192170/Escriptori/dropin3-main/dropin2-main/Dropin/src/main/resources/baseDropin ", "username", "password");

                String Nombre=usernameField.getText();
                String consulta="SELECT contraseña from Usuarios where nombre= ?" ;


                PreparedStatement statement = connection.prepareStatement(consulta);
                statement.setString(1, Nombre);

                ResultSet resultSet = statement.executeQuery();

// Recorrer los resultados
                while (resultSet.next()) {
                    // Obtener el valor del conteo
                    resultado = resultSet.getString("contraseña");
                     // Realizar las operaciones necesarias con el valor del conteo
                    // Por ejemplo, puedes asignarlo a una variable o utilizarlo para establecer el texto en un JLabel
                }
                // Pasamos por el array
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            if (resultado.equals(passwordField.getText())){
            usuarioOpciones panelUsuario = new usuarioOpciones();
            panelUsuario.setNombre(usernameField.getText());
            panelUsuario.setVisible(true);
            dispose(); // Cierra la ventana de inicio de sesión al abrir la pantalla de usuario
        }

        else{
                JOptionPane.showMessageDialog(usuarioLogin.this, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }});
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
