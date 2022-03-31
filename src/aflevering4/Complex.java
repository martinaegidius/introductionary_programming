package aflevering4;

public class Complex {
	double re;
	double im; 
	
	public Complex() { //NULL-constructor
		this.re = 0;
		this.im = 0;
	}
	
	public Complex(double r, double i) { //standard-constructor
		this.re = r;
		this.im = i;
	}
	
	public Complex(Complex z) { //construct a copy of another complex number
		this.re = z.re;
		this.im = z.im;
	}
	
	public double getRe() { //get real part
		return this.re;
	}
	public double getIm() { //get imaginary part
		return this.im;
	}
	public double abs() { //get magnitude of complex number
		return Math.sqrt(Math.pow(re, 2)+Math.pow(im, 2));
	}
	
	public Complex plus(Complex other) { //return complex sum of instance and other complex number
		double plusRe = this.re + other.re;
		double plusIm = this.im + other.im;
		Complex z = new Complex(plusRe,plusIm);
		return z;
	}
	
	public Complex times(Complex other) {//return complex product of instance and other complex number
		double timesRe = this.re*other.re-this.im*other.im;
		double timesIm = this.im*other.re+this.re*other.im;
		Complex z = new Complex(timesRe,timesIm);
		return z;
	}
	
	public String toString() {
		String format = "";
		if (this.im<0) {
			format += (this.re)+" - "+(this.im)+"i";
		}
		else {
			format += (this.re)+" + "+(this.im)+"i";
		}
		return format;
	}
	
	

}
