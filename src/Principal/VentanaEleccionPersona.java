package Principal;

import Principal.Bicicleta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class VentanaEleccionPersona extends JFrame implements ActionListener//Ventana persona con accion listener 
{
    JFrame contenedor2=new JFrame();
    JLabel texto=new JLabel();
    JButton boton1=new JButton();
    JButton boton2=new JButton();
    JButton boton3=new JButton();
    boolean confirmarPersona=false;
    boolean confirmarAbs=false;
    
 public void VentanaPersona()//metodo que contruye la gui persona
   {
      confirmarPersona=true; 
      ConfigurarVentana();
      ConfigurarMensajeClasePersona();
      ConfigurarBotones();
   } 

  public void ConfigurarVentana()//componenetes de la ventana principal
   {
        contenedor2.setLayout(null);
        contenedor2.setVisible(true);
        contenedor2.setBounds(800,400,410,250);
        contenedor2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }    
 
 public void ConfigurarMensajeClasePersona()//configuracion de los textos de ventana persona
    {      
        texto.setLayout(null);
        texto.setVisible(true);
        texto.setBounds(160,1,750,120);
        texto.setText("<html>Que desea hacer?? <p>1.Calcular Imc <p>2.Actualizar peso <p>3.Salir <html>");
    }   

 public void VentanaAbs()//metodo que contruye la gui abs
   {
      confirmarAbs=true; 
      ConfigurarVentana();
      ConfigurarMensajeClaseAbs();
      ConfigurarBotones();
   }
 
  public void ConfigurarMensajeClaseAbs()//configuracion de los textos de ventana abs
   {
        texto.setLayout(null);
        texto.setVisible(true);
        texto.setBounds(50,1,390,120);
        texto.setText("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Que desea hacer?? <p>1.Quema de calorias con ejercicio abdominal <p>2.Quema de calorias con ejercicio bicicleta <p>3.Salir <html>");
   } 
 
 public void ConfigurarBotones()//configuracion de los botones
   {
        boton1.setLayout(null);
        boton1.setVisible(true);
        boton1.setText("Opcion 1");
        boton1.setBounds(160,100,120,20);
        boton1.addActionListener(this);
        
        boton2.setLayout(null);
        boton2.setVisible(true);
        boton2.setText("Opcion 2");
        boton2.setBounds(160,130,120,20);
        boton2.addActionListener(this);
      
        boton3.setLayout(null);
        boton3.setVisible(true);
        boton3.setText("Opcion 3");
        boton3.setBounds(160,160,120,20);
        boton3.addActionListener(this);
       
        contenedor2.add(texto);
        contenedor2.add(boton1);
        contenedor2.add(boton2);
        contenedor2.add(boton3);   
   }  
 
    public void getCloseWindow()//objeto general para cerrar la ventana persona
     {
       contenedor2.dispose();
       contenedor2.setVisible(false); 
     }
 
    @Override
    public void actionPerformed(ActionEvent EventoPersona)
     {
      if ((EventoPersona.getSource()==boton1)&&confirmarPersona==true)//evento listener, llama a clase persona, calcular imc
         {
           Persona llamada = new Persona();
           llamada.Ventana();
           getCloseWindow();//cierra ventana actual 
         }else
        
        if ((EventoPersona.getSource()==boton2)&&confirmarPersona==true)//evento listener, llama a clase persona, recalcular imc
         {
           Persona llamada = new Persona();
           llamada.VentanaRecalcularIMC();
           getCloseWindow();//cierra ventana actual
         }else
            
      if ((EventoPersona.getSource()==boton1)&&confirmarAbs==true)//evento listener, llama a clase persona, calcular gasto calorico abdominales
         {
           Abs llamada = new Abs();
           llamada.VentanaAbdominales();
           getCloseWindow();//cierra ventana actual 
         }else
        
        if ((EventoPersona.getSource()==boton2)&&confirmarAbs==true)//evento listener, llama a clase hija Bicicleta
         {
           Bicicleta llamada;
           llamada = new Bicicleta();//constructor metodo de llamado a bicicleta
           llamada.ConfirmacionBooleanBicicleta();//aconfirma el alcance correcto a clase bicicleta
           llamada.ConfigurarVentana();//configura ventana bicleta heredando de abs
           llamada.ConfigurarComponentes();//llamado poliformista coponentes de bibicleta
           llamada.ConfigurarBotones();//configura botones bicleta heredando de abs
           llamada.actionPerformed(EventoPersona);//llamado poliformista a eventos boton bibicleta
           getCloseWindow();//cierra ventana actual
           
         }else        

        if (EventoPersona.getSource()==boton3)//evento listener, regresa a ventana principal
         {   
            Principal llamada = new Principal();
            llamada.VentanaPrincipal();
            getCloseWindow();//cierra ventan actual
         }   
     }
    
}
