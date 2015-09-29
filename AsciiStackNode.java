/**
  *	Nodes for the AsciiStack
  */

public class AsciiStackNode{

	AsciiStackNode next;
	AsciiImage img;

	public AsciiStackNode(AsciiImage img, AsciiStackNode next){
		
		this.img = img;
		this.next = next;
	}

	public AsciiImage getImage(){
		return img;
	}

	public AsciiStackNode getNext(){

		if(this.next != null){
			return next;
		}else{
			return null;
		}
	}

/**
  * 	Recursive Implementation, if head has no next element, it returns ++(0) which would become 1.
  * 	otherwise: ++(-1) becomes 0
  */
	
	public int size(){

		int size = -1;
		AsciiStackNode n = this;
		if(n.getNext() == null){
			return 0;
		}else{
			n.getNext().size();
		}
		return ++size;
	}
}
