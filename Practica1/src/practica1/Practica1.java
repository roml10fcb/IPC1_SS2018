package practica1;
import java.util.Scanner;

public class Practica1 {
    public static int empresa[][]=new int[9][5];
    public static int moda[]=new int[4];
    
    //Main donde inicia todo
    public static void main(String[] args) {
        int l=0;
        empresa[l][4]=1000;
        l++;
        empresa[l][4]=500;
        l++;
        empresa[l][4]=1500;
        l++;
        empresa[l][4]=7000;
        l++;
        empresa[l][4]=250;
        l++;
        empresa[l][4]=300;
        l++;
        empresa[l][4]=680;
        l++;
        empresa[l][4]=880;
        l++;
        empresa[l][4]=5000;
        menu();
    }
    
    //Menu principal
    public static void menu(){
        Scanner leer=new Scanner(System.in);
        int menu=0;
        System.out.println("\n********************************");
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("    1.Ver inventario");
        System.out.println("    2.Ingresar mercadería");
        System.out.println("    3.Extraer mercadería");
        System.out.println("    4.Transferir mercadería");
        System.out.println("    5.Reportes");
        System.out.println("    6.Salir");
        System.out.println("Ingrese un número: ");
        menu=leer.nextInt();
        
        switch(menu){
            case 1:
                verinventario();
            case 2:
                ingresarmercadería();
            case 3:
                extraermercadería();
            case 4:
                transferirmercaderia();
            case 5:
                reportes();
            case 6: 
                System.exit(0);
            default:
                System.out.println("Número desconocido o caracter inválido");
                
        }
    }
    
    //Método para ver lo que esta guardado en el inventario
    public static void verinventario(){
        Scanner obtener=new Scanner(System.in);
        int numbodega=0;
        System.out.println("\nIngrese el número de bodega: ");
        numbodega=obtener.nextInt();
        System.out.println("********************************");
        System.out.println("Bodega "+numbodega);
        int porcentaje=0;
        int capacidad=empresa[numbodega-1][4];
        
        for(int i=0;i<=3;i++){
            int p=empresa[numbodega-1][i];
            porcentaje=(p*100)/capacidad;    
                if(i==1){
                    System.out.println("GPU: "+p+" Ocupa: "+porcentaje+"%");
                }else if(i==2){
                    System.out.println("RAM: "+p+" Ocupa: "+porcentaje+"%");
                }else if(i==3){
                    System.out.println("SSD: "+p+" Ocupa: "+porcentaje+"%");
                }else{
                    System.out.println("CPU: "+p+" Ocupa: "+porcentaje+"%");
                }
        }
        
        menu();
    }
    
