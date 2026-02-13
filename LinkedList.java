/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emre.datastructures;


public class LinkedList implements ListInterface {
    private DLNode first;
    
  

    @Override
    public void Insert(int newElement, int pos) throws Exception {
        
        if (pos < 0) {
            throw new LinkedListException("Hata: Pozisyon 0'dan küçük olamaz.");
        }
        
        DLNode newNode = new DLNode();
        newNode.Element = newElement; 

        if (pos == 0) { 
            if (first == null) {
                
                first = newNode;
                newNode.left = null; 
                newNode.right = null; 
            } else {
               
                newNode.right = first; 
                first.left = newNode; 
                newNode.left = null; 
                first = newNode;      
            }
        } else {  
            DLNode current = first;
            int count = 1;
            
            while (current != null && count < pos) {
                current = current.right;
                count++;
            }

            
            if (current == null) {
                throw new LinkedListException("Hata: Pozisyon listenin sınırları dışında.");
            }
            
            
            
            DLNode nextNode = current.right; 

            newNode.right = nextNode; 
            newNode.left = current;   
            current.right = newNode;  

            if (nextNode != null) {
                nextNode.left = newNode; 
            }
        }
    }
     public int Delete(int pos) throws Exception {
        if(first== null){
            throw new LinkedListException("hata liste boş..");
        }
        
        if (pos < 1){
           throw new LinkedListException("pozisyon 1'den küçük olamaz");
        }
        DLNode current = first; 
        int count = 1;
        while (current != null && count < pos){    
            current = current.right;
            count++;
        }
        if( current ==null){ 
            throw new LinkedListException("Hata: " + pos + ". pozisyonda eleman bulunamadı.");
        }
        int deletedElement = current.Element;
            
        if (pos == 1) {
        first = current.right; 
        if (first != null) {
            first.left = null; 
        }
        
    } 
    
    
    else {
        DLNode prev = current.left;
        DLNode next = current.right;

      
        prev.right = next;

     
        if (next != null) {
          
            next.left = prev;
        }
        
    }
    
    return deletedElement;
}
  @Override
    public void ReverseLink() {
    

    DLNode current = first;
    DLNode prev = null; 

    
    while (current != null) {
        DLNode next = current.right; 
        
        current.right = prev; 
        current.left = next;  
        
        prev = current;       
        current = next;       
    }

   
    first = prev; 
    }
    public void SquashL() {
    if (first == null) {
        return;
    }

    DLNode oldCurrent = first;
    DLNode newFirst = null; 
    DLNode newLast = null;  

    while (oldCurrent != null) {
        int element = oldCurrent.Element;
        int count = 0;
        
        
        DLNode runner = oldCurrent; 
        while (runner != null && runner.Element == element) {
            count++;
            runner = runner.right;
        }

        
        
        DLNode elementNode = new DLNode();
        elementNode.Element = element;
        
       
        DLNode countNode = new DLNode();
        countNode.Element = count;

        
        if (newFirst == null) {
            
            newFirst = elementNode;
            newLast = countNode;
            
            elementNode.left = null;
            elementNode.right = countNode;
            countNode.left = elementNode;
            countNode.right = null;
        } else {
           
            newLast.right = elementNode; 
            elementNode.left = newLast; 
            
            elementNode.right = countNode;
            countNode.left = elementNode;
            countNode.right = null;
            
            newLast = countNode; 
        }
        
        
        oldCurrent = runner; 
    }
    
    
    first = newFirst;
}
    public void OplashL() {
    if (first == null) {
        return;
    }

    DLNode oldCurrent = first;
    DLNode newFirst = null; 
    DLNode newLast = null;  

    
    while (oldCurrent != null) {
        
        if (oldCurrent.right == null) {
          
            break; 
        }

        int element = oldCurrent.Element;
        int count = oldCurrent.right.Element;
        
        
        for (int i = 0; i < count; i++) {
            DLNode newNode = new DLNode();
            newNode.Element = element;
            
            
            if (newFirst == null) {
                
                newFirst = newNode;
                newLast = newNode;
                newNode.left = null;
                newNode.right = null;
            } else {
                
                newLast.right = newNode; 
                newNode.left = newLast;  
                newNode.right = null;
                newLast = newNode;       
            }
        }
        
        
        oldCurrent = oldCurrent.right.right;
    }
    
    
    first = newFirst;
}
     
    public void Output(){
     DLNode Dummy;
     Dummy = first;
     System.out.print("The Elements in the list are : ");
     while (Dummy != null){
        System.out.print(Dummy.Element + " " );
        Dummy = Dummy.right;
     }
     System.out.println(""); 
    }
    public void ROutput() {
     System.out.print("The Reverse Elements in the list are: ");
     DLNode current = first;

   
     while (current != null && current.right != null) {
        current = current.right;
    }

    
     while (current != null) {
        System.out.print(current.Element + " ");
        current = current.left; 
     }
     System.out.println("");
     
    }
    @Override
    
    public String toString() {
     DLNode current = first;
    
  
     String result = " ";

 
     while (current != null) {
        
        result = result + current.Element;
        
        
        if (current.right != null) {
            result = result + " ";
        }
        
        current = current.right;
     }
    
    return result;
    }

    @Override
    public Exception LinkedListException() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  


    
} 


class LinkedListException extends Exception {

   
    public LinkedListException(String message) {
        super(message);
    }
    
    
    public LinkedListException() {
        super();
    }
}
   
    
    
