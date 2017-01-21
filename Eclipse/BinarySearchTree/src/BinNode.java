public class BinNode implements Elem 
{
	private Object value;
	private BinNode leftChild;
	private BinNode rightChild;
		
	public BinNode(int value) 
	{
		super();
		this.value = value;
	}
	
	// Return and set the element value
	public Object element() { return value; }
	public Object setElement(Object v) { return value=v; }
	
	// Return and set the left child
	public BinNode left() { return leftChild; }
	public BinNode setLeft(BinNode p)
	{ return this.leftChild = p; }
	
	// Return and set the right child
	public BinNode right() { return rightChild; }
	public BinNode setRight(BinNode p)
	{ return this.rightChild = p; }
	
	// Return true if this is a leaf node
	public boolean isLeaf() { return ( (rightChild == null) && (leftChild == null) ); }

	public int key() 
	{
		return (int)element();  // <== il metodo key mi deve restituire un INT!!!!!!!!!!!
	}
}
