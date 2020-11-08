 package Principal;

import java.awt.event.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.*;


public class Abs extends JFrame implements ActionListener//Case abs con accion listener 
{
 JFrame contenedor5=new JFrame();
 JLabel texto1=new JLabel();
 JLabel texto2=new JLabel();
 JLabel texto3=new JLabel();
 JLabel texto4=new JLabel();
 JLabel texto5=new JLabel();
 
 JFormattedTextField txtCantidadSeries= new JFormattedTextField();
 JFormattedTextField txtRepePorSerie= new JFormattedTextField();
 JFormattedTextField txtTiempoEjercicio= new JFormattedTextField();
 JFormattedTextField txtPesoperso= new JFormattedTextField(); 

 JButton boton1=new JButton();
 JButton boton2=new JButton();
 JButton boton3=new JButton();
 JButton botonCalcular=new JButton();
 JButton Salir=new JButton();


  
 protected int tiempoab,pesoab,cantiRepeSerieAb,cantSeriesAb; 
 protected double met,seriestotal,totalMet,unidadcalorica,MetCaloricoLeve,MetCaloricoMedio,MetCaloricoAvanzado;
 DecimalFormat decimales = new DecimalFormat("0.00");
 
 boolean confirmarbotonAbs=false;
 boolean confirmarAbs=false;
 
 public void VentanaAbdominales()
 {
      ConfigurarVentana();
      ConfigurarComponentes();
      ConfigurarBotones();
      confirmarAbs=true;
 }
 