    //Método para ingresar mercadería
    public static void ingresarmercadería(){
        Scanner obtener=new Scanner(System.in);
        int tipocarga=0;
        System.out.println("\nTipo de ingreso de mercadería: ");
        System.out.println("    1.Carga Manual");
        System.out.println("    2.Carga Masiva");
        tipocarga=obtener.nextInt();
        if(tipocarga==1){
            //Carga manual
            System.out.println("\nIngrese la bodega: ");
            int bodega=obtener.nextInt();
            System.out.println("\nIngrese el tipo de producto: ");
            System.out.println("    1.CPU");
            System.out.println("    2.GPU");
            System.out.println("    3.RAM");
            System.out.println("    4.SSD");
            int tipoproducto=obtener.nextInt();
            System.out.println("\nIngrese la cantidad: ");
            int cantidad=obtener.nextInt();
            ingreso(bodega,tipoproducto,cantidad);
            
        }else if(tipocarga==2){
            //Carga masiva
            int bodega=0;
            int tipoproducto=0;
            String cargamasiva;
            System.out.println("\nIngresar los atributos a ingresar");
            cargamasiva=obtener.next();
            String carga[]=cargamasiva.split(",");
            int largo_de_matriz=(cargamasiva.split(",").length)-1;
                //Encontrar primero la bodega a la que se dirije
                for(int i=0;i<=largo_de_matriz;i++){
                    String subcarga1[]=carga[i].split(":");
                    switch(subcarga1[0]){
                        case "Bodega":
                            bodega=Integer.parseInt(subcarga1[1]);
                            break;    
                    }
                }
                for(int p=0;p<=largo_de_matriz;p++){
                    String subcarga[]=carga[p].split(":");
                    int cantidad=0;
                    switch(subcarga[0]){
                        case "SSD":
                            tipoproducto=4;
                            cantidad=Integer.parseInt(subcarga[1]);
                            ingreso(bodega,tipoproducto,cantidad);
                            break;
                        case "GPU":
                            tipoproducto=2;
                            cantidad=Integer.parseInt(subcarga[1]);
                            ingreso(bodega,tipoproducto,cantidad);
                            break;
                        case "RAM":
                            tipoproducto=3;
                            cantidad=Integer.parseInt(subcarga[1]);
                            ingreso(bodega,tipoproducto,cantidad);
                            break;
                        case "CPU":
                            tipoproducto=1;
                            cantidad=Integer.parseInt(subcarga[1]);
                            ingreso(bodega,tipoproducto,cantidad);
                            break;
                    }    
                }
                
            
            //Finalizacion de la carga masiva
        System.out.println("Carga exitosa!");
        }else{
            System.out.println("Valor incorrecto");
            menu();
        }
        menu();
    }
    //Funcion para ingreso de datos a la matriz
    public static int ingreso(int bodega,int tipoproducto,int cantidad){
        int enexistencia;
        int limite=empresa[bodega-1][4];
        enexistencia=empresa[bodega-1][tipoproducto-1];
        enexistencia=enexistencia+cantidad;
        //Calcular el limite de la capacidad de la bodega
        double limite1=(int)limite;
        if(tipoproducto==1){
            limite1=limite1*0.25;
        }else if(tipoproducto==2){
            limite1=limite1*0.4;
        }else if(tipoproducto==3){
            limite1=limite*0.2;
        }else if(tipoproducto==4){
            limite1=limite*0.15;
        }
        limite=(int)limite1;
        
        //Ingresar datos en bodega
        if(enexistencia<=limite){
            empresa[bodega-1][tipoproducto-1]=enexistencia;
            System.out.println("Ingreso con éxito");
            
            
        }else{
            String salidadeproducto="";
            switch(tipoproducto){
                case 1:salidadeproducto="CPU";break;
                case 2:salidadeproducto="GPU";break;
                case 3:salidadeproducto="RAM";break;
                case 4:salidadeproducto="SSD";break;                 
            }
            System.out.println("No exitoso. No cabe la cantidad de "+salidadeproducto+" a ingresar en la bodega "+bodega+", o no selecciono el producto adecuado");}
        return 0;
    }
    
    //Método para eliminar mercadería de una bodega
    public static void extraermercadería(){
        
        Scanner obtener=new Scanner(System.in);
        System.out.println("\nIngrese el numero de bodega: ");
        int bodega=obtener.nextInt();
        System.out.println("\nIngrese el producto a extraer: ");
        System.out.println("    1.CPU");
        System.out.println("    2.GPU");
        System.out.println("    3.RAM");
        System.out.println("    4.SSD");
        int producto=obtener.nextInt();
        System.out.println("\nIngrese la cantidad a extraer: ");
        int cantidad=obtener.nextInt();
        int enexistencia=empresa[bodega-1][producto-1];
        //Validacion 1: Ver si existe esa cantidad
        if(cantidad<=enexistencia){
            enexistencia=enexistencia-cantidad;
            empresa[bodega-1][producto-1]=enexistencia;
            System.out.println("Extraccion exitosa");
            //Validacion 2: Ver el reorden.
            int limite=empresa[bodega-1][4];
            if(producto==1){
                double limite1=(int)limite;
                limite1=limite1*0.25;
                double reorden=limite1*0.68;
                if(enexistencia<=reorden){System.out.println("Reordenar CPU, está debajo del minimo de CPU en la bodega "+bodega);}
                
            }else if(producto==2){
                double limite1=(int)limite;
                limite1=limite1*0.4;
                double reorden=limite1*0.29;
                if(enexistencia<=reorden){System.out.println("Reordenar GPU, está debajo del minimo de GPU en la bodega "+bodega);}
                
            }else if(producto==3){
                double limite1=(int)limite;
                limite1=limite1*0.2;
                double reorden=limite1*0.50;
                if(enexistencia<=reorden){System.out.println("Reordenar RAM, está debajo del minimo de RAM en la bodega "+bodega);}
                
            }else if(producto==4){
                double limite1=(int)limite;
                limite1=limite1*0.15;
                double reorden=limite1*0.33;
                if(enexistencia<=reorden){System.out.println("Reordenar SSD, está debajo del minimo de SDD en la bodega "+bodega);}
                
            }
        }else{
            System.out.println("No existe esa cantidad en la bodega "+bodega);
        }
        menu();
    }
    
