import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Saldo extends JFrame {
    private JLabel saldoLabel;

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Saldo(String nombre) {
        // Configurar la pantalla "Saldo"
        setTitle("Saldo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 200);
        setLocationRelativeTo(null);

        String resultado="";

        try {
            //C:\Users\Alejandro\IdeaProjects\dropin2-main\Dropin\src\main\resources\baseDropin

            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/baseDropin ", "username", "password");


            String consulta="SELECT saldo from Usuarios where nombre= ?" ;


            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, nombre);

            ResultSet resultSet = statement.executeQuery();

// Recorrer los resultados
            while (resultSet.next()) {
                // Obtener el valor del conteo
                resultado = resultSet.getString("saldo");
                // Realizar las operaciones necesarias con el valor del conteo
                // Por ejemplo, puedes asignarlo a una variable o utilizarlo para establecer el texto en un JLabel
            }
            // Pasamos por el array
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Crear componentes

        saldoLabel = new JLabel();
        saldoLabel.setText("Saldo: "+ resultado);

        System.out.println(resultado);
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
        JPanel saldoPanel = new JPanel((new BorderLayout()));
        saldoPanel.setBackground(backgroundColor);
        saldoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        saldoPanel.add(saldoLabel, BorderLayout.CENTER);

        saldoPanel.add(backButton, BorderLayout.SOUTH);

        // Agregar el panel al marco
        add(saldoPanel);







        // Acción del botón "Atrás"
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    usuarioOpciones usuarioOpciones = new usuarioOpciones();
                    usuarioOpciones.setNombre(getNombre());
                    usuarioOpciones.setVisible(true);
                    dispose(); // Cierra la ventana actual
                });
            }
        });
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Saldo saldo = new Saldo("Admin");
                saldo.setVisible(true);
            }
        });
    }
}
