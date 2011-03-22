package polynomial;

public class PolynomialLinkedA implements Polynomial
{
	//instance fields
	protected PolyNode head;
	
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
			while(temp.next != null && temp.exp > power)
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
	//TODO work out the boolean crap in the while loop...it aint workin...
	public void setCoefficient(int coef, int power)
	{
		if (head == null)
			head = new PolyNode(coef, power, null);
		else if(head.exp < power)
			head = new PolyNode(coef, power, head);
		else
		{
			PolyNode prev = head;
			PolyNode curr = head;
			
			while(curr != null)
			{
				if(curr.exp > power)
				{
					prev = curr;
					curr = curr.next;
				}
				else
					break;
			}
			
			if (curr == null)
			    prev.next = new PolyNode(coef, power, curr);
			else if (curr.exp != power)
			    prev.next = new PolyNode(coef, power, curr);
			else
				curr.coef = coef;
		}
	}

	@Override
	public void addCoefficient(int coef, int power)
{
		
	    if (head == null)
            head = new PolyNode(coef, power, null);
        else if(head.exp < power)
            head = new PolyNode(coef, power, head);
        else
        {
            PolyNode prev = head;
            PolyNode curr = head;
            
            while(curr != null)
            {
                if(curr.exp > power)
                {
                    prev = curr;
                    curr = curr.next;
                }
                else
                    break;
            }
            
            if (curr == null)
                prev.next = new PolyNode(coef, power, curr);
            else if (curr.exp != power)
                prev.next = new PolyNode(coef, power, curr);
            else
                curr.coef = curr.coef + coef;
        }
}
	//TODO this method
	public String toString()
	{
	    return "Mason is an idiot :( ";
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
			while (temp != null)
			{
				toRet = toRet + ((double) temp.coef * Math.pow(x, (double) temp.exp));
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