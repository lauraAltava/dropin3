import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ayuntContenedor extends JFrame {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ayuntContenedor(String nombre) {
        // Configurar la pantalla "Añadir Contenedor"
        setTitle("Añadir Contenedor");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        // Crear componentes
        JLabel serialNumberLabel = new JLabel("Nº de serie:");
        JTextField serialNumberTextField = new JTextField();

        JLabel typeLabel = new JLabel("Tipo:");
        JComboBox<String> typeComboBox = new JComboBox<>(new String[]{"Vidrio", "Cartón", "Orgánico"});

        JLabel addressLabel = new JLabel("Dirección:");
        JTextField addressTextField = new JTextField();

        JButton addButton = new JButton("Añadir");
        JButton backButton = new JButton("Atrás");

        // Establecer colores personalizados
        Color backgroundColor = new Color(85, 211, 83);
        Color buttonColor = new Color(255, 255, 255);
        Color textColor = new Color(85, 211, 83);

        // Configurar estilo de los componentes
        Font labelFont = new Font("Arial", Font.PLAIN, 12);
        Font buttonFont = new Font("Arial", Font.BOLD, 12);

        serialNumberLabel.setFont(labelFont);
        typeLabel.setFont(labelFont);
        addressLabel.setFont(labelFont);

        serialNumberLabel.setForeground(buttonColor);
        typeLabel.setForeground(buttonColor);
        addressLabel.setForeground(buttonColor);

        addButton.setBackground(buttonColor);
        backButton.setBackground(buttonColor);

        addButton.setForeground(textColor);
        backButton.setForeground(textColor);

        addButton.setFont(buttonFont);
        backButton.setFont(buttonFont);

        // Crear un panel para contener los componentes
        JPanel addContainerPanel = new JPanel(new GridBagLayout());
        addContainerPanel.setBackground(backgroundColor);
        addContainerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints componentConstraints = new GridBagConstraints();
        componentConstraints.gridx = 0;
        componentConstraints.gridy = 0;
        componentConstraints.fill = GridBagConstraints.NONE;
        componentConstraints.anchor = GridBagConstraints.WEST;
        componentConstraints.insets = new Insets(0, 0, 10, 5);
        addContainerPanel.add(serialNumberLabel, componentConstraints);

        componentConstraints.gridx = 1;
        componentConstraints.fill = GridBagConstraints.HORIZONTAL;
        componentConstraints.insets = new Insets(0, 0, 10, 0);
        addContainerPanel.add(serialNumberTextField, componentConstraints);

        componentConstraints.gridx = 0;
        componentConstraints.gridy = 1;
        componentConstraints.fill = GridBagConstraints.NONE;
        componentConstraints.insets = new Insets(0, 0, 10, 5);
        addContainerPanel.add(typeLabel, componentConstraints);

        componentConstraints.gridx = 1;
        componentConstraints.fill = GridBagConstraints.HORIZONTAL;
        componentConstraints.insets = new Insets(0, 0, 10, 0);
        addContainerPanel.add(typeComboBox, componentConstraints);

        componentConstraints.gridx = 0;
        componentConstraints.gridy = 2;
        componentConstraints.fill = GridBagConstraints.NONE;
        componentConstraints.insets = new Insets(0, 0, 10, 5);
        addContainerPanel.add(addressLabel, componentConstraints);

        componentConstraints.gridx = 1;
        componentConstraints.fill = GridBagConstraints.HORIZONTAL;
        componentConstraints.insets = new Insets(0, 0, 10, 0);
        addContainerPanel.add(addressTextField, componentConstraints);

        // Crear un panel para contener la imagen
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBackground(backgroundColor);

        // Crear el componente de imagen
        BufferedImage image = null;

            ImageIcon scaledIcon = new ImageIcon("/home/INFORMATICA/alu10216074/IdeaProjects/dropin3-main/dropin2-main/Dropin/IMAGES/Castellon.png");  // Reemplaza "ayuntamiento.jpg" con la ruta de la imagen

            if (nombre.equals("castellon")) {
                ImageIcon ayun = new ImageIcon("/home/INFORMATICA/alu10216074/IdeaProjects/dropin3-main/dropin2-main/Dropin/IMAGES/Castellon.png");  // Reemplaza "ayuntamiento.jpg" con la ruta de la imagen
                scaledIcon=ayun;

            }
            else if (nombre.equals("beni")) {
                ImageIcon ayun= new ImageIcon("/home/INFORMATICA/alu10216074/IdeaProjects/dropin3-main/dropin2-main/Dropin/IMAGES/Benicassim.png");  // Reemplaza "ayuntamiento.jpg" con la ruta de la imagen
                scaledIcon=ayun;
            }
            else if (nombre.equals("vila")) {
                ImageIcon ayun = new ImageIcon("/home/INFORMATICA/alu10216074/IdeaProjects/dropin3-main/dropin2-main/Dropin/IMAGES/Vila-real.png");  // Reemplaza "ayuntamiento.jpg" con la ruta de la imagen
                scaledIcon=ayun;
            }
            else if (nombre.equals("vall")) {
                ImageIcon ayun = new ImageIcon("/home/INFORMATICA/alu10216074/IdeaProjects/dropin3-main/dropin2-main/Dropin/IMAGES/LaVall.png");  // Reemplaza "ayuntamiento.jpg" con la ruta de la imagen
                scaledIcon = ayun;
            }

            JLabel imageLabel = new JLabel(scaledIcon);
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            imagePanel.add(imageLabel, BorderLayout.CENTER);


        // Crear el panel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(backgroundColor);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Agregar los paneles al panel principal
        mainPanel.add(addContainerPanel, BorderLayout.NORTH);
        mainPanel.add(imagePanel, BorderLayout.CENTER);

        // Crear un panel para contener los botones "Añadir" y "Atrás"
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(backgroundColor);
        buttonPanel.add(addButton);
        buttonPanel.add(backButton);

        // Agregar el panel de botones al panel principal
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Agregar el panel principal al marco
        add(mainPanel);

        // Acción del botón "Añadir"
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para añadir el contenedor
                String numero_serie = serialNumberTextField.getText();
                String tipos = (String) typeComboBox.getSelectedItem();
                String direccion = addressTextField.getText();
                String ayuntamiento=getNombre();
                if (ayuntamiento.equals("castellon")){
                    ayuntamiento="1";
                }
                else if (ayuntamiento.equals("beni")){
                    ayuntamiento="2";
                }
                else if (ayuntamiento.equals("vila")){
                    ayuntamiento="3";
                }
                else if (ayuntamiento.equals("vall")){
                    ayuntamiento="4";
                }

                if (numero_serie.isEmpty() || direccion.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        // Establecer la conexión a la base de datos
                        Connection connection = DriverManager.getConnection("jdbc:sqlite:/home/INFORMATICA/alu10216074/IdeaProjects/Dropin/src/main/resources/baseDropin", "username", "password");

                        // Preparar la sentencia SQL
                        String insertQuery = "INSERT INTO Contenedores (numero_serie,ayuntamiento, tipos, direccion) VALUES (?,?, ?, ?)";
                        PreparedStatement statement = connection.prepareStatement(insertQuery);
                        statement.setString(1, numero_serie);
                        statement.setString(2,ayuntamiento);
                        statement.setString(3, tipos);
                        statement.setString(4, direccion);

                        // Ejecutar la sentencia
                        int rowsAffected = statement.executeUpdate();

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Contenedor añadido correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                            // Limpiar los campos de entrada después de la inserción exitosa
                            serialNumberTextField.setText("");
                            addressTextField.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo añadir el contenedor.", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                        // Cerrar la conexión y el statement
                        statement.close();
                        connection.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Acción del botón "Atrás"
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ayuntNombre ayuntNombre = new ayuntNombre(getNombre());
                ayuntNombre.setNombre(getNombre());
                ayuntNombre.setVisible(true);
                dispose(); // Cerrar la pantalla actual (AñadirContenedor)
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ayuntContenedor añadirContenedor = new ayuntContenedor("vall");
                añadirContenedor.setNombre("vall");
                añadirContenedor.setVisible(true);
            }
        });
    }
}
