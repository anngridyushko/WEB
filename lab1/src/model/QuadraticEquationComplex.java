package model;

/**
 * This is the class of Quadratic equation with complex coefficients
 *
 * @author Ann Gridyushko
 * @version 1.0.0
 */
public class QuadraticEquationComplex extends QuadraticEquation<Complex> {

    /**
     * Create a quadratic equation with given complex coefficients
     * @param a the quadratic coefficient
     * @param b the linear coefficient
     * @param c the constant or free term
     */
    public QuadraticEquationComplex(Complex a, Complex b, Complex c) {
        super(a, b, c);
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public Complex getExtremum() {
        return null;
    }

    /**
     * Create a simple quadratic equation x^2 with complex coefficient a
     */
    public QuadraticEquationComplex() {
        super(new Complex(1,0), new Complex(0, 0), new Complex(0, 0));
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void getRoots() {
        Complex discriminant = b.mul(b).sub(a.mul(c).mul(4));
        discriminant = discriminant.sqrt();
        root1 = (discriminant.add(b.negate())).div(a).div(2);
        root2 = (discriminant.negate().add(b.negate())).div(a).div(2);
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void getIntervals() {
        System.out.println( "Can't calculate intervals for a coplex function");
    }
}