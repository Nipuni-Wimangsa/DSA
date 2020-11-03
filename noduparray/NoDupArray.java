/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noduparray;

import java.util.Scanner;
/**
 *
 * @author Nipuni
 */
public class NoDupArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NoDup obj = new NoDup(5);
        
//        Scanner input = new Scanner(System.in);
//        System.out.print("Enter the number of elements in the array: ");
//        
//        int nElems = input.nextInt();
//        
//        NoDup obj = new NoDup(nElems);
//        
//        for(int c = 0; c<nElems; c++){
//            System.out.printf("Enter the value %d: ", c+1);
//            long num = input.nextLong();
//            
//            if(obj.find(num) == false){
//                if(num != 0){
//                    obj.insert(num);
//                }
//                else{
//                    System.out.println("0 cannot be entered. Eneter a valid value!");
//                    System.out.printf("Enter the value %d: ", c+1);
//                
//                    num = input.nextLong();
//                    obj.insert(num);
//                
//                }
//            }
//            else{
//                System.out.println("Value is already in the array. Enter a different value.");
//                System.out.printf("Enter the value %d: ", c+1);
//                
//                num = input.nextLong();
//                obj.insert(num);
//            }
//        }
        
        obj.insert(1);
        obj.insert(2);
        obj.insert(3);
        obj.insert(4);
        obj.insert(5);
                
        obj.display();
         
        obj.delete(3);
        obj.display();
        
        obj.delete(4);
        obj.display();
        
        obj.insert(6);
        obj.display();
        
        if(obj.find(5) == true){
            System.out.println("Value is found!");
        }
        else{
            System.out.println("Value is not in the array!");
        }
        
        obj.delete(1);
        obj.display();
    }
    
}
