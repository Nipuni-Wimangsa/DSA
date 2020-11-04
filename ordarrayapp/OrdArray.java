/*Copyright - Nipuni Wimangsa
Project - Ordered Array
Date - 3/11/2020
*/

/*Assumptions:-
1 - "0" cannot be entetred as a value to the array
2 - This is and no duplication array
*/

package ordarrayapp;

public class OrdArray {
    private long[] array;
    private int nElems; //number of data items
        //-----------------------------------------
    
    
    public OrdArray(int max){ //constructor
        nElems = max;
        array = new long[max];
    }
    //--------------------------------------
    
    
    public int size(){ //start of the size() - size of occupied cells
        int index = 0; 
        for(int c = 0; c<nElems; c++){
            if(array[c] != 0){
                index += 1;
            }
        }
        return index;
    } //end of size()
    //---------------------------------------
    
    
    public int find(long searchKey){ //start of find()
        int lowerBound = 0;
        int upperBound = size() - 1;
        
        int output = nElems + 1;
        boolean exit = true;
        
        int curln = (lowerBound + upperBound)/2; //midpoint
        
        while(curln < size()){
            if(array[curln] == searchKey){
                output = curln;
                break;
            }
            else if(array[curln] < searchKey){
                lowerBound = curln + 1;
                curln = (lowerBound + upperBound)/2;
            }
            else{
                upperBound = curln - 1;
                curln = (lowerBound + upperBound)/2;
            }
        }
          
        return output;
    } //end of find()
    //------------------------------------------------------------------------
    
    
    public void insert(long value){ //start of insert()
        for(int c = 0; c<nElems; c++){
            if(array[c] == 0){
                array[c] = value;
                break;
            }
        }
        
        for(int i = 0; i<nElems; i++){
            for(int j = i+1; j<nElems; j++){
                if(array[i] > array[j]){
                    long temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        
        
    } //end of insert()
    //-------------------------------------------------------------------
    
    
    public boolean delete(long value){ //start of delete()
        int index = find(value);
        boolean output = false;
        int index1 = 0;
        
        if(index == nElems + 1){
            System.out.println("Value cannot be found in the array!");
        }
        else{
            for(int c = index; c<=size()-index; c++){
                array[c] = array[c+1];
                index1 = c+1;
            }
            
            array[index1] = 0;
            output = true;
        }
        
        return output;
    } //end of delete()
    //-------------------------------------------------------------------
    
    
    public void display(){ //start of display()
        System.out.print("Array = [ ");
        for(int c = 0; c<nElems; c++){
            System.out.print(array[c] + " ");
        }
        System.out.println("]");
    } //end of display()
    //------------------------------------------
}
