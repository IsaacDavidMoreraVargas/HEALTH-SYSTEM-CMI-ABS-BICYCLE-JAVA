// UNiversidad estatal a distancia
// Proyecto final
// Isaac Morea Vargas
// 116200798 
// Materia 00824
// Grupo: 1

package Principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.exit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Principal extends JFrame implements ActionListener//Ventana principal con accion listener 
{
    private final JFrame contenedor1=new JFrame();
    private final JLabel texto=new JLabel();
    private final JButton boton1=new JButton();
    private final JButton boton2=new JButton();
    private final JButton boton3=new JButton();

    
    public void VentanaPrincipal()
    {
       ConfigurarMensajeVentanaPrincipal();
       ConfigurarVentana();
       ConfigurarBotones();
    }  

    public void ConfigurarMensajeVentanaPrincipal()
     {   
        texto.setLayout(null);
        texto.setVisible(true);
        texto.setBounds(10,1,800,100);
        texto.setText("<html>Elija una opcion: <p>1.Para introducir tus datos personales, Calcular el IMC o actualizarlo <p>2.Para introducir la cantidad de abdominales o ejercicio en bicicleta que has hecho y calcular la quema de calorias <p>3.Salir del programa<p><html>");
     }    
 
    public void ConfigurarVentana()//componenetes de la ventana principal
     {
        contenedor1.setLayout(null);
        contenedor1.setVisible(true);
        contenedor1.setBounds(800,400,770,240);
        contenedor1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }

    public void ConfigurarBotones()
     {       
        boton1.setLayout(null);
        boton1.setVisible(true);
        boton1.setText("Opcion 1");
        boton1.setBounds(300,110,120,20);
        boton1.addActionListener(this);
        
        boton2.setLayout(null);
        boton2.setVisible(true);
        boton2.setText("Opcion 2");
        boton2.setBounds(300,140,120,20);
        boton2.addActionListener(this);
      
        boton3.setLayout(null);
        boton3.setVisible(true);
        boton3.setText("Opcion 3");
        boton3.setBounds(300,170,120,20);
        boton3.addActionListener(this);
       
        contenedor1.add(texto);
        contenedor1.add(boton1);
        contenedor1.add(boton2);
        contenedor1.add(boton3);
     }
    
    public void getCloseWindow()//objeto general para cerrar la ventana principal
     {
       contenedor1.dispose();
       contenedor1.setVisible(false); 
     }       

    @Override
    public void actionPerformed(ActionEvent EventoGeneral) 
    {
        if (EventoGeneral.getSource()==boton1)//evento listener, cierra ventana principal y llama a la clase persona
         {
             VentanaEleccionPersona llamadaVentanaPersona = new VentanaEleccionPersona();
             llamadaVentanaPersona.VentanaPersona();
             getCloseWindow();
             
        }else
        
        if (EventoGeneral.getSource()==boton2)//evento listener, cierra ventana principal y llama a la clase abs
         {      
            VentanaEleccionPersona llamadaVentanaPersona = new VentanaEleccionPersona();
             llamadaVentanaPersona.VentanaAbs();
             getCloseWindow();
            
         }else
        
        if (EventoGeneral.getSource()==boton3)//evento listener, cierra el programa
         {   
            exit(1);
         }
        
    }
    
public static void main(String[] args)
    {       
        Principal llamadaInicio= new Principal();
        llamadaInicio.VentanaPrincipal();
    }       

}



    