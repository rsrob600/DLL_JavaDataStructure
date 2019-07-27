package com.codingdojo.dll;

public class DoublyLinkedList {

	// DoublyLinkedList member class attributes
	public Node head;
	public Node tail;
	public int length;
    
	// DoublyLinkedList Constructor to set both the head and tail as null
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    
    
    // the push method will add a new node to the end of the list
    public void push(Node newNode) {
    	
        /*if there is no head in the list, aka, an empty list, we set the newNode
        * to be the head and tail of the list*/
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            // increment the link length variable
            this.length++;
            return;
        }
        
        // first find the lastNode in the list
        Node lastNode = this.tail;
        // then, set the lastNode's next to be the newNode;
        lastNode.next = newNode;
        // then, we have to set the previous of the lastNode to the lastNode that we found previously.
        newNode.previous = lastNode;
        // finally, set the list's tail to be the node that we have added
        this.tail = newNode;
        // increment the link length variable
        this.length++;
    }
    

    // Node pop(): This method removes the last node of our DLL and returns it.
    public Node pop() {
    	// declare temp variable to store the current tail node during the swap
    	Node temp = tail;
    	// If the list is two nodes 
    	// "head node <> next node <> null/tail"
    	if(this.head.next == null) {
    		// set the head node to null (cutting off the "next" node from the list)
    		// "head node <> null/tail"
    		this.head = null;
    	}
    	else
    		// set the previous node's "Next" setting to "Null" (cutting off the current tail from the list)
    		// "head node <> next node <> next node <> null" becomes "head node <> next node <> null"
    		this.tail.previous.next = null;
    		// set the previous node to become the new "Tail" (removing the tail from the old tail)
    		// "head node <> next node <> null" becomes ""head node <> next node <> null/tail"
    		tail = tail.previous;
    	// decrement the link length variable
    	this.length--;	
    	return temp;
    }
    
    
    /*boolean contains(Integer value): This method returns a boolean whether the value in the argument
    * is in the list or not. Return true if the value exists, else, return false. */
    public boolean contains(Integer node) {
    	// find the first node, aka head
    	Node current = this.head;
    	// iterate through list until a match is found
    	while(current.value != node) {
    		// move to the next node
    		current = current.next;
    		// if you've arrived at the end of the list with no match
    		if(current == null) {
    			System.out.println("Sorry, match not found for: " + node);
    			return false;
    		}
    	}
    	// return match otherwise
    	System.out.println("Match found for: " + current.value);
    	return true;
    }
    
    
    // int size(): Returns the number of nodes in the list.
    public int size() {
    	// declare count variable
    	int count = 0;
    	// find the first node, aka head
    	Node current = this.head;
    	// iterate through the list
    	while(current != null) {
    		// increment the counter
    		count++;
    		// move to the next node
    		current = current.next;
    	}
    	System.out.println("There are currently " + count + " nodes found in this list.");
    	return count;
    }
    
    
    //--------------------------------------Bonus Challenges----------------------------------->

    
    /*void insertAt(Node newNode, int index): Inserts a node at a specific index. 
    * For example, let's say that we have 3 nodes in our list. If we call insertAt(newNode, 1), the
    * newNode should be inserted right after the head. (head is index 0) */
    public void insertAt(Node newNode, int index) {
    	// find the first node, aka head
        Node currentNode = this.head;

        // loop through list until you reach the target index to be removed
        for (int i = 0; i <= index; i++) {
        	// return error of the index entered is a negative number or greater than length of the list
            if (index < 0 || index > length-1) {
                System.out.println("The index is out of bounds");
                return;
            }
            // perform insert function if index is greater than 0 and less than max length (middle of the list)    
            else if (i > 0 && i < length && i == index) {
                // establish the "prevNode" variable to identify the node to the left of the target node
                Node prevNode = currentNode.previous;
                // connect the pointer of the node to the left of (target node) to the new node for insert
                prevNode.next = newNode;
                // connect the new inserted node to the old current node (to the right)
                newNode.next = currentNode;
                return;
            }
            // perform insert if index equal to 0 (head of list)
            else if (i == 0 && i == index) {
	        	// set the new node to become the new head
	            this.head = newNode;
	            // set the old head as the next node after the new head (new inserted node)
	            newNode.next = currentNode;
	            return;
	        }
            // move to the next node
            currentNode = currentNode.next;
        }
        // decrement the length list variable
        this.length--;
    }
    
    
    // void removeAt(int index): This method removes a node at an index. For example, let's say that we have 3 nodes in our list. If we call removeAt(1), the middle node is removed. (head is index 0)
	public void removeAt(int index) {
    	// find the first node, aka head
        Node currentNode = this.head;

        // loop through list until you reach the target index to be removed
        for (int i = 0; i <= index; i++) {
        	// return error of the index entered is a negative number or greater than length of the list
            if (index < 0 || index > length-1) {
                System.out.println("The index is out of bounds");
                return;
            }
            // return error if the list is empty    
            else if (currentNode == null) {
                System.out.println("The list is empty");
                return;
            }
            // perform removal function if index is greater than 0 and less than max length (middle of the list)    
            else if (i > 0 && i < length-1 && i == index) {
            	// establish the "nextNode" variable to identify the node to the right of the target node
                Node nextNode = currentNode.next;
                // establish the "prevNode" variable to identify the node to the left of the target node
                Node prevNode = currentNode.previous;
                // connect the pointer of the node to the left of (target node) to the node on the right of (target node)
                prevNode.next = nextNode;
                // connect the pointer of the node to the right of (target node) to the node on the left of (target node)
                nextNode.previous = prevNode;
                return;
            }
            // perform removal if index equal to 0 (head of list)
            else if (i == 0 && i == index) {
	        	// set the second node in the list (after head) to become the new head -- cutting off the old head at index 0
	            this.head = currentNode.next;
	            return;
	        }
            // perform removal if index is equal to the length (tail of list)
            else if (i == length-1 && i == index) {
	        	// 
	            currentNode.previous.next = null;
	            return;
	        }
            // move to the next node
            currentNode = currentNode.next;
        }
        // decrement the length list variable
        this.length--;
    }
    
	
	
    
    
    // boolean isPalindrome(): This method returns a boolean whether the node is a palindrome or not. Return true if it is a palindrome, else, return false.
    
    
    
    
    
    // ------------------------------------- Print Methods -------------------------------------
    
    // print values forward
    public void printValuesForward() {
        // find the first node, aka head.
        Node current = this.head;
        
        // while the current node exists...
        while(current != null) {
            // print it's value
            System.out.println(current.value);
            // and move on to it's next node.
            current = current.next;
        }
        
    }
	
    
    // This method prints the values of the nodes from the tail to the head.
    public void printValuesBackward() {
    	// find the last node, aka tail.
    	Node current = this.tail;
    	
    	// while the current node exists...
    	while(current != null) {
    		// print it's value
    		System.out.println(current.value);
    		// and move on to it's next node.
    		current = current.previous;
    	}
    }
    
	
}
