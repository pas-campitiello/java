public class BST 
{
	private BinNode root;
	
	public BST() { root = null; }
	
	public void clear() {root = null;}
	
	public void insert(Elem val) 
	{
		root = inserthelp(root, val);
	}
	
	public void remove(int key)
	{
		root = removehelp(root, key);
	}
	
	public Elem find(int key)
	{
		return findhelp(root, key);
	}
	
	public boolean isEmpty()
	{
		return root == null;
	}
	
	public void print()
	{
		if (root == null)
			System.out.println("The BST is empty.");
		else
		{
			printhelp(root,0);
			System.out.println();
		}
	}
	
	// Methods
	
	private Elem findhelp(BinNode rt, int key)
	{
		if (rt == null) return null;
		
		Elem it = (Elem)rt.element();
		
		if (it.key() > key) return findhelp(rt.left(),key);
		else if (it.key() == key) return it;
		else return findhelp(rt.right(), key);
	}
	
	private BinNode inserthelp(BinNode rt, Elem val)
	{
		if (rt == null) return new BinNode(val);
		
		Elem it = (Elem) rt.element();
		
		if (it.key() > val.key()) rt.setLeft(inserthelp(rt.left(),val));
		else rt.setRight(inserthelp(rt.right(),val));
		
		return rt;
	}
	
	private BinNode deletemin(BinNode rt)
	{
		if (rt.left()== null) return rt.right();
		else
		{
			rt.setLeft(deletemin(rt.left()));
			return rt;
		}
	}
	
	private Elem getmin(BinNode rt)
	{
		if (rt.left() == null) return (Elem)rt.element();
		else return getmin(rt.left());
	}
	
	private BinNode removehelp(BinNode rt, int key)
	{
		if (rt == null)return null;
		Elem it = (Elem) rt.element();
		
		if (key < it.key())
			rt.setLeft(removehelp(rt.left(),key));
		else if (key > it.key())
			rt.setRight(removehelp(rt.right(),key));
		else
		{
			if (rt.left() == null)
				rt = rt.right();
			else if (rt.right() == null)
				rt = rt.left();
			else
			{
				Elem temp = getmin(rt.right());
				rt.setElement(temp);
				rt.setRight(deletemin(rt.right()));
			}
		}
		
		return rt;
	}
	
	
}

