/* 
Team Miscalculations - Nancy Li, Sadia Azmine
APCS1 pd9
HW 33 -- Do You Even Add Bro?
2015-11-19
*/

public class Rational {
    //numerator
    private int p;
    //denominator
    private int q;
    //sets initial values for numerator and denominator
    public Rational() {
        p = 0;
        q = 1;
    }
    //allows one to create a new Rational Object with a certain numerator and denominator
    public Rational (int num, int den) {
        //will cause an error message and reset to default
        if (den == 0) {
            p = 0;
            q = 1;
            System.out.println("I'm sorry the number you are trying to make is undefined");
        }
        else {
            p = num;
            q = den;
        }
    }
    //overwrites inherited toString
    public String toString() {
        return p + "/" + q;
    }
    //stroes the value of the rational
    public double floatValue() {
        return p/q;
    }
    //accessor method for p
    public int getP(){
        return p;
    }
    //accesor method for q
    public int getQ(){
        return q;
    }
    //multiplies two rational classes together and changes the value of the initial class
    public void multiply(Rational s) {
        p = p*s.getP();
        q = q*s.getQ();
    }
    //divides two rational classes and changes the value of the initial class
    public void divide(Rational s){
        p = p/s.getP();
        q = q/s.getQ();
    }
    
    //subtracts two rational classes and changes value of initial class
    public void subtract(Rational s){
        q = this.getQ() * s.getQ();
        p = (this.getP() * s.getQ()) + (s.getP() * this.getQ());
    }
    
    // Finds the GCD of two integer inputs recursively.
    public static int gcdER (int a, int b){
        if ((a == b) || (b == 0)){
            return a;} //returns the GCD.
        else if (a < b){
            return gcdER (b,a);} //If b is greater than a, the function will be run again with both values swapped.
        else{
            return gcdER (b , (a-b));
        }
    } //Recalls the function with b and the difference between a and b.

    //main method for testing purposes
    public static void main(String[] args){
        Rational r = new Rational(2,3); //Stores the rational number 2/3
        Rational s = new Rational(1,2); //Stores the rational number 1/2
        r.multiply(s); //Multiplies r by s, changes r to 2/6.  s remains ½
        System.out.println(r);
        r.divide(s); //Multiplies r by s, changes r to 2/6.  s remains ½
        System.out.println(r);
        Rational a = new Rational(1,0);
        System.out.println(a);
    }
} 
//end class Rational
