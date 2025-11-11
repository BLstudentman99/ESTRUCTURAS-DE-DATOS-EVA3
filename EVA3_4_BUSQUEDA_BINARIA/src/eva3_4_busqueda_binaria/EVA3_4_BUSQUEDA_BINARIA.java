/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eva3_4_busqueda_binaria;

import java.util.Scanner;

/**
 *
 * @author invitado
 */
public class EVA3_4_BUSQUEDA_BINARIA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner captu = new Scanner(System.in);
         int[] original = new int[10];
         llenarArreglo(original);
         imprimirArreglo(original);
         selectionSort(original);
         imprimirArreglo(original);
         System.out.println("valor a buscar");
         int valor = captu.nextInt();
         System.out.println("El valor esta en " + binarySearch(original, valor));
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
    
    public static int binarySearch(int[] arreglo, int valor){
        return binarySearchRec(arreglo, valor, 0, arreglo.length -1);
    
    } //O(logn)
    private static int binarySearchRec(int[] arreglo, int valor, int ini, int fin){
        int resu = -1;
        if(ini <= fin){
            int mid = ini + ((fin - ini) / 2);
            if(valor > arreglo[mid])
                resu= binarySearchRec(arreglo, valor, mid + 1, fin);
            else if (valor < arreglo[mid])
                resu= binarySearchRec(arreglo, valor, ini, mid - 1);
            else
                resu = mid;
        }
        return resu;
    }
}
