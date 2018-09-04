package tarea.pkg3;
import javax.swing.*;
import java.awt.*;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario {
    public JFrame formulario;
    public JButton boton;
    
    public Formulario(){
        //Creacion del formulario principal y sus ediciones
        formulario=new JFrame();
        formulario.setLayout(null);
        formulario.setTitle("Tarea 3: Botones de colores");
        formulario.setSize(750, 700);
        formulario.setLocationRelativeTo(null);
        formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Crear los botones con su listener
        Container cp=formulario.getContentPane();
        GridLayout gl= new GridLayout(16,16);
        gl.setHgap(5);gl.setVgap(5);
        cp.setLayout(gl);
        int posicion=0;
        for(int i=1;i<=256;i++){
            boton=new JButton();
            posicion=i;
            boton.setToolTipText(i+"");
            boton.addActionListener(new Esp());
            
            formulario.add(boton);
        }
        
        
        formulario.setVisible(true);
    }
}
class Esp implements ActionListener{
    public int acumulador[]=new int[256];
    int posicion=0;
    
    public void actionPerformed(ActionEvent e) {
        JButton botonpulsado=(JButton)e.getSource();
        posicion=Integer.parseInt(botonpulsado.getToolTipText());
        acumulador[posicion]=acumulador[posicion]+1;
        if(acumulador[posicion]==1){
            botonpulsado.setBackground(Color.black);
        }else if(acumulador[posicion]==2){
            botonpulsado.setBackground(Color.GRAY);
        }else if(acumulador[posicion]==3){
            botonpulsado.setBackground(Color.red);
        }else if(acumulador[posicion]==4){
            botonpulsado.setBackground(Color.blue);
        }else if(acumulador[posicion]==5){
            botonpulsado.setBackground(Color.green);
        }else if(acumulador[posicion]==6){
            botonpulsado.setBackground(Color.orange);
        }else if(acumulador[posicion]==7){
            botonpulsado.setBackground(Color.yellow);
        }else if(acumulador[posicion]==8){
            botonpulsado.setBackground(Color.MAGENTA);
        }else if(acumulador[posicion]==9){
            botonpulsado.setBackground(Color.white);
            acumulador[posicion]=0;
        }
        //negro-gris-rojo-azul-verde-naranja-amarillo-morado-blanco
    }
    
}