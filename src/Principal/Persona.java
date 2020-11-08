package Principal;

import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Persona extends JFrame implements ActionListener//clase persona con accion listener 
 { 
    
 JFrame contenedor3=new JFrame();
 JLabel texto1=new JLabel();
 JLabel texto2=new JLabel();
 JLabel texto3=new JLabel();
 JLabel texto4=new JLabel();
 JFormattedTextField txtedad=new JFormattedTextField();
 JFormattedTextField txtpesoPerso=new JFormattedTextField();
 JFormattedTextField txtestaturaPerso=new JFormattedTextField();
 JFormattedTextField txtRedigiestaturaPerso=new JFormattedTextField();
 JButton botoncalcularIMC=new JButton();
 JButton botonRecalcularIMC=new JButton();
 JButton botonSalirIMC=new JButton();
 
 int edad,pesoPerso,redigitarPeso;
 double estaturaPerso,imc,recalcularImc,comodinRecalcularImc;
 String clasificacionPersonaImc;
 DecimalFormat decimales = new DecimalFormat("0.00");
 
 void Ventana()
   {
      ConfigurarVentana();
      ConfigurarComponentes();  
   } 
 
 void VentanaRecalcularIMC()
   {
      ConfigurarVentana();
      ConfigurarComponentesRecalcularIMC();  
   } 
   
 void ConfigurarVentana()//componentes de la ventana calcular IMC
   {
        contenedor3.setLayout(null);
        contenedor3.setVisible(true);
        contenedor3.setBounds(800,400,510,600);
        contenedor3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
   }
  
 public void ConfigurarComponentes()
   {    
        texto1.setLayout(null);
        texto1.setVisible(true);
        texto1.setBounds(180,0,200,30);
        texto1.setText("<html>Digite su edad en a;os:<html>");
        
        txtedad.setLayout(null);
        txtedad.setVisible(true);
        txtedad.setBounds(201,32,120,30);
        
        texto2.setLayout(null);
        texto2.setVisible(true);
        texto2.setBounds(180,65,200,30);
        texto2.setText("<html>Digite su peso en kilos:<html>");   
        
        txtpesoPerso.setLayout(null);
        txtpesoPerso.setVisible(true);
        txtpesoPerso.setBounds(201,92,120,30);
        
        texto3.setLayout(null);
        texto3.setVisible(true);        
        texto3.setBounds(120,130,320,30);
        texto3.setText("<html>Digite su estatura en metros, Ejem: 1.83:<html>");    
        
        txtestaturaPerso.setLayout(null);
        txtestaturaPerso.setVisible(true);
        txtestaturaPerso.setBounds(201,160,120,30);    
        
        botoncalcularIMC.setLayout(null);
        botoncalcularIMC.setVisible(true);
        botoncalcularIMC.setText("Calcular");
        botoncalcularIMC.setBounds(201,470,120,20);
        botoncalcularIMC.addActionListener(this);    

        botonSalirIMC.setLayout(null);
        botonSalirIMC.setVisible(true);
        botonSalirIMC.setText("Salir");
        botonSalirIMC.setBounds(201,500,120,20);
        botonSalirIMC.addActionListener(this);
       
        contenedor3.add(texto1);
        contenedor3.add(txtedad);
        contenedor3.add(texto2);
        contenedor3.add(txtpesoPerso);
        contenedor3.add(texto3);
        contenedor3.add(txtestaturaPerso);
        contenedor3.add(botoncalcularIMC);
        contenedor3.add(botonSalirIMC);    
  }    
  
        
 public void ConfigurarComponentesRecalcularIMC()
   {      
        texto4.setLayout(null);
        texto4.setVisible(true);
        texto4.setBounds(180,65,200,30);
        texto4.setText("<html>Redigite su peso en kilos:<html>");
        
        txtRedigiestaturaPerso.setLayout(null);
        txtRedigiestaturaPerso.setVisible(true);
        txtRedigiestaturaPerso.setBounds(201,92,120,30);      
        
        botonRecalcularIMC.setText("Calcular");
        botonRecalcularIMC.setLayout(null);
        botonRecalcularIMC.setBounds(201,470,120,20);
        botonRecalcularIMC.addActionListener(this);

        botonSalirIMC.setText("Salir");
        botonSalirIMC.setLayout(null);
        botonSalirIMC.setBounds(201,500,120,20);
        botonSalirIMC.addActionListener(this);         
        
        contenedor3.add(texto4);
        contenedor3.add(txtRedigiestaturaPerso);
        contenedor3.add(botonRecalcularIMC);
        contenedor3.add(botonSalirIMC);              
   }     
   
   public String getTablaImcConFormato()
   { 
     String MensajeTabla="<html>TABLA IMC<p>Menos al normal: -18.5 <p>Normal: 18.5-24.9 <p>Superior al normal: 25.0-29.9 <p>Obesidad: 30.0+<html>";
     return MensajeTabla;
   } 
   
   public String getTablaImcTextoSinFormato()
   { 
     String MensajeTablaTexto="TABLA IMC ---- Menos al normal: -18.5 ---- Normal: 18.5-24.9 ---- Superior al normal: 25.0-29.9 ----- Obesidad: 30.0+";
     return MensajeTablaTexto;   
   }
 
   public String getClasificacionIMC()
    {
     return clasificacionPersonaImc;
    }      
   
   public void setClasificacionIMC()//metodo para calcular clasificacion IMC
     {
        if(this.imc<18.5)
         {
           clasificacionPersonaImc="Inferior al Normal,Porfavor preste atencion";
         }else if(this.imc>=18.5 && this.imc<=24.9)
         {
           clasificacionPersonaImc="Normal,Siga asi";  
         }else if(this.imc>=25.0 && this.imc<=29.9)
         {
           clasificacionPersonaImc="Superior al normal,Porfavor preste atencion"; 
         }else if(this.imc>=30.0)
         {
           clasificacionPersonaImc="Obeso,Porfavor preste atencion"; 
         }  
     }    
    
    public void MensajeInfo()//metodo que muestra los resultados de clase Persona
     {
       JOptionPane.showMessageDialog(null,"<html>Su edad:<html>"+getEdad()+"<html><p>Su estatura: <html>"+getEstaturaPersona()+"<html><p>Su peso: <html>"+getPesoPersona()+"<html><p>Su IMC: <html>"+getImcPersona()+"<html><p> <p><html>"+getTablaImcConFormato()+"<html><p> <p><html>"+"Su clasificacion: "+getClasificacionIMC());
     }
    
    public void ActualizacionInfo()//metodo que muestra los resultados de clase Persona
     {
       JOptionPane.showMessageDialog(null,"<html>Ahora su IMC recalculado es:<html>"+setActualizcionImc()+"<html><p> <p><html>"+getTablaImcConFormato()+"<html><p> <p><html>"+"Su clasificacion: "+getClasificacionIMC());
     }
   
   public int getEdad()//metodo obtener edad
     {
       return this.edad; 
     } 
   
   public int getPesoPersona()//metodo obtener peso
     {
       return this.pesoPerso;
     } 
   
   public double getEstaturaPersona()//metodo obtener estatura
     {
       return this.estaturaPerso;  
     }
   
   public String getImcPersona()//metodo obtener imc
     {
      return decimales.format(this.imc);   
     }      

   public void setImcPersona()//metodo calcular el IMC
     {
      this.imc=this.pesoPerso/(this.estaturaPerso*this.estaturaPerso);
     }

   public String setActualizcionImc()//metodo para recalcular el IMC
    {    
      this.imc=this.redigitarPeso/this.comodinRecalcularImc;
      return decimales.format(this.imc);
    }  
    
   public void setPersona(int edad, int pesoPerso, int redigitarPeso, double imc, double estaturaPerso, double comodinRecalcularImc, double recalcularImc)//objeto general para crear apuntadores
    {
       this.edad=edad;
       this.pesoPerso= pesoPerso;
       this.redigitarPeso=redigitarPeso;
       this.estaturaPerso=estaturaPerso;
       this.imc=imc;
       this.comodinRecalcularImc=comodinRecalcularImc;
    }
   
   public void CrearArchivo()//metodo creacion archivo persona
    {  
      Calendar fecha=new GregorianCalendar(); 
      int ano=fecha.get(Calendar.YEAR);
      int mes=fecha.get(Calendar.MONTH);
      int dia = fecha.get(Calendar.DAY_OF_MONTH);
      int minuto = fecha.get(Calendar.MINUTE);
      
      File archivoPersona = new File("Persona.txt");
      BufferedWriter EscribirEnPersona;
      
      if(archivoPersona.exists())
       {
        try
           {                   
               EscribirEnPersona=new BufferedWriter(new FileWriter(archivoPersona,true));
               EscribirEnPersona.newLine();
               EscribirEnPersona.write("Year:"+ano+"-"+"Month:"+mes+"-"+"Day:"+dia+"-"+"Minute:"+minuto);
               EscribirEnPersona.write("\n-Peso-");
               EscribirEnPersona.write("\n"+getPesoPersona());
               EscribirEnPersona.write("\n-Estatura-");
               EscribirEnPersona.write("\n"+getEstaturaPersona());
               EscribirEnPersona.write("\n"+getTablaImcTextoSinFormato());              
               EscribirEnPersona.write("\nSu clasificacion de la tabla IMC fue: "+getClasificacionIMC());
               EscribirEnPersona.write("\n"+"-Su Calificacion IMC:-");
               EscribirEnPersona.write("\n"+getImcPersona());               
               EscribirEnPersona.newLine();
               EscribirEnPersona.close();
               
           }catch(Exception e)
              {
               JOptionPane.showMessageDialog(null,"No se pudo abrir o crear el arvhivo, excepcion:"+e);    
              }
        }else
           {
             try
                { 
                    
               EscribirEnPersona=new BufferedWriter(new FileWriter(archivoPersona,true));
               EscribirEnPersona.newLine();
               EscribirEnPersona.write("Year:"+ano+"-"+"Month:"+mes+"-"+"Day:"+dia+"-"+"Minute:"+minuto);
               EscribirEnPersona.write("\n-Peso-");
               EscribirEnPersona.write("\n"+getPesoPersona());
               EscribirEnPersona.write("\n-Estatura-");
               EscribirEnPersona.write("\n"+getEstaturaPersona());
               EscribirEnPersona.write("\n"+getTablaImcTextoSinFormato());              
               EscribirEnPersona.write("\nSu clasificacion de la tabla IMC fue: "+getClasificacionIMC());
               EscribirEnPersona.write("\n"+"-Su Calificacion IMC:-");
               EscribirEnPersona.write("\n"+getImcPersona());               
               EscribirEnPersona.newLine();
               EscribirEnPersona.close();
               
                }catch(Exception e)
                   {
                    JOptionPane.showMessageDialog(null,"No se pudo abrir o crear el arvhivo, excepcion:"+e); 
                   }   
           } 
       
    }   


    public void ObtnerImcArchivo()//metodo encontrar datos en archivo persona para recalcular imc
     {
      Calendar fecha=new GregorianCalendar(); 
      int ano=fecha.get(Calendar.YEAR);
      int mes=fecha.get(Calendar.MONTH);
      int dia = fecha.get(Calendar.DAY_OF_MONTH);
      int minuto = fecha.get(Calendar.MINUTE);      
         
         
      try
        {      
       BufferedReader VerEnPersona = new BufferedReader(new FileReader("Persona.txt"));
       BufferedReader leerToken = new BufferedReader(new FileReader("Persona.txt"));
       String temp="";
       String estatura="";
       String fechaAntigua="";
       String ImcAntigua="";
       int bandera=0;
       int banderaFecha=0;
       int banderaEstatura=0;
       int banderaContador=0;
       String ReescribirEnPersonaRead;
       
       while ((leerToken.readLine())!=null)//cuenta cantidad de lineas
           {
               bandera++;
           }
       
          banderaFecha=bandera-9;
          banderaEstatura=bandera-5;
               
       while ((ReescribirEnPersonaRead=VerEnPersona.readLine())!=null)//encuentra los datos necesarios segun su numero de linea
           {            
                 temp=" ";
                 
                 temp=temp+ReescribirEnPersonaRead;

                 if(banderaContador==banderaFecha)
                  { 
                    fechaAntigua=fechaAntigua+ReescribirEnPersonaRead;
                  }                  
                 
                 if(banderaContador==banderaEstatura)
                  {    
                    estatura=estatura+ReescribirEnPersonaRead;
                  } 
                 
                 banderaContador+=1;
                 ImcAntigua=temp;            
           }
         
         this.comodinRecalcularImc=Double.parseDouble(estatura);
         this.comodinRecalcularImc=this.comodinRecalcularImc*this.comodinRecalcularImc;   
        
         setActualizcionImc();
         setClasificacionIMC();
         
        File archivoPersona = new File("Record de actualizacion Peso-IMC.txt");// metodo para escribir en un texto la actualizacion de imc
        BufferedWriter EscribirEnPersona; 
        
      if(archivoPersona.exists())//si existe el archivo texto esto sucedera
         {
        try
           {
              EscribirEnPersona=new BufferedWriter(new FileWriter(archivoPersona,true));
              EscribirEnPersona.write("\nEl dato actualizado fue de la fecha:"+fechaAntigua+", a la fecha: "+"Year:"+ano+"-"+"Month:"+mes+"-"+"Day:"+dia+"-"+"Minute:"+minuto); 
              EscribirEnPersona.write("\n-Su Imc era de:"+ImcAntigua+", Y paso a :"+setActualizcionImc());
              EscribirEnPersona.write("\n-Ahora su estado fue actualizado a-"+getClasificacionIMC()); 
              EscribirEnPersona.newLine();              
              EscribirEnPersona.close();
              
           }catch(Exception e)
                   {
                    JOptionPane.showMessageDialog(null,"No se pudo abrir o crear el arvhivo, excepcion:"+e); 
                   }
          }else//si no existe el archivo texto esto sucedera
           {
             try
                { 
                    
              EscribirEnPersona=new BufferedWriter(new FileWriter(archivoPersona,true));
              EscribirEnPersona.write("\nEl dato actualizado fue de la fecha:"+fechaAntigua+", a la fecha: "+"Year:"+ano+"-"+"Month:"+mes+"-"+"Day:"+dia+"-"+"Minute:"+minuto); 
              EscribirEnPersona.write("\n-Su Imc era de: "+ImcAntigua+", Y paso a :"+setActualizcionImc());
              EscribirEnPersona.write("\n-Ahora su estado fue actualizado a-"+getClasificacionIMC()); 
              EscribirEnPersona.newLine();              
              EscribirEnPersona.close();
                    
                }catch(Exception e)
                   {
                    JOptionPane.showMessageDialog(null,"No se pudo abrir o crear el arvhivo, excepcion:"+e); 
                   
                   }  
           }  
   
        }catch(IOException e)
          {
            JOptionPane.showMessageDialog(null,"No se pudo abrir o crear el archivo, excepcion:"+e); 
          }  
      }       

   public void getCloseWindowSalirIMC()//objeto general para cerrar la ventana calcular IMC
     {
       contenedor3.dispose(); 
       contenedor3.setVisible(false);
     }    
    
    @Override
   public void actionPerformed(ActionEvent eventoImc) 
    {   
        
        if (eventoImc.getSource()==botoncalcularIMC)//evento listener, obtiene datos de los textfield, calcula IMC y muestra resultados
         {  
           try{  
                 this.edad=Integer.parseInt(txtedad.getText());      
                 this.pesoPerso=Integer.parseInt(txtpesoPerso.getText());
                 this.estaturaPerso=Double.parseDouble(txtestaturaPerso.getText());
                 setImcPersona();//llama a metodo obtner IMC
                 getImcPersona();//llama a metodo Ccalcular IMC
                 setClasificacionIMC();//llama a metodo Clasificacion segun tabla IMC
                 MensajeInfo();//llama a metodo mostrar informacion
                 CrearArchivo();//metodo que creara el archivo persona
              }catch(NumberFormatException exception)
              {
                 JOptionPane.showMessageDialog(null,"Problemente incurrio en dos errores: \n1.No Introdujo numeros donde debia \n2.La altura debe usar . para separar los centimetros \nExcepcion-"+ exception);
              }  
         }       
            
        if (eventoImc.getSource()==botonRecalcularIMC)//evento listener,obtiene datos del textfield, recalcula IMC y muestra resultados
         {  
            try{
                 this.redigitarPeso=Integer.parseInt(txtRedigiestaturaPerso.getText());
                 ObtnerImcArchivo();//Abre archivo persona para leer y otener datos
                 setActualizcionImc();//metodo para recalcular el IMC
                 setClasificacionIMC();//llama a metodo Clasificacion segun tabla IMC
                 ActualizacionInfo();//llama a metodo mostrar informacion
            }catch(NumberFormatException exception)
              {
                 JOptionPane.showMessageDialog(null,"Introduzca solo numeros \nExcepcion-"+ exception);
              } 
         }
        
        if (eventoImc.getSource()==botonSalirIMC)//evento listener, regresa a clase ventana persona(menu persona)
         {   
             VentanaEleccionPersona llamadaVentanaPersona = new VentanaEleccionPersona();
             llamadaVentanaPersona.VentanaPersona();
             getCloseWindowSalirIMC();//cierra ventana actual
         }
        
    }
  
}    