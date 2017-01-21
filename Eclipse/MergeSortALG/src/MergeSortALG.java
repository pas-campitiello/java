public class MergeSortALG 
{
	public static void main(String[] args) 
	{
		int[] vettore = new int[4];
		int[] ausiliario = new int[4];
		
		vettore[0] = 8;
		vettore[1] = 1;
		vettore[2] = 3;
		vettore[3] = 9;
		
		mergesort(vettore,ausiliario,0,3);
		
		System.out.print("\n Vettore finale: ");
		print(vettore);
		
		System.out.print("\n Ausiliario finale: ");
		print(ausiliario);
	}
	
	static void mergesort(int[] array, int[] temp, int l, int r)
	{
		System.out.print("mergesort(");
		print(array);
		System.out.print(",");
		print(temp);
		System.out.print("," + l + "," + r + ") ");
		
		if (l==r) 
		{
			System.out.println(" -> " + l + "==" + r + " -> l==r");
			return;
		}
		
		int mid = (l+r)/2; System.out.print(" -> mid = " + mid + "\n");
		
		mergesort(array,temp,l,mid);		
		mergesort(array,temp,mid+1,r);
		merge(array,temp,l,mid,mid+1,r);
	}
	
	static void merge(int[] array, int[] temp, int l1, int r1, int l2, int r2)
	{
		System.out.print("\nmerge(");
		print(array);
		System.out.print(",");
		print(temp);
		System.out.print("," + l1 + "," + r1 + "," + l2 + "," + r1 +") ");
		
		for(int i=l1; i<=r2; i++)
			temp[i] = array[i];
		
		int i1 = l1; 
		int i2 = l2;
		
		for(int curr=l1; curr<=r2; curr++)
		{
			if (i1 > r1) array[curr] = temp[i2++];
			else if (i2 > r2) array[curr] = temp[i1++];
			else if (temp[i1]<temp[i2]) array[curr] = temp[i1++];
			else array[curr] = temp[i2++];
		}
		
		System.out.println(" -> DOPO merge -> l1=" + l1 + " r1=" + r1 + " l2=" + l2 + " r2=" + r2 + "\n");
	}
	
	static void print(int[] array)
	{
		for(int i=0; i<4; i++) System.out.print("[" + array[i] + "]");
	}

}
