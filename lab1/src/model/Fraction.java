package model;

/**
 *  Data type for fractions
 *
 *  @author Ann Gridyushko
 *  @version 1.0.0
 */
public class Fraction {

    /** the numerator of fraction */
    private int numerator;

    /** the denominator of fraction */
    private int denominator = 1;

    /**
     * Create a fraction given the numerator and denominator
     *
     * @param a numerator
     * @param b denominator
     */
    public Fraction(long a, long b)
    {
        Init(a,b);
    }

    /**
     * The default constructor, which creates 0
     */
    public Fraction()
    {
        Init(0,1);
    }

    /**
     * Create a fraction given the numerator
     *
     * @param a numerator
     */
    public Fraction(int a)
    {
        numerator=a;
        denominator=1;
    }

    /**
     * The GCD method to reduce a fraction
     *
     * @param a numerator
     * @param b denimenator
     * @return reduced fraction
     */
    private long GCD (long a, long b) {
        return ((b != 0) ? GCD(b,a%b) : a);
    }

    /**
     * The Init method to reduce and validate created fraction
     * @param num numerator
     * @param den denominator
     */
    private void Init(long num, long den) {
        assert(den!=0):"denominator is null";
        int gcd = (int)GCD(Math.abs(num), Math.abs(den));
        num /= gcd;
        den /= gcd;
        assert(Math.abs(num) < Integer.MAX_VALUE && (Math.abs(den) < Integer.MAX_VALUE)) : "Overflow of int type";
        numerator = (int)num;
        denominator = (int)den;
        if (denominator < 0) {
            denominator = -denominator;
            numerator = -numerator;
        }
    }

    /**
     * Returnd a fraction whose value is this + addend
     *
     * @param f addend fraction
     * @return this + addend
     */
    public Fraction add(Fraction f) {
        long newY, newX;
        newY = (long)denominator*f.denominator;
        newX =(long)denominator * f.numerator + (long)numerator * f.denominator;
        return new Fraction(newX,newY);
    }

    /**
     * Returnd a fraction whose value is this + addend, with addend being decimal
     *
     * @param num addend decimal
     * @return this + addend
     */
    public Fraction add(int num) {
        return this.add(new Fraction(num));
    }

    /**
     * Returnd a fraction whose value is this - subtrahend
     *
     * @param f subtrahend fraction
     * @return this - subtrahend
     */
    public Fraction sub(Fraction f) {
        long newY, newX;
        newY = (long)denominator*f.denominator;
        newX =(long)numerator * f.denominator - (long)denominator * f.numerator ;
        Fraction result = new Fraction(newX,newY);
        return result;
    }

    /**
     * Returnd a fraction whose value is this - subtrahend, with subtrahend being decimal
     *
     * @param num subtrahend decimal
     * @return this - subtrahend
     */
    public Fraction sub(int num) {
        return this.sub(new Fraction(num));
    }

    /**
     * Returnd a fraction whose value is this / divisor
     *
     * @param f divisor fraction
     * @return this / divisor
     */
    public Fraction div(Fraction f) {
        long newY, newX;
        newY = (long)f.numerator*denominator;
        newX = (long)numerator*f.denominator;
        Fraction result = new Fraction(newX,newY);
        return result;
    }

    /**
     * Returnd a fraction whose value is this / divisor, with divisor being decimal
     *
     * @param num divisor decimal
     * @return this / divisor
     */
    public Fraction div(int num) {
        return this.div(new Fraction(num));
    }

    /**
     * Returnd a fraction whose value is this * factor
     *
     * @param f factor fraction
     * @return this * factor
     */
    public Fraction mul(Fraction f) {
        long newY, newX;
        newY = (long)f.denominator*denominator;
        newX = (long)numerator*f.numerator;
        Fraction result = new Fraction(newX,newY);
        return result;
    }

    /**
     * Returnd a fraction whose value is this * factor, with factor being decimal
     *
     * @param num factor decimal
     * @return this * factor
     */
    public Fraction mul(int num) {
        return this.mul(new Fraction(num));
    }

    /**
     * Returns a fraction whose value is (-this)
     *
     * @return -this
     */
    public Fraction negate() {
        return new Fraction(-numerator,denominator);
    }

    /**
     * Returns a double value of fraction
     *
     * @return double value of fraction
     */
    public double toDouble() {
        return (double)numerator / denominator;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        if (denominator == 1)
        {
            return String.format("%d", numerator);
        }
        else
            return String.format("%d/%d", numerator, denominator);
    }

}
