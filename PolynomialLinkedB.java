package polynomial;

import java.util.*;

public class PolynomialLinkedB implements Polynomial
{
    private LinkedList<PolyTerm> polyList;
    
    public PolynomialLinkedB()
    {
        polyList = new LinkedList<PolyTerm>();
    }

	@Override
	public int getCoefficient(int power)
	{
		ListIterator<PolyTerm> i = polyList.listIterator();
		
		if (polyList.isEmpty())
		    return 0;
		else
		{
		    PolyTerm temp = i.next();
		    for (int k = temp.pow; k < power && i.hasNext(); k = temp.pow)
		    {
		        temp = i.next();
		    }
		    if (temp.pow == power)
		    {
		        return temp.pow;
		    }
		    
		}
		return 0;
		
	}

	@Override
	public void setCoefficient(int coef, int power)
	{
	    
	    ListIterator<PolyTerm> i = polyList.listIterator();
	    
	    PolyTerm temp = i.next();
	    
        if (temp == null)
            polyList.add(0, new PolyTerm(coef, power));
        else if(temp.pow < power)
            polyList.add(0, new PolyTerm(coef, power));
        else
        {
            
            while(temp != null)
            {
                if(temp.pow > power)
                {
                    temp = i.next();
                }
                else
                    break;
            }
            
            if (temp == null)
                polyList.add(i.previousIndex(), new PolyTerm(coef, power));
            else if (temp.pow != power)
                polyList.add(i.previousIndex(), new PolyTerm(coef, power));
            else
                temp.coef = coef;
        }
    }

	@Override
	public void addCoefficient(int coef, int power)
{
        
        ListIterator<PolyTerm> i = polyList.listIterator();
        
        PolyTerm temp = i.next();
        
        if (temp == null)
            polyList.add(0, new PolyTerm(coef, power));
        else if(temp.pow < power)
            polyList.add(0, new PolyTerm(coef, power));
        else
        {
            
            while(temp != null)
            {
                if(temp.pow > power)
                {
                    temp = i.next();
                }
                else
                    break;
            }
            
            if (temp == null)
                polyList.add(i.previousIndex(), new PolyTerm(coef, power));
            else if (temp.pow != power)
                polyList.add(i.previousIndex(), new PolyTerm(coef, power));
            else
                temp.coef = temp.coef + coef;
        }
    }
	
	
    public String toString()
    {
        //TODO This method...
        
        return "Mason is an idiot :( ";
    }

	@Override
	public double evaluate(double x)
	{
		double toRet = 0.0;
		
		ListIterator<PolyTerm> i = polyList.listIterator();
		
		PolyTerm temp = i.next();
		
		if (polyList.isEmpty())
            toRet = 0.0;
        else
        {
           while (temp != null)
           {
               toRet = toRet + (double)temp.coef * Math.pow(x, (double) temp.pow);
               temp = i.next();
           }
        }
        return toRet;
		
	}

	@Override
	public Polynomial add(PolynomialLinkedB p)
	{
	    ListIterator<PolyTerm> ci = polyList.listIterator();
	    ListIterator<PolyTerm> pi = p.polyList.listIterator();
	    
	}
	
	class PolyTerm
	{
	    int coef;
	    int pow;
	    
	    PolyTerm(int c, int p)
	    {
	        coef = c;
	        pow = p;
	    }
	}

}
