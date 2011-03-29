package polynomial;

import java.util.*;


/**
 * File: PolynomialTestB.java
 * @author Marc Slaughter, Mason Geyser, and Patrick Bowman
 * @version 29 March 2011
 * Description: A file to test the operations of PolynomialLinkedB.java
 */
public class PolynomialTestB
{

    /**
     * Test code to perform operations on polynomials using ONLY PolynomialLinkedB.java.
     * This code employs a scanner in order to wait for input (such as the enter key)
     * before displaying the next operation
     * @param args
     */
    public static void main(String[] args)
    {
        
        Scanner s = new Scanner(System.in);
        
        //Delcare, initialize, and populate 5 separate polynomials
        PolynomialLinkedB p1 = new PolynomialLinkedB();
        
        PolynomialLinkedB p2 = new PolynomialLinkedB();
        
        p2.setCoefficient(3,3);
        p2.setCoefficient(2,1);
        p2.setCoefficient(10,0);
       
        PolynomialLinkedB p3 = new PolynomialLinkedB();
        
        p3.setCoefficient(4,4);
        p3.setCoefficient(2,2);
        p3.setCoefficient(8,0);
        
        PolynomialLinkedB p4 = new PolynomialLinkedB();
        
        p4.setCoefficient(8,3);
        
        PolynomialLinkedB p5 = new PolynomialLinkedB();
        
        p5.setCoefficient(-2,2);
        
        //Print out each polynomial prior to performing operations waiting for the user to press a key between each
        System.out.println("************** THIS IS TEST CODE FOR POLYNOMIBL LINKED B ***************");
        
        System.out.println("Polynonmial 1 = " + p1.toString());
        
        s.nextLine();
        
        System.out.println("Polynonmial 2 = " + p2.toString());
        
        s.nextLine();
        
        System.out.println("Polynonmial 3 = " + p3.toString());
        
        s.nextLine();
        
        System.out.println("Polynonmial 4 = " + p4.toString());
        
        s.nextLine();
        
        System.out.println("Polynonmial 5 = " + p5.toString());
        
        s.nextLine();
           
        //Perform operations on the polynomials and print out the results
        PolynomialLinkedB p6 = p2.add(p3);
        System.out.println("Polynomial 2 + Polynomial 3 = " + p6.toString() + "\n");
        s.nextLine();
         
        p2.setCoefficient(4, 3);
        System.out.println("Polynomial 2 with the coefficient of the first term changed to 4: \n" + p2.toString());
        s.nextLine();
         
        PolynomialLinkedB p7 = p3.add(p5);
        System.out.println("Polynomial 3 + Polynomial 5 = " + p7.toString());
        s.nextLine();
 
        p4.addCoefficient(10,3);
        System.out.println("Polynomial P4 with 10 added to the coefficient of the term is: " + p4.toString());
        s.nextLine();
         
        p1.addCoefficient(6,100);
        System.out.println("Polynomail P1 with a term of degree 100 and coefficient 6 added to it: " + p1.toString());
        
         
    }

}
