package polynomial;

public interface Polynomial
{
	public int getCoefficient(int power);
	
	public void setCoefficient(int coef, int power);
	
	public void addCoefficient(int coef, int power);
	
	public String toString();
	
	public double evaluate(double x);
	
	public Polynomial add(Polynomial p);
}