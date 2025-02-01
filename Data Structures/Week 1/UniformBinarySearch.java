class UniformBinarySearch
{	
	static int MAX_SIZE = 1000; 
 
	static int lookup_table[] = new int[MAX_SIZE]; 
	 
	static void create_table(int n) 
	{ 
		int pow = 1; 
		int co = 0; 
		do
		{  
			pow <<= 1; 
			lookup_table[co] = (n + (pow >> 1)) / pow; 
		} while (lookup_table[co++] != 0); 
	} 
	
	static int binary(int arr[], int v) 
	{  
		int index = lookup_table[0] - 1; 
	
		int co = 0; 
	
		while (lookup_table[co] != 0) 
		{ 
	
			if (v == arr[index]) 
				return index; 
	 
			else if (v < arr[index]) 
			{
				index -= lookup_table[++co]; 

			} 
			else
			{
				index += lookup_table[++co];
				
			}
		} 
		return index ;
	} 
	public static void main (String[] args) 
	{ 
	
		int arr[] = { 1, 3, 5, 6, 7, 8, 9 }; 
		int n = arr.length;  
		create_table(n);  
		System.out.println( "Position of 3 in array = " + binary(arr, 3)) ;
	
	
	} 
}

