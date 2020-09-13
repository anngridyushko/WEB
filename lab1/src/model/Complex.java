package model;

/**
 *  Data type for complex numbers
 *
 *  @author Ann Gridyushko
 *  @version 1.0.0
 */
public class Complex {

    /** The real part of complex number */
    private double r;

    /** The imagenary part of complex number */
    private double i;

    /**
     * Create a complex number given the real and imaginary parts
     *
     * @param r real part
     * @param i imaginary part
     * @see Complex#Complex(double)
     */
    public Complex (double r, double i) {
        this.r = r;
        this.i = i;
    }

    /**
     * Create a complex number given only the real part
     *
     * @param r The real part of complex number
     * @see Complex#Complex(double, double)
     */
    public Complex (double r) {
        this.r = r;
        this.i = 0;
    }

    /**
     * Returns a Complex whose value is this + addend
     *
     * @param z addend value
     * @return this + addend
     */
    public Complex add (Complex z) {
        return new Complex(r + z.r,i + z.i);
    }

    /**
     * Returns a Complex whose value is this + addend, with addend being a real number
     *
     * @param d addend value
     * @return this + addend
     */
    public Complex add (double d) {
        return new Complex(r + d,i);
    }

    /**
     * Returns a Complex whose value is this - subtrahend
     *
     * @param z subtrahend value
     * @return this - subtrahend
     */
    public Complex sub (Complex z) {
        return new Complex(r - z.r,i - z.i);
    }

    /**
     * Returns a Complex whose value is this - subtrahend, with subtrahend being a real number
     *
     * @param d subtrahend value
     * @return this - subtrahend
     */
    public Complex sub (double d) {
        return new Complex(r - d, i);
    }

    /**
     * Returns a Complex whose value is this * factor
     *
     * @param z factor value
     * @return this * factor
     */
    public Complex mul (Complex z) {
        return new Complex(r * z.r - i * z.i, r * z.i + i * z.r);
    }

    /**
     * Returns a Complex whose value is this - factor, with factor being a real number
     *
     * @param d factor value
     * @return this * factor
     */
    public Complex mul (double d) {
        return new Complex(r * d, i * d);
    }

    /**
     * Returns a Complex whose value is this * divisor
     *
     * @param z divisor value
     * @return this / divisor
     */
    public Complex div (Complex z) {
        return new Complex((r * z.r + i * z.i) / (z.r * z.r + z.i * z.i),
                (i * z.r - r * z.i) / (z.r * z.r + z.i * z.i));
    }

    /**
     * Returns a Complex whose value is this * divisor, with divisor being a real number
     *
     * @param d divisor value
     * @return this / divisor
     */
    public Complex div (double d) {
        return new Complex(r / d, i / d);
    }

    /**
     * Returns the modulus of complex number
     *
     * @return complex number modulus
     */
    public double mod() {
        return Math.sqrt(r * r + i * i);
    }

    /**
     * Computes the square root of complex number.
     *
     * @return  the square root of complex number
     */
    public Complex sqrt() {
        double modZ = mod();
        double argz = 0, argtan = Math.atan(Math.abs(i / r));
        if (r < 0) {
            argz += Math.PI;
            if (i < 0) {
                argz += argtan;
            } else {
                argz -= argtan;
            }
        }
        else if (i < 0) {
            argz = 2*Math.PI - argtan;
        }
        else {
            argz = argtan;
        }

        return new Complex(Math.sqrt(modZ) * Math.cos(argz / 2),
                Math.sqrt(modZ) * Math.sin(argz / 2));
    }

    /**
     * Returns a Complex whose value is (-this)
     *
     * @return -this
     */
    Complex negate() {
        return new Complex(-r, -i);
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        if (i > 0.0) {
            return String.format("%s + %si", r, i);
        } else if (i == 0.0) {
            return String.format("%s", r);
        } else {
            return String.format("%s - %si", r, Math.abs(i));
        }
    }
}
