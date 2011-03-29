package polynomial;

/**
 * File: PolynomialLinkedA.java
 * @author Marc Slaughter, Mason Geyser, and Patrick Bowman
 * @version 29 March 2011
 * Description: A class to store and perform operations on a polynomial
 */
public class PolynomialLinkedA implements Polynomial
{
    
    
    /**
     * A default constructor, initializing an empty list.
     */
    public PolynomialLinkedA()
    {
        head = null;
    }

    /**
     * Return the coefficient of a term in the stored polynomial with specified power.
     * @param power - The power of the desired polynomial term
     * @return The coefficient of the desired term
     */
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

    /**
     * Set the coefficient of a specified term in the polynomial
     * @param coef - The new coefficient of the desired term
     * @param power -  The power of the desired polynomial term
     */
    public void setCoefficient(int coef, int power)
    {
        PolyNode prev = head;
        PolyNode curr = head;
        
        if (head == null)
            head = new PolyNode(coef, power, null);
        else if(head.exp < power)
        {
            head = new PolyNode(coef, power, head);
            curr = head.next;
        }
        else
        {
            
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
        if (curr != null)
        if (curr.coef == 0)
            prev.next = curr.next;
    }

    /**
     * Add the coefficient of a specified term in the polynomial to the passed value
     * @param coef - The number to be added to the coefficient of the desired term
     * @param power -  The power of the desired polynomial term
     */
    public void addCoefficient(int coef, int power)
{
        
        PolyNode prev = head;
        PolyNode curr = head;
        
        if (head == null)
            head = new PolyNode(coef, power, null);
        else if(head.exp < power)
        {
            head = new PolyNode(coef, power, head);
            curr = head.next;
        }
        else
        {
            
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
        
        if (curr != null)
        if (curr.coef == 0)
            prev.next = curr.next;
}
    /**
     * Set the coefficient of a specified term in the polynomial
     * @return A string representation of the polynomial of the form:
     *              3 * x^4 + 4 * x^2 + 2
     */
    public String toString()
    {
        String str = "";
        
        PolyNode curr = head;
        
        while (curr != null)
        {
            if (curr.exp == 0)
                str = str + " " + curr.coef;
            else if (curr.exp == 1)
                str = str + curr.coef + " * x";
            else
                str = str + curr.coef + " * x^" + curr.exp; 
            
            curr = curr.next;
            
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
     * Add the passed polynomial to the calling polynomial
     * @param px - The polynomial to be added to the calling polynomial
     * @return The outcome of adding the two polynomials
     */
    public PolynomialLinkedA add(Polynomial px)
    {
        PolynomialLinkedA p = (PolynomialLinkedA)px;
        PolynomialLinkedA toRet = new PolynomialLinkedA();
        
        PolyNode cTemp = head;
        PolyNode pTemp = p.head;
        
        toRet.head = new PolyNode(0,0,null);
        PolyNode curr = toRet.head;
        
        while (cTemp != null && pTemp != null)
        {
            if (cTemp.exp == pTemp.exp && cTemp.coef + pTemp.coef != 0)
            {
               
                curr.next = new PolyNode(cTemp.coef + pTemp.coef, cTemp.exp, null);
                cTemp = cTemp.next;
                pTemp = pTemp.next;
                
                curr = curr.next;
                
            }
            
            else if(cTemp.exp > pTemp.exp)
            {
                curr.next = new PolyNode(cTemp.coef, cTemp.exp, null);
                cTemp = cTemp.next;
                
                curr = curr.next;   
            }
            
            else if(cTemp.exp < pTemp.exp)
            {
                curr.next = new PolyNode(pTemp.coef, pTemp.exp, null);
                pTemp = pTemp.next;
                
                curr = curr.next;   
            }
            else
            {
                pTemp = pTemp.next;
                cTemp = cTemp.next;
            }
        }
        
        while (cTemp != null && pTemp == null)
        {
            curr.next = new PolyNode(cTemp.coef, cTemp.exp, null);
            cTemp = cTemp.next;
            
            curr = curr.next;   
        }
        
        while (cTemp == null && pTemp != null)
        {
            curr.next = new PolyNode(pTemp.coef, pTemp.exp, null);
            pTemp = pTemp.next;
            
            curr = curr.next;  
        }
        
        toRet.head = toRet.head.next;
        
        return toRet;
        
    }
    
    
    //instance fields
    protected PolyNode head;
    
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