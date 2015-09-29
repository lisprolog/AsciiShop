/**
  * 	LinkedList Stack
  */

public class AsciiStack{

	AsciiStackNode head;

	public AsciiStack(){
		head = new AsciiStackNode(null, null);
	}

/**
  *	pushes an AsciiImage on the stack
  */

	public void push(AsciiImage img){

		AsciiStackNode node;

		if(empty()){
			node = new AsciiStackNode(img, null);
			head.next = node;
		}else{
			node = new AsciiStackNode(img, head.getNext());	
			head.next = node;
		}
	}

/**
  *  	pops top AsciiImage from the stack
  */

	public AsciiImage pop(){

		AsciiStackNode node = new AsciiStackNode(head.getNext().getImage(), head.getNext().getNext());
		AsciiImage result;

		if(head.getNext() == null){
			result = null;
		}else{
			head.next = node.getNext();
			result = new AsciiImage(node.getImage());
		}
		return result;
	}

/**
  *	return all AsciiImages without reducing the stack
  */
	public AsciiImage peekAll(){

		AsciiStackNode node = new AsciiStackNode(head.getNext().getImage(), head.getNext().getNext());
		AsciiImage result;

		if(head.getNext() == null){
			result = null;
		}else{
			head.next = node.getNext();
			result = new AsciiImage(node.getImage());
		}
		return result;
	}
	

/**
  *	return the top AsciiImage, without reducing the stack
  */
	public AsciiImage peek(){

		if(head.getNext() != null){
			return head.getNext().getImage();
		}else{
			return null;
		}
	}

/**
  *	returns true, if the stack is empty
  */
	public boolean empty(){

		if(peek() == null){
			return true;
		}else{
			return false;
		}
	}

/**
  *	returns the stacksize
  */
	public int size(){

		AsciiStackNode n = head;
		return n.size();
	}
}
