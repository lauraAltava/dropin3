import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Reciclar extends JFrame {
    JComboBox<String> typesComboBox;
    private Connection connection;
    private int contador = 0;

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Reciclar() {
        // Configurar la pantalla "Reciclar"
        setTitle("Reciclar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 175);
        setLocationRelativeTo(null);



        //tenemos aqui la consulta



        // Crear componentes
        JLabel typesLabel = new JLabel("Tipos:");
        typesComboBox = new JComboBox<>(new String[]{"Vidrio", "Cartón", "Orgánico"});

        // Configurar el renderizador de las opciones del JComboBox
        typesComboBox.setRenderer(new DefaultListCellRenderer() {
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                c.setForeground(Color.BLACK); // Cambiar el color del texto a negro
                return c;
            }
        });

        // Establecer colores personalizados
        Color backgroundColor = new Color(85, 211, 83);
        Color buttonColor = new Color(255, 255, 255);
        Color textColor = new Color(85, 211, 83);

        // Configurar estilo de los componentes
        typesLabel.setForeground(buttonColor);
        typesComboBox.setBackground(buttonColor);
        typesComboBox.setForeground(textColor);

        // Establecer fuente personalizada
        Font labelFont = new Font("Arial", Font.PLAIN, 20);
        Font comboBoxFont = new Font("Arial", Font.PLAIN, 16);
        typesLabel.setFont(labelFont);
        typesComboBox.setFont(comboBoxFont);

        // Crear un panel para contener los componentes
        JPanel recyclePanel = new JPanel(new BorderLayout());
        recyclePanel.setBackground(backgroundColor);
        recyclePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Panel inferior con botones "Atrás" y "Reciclar"
        JPanel lowerPanel = new JPanel(new BorderLayout());
        lowerPanel.setOpaque(false);

        // Botón "Atrás"
        JButton backButton = new JButton("Atrás");
        backButton.setBackground(buttonColor);
        backButton.setForeground(textColor);
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
        lowerPanel.add(backButton, BorderLayout.WEST);

        // Botón "Reciclar"
        JButton recycleButton = new JButton("Reciclar");
        recycleButton.setBackground(buttonColor);
        recycleButton.setForeground(textColor);
        recycleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedType = (String) typesComboBox.getSelectedItem();
                System.out.println(selectedType);

                if (selectedType.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione un tipo de reciclaje.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        // Establecer la conexión a la base de datos
                        connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/baseDropin", "username", "password");
                        String insertQuery = "Update Usuarios set saldo= saldo + 3 where nombre = ?";
                        // Preparar la sentencia SQL
                        if(selectedType.equals("Vidrio")){
                            insertQuery = "Update Usuarios set saldo= saldo + 3 where nombre = ?";
                        }
                        else if (selectedType.equals("Cartón")){
                            insertQuery = "Update Usuarios set saldo= saldo + 2 where nombre = ?";
                        }
                        else if (selectedType.equals("Orgánico")){
                            insertQuery = "Update Usuarios set saldo= saldo + 1 where nombre = ?";
                        }
                        PreparedStatement statement = connection.prepareStatement(insertQuery);
                        statement.setString(1, getNombre());


                        // Ejecutar la inserción
                        int rowsAffected = statement.executeUpdate();

                        System.out.println(rowsAffected);

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Gracias por reciclar.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al registrar el reciclaje.", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                        // Cerrar la conexión y el statement
                        statement.close();
                        connection.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                }




            }
        });
        lowerPanel.add(recycleButton, BorderLayout.EAST);

        // Panel para los componentes superiores
        JPanel componentsPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        componentsPanel.setOpaque(false);
        componentsPanel.add(typesLabel);
        componentsPanel.add(typesComboBox);
        recyclePanel.add(componentsPanel, BorderLayout.NORTH);

        // Agregar paneles al panel principal
        recyclePanel.add(lowerPanel, BorderLayout.SOUTH);

        // Agregar el panel al marco
        add(recyclePanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Reciclar reciclar = new Reciclar();
                reciclar.setVisible(true);
            }
        });
    }
}