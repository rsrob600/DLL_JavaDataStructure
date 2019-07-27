package com.codingdojo.dll;

public class ListTester {

	public static void main(String[] args) {

		// Instantiate a new DoublyLinkedList Object
		DoublyLinkedList dll = new DoublyLinkedList();
		
		// Instantiate new node objects
	    Node n1 = new Node(10);
	    Node n2 = new Node(20);
	    Node n3 = new Node(30);
	    Node n4 = new Node(40);
	    Node n5 = new Node(50);
	    Node n6 = new Node(60);
	    Node n7 = new Node(55);
	        
	    // add the nodes created above to the DoublyLinkedList object created above
	    dll.push(n1);
	    dll.push(n2);
	    dll.push(n3);
	    dll.push(n4);
	    dll.push(n5);
	    dll.push(n6);
	    
	    System.out.println("-----------------Print Forward-------------------");
	    dll.printValuesForward();
	    System.out.println("");
	    
	    
	    System.out.println("-----------------Print Backwards-------------------");
	    dll.printValuesBackward();
	    System.out.println("");
	    
	    
	    System.out.println("-----------------Delete Last Node and Print-------------------");
	    dll.pop();
	    dll.printValuesForward();
	    System.out.println("");
	    
	    
	    System.out.println("-----------------Contains-------------------");
	    dll.contains(50);
	    dll.contains(60);
	    System.out.println("");
	    
	    
	    System.out.println("-----------------Number of nodes in the list-------------------");
	    dll.size();
	    System.out.println("");
	    
	    
	    System.out.println("-----------------Insert Node at-------------------");
	    dll.insertAt(n7, 1);
	    dll.printValuesForward();
	    System.out.println("");
	    
	    
	    System.out.println("-----------------Remove Node at-------------------");
	    dll.removeAt(3);
	    dll.printValuesForward();
	    System.out.println("");
	    
	    
	    System.out.println("-----------------Is Palindrone-------------------");
	    //dll.isPalindrone();
	    //dll.printValuesForward();
	    
	}

}
