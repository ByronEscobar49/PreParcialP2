package org.example.Formularios;

import javax.swing.*;

public class frmChampionsLeague extends JFrame {

    private JPanel frmChampions;
    private JTextField textFieldIdEquipo;
    private JTextField textFieldnomb;
    private JTextField textFieldpais;
    private JButton button1;
    private JTextField textFieldCiudad;
    private JTextField textFieldestadio;
    private JTextField textFieldfundacion;
    private JTextField textFieldentrenador;
    private JTextField textFieldweb;
    private JTextField textFieldface;
    private JTextField textFieldtwitter;
    private JTextField textFieldinstagram;
    private JTextField textFieldPatrocinador;
    private JTextField textFieldCreado;


        public frmChampionsLeague() {
            // Configuración del formulario secundario
           setTitle( "frmChampionsLeague");
            setSize(700, 400);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);

            // Crear y añadir un mensaje al formulario
            //add(new frmChampionsLeague());
        }


}