    //Método para transferir mercadería
    public static void transferirmercaderia(){
        Scanner obtener=new Scanner(System.in);
        //Ingreso de datos
        System.out.println("\nIngrese el numero de bodega de donde extraer: ");
        int bodega=obtener.nextInt();
        System.out.println("\nIngrese el producto a transferir: ");
        System.out.println("    1.CPU");
        System.out.println("    2.GPU");
        System.out.println("    3.RAM");
        System.out.println("    4.SSD");
        int producto=obtener.nextInt();
        System.out.println("\n¿Cuantos productos va extraer?");
        int cantidad=obtener.nextInt();
        System.out.println("\n¡Hacia que bodega desea enviarlos?");
        int bodegafinal=obtener.nextInt();
        
        //Calculos de tranferencia
        int enexistenciainicio=empresa[bodega-1][producto-1];
        int enexistenciafinal=empresa[bodegafinal-1][producto-1];
               
        if(cantidad<=enexistenciainicio){
            if(producto==1){
                //Calcular la capacidad de almacenar CPU en bodega de inicio
                int capacidadinicio=empresa[bodega-1][4];
                double limite=(double)capacidadinicio;
                limite=limite*0.25;
                double reordeninicio=limite*0.68;
                capacidadinicio=(int)limite;
                //Calcular la capacidad de almacenar CPU en bodega de destino
                int capacidadfinal=empresa[bodegafinal-1][4];
                double limite1=(double)capacidadfinal;
                limite1=limite1*0.25;
                double reordenfinal=limite1*0.68;
                capacidadfinal=(int)limite1;
                enexistenciafinal=enexistenciafinal+cantidad;
                //Verificar si hay espacio en la bodega hacia la que van los productos
                if(enexistenciafinal<=capacidadfinal){
                    empresa[bodegafinal-1][producto-1]=enexistenciafinal;
                    if(enexistenciafinal<=reordenfinal){System.out.println("Reordenar CPU, está debajo del minimo de CPU en la bodega "+bodegafinal);}
                    empresa[bodega-1][producto-1]=enexistenciainicio-cantidad;
                    if(enexistenciainicio<=reordeninicio){System.out.println("Reordenar CPU, está debajo del minimo de CPU en la bodega "+bodega);}
                }else{
                    System.out.println("No hay espacio en la bodega en donde solicitó colocar los productos");
                }
                
            }else if(producto==2){
                //Calcular la capacidad de almacenar GPU en bodega de inicio
                int capacidadinicio=empresa[bodega-1][4];
                double limite=(double)capacidadinicio;
                limite=limite*0.4;
                double reordeninicio=limite*0.29;
                capacidadinicio=(int)limite;
                //Calcular la capacidad de almacenar CPU en bodega de destino
                int capacidadfinal=empresa[bodegafinal-1][4];
                double limite1=(double)capacidadfinal;
                limite1=limite1*0.4;
                double reordenfinal=limite1*0.29;
                capacidadfinal=(int)limite1;
                enexistenciafinal=enexistenciafinal+cantidad;
                //Verificar si hay espacio en la bodega hacia la que van los productos
                if(enexistenciafinal<=capacidadfinal){
                    empresa[bodegafinal-1][producto-1]=enexistenciafinal;
                    if(enexistenciafinal<=reordenfinal){System.out.println("Reordenar GPU, está debajo del minimo de GPU en la bodega "+bodegafinal);}
                    empresa[bodega-1][producto-1]=enexistenciainicio-cantidad;
                    if(enexistenciainicio<=reordeninicio){System.out.println("Reordenar GPU, está debajo del minimo de GPU en la bodega "+bodega);}
                }else{
                    System.out.println("No hay espacio en la bodega en donde solicitó colocar los productos");
                }
                
            }else if(producto==3){
                //Calcular la capacidad de almacenar RAM en bodega de inicio
                int capacidadinicio=empresa[bodega-1][4];
                double limite=(double)capacidadinicio;
                limite=limite*0.2;
                double reordeninicio=limite*0.5;
                capacidadinicio=(int)limite;
                //Calcular la capacidad de almacenar CPU en bodega de destino
                int capacidadfinal=empresa[bodegafinal-1][4];
                double limite1=(double)capacidadfinal;
                limite1=limite1*0.2;
                double reordenfinal=limite1*0.5;
                capacidadfinal=(int)limite1;
                enexistenciafinal=enexistenciafinal+cantidad;
                //Verificar si hay espacio en la bodega hacia la que van los productos
                if(enexistenciafinal<=capacidadfinal){
                    empresa[bodegafinal-1][producto-1]=enexistenciafinal;
                    if(enexistenciafinal<=reordenfinal){System.out.println("Reordenar RAM, está debajo del minimo de RAM en la bodega "+bodegafinal);}
                    empresa[bodega-1][producto-1]=enexistenciainicio-cantidad;
                    if(enexistenciainicio<=reordeninicio){System.out.println("Reordenar RAM, está debajo del minimo de RAM en la bodega "+bodega);}
                }else{
                    System.out.println("No hay espacio en la bodega en donde solicitó colocar los productos");
                }
                
            }else if(producto==4){
                //Calcular la capacidad de almacenar SSD en bodega de inicio
                int capacidadinicio=empresa[bodega-1][4];
                double limite=(double)capacidadinicio;
                limite=limite*0.15;
                double reordeninicio=limite*0.33;
                capacidadinicio=(int)limite;
                //Calcular la capacidad de almacenar CPU en bodega de destino
                int capacidadfinal=empresa[bodegafinal-1][4];
                double limite1=(double)capacidadfinal;
                limite1=limite1*0.15;
                double reordenfinal=limite1*0.33;
                capacidadfinal=(int)limite1;
                enexistenciafinal=enexistenciafinal+cantidad;
                //Verificar si hay espacio en la bodega hacia la que van los productos
                if(enexistenciafinal<=capacidadfinal){
                    empresa[bodegafinal-1][producto-1]=enexistenciafinal;
                    if(enexistenciafinal<=reordenfinal){System.out.println("Reordenar SSD, está debajo del minimo de SSD en la bodega "+bodegafinal);}
                    empresa[bodega-1][producto-1]=enexistenciainicio-cantidad;
                    if(enexistenciainicio<=reordeninicio){System.out.println("Reordenar SSD, está debajo del minimo de SSD en la bodega "+bodega);}
                }else{
                    System.out.println("No hay espacio en la bodega en donde solicitó colocar los productos");
                }
                
            }else{
                System.out.println("Error caracter no válido, producto no existe");
            }
                    
        }else{
            System.out.println("No existe esa cantidad en la bodega "+bodega);
        }
        menu();
    }
    