 public void ConfigurarVentana()//componentes de la clase calcular Abs
  {     
        contenedor5.setLayout(null);
        contenedor5.setVisible(true);
        contenedor5.setBounds(800,400,510,600);
        contenedor5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
 
 public void ConfigurarComponentes()//congira componenetes de la ventana
  {      
        texto1.setLayout(null);
        texto1.setVisible(true);
        texto1.setBounds(150,0,200,30);
        texto1.setText("<html>Digite la cantidad de series:<html>");
        
        txtCantidadSeries.setLayout(null);
        txtCantidadSeries.setVisible(true);
        txtCantidadSeries.setBounds(201,32,120,30);
        
        texto2.setLayout(null);
        texto2.setVisible(true);
        texto2.setBounds(150,65,240,30);
        texto2.setText("<html>Digite la repeticiones por cada serie:<html>");
        
        txtRepePorSerie.setLayout(null);
        txtRepePorSerie.setVisible(true);
        txtRepePorSerie.setBounds(201,92,120,30);
        
        texto3.setLayout(null);
        texto3.setVisible(true);
        texto3.setBounds(120,130,380,30);
        texto3.setText("<html>Digite el tiempo que tomo completar el ejercicio en minutos<html>");
        
        txtTiempoEjercicio.setLayout(null);
        txtTiempoEjercicio.setVisible(true);
        txtTiempoEjercicio.setBounds(201,160,120,30);
        
        texto4.setLayout(null);
        texto4.setVisible(true);
        texto4.setBounds(190,195,380,30);
        texto4.setText("<html>Digite su peso en kilos<html>");
        
        txtPesoperso.setLayout(null);
        txtPesoperso.setVisible(true);
        txtPesoperso.setBounds(201,220,120,30);
            
        contenedor5.add(texto1);
        contenedor5.add(txtCantidadSeries);
        contenedor5.add(texto2);
        contenedor5.add(txtRepePorSerie);
        contenedor5.add(texto3);
        contenedor5.add(txtTiempoEjercicio);
        contenedor5.add(texto4);
        contenedor5.add(txtPesoperso);
   }
 
 public void ConfigurarBotones()//configura los botones de la ventana
   {         
        
        texto5.setLayout(null);
        texto5.setVisible(true);
        texto5.setBounds(180,210,220,220);
        texto5.setText("<html>Pinche la intensidad del ejercicio: <p>1.Leve <p>2.Moderada <p>3.Intenso<html>");
        
        boton1.setLayout(null);
        boton1.setVisible(true);
        boton1.setText("Opcion 1"); 
        boton1.setBounds(201,370,120,20);
        boton1.addActionListener(this);
        
        boton2.setLayout(null);
        boton2.setVisible(true);
        boton2.setText("Opcion 2");  
        boton2.setBounds(201,400,120,20);
        boton2.addActionListener(this);
        
        boton3.setLayout(null);
        boton3.setVisible(true);
        boton3.setText("Opcion 3");    
        boton3.setBounds(201,430,120,20);
        boton3.addActionListener(this);
        
        botonCalcular.setLayout(null);
        botonCalcular.setVisible(true);
        botonCalcular.setText("Calcular");
        botonCalcular.setBounds(201,510,120,20);
        botonCalcular.addActionListener(this);
        
        Salir.setLayout(null);
        Salir.setVisible(true);
        Salir.setText("Salir");
        Salir.setBounds(201,540,120,20);
        Salir.addActionListener(this);

        contenedor5.add(texto5);
        contenedor5.add(boton1);
        contenedor5.add(boton2);
        contenedor5.add(boton3);
        contenedor5.add(botonCalcular);
        contenedor5.add(Salir); 
      
  }  

    public void getResultados()//metodo que muestra los resultados de clase Abs
     {
       JOptionPane.showMessageDialog(null,"<html>Tu peso: <html>"+getPesoAbs()+"<html><p>Cantidad de series hechas:<html>"+getSeriesAbs()+" series"+"<html><p>Cantidad abdominales hechos: <html>"+getCantiAbs()+" por serie"+"<html><p>Tiempo que te tomo hacer el ejercicio: <html>"+getTiempoAbs()+"min"+"<html><p><p>Cantidad de calorias que quemastes por concepto de:<html>"+"<html><p><p>Total de calorias quemadas en <html>"+getTiempoAbs()+"min: "+getcalcularGastoMet()+"<html><p>Total calorias consumidas por serie: <html>"+getcalcularGastoSerie()+" Calorias" +"<html><p>Total calorias consumidas por entrenamiento:<html>"+getcalcularGastototalMet()+" Calorias"); 
     }
    
    public int getTiempoAbs()//metodo obtener tiempo
     {
       return tiempoab;
     }
    
    public int getPesoAbs()//metodo obtener peso
     {
       return this.pesoab; 
     }       
    
    public int getCantiAbs()//metodo obtener cantidad abs
     {
       return this.cantiRepeSerieAb; 
     }
    
    public int getSeriesAbs()//metodo obtener series abs
     {
       return this.cantSeriesAb;
     } 

    public String getcalcularGastoSerie()//calcula el gasto calorico por el total de series
     {
       this.seriestotal=(this.cantiRepeSerieAb*this.unidadcalorica);
       return decimales.format(this.seriestotal);
     } 
    
    public String getcalcularGastoMet()//metodo obtener imc
     {
      return decimales.format(this.met);
     }       
    
    public void setcalcularGastoMet()//calcula el gasto calorico 
     {
       this.met=(this.unidadcalorica*this.pesoab)*this.tiempoab;
     }
    
    public String getcalcularGastototalMet()//calcula el promedio de gasto calorico total 
     {
       this.totalMet=(this.seriestotal*this.cantSeriesAb);
       return decimales.format(this.totalMet);
     } 
    
    public void setAbs(int tiempoab, int pesoab, double met, int cantidadab, int seriesab, double seriestotal, double totalMet)//objeto para crear apuntadores
     { 
       this.cantSeriesAb=seriesab; 
       this.cantiRepeSerieAb=cantidadab;
       this.tiempoab = tiempoab;
       this.pesoab=pesoab;
       this.met=met;
       this.seriestotal=seriestotal; 
       this.totalMet=totalMet;     
     } 
    
   public void CrearArchivo()//crar archivo texto abs
    {  
      Calendar fecha=new GregorianCalendar(); 
      int ano=fecha.get(Calendar.YEAR);
      int mes=fecha.get(Calendar.MONTH);
      int dia = fecha.get(Calendar.DAY_OF_MONTH);
      int minuto = fecha.get(Calendar.MINUTE);
      
      File archivoAbs = new File("Abs.txt");
      BufferedWriter EscribirEnAbs;
      
      if(archivoAbs.exists())//si no existe el archivo
       {
        try
           {         
               EscribirEnAbs=new BufferedWriter(new FileWriter(archivoAbs,true));
               EscribirEnAbs.newLine();
               EscribirEnAbs.write("Year:"+ano+"-"+"Month:"+mes+"-"+"Day:"+dia+"-"+"Minute:"+minuto);
               EscribirEnAbs.newLine();
               EscribirEnAbs.write("Tu peso:"+getPesoAbs()+" - "+"Tu Cantidad de series hechas:"+getSeriesAbs()+" - "+"Tu Cantidad abdominales hechos:"+getCantiAbs()+" - "+"Tiempo que te tomo hacer el ejercicio:"+getTiempoAbs()+" min");
               EscribirEnAbs.newLine();               
               EscribirEnAbs.write("Tu Cantidad de calorias que quemastes por concepto de:");
               EscribirEnAbs.newLine();
               EscribirEnAbs.write("Tiempo entrenado:" +getcalcularGastoMet()+" - "+"Cada repeticion de cada serie:"+getcalcularGastoSerie()+" - "+"Un promedio total de calorias quemadas en este entrenamiento:"+getcalcularGastototalMet());
               EscribirEnAbs.newLine();
               EscribirEnAbs.close();            
           }catch(Exception e)
              {
               JOptionPane.showMessageDialog(null,"No se pudo abrir o crear el arvhivo, excepcion:"+e);    
              }
        }else//si no existe el archivo
           {
             try
                {  
                  EscribirEnAbs=new BufferedWriter(new FileWriter(archivoAbs,true));
                  EscribirEnAbs.newLine();
                  EscribirEnAbs.write("Year:"+ano+"-"+"Month:"+mes+"-"+"Day:"+dia+"-"+"Minute:"+minuto);
                  EscribirEnAbs.newLine();
                  EscribirEnAbs.write("Tu peso:"+getPesoAbs()+" - "+"Tu Cantidad de series hechas:"+getSeriesAbs()+" - "+"Tu Cantidad abdominales hechos:"+getCantiAbs()+" - "+"Tiempo que te tomo hacer el ejercicio:"+getTiempoAbs()+" min");
                  EscribirEnAbs.newLine();               
                  EscribirEnAbs.write("Tu Cantidad de calorias que quemastes por concepto de:");
                  EscribirEnAbs.newLine();
                  EscribirEnAbs.write("Tiempo entrenado:" +getcalcularGastoMet()+" - "+"Cada repeticion de cada serie:"+getcalcularGastoSerie()+" - "+"Un promedio total de calorias quemadas en este entrenamiento:"+getcalcularGastototalMet());
                  EscribirEnAbs.newLine();
                  EscribirEnAbs.close();
                }catch(Exception e)
                   {
                    JOptionPane.showMessageDialog(null,"No se pudo abrir o crear el arvhivo, excepcion:"+e); 
                   }   
           } 
       
    }   
    
    
    public void getCloseWindow()//objeto general para cerrar la ventana abs
     {
       contenedor5.dispose();
       contenedor5.setVisible(false); 
     }     

 @Override
    public void actionPerformed(ActionEvent EventoAbs)//objeto que permite decidir el vaor de las unidades caloricas segun intensidad
     {
      
       if ((EventoAbs.getSource()==boton1)&&confirmarAbs==true)
         {
             MetCaloricoLeve=5.5;
             unidadcalorica=MetCaloricoLeve*0.0175;
             confirmarbotonAbs=true;
         }
                 if ((EventoAbs.getSource()==boton2)&&confirmarAbs==true)
                    {
                        MetCaloricoMedio=5.8;
                        unidadcalorica=MetCaloricoLeve*0.0175;
                        confirmarbotonAbs=true;
                     }        
                             if ((EventoAbs.getSource()==boton3)&&confirmarAbs==true)
                                {
                                    MetCaloricoLeve=6.2;
                                    unidadcalorica=MetCaloricoLeve*0.0175;
                                    confirmarbotonAbs=true;
                                }
       
       if (EventoAbs.getSource()==botonCalcular && confirmarbotonAbs==false)
         {
           JOptionPane.showMessageDialog(null,"Debes apretar un boton de intensidad para obtener las calorias gastadas");
         }
           
       if (EventoAbs.getSource()==botonCalcular && confirmarbotonAbs==true)//objeto que obtiene los datos escritos 
         {  
           try{
                this.cantiRepeSerieAb=Integer.parseInt(txtRepePorSerie.getText());
                this.cantSeriesAb=Integer.parseInt(txtCantidadSeries.getText());
                this.tiempoab=Integer.parseInt(txtTiempoEjercicio.getText());
                this.pesoab=Integer.parseInt(txtPesoperso.getText());
                getcalcularGastoSerie();//calcula el gasto calorico por el total de series
                setcalcularGastoMet();
                getcalcularGastoMet();//calcula el gasto calorico
                getcalcularGastototalMet();//calcula el promedio de gasto calorico total 
                getResultados();//metodo que muestra los resultados de clase Abs
                CrearArchivo();//metodo que creara el archivo abs
                                           
               }catch(NumberFormatException exception)
                  {
                    JOptionPane.showMessageDialog(null,"Introduzca solo numeros \nExcepcion-"+ exception);
                  }   
         }
       
       if (EventoAbs.getSource()==Salir)
             {   
                VentanaEleccionPersona llamadaRetorno = new VentanaEleccionPersona();
                llamadaRetorno.VentanaAbs();//metodo para regresar a la ventana principal del programa
                getCloseWindow();//objeto que cerrar la clase abs
             }      
    }  
    
}

