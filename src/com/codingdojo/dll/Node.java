package com.codingdojo.dll;

public class Node {
	
	// Node member class attributes value and next are the standard attributes for a singly linked list
	public Integer value;
    public Node next;
    
    // Node member class attribute previous completes the attributes required for a reverse link of a 
    // doubly linked list
    public Node previous;
    
    /* Node constructor to set the initial value for the first node,  and the next/previous pointers to 	* null once instantiation occurs*/
    public Node(Integer val) {
        this.value = val;
        this.previous = null;
        this.next = null;
    }
    
	
}
