package polynomial;

public class PolynomialLinkedA implements Polynomial
{
	//instance fields
	private PolyNode head;
	
	//constructor
	public PolynomialLinkedA()
	{
		head = null;
	}

	@Override
	public int getCoefficient(int power)
	{
		int toRet;
		PolyNode temp = head;
		
		if (temp == null)
			toRet = 0;
		else
		{
			while(temp.exp < power)
			{
				temp = temp.next;
			}
			
			if (temp.exp == power)
				toRet = temp.coef;
			else
				toRet = 0;
		}
		
		return toRet;
	}

	@Override
	public void setCoefficient(int coef, int power)
	{
		
		PolyNode prev = head;
		PolyNode curr = head.next;
		
		if (head == null)
			head = new PolyNode(coef, power, null);
		else
		{
			while(curr.exp < power)
			{
				curr = curr.next;
				prev = prev.next;
			}
			
			if (curr.exp == power)
				curr.coef = coef;
			else
				prev.next = new PolyNode(coef, power, curr);
		}
	}

	@Override
	public void addCoefficient(int coef, int power)
{
		
		PolyNode prev = head;
		PolyNode curr = head.next;
		
		if (head == null)
			head = new PolyNode(coef, power, null);
		else
		{
			while(curr.exp < power)
			{
				curr = curr.next;
				prev = prev.next;
			}
			
			if (curr.exp == power)
				curr.coef = curr.coef + coef;
			else
				prev.next = new PolyNode(coef, power, curr);
		}
	}

	@Override
	public double evaluate(double x)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Polynomial add(Polynomial p)
	{
		// TODO Auto-generated method stub
		return null;
	}
}

class PolyNode
{
	//instance fields
	int coef;
	int exp;
	PolyNode next;
	
	//constructor
	public PolyNode(int c, int e, PolyNode n)
	{
		coef = c;
		exp = e;
		next = n;
	}
}