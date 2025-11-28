package vista;

import javax.swing.*;

import modelo.Tarea;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vista extends JFrame {
    JButton btnMostrarTodas = new JButton("Mostrar tareas");
    JButton btnMostrarPorId = new JButton("Mostrar por ID");
    JButton btnAgregar = new JButton("Agregar");
    JButton btnEliminar = new JButton("Eliminar");
    JButton btnCompletar = new JButton("Completar");
    private JTextArea areaResultado;
    

    public JButton getBtnCompletar() {
        return btnCompletar;
    }
    
    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }
     
    public JButton getBtnMostrarTodas() {
        return btnMostrarTodas;
    }

    public JTextArea getAreaResultado() {
        return areaResultado;
    }
    public JButton getBtnMostrarPorId() {
        return btnMostrarPorId;
    }

    public Vista() {
        setTitle("Gestor de Tareas");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear el menú
        

        // Panel de botones
        JPanel panelBotones = new JPanel(new GridLayout(1, 5, 5, 5));

        panelBotones.add(btnMostrarTodas);
        panelBotones.add(btnMostrarPorId);
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnCompletar);

        // Área de resultados
        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultado);

        add(panelBotones, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

       
    }


    public String showInput(String texto){
        return JOptionPane.showInputDialog(this, texto);
    }
  

    public void showError(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

   public void showConfirmation(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.INFORMATION_MESSAGE);
    }

}
