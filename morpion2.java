public class morpion2
{
	public static void main(String[] arg)
	{
		int case11 = 7;
		int case12 = 8;
		int case13 = 9;
		int case21 = 4;
		int case22 = 5;
		int case23 = 6;
		int case31 = 1;
		int case32 = 2;
		int case33 = 3;
		int [] listCase = {case11, case12, case13, case21, case22, case23, case31, case32, case33};
		for (int i = 0; i < 9; i++)
		{
			if (i % 3 == 2)
			{
				System.out.print("|" + listCase[i] + "|\n");
			}
			else
			{
				System.out.print("|" + listCase[i]);
			}
		}
	
	}
}
