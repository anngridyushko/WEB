package model;

/**
 * This is the class of Quadratic equation
 *
 * @author Ann Gridyushko
 * @version 1.0.0
 */
public abstract class QuadraticEquation<T> {

    /**
     * The quadratic coefficient of the equation
     */
    T a;

    /**
     * The linear coefficient of the equation
     */
    T b;

    /**
     * The constant or free term of the quadratic equation
     */
    T c;

    /**
     *  the roots of the equation
     */
    Complex root1, root2;

    /**
     * Create a quadratic equation  distinguished by coefficients a, b and c
     * @param a the quadratic coefficient
     * @param b the linear coefficient
     * @param c the constant or free term
     */
    QuadraticEquation(T a, T b, T c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * getter of the first root
     * @return root1
     */
    public Complex getRoot1() {
        if(root1 == null) {
            getRoots();
        }
        return root1;
    }

    /**
     * getter of the second root
     * @return root2
     */
    public Complex getRoot2() {
        if(root2 == null) {
            getRoots();
        }
        return root2;
    }

    /**
     * The method to find the extremum of quadratic equation
     * @return extremum of the equation
     */
    public abstract T getExtremum();

    /**
     * The method to find both roots of the quadratic equation
     */
    public abstract void getRoots();

    /**
     * The method to find the increasing and decreasing intervals of quadratic equation
     */
    public abstract void getIntervals();

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "x^2*(" + a.toString() + ") + x*(" +
                b.toString() + ") + " +
                c.toString() + " = 0" ;
    }
}
