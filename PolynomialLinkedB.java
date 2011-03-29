package polynomial;

import java.util.*;

/**
 * File: PolynomialLinkedB.java
 * @author Marc Slaughter, Mason Geyser, and Patrick Bowman
 * @version 29 March 2011
 * Description: A class to store and perform operations on a polynomial using the LinkedList
 *              class from the java API.
 */
public class PolynomialLinkedB implements Polynomial
{
    
     /**
     * A default constructor, initializing an empty list.
     */
    public PolynomialLinkedB()
    {
        polyList = new LinkedList<PolyTerm>();
    }

    /**
     * Return the coefficient of a term in the stored polynomial with specified power.
     * @param power - The power of the desired polynomial term
     * @return The coefficient of the desired term
     */
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

    /**
     * Set the coefficient of a specified term in the polynomial
     * @param coef - The new coefficient of the desired term
     * @param power -  The power of the desired polynomial term
     */
    public void setCoefficient(int coef, int power)
    {
        
        ListIterator<PolyTerm> i = polyList.listIterator();
        
        PolyTerm temp;
        
        if(i.hasNext())
            temp = i.next();
        else
            temp = null;
        
        if (temp == null)
            polyList.addFirst(new PolyTerm(coef, power));
        else if(temp.pow < power)
            polyList.addFirst(new PolyTerm(coef, power));
        else
        {
            
            while(temp != null)
            {
                if(temp.pow > power)
                {
                    if(i.hasNext())
                        temp = i.next();
                    else
                        temp = null;
                }
                else
                    break;
            }
            
            if (temp == null)
                polyList.add(i.nextIndex(), new PolyTerm(coef, power));
            else if (temp.pow != power)
                polyList.add(i.nextIndex(), new PolyTerm(coef, power));
            else
                temp.coef = coef;
        }
        
        if (coef == 0)
            polyList.remove(i.previousIndex());
    }


    /**
     * Add the coefficient of a specified term in the polynomial to the passed value
     * @param coef - The number to be added to the coefficient of the desired term
     * @param power -  The power of the desired polynomial term
     */
    public void addCoefficient(int coef, int power)
    {
        
        ListIterator<PolyTerm> i = polyList.listIterator();
        
        PolyTerm temp;
        
        if(i.hasNext())
            temp = i.next();
        else
            temp = null;
        
        if (temp == null)
        {
            polyList.add(0, new PolyTerm(coef, power));
           
            temp = i.next();
            
            if (coef == 0)
                temp.coef = coef;
        }
        else if(temp.pow < power)
        {
            polyList.add(0, new PolyTerm(coef, power));
            if (coef == 0)
                temp.coef = coef;
        }
        else
        {
            
            while(temp != null)
            {
                if(temp.pow > power)
                {
                    if(i.hasNext())
                        temp = i.next();
                    else
                        temp = null;
                }
                else
                    break;
            }
            
            if (temp == null)
                polyList.add(i.nextIndex(), new PolyTerm(coef, power));
            else if (temp.pow != power)
                polyList.add(i.nextIndex(), new PolyTerm(coef, power));
            else
                temp.coef = temp.coef + coef;
        }
       
        if (temp != null)
        if (temp.coef == 0)
            polyList.remove(i.previousIndex());
    }
    
    /**
     * Set the coefficient of a specified term in the polynomial
     * @return A string representation of the polynomial of the form:
     *              3 * x^4 + 4 * x^2 + 2
     */
    public String toString()
    {
        ListIterator<PolyTerm> i = polyList.listIterator();
        
        String str = "";
        PolyTerm curr;
        
        if(i.hasNext())
            curr = i.next();
        else
            curr = null;
        
        while (curr != null)
        {

            if (curr.pow == 0)
                str = str + curr.coef;
            else if (curr.pow == 1)
                str = str + curr.coef + " * x";
            else
                str = str + curr.coef + " * x^" + curr.pow; 
            
            if(i.hasNext())
                curr = i.next();
            else
                curr = null;
            
            if (curr != null)
                str = str + " + ";
        } 
        
        return str;
    }

    /**
     * Evaluate the stored polynomial with specified x value
     * @param x - the specified x value
     * @return The outcome of evaluating the polynomial
     */
    public double evaluate(double x)
    {
        double toRet = 0.0;
        
        ListIterator<PolyTerm> i = polyList.listIterator();
        
        PolyTerm temp;
        
        if(i.hasNext())
            temp = i.next();
        else
            temp = null;
        
        if (polyList.isEmpty())
            toRet = 0.0;
        else
        {
           while (temp != null)
           {
               toRet = toRet + (double)temp.coef * Math.pow(x, (double) temp.pow);
               if(i.hasNext())
                   temp = i.next();
               else
                   temp = null;
           }
        }
        return toRet;
        
    }

    /**
     * Add the passed polynomial to the calling polynomial
     * @param px - The polynomial to be added to the calling polynomial
     * @return The outcome of adding the two polynomials
     */
    public PolynomialLinkedB add(Polynomial px)
    {
        PolynomialLinkedB p = (PolynomialLinkedB)px;
        ListIterator<PolyTerm> ci = polyList.listIterator();
        ListIterator<PolyTerm> pi = p.polyList.listIterator();
        
        PolynomialLinkedB toRet = new PolynomialLinkedB();
        
        PolyTerm cTemp, pTemp;
        
        if(ci.hasNext())
            cTemp = ci.next();
        else
            cTemp = null;
        
        if(pi.hasNext())
            pTemp = pi.next();
        else
            pTemp = null;
        
        while (cTemp != null && pTemp != null)
        {
            if (cTemp.pow == pTemp.pow)
            {
                if (cTemp.coef + pTemp.coef != 0)
                    {
                    toRet.polyList.addLast(new PolyTerm(cTemp.coef + pTemp.coef, cTemp.pow));
                    if(ci.hasNext())
                        cTemp = ci.next();
                    else
                        cTemp = null;
                    if(pi.hasNext())
                        pTemp = pi.next();
                    else
                        pTemp = null;
                    }
                else
                    {
                      if(ci.hasNext())
                         cTemp = ci.next();
                      else
                         cTemp = null;
                      if(pi.hasNext())
                         pTemp = pi.next();
                      else
                         pTemp = null;
                    }
            }
            
            else if(cTemp.pow > pTemp.pow)
            {
                toRet.polyList.addLast(new PolyTerm(cTemp.coef, cTemp.pow));
                if(ci.hasNext())
                    cTemp = ci.next();
                else
                    cTemp = null;
            }
            
            else
            {
                toRet.polyList.addLast(new PolyTerm(pTemp.coef, pTemp.pow));
                if(pi.hasNext())
                    pTemp = pi.next();
                else
                    pTemp = null;
            }
        }
        
        while (cTemp != null && pTemp == null)
        {
            toRet.polyList.addLast(new PolyTerm(cTemp.coef, cTemp.pow));
            if(ci.hasNext())
                cTemp = ci.next();
            else
                cTemp = null;
        }
        
        while (cTemp == null && pTemp != null)
        {
            toRet.polyList.addLast(new PolyTerm(pTemp.coef, pTemp.pow));
            if(pi.hasNext())
                pTemp = pi.next();
            else
                pTemp = null;
        }
        
        return toRet;
        
    }
    
    //Private field
    private LinkedList<PolyTerm> polyList;
    
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
