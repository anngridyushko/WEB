package model;

/**
 * This is the class of Quadratic equation with fraction coefficients
 *
 * @author Ann Gridyushko
 * @version 1.0.0
 */
public class QuadraticEquationFraction extends QuadraticEquation<Fraction> {

    /**
     * Create a quadratic equation with given fraction coefficients
     * @param a the quadratic coefficient
     * @param b the linear coefficient
     * @param c the constant or free term
     */
    public QuadraticEquationFraction(Fraction a, Fraction b, Fraction c) {
        super(a, b, c);
    }

    /**
     * Create a simple quadratic equation x^2 with fraction coefficient a
     */
    public QuadraticEquationFraction() {
        super(new Fraction(1), new Fraction(0), new Fraction(0));
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void getRoots() {
        Complex discriminant = new Complex(b.mul(b).sub(a.mul(c).mul(4)).toDouble(), 0.0);
        discriminant = discriminant.sqrt();
        root1 = (discriminant.add(b.negate().toDouble())).div(a.toDouble()*2);
        root2 = (discriminant.negate().add(b.negate().toDouble())).div(a.toDouble()*2);
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public Fraction getExtremum() {
        Fraction x1 = b.negate().div(a).div(2);
        return (a.mul(x1).mul(x1)).add((b).mul(x1)).add(c);
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void getIntervals() {
        Fraction x1 = b.negate().div(a).div(2);
        if (a.toDouble() > 0){
            System.out.println( "[-INF; " + x1 +"], [ "+ x1 + ", INF]");
        } else {
            System.out.println("[" + x1 + ", INF], [-INF; " + x1 +"]");
        }

    }

}