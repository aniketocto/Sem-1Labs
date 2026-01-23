class HashTable1
{
	private Integer[] table;
	private int size;
	private int capacity;

	public HashTable1(int capacity)
	{
		this.table = new Integer[capacity];
		this.capacity = capacity;
		this.size = 0;
	}

	public int Hash(int key)
	{
		return (key % 100) % capacity;
	}

	public void Insert(int key)
	{
		if(size > capacity)
		{
			System.out.println("Table is full");
			return;
		}

		int index = Hash(key);

		while(table[index] != null)
		{
			index = (index + 1) % capacity;
		}
		table[index] = key;
		size++;
	}

	public void Display()
	{
		for(int i = 0; i < capacity; i++)
		{
			if(table[i] != null)
			{
				System.out.println(i +" : " + table[i]);
			} else
			{
				System.out.println(i + " : null"); 
			}
		}
	}

	public static void main(String[] args)
	{
		HashTable1 ht1 = new HashTable1(10);

		int arr[] = {5, 10, 15, 25, 35, 55, 70, 52};
		for(int i: arr)
		{
			ht1.Insert(i);
		}

		ht1.Display();
	}
}