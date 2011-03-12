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
		double toRet = 0.0;
		PolyNode temp = head;
		
		if (head == null)
			toRet = 0.0;
		else
		{
			while (head.next != null)
			{
				toRet = toRet + (temp.coef * Math.pow(x, (double) temp.exp));
				temp = temp.next;
			}
		}
		return toRet;
	}

	/**
	 * So I did this the short and easy way, but not necessarily the efficient way...needs work
	 */
	public Polynomial add(Polynomial p)
	{
		PolynomialLinkedA toRet = this;
		PolynomialLinkedA h = (PolynomialLinkedA) p;
		
		PolyNode paramCurr = h.head;
		
		while (paramCurr != null)
		{
			toRet.addCoefficient(paramCurr.coef, paramCurr.exp);
			paramCurr = paramCurr.next;
		}
		
		return toRet;
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