import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class ayuntNombre extends JFrame {

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ayuntNombre(String nombre) {
        // Configuración de la ventana
        setTitle("Drop-in - Ayuntamiento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);


        //hacemos la consulta a la base de datos
        ArrayList<Integer> sumaContenedores = new ArrayList<>();
        String stringconteo = "";
        int conteo = 0;

        try {
            //C:\Users\Alejandro\IdeaProjects\dropin2-main\Dropin\src\main\resources\baseDropin

            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/baseDropin ", "username", "password");

            String consulta = "SELECT count(numero_serie) from Contenedores Group by ayuntamiento";

            PreparedStatement statement = connection.prepareStatement(consulta);

            ResultSet resultSet = statement.executeQuery();

// Recorrer los resultados
            while (resultSet.next()) {
                // Obtener el valor del conteo
                conteo = resultSet.getInt(1);
                sumaContenedores.add(conteo);


                // Realizar las operaciones necesarias con el valor del conteo
                // Por ejemplo, puedes asignarlo a una variable o utilizarlo para establecer el texto en un JLabel
            }
            // Pasamos por el array
            if (nombre.equals("castellon")) {
                conteo = sumaContenedores.get(0);
                stringconteo = Integer.toString(conteo);
            } else if (nombre.equals("beni")) {
                conteo = sumaContenedores.get(1);
                stringconteo = Integer.toString(conteo);
            } else if (nombre.equals("vila")) {
                conteo = sumaContenedores.get(2);
                stringconteo = Integer.toString(conteo);
            } else if (nombre.equals("vall")) {
                conteo = sumaContenedores.get(3);
                stringconteo = Integer.toString(conteo);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        ImageIcon ayuntamientoImage = new ImageIcon("IMAGES/csss.png");  // Reemplaza "ayuntamiento.jpg" con la ruta de la imagen

        if (nombre.equals("castellon")) {
            ImageIcon ayun = new ImageIcon("IMAGES/csss.png");  // Reemplaza "ayuntamiento.jpg" con la ruta de la imagen
            ayuntamientoImage = ayun;

        } else if (nombre.equals("beni")) {
            ImageIcon ayun = new ImageIcon("IMAGES/beniii.png");  // Reemplaza "ayuntamiento.jpg" con la ruta de la imagen
            ayuntamientoImage = ayun;
        } else if (nombre.equals("vila")) {
            ImageIcon ayun = new ImageIcon("IMAGES/villa.png");  // Reemplaza "ayuntamiento.jpg" con la ruta de la imagen
            ayuntamientoImage = ayun;
        } else if (nombre.equals("vall")) {
            ImageIcon ayun = new ImageIcon("IMAGES/vallA.png");  // Reemplaza "ayuntamiento.jpg" con la ruta de la imagen
            ayuntamientoImage = ayun;
        }

        JLabel containerLabel = new JLabel("Nº de Contenedores:");
        JLabel numeroLabel = new JLabel(stringconteo);


        JButton addButton = new JButton("Añadir");
        JButton listaButton = new JButton("Lista");
        JButton backButton = new JButton("Atrás");

        // Establecer colores personalizados
        Color backgroundColor = new Color(85, 211, 83);
        Color buttonColor = new Color(255, 255, 255);
        Color textColor = new Color(85, 211, 83);

        // Configurar estilo de los componentes
        containerLabel.setForeground(buttonColor);
        numeroLabel.setForeground(buttonColor);
        addButton.setBackground(buttonColor);
        addButton.setForeground(textColor);
        listaButton.setBackground(buttonColor);
        listaButton.setForeground(textColor);
        backButton.setBackground(buttonColor);
        backButton.setForeground(textColor);

        Font labelFont = new Font("Arial", Font.PLAIN, 21);
        Font buttonFont = new Font("Arial", Font.BOLD, 18);
        containerLabel.setFont(labelFont);
        numeroLabel.setFont(labelFont);
        addButton.setFont(buttonFont);
        listaButton.setFont(buttonFont);
        backButton.setFont(buttonFont);

        JLabel imageLabel = new JLabel();
        // Configurar la imagen del ayuntamiento
        Image image = ayuntamientoImage.getImage();
        Image scaledImage = image.getScaledInstance(260, 120, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        imageLabel.setIcon(scaledIcon);

        // Agregar componentes al panel principal
        JPanel panelAyuntamiento = new JPanel(new BorderLayout());
        panelAyuntamiento.setBackground(backgroundColor);
        panelAyuntamiento.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputPanel.setBackground(backgroundColor);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(containerLabel);
        inputPanel.add(numeroLabel);


        panelAyuntamiento.add(imageLabel, BorderLayout.NORTH);
        panelAyuntamiento.add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(backgroundColor);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 0));
        buttonPanel.add(backButton);
        buttonPanel.add(listaButton);
        buttonPanel.add(addButton);

        panelAyuntamiento.add(buttonPanel, BorderLayout.SOUTH);

        add(panelAyuntamiento);

        // Acción del botón "Añadir"
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ayuntContenedor añadirContenedor = new ayuntContenedor(getNombre());
                añadirContenedor.setNombre(getNombre());
                añadirContenedor.setVisible(true);
                dispose(); // Cierra la ventana actual de ayuntNombre
            }
        });

        // Acción del botón "Atrás"
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ayuntLogin mapButtons = new ayuntLogin();
                mapButtons.setVisible(true);
                dispose(); // Cierra la ventana actual de ayuntNombre

            }
        });

        listaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)  {
                try (Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/baseDropin")) {
                    String nombreInt="";
                    if (getNombre().equals("castellon")){
                        nombreInt="1";
                    }
                    else if (getNombre().equals("beni")){
                        nombreInt="2";
                    }
                    else if (getNombre().equals("vila")){
                        nombreInt="3";
                    }
                    else if (getNombre().equals("vall")){
                        nombreInt="4";
                    }


                    String insertQuery = "SELECT * FROM Contenedores where ayuntamiento = ? ";
                    PreparedStatement statement = connection.prepareStatement(insertQuery);
                    statement.setString(1, nombreInt);

                    ResultSet resultSet =statement.executeQuery();


                    BufferedWriter writer = new BufferedWriter(new FileWriter("Contenedores.txt"));

                    while (resultSet.next()) {
                        String columna1 = resultSet.getString("numero_serie");
                        String columna2 = resultSet.getString("ayuntamiento");
                        if (columna2.equals("1")){
                            columna2="Castellon";
                        }
                        else if (columna2.equals("2")){
                            columna2="Benicassim";
                        }
                        else if (columna2.equals("3")){
                            columna2="Vil-lareal";
                        }
                        else if (columna2.equals("4")){
                            columna2="Vall d'uixo";
                        }
                        String columna3 = resultSet.getString("tipos");
                        String columna4 = resultSet.getString("direccion");


                        // Escribe los datos en el archivo
                        writer.write(columna1 + ", " + columna2 +","+ columna3 +", "+columna4 +"\n");
                    }

                    statement.close();

                    writer.close();

                    JOptionPane.showMessageDialog(ayuntNombre.this, "Lista creada", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);

                    File f = new File("Contenedores.txt");
                    try {
                        Desktop.getDesktop().open(f);
                    } catch (IOException g) {
                        g.printStackTrace();
                    }



                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(ayuntNombre.this, "No se pudo conectar", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ayuntNombre app = new ayuntNombre("vall");
                app.setNombre("vall");
                app.setVisible(true);
            }
        });
    }
}
