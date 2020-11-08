
package Principal;

import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class Bicicleta extends Abs { //heredara de clase Abs
    
   boolean confirmarbotonBicicleta=false;//confirmara el evento elecion de intensidad
   boolean confirmarVentanaBicicleta=false;//confirmara el acceso correcto a la clase bicileta
   
    public void ConfirmacionBooleanBicicleta()
         {     
           confirmarVentanaBicicleta=true;
         }   
    
    public void ConfigurarComponentes()//configura los componentes de la clase bicileta
        {  
            
        texto3.setLayout(null);
        texto3.setVisible(true);
        texto3.setBounds(120,70,380,30);
        texto3.setText("<html>Digite el tiempo que tomo completar el ejercicio en minutos<html>");
        
        txtTiempoEjercicio.setLayout(null);
        txtTiempoEjercicio.setVisible(true);
        txtTiempoEjercicio.setBounds(201,100,120,30);
        
        texto4.setLayout(null);
        texto4.setVisible(true);
        texto4.setBounds(190,125,380,30);
        texto4.setText("<html>Digite su peso en kilos<html>");
        
        txtPesoperso.setLayout(null);
        txtPesoperso.setVisible(true);
        txtPesoperso.setBounds(201,160,120,30);
        
        contenedor5.add(texto3);
        contenedor5.add(txtTiempoEjercicio);
        contenedor5.add(texto4);
        contenedor5.add(txtPesoperso);
        }

    public void InformacionBicicleta()// metodo lanzara la informacion luego de hacer los calculos
         { 
           JOptionPane.showMessageDialog(null,"<html>Tu peso: <html>"+getPesoAbs()+"<html><p>Tiempo que te tomo hacer el ejercicio: <html>"+getTiempoAbs()+"min"+"<html><p><p>Cantidad de calorias que quemastes por concepto de:<html>"+"<html><p><p>Total de calorias quemadas en <html>"+getTiempoAbs()+"min: "+getcalcularGastoMet());
         }
    
    public void CrearArchivo()//creara el texto bibicleta
    {  
      Calendar fecha=new GregorianCalendar(); 
      int ano=fecha.get(Calendar.YEAR);
      int mes=fecha.get(Calendar.MONTH);
      int dia = fecha.get(Calendar.DAY_OF_MONTH);
      int minuto = fecha.get(Calendar.MINUTE);
      
      File archivoBici = new File("Bicicleta.txt");
      BufferedWriter EscribirEnBici;
      
      if(archivoBici.exists())//bloque que si existe archivo introducira estos datos
       {
        try
           { 
                EscribirEnBici=new BufferedWriter(new FileWriter(archivoBici,true));
                EscribirEnBici.newLine();
                EscribirEnBici.write("Year:"+ano+"-"+"Month:"+mes+"-"+"Day:"+dia+"-"+"Minute:"+minuto);
                EscribirEnBici.newLine();
                EscribirEnBici.write("En: "+getTiempoAbs()+"min, quemo: "+getcalcularGastoMet()+"calorias, por andar en bicileta");
                EscribirEnBici.newLine();
                EscribirEnBici.close();          
           }catch(Exception e)
              {
               JOptionPane.showMessageDialog(null,"No se pudo abrir o crear el arvhivo, excepcion:"+e);    
              }
        }else//bloque que si no existe archivo introducira estos datos
           {
             try
                {  
                EscribirEnBici=new BufferedWriter(new FileWriter(archivoBici,true));
                EscribirEnBici.newLine();
                EscribirEnBici.write("Year:"+ano+"-"+"Month:"+mes+"-"+"Day:"+dia+"-"+"Minute:"+minuto);
                EscribirEnBici.newLine();
                EscribirEnBici.write("En: "+getTiempoAbs()+"min, quemo: "+getcalcularGastoMet()+"calorias, por andar en bicileta");
                EscribirEnBici.newLine();
                EscribirEnBici.close();  
                }catch(Exception e)
                   {
                    JOptionPane.showMessageDialog(null,"No se pudo abrir o crear el arvhivo, excepcion:"+e); 
                   }   
           } 
        }
    
   @Override
    public void actionPerformed(ActionEvent Bici)//objeto que permite decidir el vaor de las unidades caloricas segun intensidad
     {
       if (Bici.getSource()==boton1)
              {
                 MetCaloricoLeve=4.0;
                 unidadcalorica=MetCaloricoLeve*0.0175;
                 confirmarbotonBicicleta=true;
              }
       
       if (Bici.getSource()==boton2)
              {
                MetCaloricoMedio=8.0;
                unidadcalorica=MetCaloricoLeve*0.0175;
                confirmarbotonBicicleta=true;
              }
           
       if (Bici.getSource()==boton3)
              {
                MetCaloricoMedio=10.0;
                unidadcalorica=MetCaloricoLeve*0.0175;
                confirmarbotonBicicleta=true;
              } 
       
        if (Bici.getSource()==botonCalcular && confirmarbotonBicicleta==false)
         {
           JOptionPane.showMessageDialog(null,"Debes apretar un boton de intensidad para obtener las calorias gastadas");
         }else      
         
         if ((Bici.getSource()==botonCalcular && confirmarbotonBicicleta==true)&&confirmarVentanaBicicleta==true)//metodo que llama a los calculos heredados de abs
           {
             try{
                   this.tiempoab=Integer.parseInt(txtTiempoEjercicio.getText());
                   this.pesoab=Integer.parseInt(txtPesoperso.getText());
                   setcalcularGastoMet();
                   getcalcularGastoMet();
                   InformacionBicicleta();
                   CrearArchivo();
                }catch(NumberFormatException exception)
                     {
                      JOptionPane.showMessageDialog(null,"Introduzca solo numeros \nExcepcion-"+ exception);
                     }  
          } 
        
         if (Bici.getSource()==Salir)//metodo para retorno y cierra ventana actual
             {   
                VentanaEleccionPersona llamadaRetorno = new VentanaEleccionPersona();
                llamadaRetorno.VentanaAbs();//metodo para regresar a la ventana principal del programa
                getCloseWindow();//objeto que cerrar la clase abs
             } 
       
     }
}
