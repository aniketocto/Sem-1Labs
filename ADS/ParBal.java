public class ParBal
{
	public static void main(String[] args)
	{
		String expression = "((a+b)+(c-d])";
		
		if(isBalanced(expression))
		{
			System.out.println("Balanced");
		} else
		{
			System.out.println("Not Balanced");
		}
	}

	public static boolean isBalanced(String exp)
	{
		int[] stack = new int[exp.length()];
		int tos = -1;

		for(int i = 0; i < exp.length(); i++)
		{
			char ch = exp.charAt(i);

			if(ch == '(')
			{
				stack[++tos] = ch;
			}
			else if(ch == ')')
			{			
				if(tos == -1)
				{
					return false;
				}
				tos--;
			}
		}
		return tos == -1;
	}
}