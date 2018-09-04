package tarea.pkg2;
import java.util.Scanner;
        
public class Tarea2 {

    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        System.out.println("Ingrese un número de filas: ");
	int numerofilas=obj.nextInt();
	
	for(int i=0;i<=numerofilas-1;i++){
            for(int espacios=numerofilas-i; espacios>0;espacios--){
		System.out.print(" ");
            }
                System.out.print("/");
            for(int lineas=1;lineas<=i;lineas++){
                System.out.print("/\\");
            }
            System.out.print("\\");
            System.out.println("");
        }	
    }
}    

