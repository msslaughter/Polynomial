package polynomial;

/**
 * File: Polynomial.java
 * @author Marc Slaughter, Mason Geyser, and Patrick Bowman
 * @version 29 March 2011
 * Description: An interface for storing and performing operations on polynomials
 */
public interface Polynomial
{
    /**
     * Return the coefficient of a term in the stored polynomial with specified power.
     * @param power - The power of the desired polynomial term
     * @return The coefficient of the desired term
     */
    public int getCoefficient(int power);
    
    /**
     * Set the coefficient of a specified term in the polynomial
     * @param coef - The new coefficient of the desired term
     * @param power -  The power of the desired polynomial term
     */
    public void setCoefficient(int coef, int power);
    
    /**
     * Add the coefficient of a specified term in the polynomial to the passed value
     * @param coef - The number to be added to the coefficient of the desired term
     * @param power -  The power of the desired polynomial term
     */
    public void addCoefficient(int coef, int power);
    
    /**
     * Set the coefficient of a specified term in the polynomial
     * @return A string representation of the polynomial of the form:
     *              3 * x^4 + 4 * x^2 + 2
     */
    public String toString();
    
    /**
     * Evaluate the stored polynomial with specified x value
     * @param x - the specified x value
     * @return The outcome of evaluating the polynomial
     */
    public double evaluate(double x);
    
    /**
     * Add the passed polynomial to the calling polynomial
     * @param p - The polynomial to be added to the calling polynomial
     * @return The outcome of adding the two polynomials
     */
    public Polynomial add(Polynomial p);
}