/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noduparray;
/**
 *
 * @author Nipuni
 */
public class NoDup { //start of the NoDup class
    
    private int nElems; //number of data items
    private long[] array;
    //-----------------------------------------
    
    
    //constructor
    public NoDup(int max){
        nElems = max;
        array = new long[max];
    }
    //-----------------------------------
    
    
    //find specified value
    public boolean find(long searchKey){ 
        boolean value = false; //the Key was not found
        
        for(int counter = 0; counter<nElems; counter++){
            if(array[counter] == searchKey){
                value = true; //key was found
            }
        }
        return value;
    } //end find()
    //------------------------------------------------------
    
    
    //insert an element into array
    public void insert(long value){              
        boolean check = find(value); //checking whether value is already in array
         
    
        if(check == false){ //if statement start
            for(int c = 0; c<nElems; c++){
                if(array[c] == 0){ //add the value to the first 0 we find
                    array[c] = value;
                    break;
                }
            }
        }            
        
    } //end of insert()
    //-------------------------------------------------------------------------
    
    
    public boolean delete(long value){ // delete an element if found
        boolean TF = false; //TF = true or false
        int index = 0;
        int index1 = 0;
        
        if(find(value) == true){ //start of if statement
            for(int c = 0; c<nElems; c++){
                if(array[c] == value){
                    index = c+1;
                } 
            }
            
            for(int c = index; c<nElems; c++){
                array[c-1] = array[c];
                index1 = c;
            }
            array[index1] = 0;
            
            TF = true;
        } //end of if statement
        
        else{
            System.out.println("Entered value is not in the array!");
        }
        
        return TF;
    } // end of delete()
    //-----------------------------------------------------------------

   
    public void display(){ //display()
        System.out.print("Array = [ ");
        for(int c = 0; c<nElems; c++){
            System.out.print(array[c] + " ");
        }
        System.out.println("]");
    } // end of display()
    //------------------------------------------
    
} //end of the class
