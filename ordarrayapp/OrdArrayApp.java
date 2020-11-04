/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordarrayapp;

/**
 *
 * @author Nipuni
 */
public class OrdArrayApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        OrdArray obj = new OrdArray(5);
        
        obj.insert(1);
        obj.insert(4);
        obj.insert(2);
        obj.insert(5);
        obj.insert(3);
        
        obj.display();
        
        System.out.println("Number 4 is found at index is: " + obj.find(4));
        
        obj.delete(3);
        obj.display();
        
        obj.delete(2);
        obj.display();
    }
    
}
