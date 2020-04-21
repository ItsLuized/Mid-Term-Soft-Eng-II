package parcialii.view;


import parcialii.controller.Client;

import javax.swing.*;
import java.awt.*;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Menu {
    private final Icon showPassword = new ImageIcon(new ImageIcon(getClass().getResource("./Images/show_password_Icon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    private final Icon hidePassword = new ImageIcon(new ImageIcon(getClass().getResource("./Images/hide_password_Icon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
    private final Client client = new Client();
    private BigInteger nonce = new BigInteger("0");
    private JFrame menuFrame;
    private JFrame authorizedMenu;
    private boolean registrado = false;
    private String ciudad;

    /*

     */
    public Menu() {
        /*boolean registrado = false;
        char opcion = '9';
        while (opcion != '0') {
            opcion = JOptionPane.showInputDialog("MENU\n" +
                    "1. Registrarse\n" +
                    "2. Ingresar\n" +
                    "0. Salir").charAt(0);

            switch (opcion) {
                case '1':
                    this.registrar();
                    registrado = true;
                    break;
                case '2':
                    if (!registrado) {
                        JOptionPane.showMessageDialog(null, "Debe registrarse primero", "Error", JOptionPane.ERROR_MESSAGE);
                    } else
                        this.ingresar();
                    break;
                case '0':
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion Invalida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }*/

        this.menuPrincipal();
    }

    public void menuPrincipal() {


        // Create Frame
        menuFrame = new JFrame("Menu Principal");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create Frame
        JPanel panel = new JPanel();
        // Set border for the panel
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        JButton registrarse = new JButton("Registro");
        registrarse.addActionListener(e -> {
            this.registrar();
            menuFrame.setVisible(false);
            //this.registrado = true;
        });

        JButton ingresar = new JButton("Ingresar");
        ingresar.addActionListener(e -> {
            //if (registrado) {
                this.ingresar();
                menuFrame.setVisible(false);
            //} else
             //   JOptionPane.showMessageDialog(menuFrame, "Debe registrarse primero", "Advertencia", JOptionPane.WARNING_MESSAGE);
        });

        JButton salir = new JButton("Salir");
        salir.addActionListener(e -> System.exit(0));

        JLabel menu = new JLabel("MENU");
        // Layout for the frame
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // add stuff to the panel
        gbc.gridy = 0;
        panel.add(menu, gbc);

        gbc.gridy = 1;
        panel.add(Box.createVerticalStrut(10), gbc);

        gbc.gridy = 2;
        panel.add(registrarse, gbc);

        gbc.gridy = 3;
        panel.add(Box.createVerticalStrut(10), gbc);

        gbc.gridy = 4;
        panel.add(ingresar, gbc);

        gbc.gridy = 5;
        panel.add(Box.createVerticalStrut(10), gbc);

        gbc.gridy = 6;
        panel.add(salir, gbc);
        // Add panel to frame
        menuFrame.add(panel, BorderLayout.CENTER);

        menuFrame.setMinimumSize(menuFrame.getMinimumSize());
        ;
        // Set frame size
        menuFrame.setPreferredSize(new Dimension(400, 400));
        menuFrame.setResizable(false);
        // Pack the frame
        menuFrame.pack();
        // Make the frame appear on the center
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setVisible(true);
    }

    public void registrar() {

        JFrame registerFrame = new JFrame("Registro");
        registerFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        JLabel nameLabel = new JLabel("Nombre: ");
        JLabel emailLabel = new JLabel("Email: ");
        JLabel passwordLabel = new JLabel("Contraseña: ");
        JLabel direccionLabel = new JLabel("Direccion: ");
        JLabel telefonoLabel = new JLabel("Telefono: ");
        JLabel ciudadLabel = new JLabel("Ciudad: ");

        JTextField nameField = new JTextField(20);
        JTextField emailField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JTextField direccionField = new JTextField(20);
        JTextField telefonoField = new JTextField(20);
        JTextField ciudadField = new JTextField(20);

        JButton registerButton = new JButton("Registrarse");
        JButton salirButton = new JButton("Regresar");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(emailLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(passwordLabel, gbc);


        passwordField.setLayout(new BorderLayout());
        //Display password
        JCheckBox displayPassword = new JCheckBox();
        displayPassword.setFocusable(false);
        displayPassword.setIcon(showPassword);
        displayPassword.setSelected(false);
        displayPassword.addActionListener(e -> {
            if (displayPassword.isSelected()) {
                displayPassword.setIcon(hidePassword);
                passwordField.setEchoChar((char) 0);
            } else {
                displayPassword.setIcon(showPassword);
                passwordField.setEchoChar('*');
            }
        });
        displayPassword.setBackground(Color.WHITE);
        passwordField.add(displayPassword, BorderLayout.EAST);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(passwordField, gbc);


        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(direccionLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(direccionField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(telefonoLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(telefonoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(ciudadLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(ciudadField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;

        panel.add(Box.createVerticalStrut(10), gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        panel.add(registerButton, gbc);

        gbc.gridy = 8;
        panel.add(Box.createVerticalStrut(20));

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        panel.add(salirButton, gbc);

        registerFrame.add(panel, BorderLayout.CENTER);
        // Set frame size
        registerFrame.setPreferredSize(new Dimension(400, 400));
        registerFrame.setResizable(false);
        // Pack the frame
        registerFrame.pack();
        // Make the frame appear on the center
        registerFrame.setLocationRelativeTo(null);
        registerFrame.setVisible(true);

        // =================== Action Listeners ===================

        registerButton.addActionListener(e -> {
            String email = emailField.getText().toLowerCase();
            String password = new String(passwordField.getPassword());
            String nombre = nameField.getText();
            String direccion = direccionField.getText();
            String telefono = telefonoField.getText();
            String ciudad = ciudadField.getText();

            if (!email.equals("") || !password.equals("") || !nombre.equals("") || !direccion.equals("") || !telefono.equals("") || !ciudad.equals("")) {
                if (!email.contains("@")) {
                    JOptionPane.showMessageDialog(null, "El correo debe tener un '@'");
                    emailField.setText("");
                } else {
                    String response = this.client.registerUser(email, password);
                    JOptionPane.showMessageDialog(null, response, "Exito", JOptionPane.INFORMATION_MESSAGE);
                    this.registrado = true;
                    this.menuFrame.setVisible(true);
                    registerFrame.dispose();
                }

            } else
                JOptionPane.showMessageDialog(registerFrame, "No pueden haber campos vacios", "Aviso", JOptionPane.WARNING_MESSAGE);

        });

        salirButton.addActionListener(e -> {
            menuFrame.setVisible(true);
            registerFrame.dispose();
        });

        /*String email = "";
        String password = "";
        String nombre = "";
        String direccion = "";
        String telefono = "";
        String ciudad = "";


        while (email.equals("")) {
            email = JOptionPane.showInputDialog("Ingrese su correo electronico:");
            if (!email.contains("@")) {
                JOptionPane.showMessageDialog(null, "El correo debe tener un '@'");
                email = "";
            }
        }

        while (password.equals("")) {
            JPanel panel = new JPanel();
            JLabel label = new JLabel("Enter a password:");
            JPasswordField pass = new JPasswordField(20);
            panel.add(label);
            panel.add(pass);
            int button = JOptionPane.showConfirmDialog(null, panel, "Password", JOptionPane.OK_CANCEL_OPTION);

            if (button == JOptionPane.OK_OPTION) {
                password = new String(pass.getPassword());
            } else return;
            if (password == "") {
                JOptionPane.showMessageDialog(null, "No puede haber una contraseña vacia.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        while (nombre.equals("")) {
            nombre = JOptionPane.showInputDialog("Cual es su nombre?");
        }

        while (direccion.equals("")) {
            direccion = JOptionPane.showInputDialog("Cual es su direccion?");
        }

        while (telefono.equals("")) {
            telefono = JOptionPane.showInputDialog("Cual es su numero de telefono?");
        }

        while (ciudad.equals("")) {
            ciudad = JOptionPane.showInputDialog("Donde vive?");
        }

        String response = this.client.registerUser(email, password, nombre, direccion, telefono, ciudad);
        JOptionPane.showMessageDialog(null, response, "Exito", JOptionPane.INFORMATION_MESSAGE);
         */
    }

    public void ingresar() {

        JFrame loginFrame = new JFrame("Registro");
        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panelLogin = new JPanel();
        panelLogin.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        //label Email
        JLabel emailLabel = new JLabel("Email: ");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelLogin.add(emailLabel, gbc);

        // Email TextField
        JTextField emailInput = new JTextField(20);
        emailInput.setBounds(100, 20, 165, 25);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panelLogin.add(emailInput, gbc);

        // Password Label
        JLabel passwordLabel = new JLabel("Password: ");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelLogin.add(passwordLabel, gbc);

        // Email TextField
        JPasswordField passwordInput = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        passwordInput.setLayout(new BorderLayout());
        //Display password
        JCheckBox displayPassword = new JCheckBox();
        displayPassword.setFocusable(false);
        displayPassword.setIcon(showPassword);
        displayPassword.setSelected(false);
        displayPassword.addActionListener(e -> {
            if (displayPassword.isSelected()) {
                displayPassword.setIcon(hidePassword);
                passwordInput.setEchoChar((char) 0);
            } else {
                displayPassword.setIcon(showPassword);
                passwordInput.setEchoChar('*');
            }
        });
        displayPassword.setBackground(Color.WHITE);

        passwordInput.add(displayPassword, BorderLayout.EAST);
        panelLogin.add(passwordInput, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panelLogin.add(Box.createVerticalStrut(10), gbc);

        // Login Button
        JButton loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panelLogin.add(loginButton, gbc);

        gbc.gridy = 4;
        panelLogin.add(Box.createVerticalStrut(10));

        JButton salirButton = new JButton("Regresar");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panelLogin.add(salirButton, gbc);


        panelLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelLogin.setAlignmentY(Component.CENTER_ALIGNMENT);

        loginFrame.add(panelLogin, BorderLayout.CENTER);
        loginFrame.setPreferredSize(new Dimension(400, 400));
        loginFrame.setResizable(false);
        loginFrame.getRootPane().setDefaultButton(loginButton);
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);

        // ========================== Action Listeners  ==========================

        loginButton.addActionListener(e -> {
            String email = emailInput.getText().toLowerCase();
            String password = new String(passwordInput.getPassword());

            //Check if Email is correctly written
            if (email.equals("")) {
                JOptionPane.showMessageDialog(loginFrame, "Correo no puede estar vacio");
            } else if (!email.contains("@")) {
                JOptionPane.showMessageDialog(null, "El correo debe tener un '@'");
            }

            // Check that password is not null
            if (password.equals("")) {
                JOptionPane.showMessageDialog(loginFrame, "Contraseña no puede estar vacia");
            }

            // If email and password fields are filled
            if (!password.equals("") || !email.equals("")) {

                try {
                    this.nonce = this.client.accederSistema(email, password, this.getIP());
                    System.out.println(nonce);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                if (!nonce.equals(BigInteger.ZERO)) {
                    loginFrame.dispose();
                    this.authorizedMenu();
                } else {
                    emailInput.setText("");
                    passwordInput.setText("");
                    JOptionPane.showMessageDialog(loginFrame, "Login Fallido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        salirButton.addActionListener(e -> {
            this.menuFrame.setVisible(true);
            loginFrame.dispose();
        });


        /*while (email.equals("")) {
            email = JOptionPane.showInputDialog("Ingrese su correo electronico:");
            if (!email.contains("@")) {
                JOptionPane.showMessageDialog(null, "El correo debe tener un '@'");
                email = "";
            }
        }

        while (password.equals("")) {
            JPanel panel = new JPanel();
            JLabel label = new JLabel("Ingrese una contraseña:");
            JPasswordField pass = new JPasswordField(20);
            panel.add(label);
            panel.add(pass);
            int button = JOptionPane.showConfirmDialog(null, panel, "Password", JOptionPane.OK_CANCEL_OPTION);

            if (button == JOptionPane.OK_OPTION) {
                password = new String(pass.getPassword());
            } else return;
            if (password.equals("")) {
                JOptionPane.showMessageDialog(null, "No puede haber una contraseña vacia.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        try {
            this.nonce = this.client.accederSistema(email, password, this.getIP());
            System.out.println(nonce);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!nonce.equals(BigInteger.ZERO))
            this.authorizedMenu();
         */
    }

    public void authorizedMenu() {

        authorizedMenu = new JFrame("Menu Autorizado");
        authorizedMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JButton crearBus = new JButton("Crear Bus");
        JButton verRutas = new JButton("Ver Rutas");
        JButton buscarPersonaZona = new JButton("Buscar Persona Por Ciudad");
        JButton salir = new JButton("Salir");

        gbc.gridy = 0;
        panel.add(crearBus, gbc);

        gbc.gridy = 1;
        panel.add(Box.createVerticalStrut(10), gbc);

        gbc.gridy = 2;
        panel.add(verRutas, gbc);

        gbc.gridy = 3;
        panel.add(Box.createVerticalStrut(10), gbc);

        gbc.gridy = 4;
        panel.add(buscarPersonaZona, gbc);

        gbc.gridy = 5;
        panel.add(Box.createVerticalStrut(10), gbc);

        gbc.gridy = 6;
        panel.add(salir, gbc);

        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setAlignmentY(Component.CENTER_ALIGNMENT);

        authorizedMenu.add(panel, BorderLayout.CENTER);
        authorizedMenu.setPreferredSize(new Dimension(400, 400));
        authorizedMenu.setResizable(false);
        authorizedMenu.pack();
        authorizedMenu.setLocationRelativeTo(null);
        authorizedMenu.setVisible(true);

        // ========================== Action Listeners ==========================

        crearBus.addActionListener(e -> {
            this.crearBus();
            this.authorizedMenu.setVisible(false);
        });

        verRutas.addActionListener(e -> {
            this.verRutas();
            this.authorizedMenu.setVisible(false);
        });

        buscarPersonaZona.addActionListener(e -> {
            this.buscarPersonaZona();
            this.authorizedMenu.setVisible(false);
        });

        salir.addActionListener(e -> {
            this.menuFrame.setVisible(true);
            this.authorizedMenu.dispose();
        });

        /*char opcion = '9';

        while (opcion != '0') {
            opcion = JOptionPane.showInputDialog(null, "Que quiere hacer:\n" +
                    "1. Crear un Bus\n" +
                    "2. Ver las rutas\n" +
                    "3. Buscar persona por zonas\n" +
                    "0. Salir").charAt(0);

            switch (opcion) {
                case '1':
                    this.crearBus();
                    break;
                case '2':
                    this.verRutas();
                    break;
                case '3':
                    this.buscarPersonaZona();
                    break;
                case '0':
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion Invalida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }*/
    }

    public void crearBus() {

        JFrame crearBus = new JFrame("Crear Bus");
        crearBus.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        crearBus.setPreferredSize(new Dimension(400, 400));
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel conductorLabel = new JLabel("Conductor: ");
        JLabel rutaLabel = new JLabel("Ruta: ");
        JLabel placaLabel = new JLabel("Placa: ");
        JLabel capacidadLabel = new JLabel("Capacidad: ");
        JLabel marcaLabel = new JLabel("Marca del Bus: ");

        JTextField conductorField = new JTextField(10);
        JTextField rutaField = new JTextField(10);
        JTextField placaField = new JTextField(10);
        JTextField capacidadField = new JTextField(10);
        JTextField marcaField = new JTextField(10);

        JButton crear = new JButton("Crear");
        JButton regresar = new JButton("Regresar");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(conductorLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(conductorField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(rutaLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(rutaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(placaLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(placaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(capacidadLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(capacidadField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(marcaLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(marcaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(crear, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        panel.add(regresar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panel.add(Box.createVerticalStrut(15), gbc);
        crearBus.add(panel, BorderLayout.CENTER);
        crearBus.setResizable(false);
        crearBus.pack();
        crearBus.setLocationRelativeTo(null);
        crearBus.setVisible(true);

        // ========================== Action Listeners ==========================

        crear.addActionListener(e -> {
            String conductor = conductorField.getText();
            String ruta = rutaField.getText();
            String placa = placaField.getText();
            String marca = marcaField.getText();
            String capacidadTemp = capacidadField.getText();
            int capacidad = 0;

            if (conductor.equals("") || ruta.equals("") || placa.equals("") || marca.equals("") || capacidadTemp.equals("")) {
                JOptionPane.showMessageDialog(crearBus, "No pueden haber campos vacios.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                try {
                    capacidad = Integer.parseInt(capacidadTemp);
                    String nombreMetodo = "crearBus," + conductor + "," + ruta + "," + placa + "," + capacidad + "," + marca;
                    try {
                        this.client.elaborarOperacion(nombreMetodo, /*Changed from nonce to IP*/this.getIP());
                        this.authorizedMenu.setVisible(true);
                        crearBus.dispose();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(crearBus, "La capacidad no puede tener letras.", "Error", JOptionPane.ERROR_MESSAGE);
                    capacidadField.setText("");
                    exception.printStackTrace();
                }

            }
        });

        regresar.addActionListener(e -> {
            this.authorizedMenu.setVisible(true);
            crearBus.dispose();
        });


        /*String conductor = JOptionPane.showInputDialog("Quien es el conductor del bus?");
        String ruta = JOptionPane.showInputDialog("Cual es la ruta del bus?");
        String placa = JOptionPane.showInputDialog("Cual es la placa del bus?");
        String marca = JOptionPane.showInputDialog("Cual es la marca del bus?");
        int capacidad = 0;
        boolean valido = false;
        while (!valido) {
            try {
                String temp = JOptionPane.showInputDialog("Cual es la capacidad del bus?");
                if (temp == null) {
                    break;
                } else
                    capacidad = Integer.parseInt(temp);
                valido = true;
            } catch (NumberFormatException e) {
                capacidad = 0;
                valido = false;
                JOptionPane.showMessageDialog(null, "La capacidad no puede tener letras.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }

        String nombreMetodo = "crearBus," + conductor + "," + ruta + "," + placa + "," + capacidad + "," + marca;
        try {
            this.client.elaborarOperacion(nombreMetodo, nonce);
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
    }

    public void verRutas() {
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JTextArea resultado = new JTextArea();
        resultado.setEditable(false);
        resultado.setBackground(new Color(238, 238, 238));
        resultado.setForeground(Color.BLACK);
        JButton ok = new JButton("Ok");

        gbc.gridy = 0;
        panel.add(resultado, gbc);

        gbc.gridy = 1;
        panel.add(Box.createVerticalStrut(20), gbc);

        gbc.gridy = 2;
        panel.add(ok, gbc);

        String nombreMetodo = "verRutas";
        String res = "";
        try {
            res = (String) this.client.elaborarOperacion(nombreMetodo, /*Changed from nonce to IP*/this.getIP());
            if (!res.equals("")) {
                //JOptionPane.showMessageDialog(null, res, "Ver Rutas", JOptionPane.PLAIN_MESSAGE);
                frame.setTitle("Ver Rutas");
                res = res.replaceAll(",", "\n");
                resultado.setText(res);
            } else {
                //JOptionPane.showMessageDialog(null, "No hay buses creados.", "Error", JOptionPane.ERROR_MESSAGE);
                frame.setTitle("Error");
                resultado.setText("No hay buses creados.");
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No se pudieron obtener las rutas.", "Error", JOptionPane.ERROR_MESSAGE);
            frame.setTitle("Error");
            resultado.setText("No se pudieron obtener las rutas.");
            e.printStackTrace();
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        ok.addActionListener(e -> {
            this.authorizedMenu.setVisible(true);
            frame.dispose();
        });

    }

    public void buscarPersonaZona() {
        ciudad = "";
        JFrame frame = new JFrame("Buscar Persona Por Zona");
        JPanel pregunta = new JPanel();
        pregunta.setVisible(true);
        pregunta.setLayout(new GridBagLayout());
        GridBagConstraints gbcPregunta = new GridBagConstraints();
        JTextArea preguntaText = new JTextArea();
        preguntaText.setEditable(false);
        preguntaText.setBackground(new Color(238, 238, 238));
        preguntaText.setForeground(Color.BLACK);
        JTextField ciudadInput = new JTextField(10);
        JButton aceptar = new JButton("Buscar");
        JButton salir = new JButton("regresar");

        gbcPregunta.gridy = 0;
        gbcPregunta.gridx = 0;
        pregunta.add(preguntaText, gbcPregunta);

        gbcPregunta.gridy = 0;
        gbcPregunta.gridx = 1;
        pregunta.add(ciudadInput, gbcPregunta);

        gbcPregunta.gridx = 0;
        gbcPregunta.gridy = 1;
        pregunta.add(Box.createVerticalStrut(10), gbcPregunta);

        gbcPregunta.gridy = 2;
        gbcPregunta.gridx = 0;
        gbcPregunta.gridwidth = 2;
        pregunta.add(aceptar, gbcPregunta);

        gbcPregunta.gridx = 0;
        gbcPregunta.gridy = 3;
        pregunta.add(Box.createVerticalStrut(10), gbcPregunta);

        gbcPregunta.gridy = 4;
        gbcPregunta.gridx = 0;
        gbcPregunta.gridwidth = 2;
        pregunta.add(salir, gbcPregunta);

        preguntaText.setText("Ciudades existentes:\n" + this.client.getZonas() + "\nMostrar las personas de que ciudad?");



        frame.add(pregunta, BorderLayout.CENTER);
        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(400, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        aceptar.addActionListener(e -> {
            ciudad = ciudadInput.getText();
            if (!ciudad.equals("")) {
                if (this.client.existeZona(ciudad)) {

                    try {
                        String res;
                        String nombreMetodo = "buscarPersonaZona," + ciudad;
                        res = (String) this.client.elaborarOperacion(nombreMetodo, /*Changed from nonce to IP*/ this.getIP());
                        this.mostrarPersonas(res);
                        frame.dispose();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

                }else{
                    ciudadInput.setText("");
                    JOptionPane.showMessageDialog(frame, "No existe la ciudad solicitada");
                }
            } else {
                ciudadInput.setText("");
                JOptionPane.showMessageDialog(frame, "No puede haber campos vacios");
            }
        });

        salir.addActionListener(e -> {
            this.authorizedMenu.setVisible(true);
            frame.dispose();
        });

    }

    public void mostrarPersonas(String res) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JTextArea respuestaField = new JTextArea();
        respuestaField.setBackground(new Color(238, 238, 238));
        JButton ok = new JButton("Ok");

        gbc.gridy = 0;
        panel.add(respuestaField, gbc);

        gbc.gridy = 1;
        panel.add(Box.createVerticalStrut(10), gbc);

        gbc.gridy = 2;
        panel.add(ok, gbc);

        if (!res.equals("")) {
            //JOptionPane.showMessageDialog(null, res, "Personas por zona", JOptionPane.INFORMATION_MESSAGE);
            frame.setTitle("Personas por zona");
            respuestaField.setText(res.replaceAll(",", "\n"));
        } else {
            //JOptionPane.showMessageDialog(null, "No se pudieron No se pudieron obtener las personas.", "Error",  JOptionPane.ERROR_MESSAGE);
            frame.setTitle("Error");
            respuestaField.setText("No se pudieron No se pudieron obtener las personas.");
        }

        respuestaField.setEditable(false);
        frame.add(panel, BorderLayout.CENTER);
        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(400, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        ok.addActionListener(e -> {
            this.authorizedMenu.setVisible(true);
            frame.dispose();
        });

    }

    public String getIP() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostAddress();
    }

}
