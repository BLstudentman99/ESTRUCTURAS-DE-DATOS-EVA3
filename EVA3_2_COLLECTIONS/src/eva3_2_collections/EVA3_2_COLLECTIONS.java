/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eva3_2_collections;

import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author invitado
 */
public class EVA3_2_COLLECTIONS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList<Integer> lista = new LinkedList<Integer>();
        lista.add(500);
        lista.add(400);
        lista.add(300);
        lista.add(200);
        lista.add(100);
        System.out.println(lista);
       Comparator<Integer> comparator = new Comparator<Integer>(){
            
            @Override
            public int compare(Integer o1, Integer o2) {
     
                return o1 - o2; 
            }
        };   
        lista.sort(comparator);   
        System.out.println("After sorting: " + lista);
    }
}
