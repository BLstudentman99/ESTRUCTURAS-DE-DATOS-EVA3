/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eva3_1_ordenamiento;

/**
 *
 * @author invitado
 */
public class EVA3_1_ORDENAMIENTO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] original = new int[10];
        int[] selection;
        int[] insertion;
        int[] bubble;
        int[] quick;
        long ini, fin, tiempo;
        llenarArreglo(original);
        imprimirArreglo(original);
        selection = copiarArreglo(original);
        insertion = copiarArreglo(original);
        bubble = copiarArreglo(original);
        quick = copiarArreglo(original);
        
        System.out.println("****SELECTION SORT****");
        ini = System.nanoTime();
        selectionSort(selection); 
        fin = System.nanoTime();
        tiempo = fin - ini; 
        System.out.println("Arreglo ordenado:");
        imprimirArreglo(selection);
        System.out.println("Tiempo: " + tiempo);
        
        System.out.println("****INSERTION SORT****");
        ini = System.nanoTime();
        insertionSort(insertion); 
        fin = System.nanoTime();
        tiempo = fin - ini; 
        System.out.println("Arreglo ordenado:");
        imprimirArreglo(insertion);
        System.out.println("Tiempo: " + tiempo);
                                                            
        System.out.println("****BUBBLE SORT****");
        ini = System.nanoTime();
        bubbleSort(bubble); 
        fin = System.nanoTime();
        tiempo = fin - ini; 
        System.out.println("Arreglo ordenado:");
        imprimirArreglo(bubble);
        System.out.println("Tiempo: " + tiempo);
        
        System.out.println("****QUICK SORT****");
        ini = System.nanoTime();
        quickSort(quick, 0, quick.length - 1);
        fin = System.nanoTime();
        tiempo = fin - ini;
        System.out.println("Arreglo ordenado:");
        imprimirArreglo(quick);
        System.out.println("Tiempo: " + tiempo);
    
    }
    public static void llenarArreglo(int[] datos){
        for (int i = 0; i < datos.length; i++) {
          datos[i] = (int)(Math.random() * 100);
        }
    }
    
    public static void imprimirArreglo(int[] datos){
         for (int i = 0; i < datos.length; i++) {
             System.out.print("[" + datos[i] + "]");;
        }
         System.out.println("");
    }
    public static int[] copiarArreglo(int[] datos){
        int[] nuevo = new int[datos.length];
        for (int i = 0; i < datos.length; i++) {
            nuevo[i] = datos[i];
        }
        
        return nuevo;

    }
    //o(n2)
    public static void selectionSort(int[] datos) {
        for (int i = 0; i < datos.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < datos.length; j++) {
                if (datos[j] < datos[min]) {
                    min = j;
                }
            }
            int temp = datos[min];
            datos[min] = datos[i];
            datos[i] = temp;
        }   
    }  
    //o(n2)
    public static void insertionSort(int[] datos) {
        for (int i = 1; i < datos.length; ++i) {
        int temp = datos[i]; 
        int j = i - 1; 
        while (j >= 0 && datos[j] > temp) {
            datos[j + 1] = datos[j];
            j = j - 1;
        }
        datos[j + 1] = temp;
    }
}
    //o(n2)
    public static void bubbleSort(int[] datos){
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos.length - 1; j++) {
                if(datos[j] > datos[j + 1]){ //intercambio
                    int temp = datos[j + 1];
                    datos[j + 1] = datos[j];
                    datos[j] = temp;
                }
            }
            
        }
    
    }
    public static void quickSort(int[] datos, int ini, int fin){
        if (ini < fin) {
            int indiceParticion = particion(datos, ini, fin);
            quickSort(datos, ini, indiceParticion - 1);
            quickSort(datos, indiceParticion + 1, fin);
        }
    }

    public static int particion(int[] datos, int ini, int fin) {
        int pivote = datos[fin];
        int i = ini - 1;
        for (int j = ini; j < fin; j++) {
            if (datos[j] <= pivote) {
                i++;
                int temp = datos[i];
                datos[i] = datos[j];
                datos[j] = temp;
            }
        }
        int temp = datos[i + 1];
        datos[i + 1] = datos[fin];
        datos[fin] = temp;
        return i + 1;
    }
}