    public static void reportes(){
        Scanner obtener=new Scanner(System.in);
        System.out.println("\nIngrese el tipo de reporte");
        System.out.println("    1.Bodega con mayor cantidad de productos totales");//En total
        System.out.println("    2.Bodega con menor cantidad de productos totales");//En total
        System.out.println("    3.Bodega con mayor cantidad de productos totales (por articulos)");
        System.out.println("    4.Bodega con menor cantidad de productos totales (por articulos)");
        System.out.println("    5.Promedio de artículos por bodega");
        System.out.println("    6.Mediana de unidades por artículo calculado sobre todas las bodegas");
        System.out.println("    7.Moda de unidades por artículo calculado sobre todas las bodegas");
        int reporte=obtener.nextInt();
        
        //Calcular el mayor y menor de las bodegas
        int bodegamayor=0;
        int bodegamenor=0;
        int totalenbodegamayor=0;
        int totalenbodegamenor=0;
        int mayor[]=new int[9];
            //Ciclo para la suma de cada bodega para luego evaluarla
            for(int m=0;m<=8;m++){
                int acumulador=0;
                for(int i=0;i<=3;i++){
                    acumulador=acumulador+empresa[m][i];
                }
                    mayor[m]=acumulador;
            }
            //Evaluacion de cual bodega es mayor
            
            int min=mayor[0];
            int max=mayor[0];
            for(int i=0;i<=8;i++){
                if (mayor[i]< min) {
                    min = mayor[i];
                    bodegamenor=i+1;
                }else if(mayor[i] > max){
                    max = mayor[i];
                    bodegamayor=i+1;
                }
            }
        totalenbodegamayor=max;
        totalenbodegamenor=min;
        //Fin del calculo del mayor y menor
        switch(reporte){
            case 1:
                if(bodegamayor==0){System.out.println("Hay bodegas aún totalmente vacias");
                }else{
                    System.out.println("\nLa bodega "+bodegamayor+" tiene "+totalenbodegamayor+" unidades");
                }
                break;
            case 2:
                if(bodegamenor==0){System.out.println("Hay bodegas aún totalmente vacias");
                }else{
                    System.out.println("\nLa bodega "+bodegamenor+" tiene "+totalenbodegamenor+" unidades");
                }
                break;
            case 3:
                if(bodegamayor==0){System.out.println("Hay bodegas aún totalmente vacias");
                }else{
                    int cpu=empresa[bodegamayor-1][0];
                    int gpu=empresa[bodegamayor-1][1];
                    int ram=empresa[bodegamayor-1][2];
                    int ssd=empresa[bodegamayor-1][3];
                    
                    System.out.println("\nEl articulo CPU tiene: "+cpu+" unidades en bodega "+bodegamayor);
                    System.out.println("El articulo GPU tiene: "+gpu+" unidades en bodega "+bodegamayor);
                    System.out.println("El articulo RAM tiene: "+ram+" unidades en bodega "+bodegamayor);
                    System.out.println("El articulo SSD tiene: "+ssd+" unidades en bodega "+bodegamayor);
                }
                System.out.println("\n");
                break;
            case 4:
                if(bodegamenor==0){System.out.println("Hay bodegas aún totalmente vacias");
                }else{
                    int cpu=empresa[bodegamenor-1][0];
                    int gpu=empresa[bodegamenor-1][1];
                    int ram=empresa[bodegamenor-1][2];
                    int ssd=empresa[bodegamenor-1][3];
                    
                    System.out.println("\nEl articulo CPU tiene: "+cpu+" unidades en bodega "+bodegamenor);
                    System.out.println("El articulo GPU tiene: "+gpu+" unidades en bodega "+bodegamenor);
                    System.out.println("El articulo RAM tiene: "+ram+" unidades en bodega "+bodegamenor);
                    System.out.println("El articulo SSD tiene: "+ssd+" unidades en bodega "+bodegamenor);
                }
                break;
            case 5:
                //Promedio de bodegas
                System.out.println("**********************************************");
                System.out.println("Bodega\tPromedio");
                for(int i=0;i<=8;i++){
                    int acumulador=0;
                    for(int m=0;m<=3;m++){
                        acumulador=acumulador+empresa[i][m];
                    }
                    acumulador=acumulador/4;
                    System.out.println("  "+(i+1)+"\t"+acumulador);
                }
                break;
            case 6:
                //Cálculo de mediana
                 int acumulador=0;
                for(int k=0;k<=3;k++){
                    acumulador=0;
                    for(int l=0;l<=8;l++){
                        acumulador=acumulador+empresa[l][k];
                    }
                    moda[k]=acumulador;
                }
                double media=0;
                int sumatoria=0;
                int posicion_eliminar=0;
                int posicion_eliminar1=0;
                min=moda[0];
                max=moda[0];
                //Ciclo de llenado del vector moda
                for(int i=0;i<=3;i++){
                    if (moda[i]< min) {min = moda[i];posicion_eliminar=i;}
                    else if(moda[i] > max){max = moda[i];posicion_eliminar1=i;}
                }
                
                //Eliminar dos posiciones (mayor y menor)
                for(int i=0;i<=3;i++){
                    if(i==posicion_eliminar){moda[i]=0;}
                    else if(i==posicion_eliminar1){moda[i]=0;}
                    else{sumatoria=sumatoria+moda[i];}
                }
                media=sumatoria/2;
                System.out.println("La media es: "+media);
                break;
            case 7:
                //Cálculo de modas
                //Llenado de sumatorias para calcular la moda
                int acumulador1=0;
                for(int k=0;k<=3;k++){
                    acumulador1=0;
                    for(int l=0;l<=8;l++){
                        acumulador1=acumulador1+empresa[l][k];
                    }
                    moda[k]=acumulador1;
                }
                //Calcular el mayor
                min=0;
                max=0;
                int producto_mayor=0;
                for(int i=0;i<=3;i++){
                    if(moda[i] > max){
                        max = moda[i];
                        producto_mayor=i+1;
                    }else if(moda[i] < min){
                        min = moda[i];
                    }
                }
                
                switch(producto_mayor){
                    case 1:
                        System.out.println("El producto moda es: CPU con "+max+" unidades");break;
                    case 2:
                        System.out.println("El producto moda es: GPU con "+max+" unidades");break;
                    case 3:
                        System.out.println("El producto moda es: RAM con "+max+" unidades");break;
                    case 4:
                        System.out.println("El producto moda es: SSD con "+max+" unidades");break;
                    
                                
                }
                break;
            default:
                System.out.println("Opcion no válida");
                menu();
        }
        
        //Reporte general
        System.out.println("\n");
        System.out.println("**********************************************");
        System.out.println("Reporte general:");
        System.out.println("Bodega\tCPU\tGPU\tRAM\tSSD");
        for(int i=0;i<=8;i++){
            int cpu=0;
            int gpu=0;
            int ram=0;
            int ssd=0;
            cpu=empresa[i][0];
            gpu=empresa[i][1];
            ram=empresa[i][2];
            ssd=empresa[i][3];
            System.out.println("  "+(i+1)+"\t"+cpu+"\t"+gpu+"\t"+ram+"\t"+ssd);
        } 
        System.out.println("**********************************************");
        menu(); 
    }
}