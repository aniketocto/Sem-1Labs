class PostEval
{
	public static void main(String[] args)
	{
		String expression = "93+42-*5+";
		int result = eval(expression);
		System.out.println("Result: " + result);
	}

	public static int eval(String exp)
	{	
		int[] stack = new int[exp.length()];
		int tos = -1;
		
		for(int i = 0; i < exp.length(); i++)
		{
			char ch = exp.charAt(i);

			if(Character.isDigit(ch))
			{
				stack[++tos] = ch - '0';
			}
			else
			{
				int x1 = stack[tos--];
				int x2 = stack[tos--];

				int result = 0;

				switch(ch)
				{
					case '+':
						result = x2 + x1;
						break;
					case '-':
						result = x2 - x1;
						break;
					case '*':
						result = x2 * x1;
						break;
					case '/':
						result = x2 / x1;
						break;
				}

				stack[++tos] = result;
			}
		}

		return stack[tos];
	}
}