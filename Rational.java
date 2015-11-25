/* 
   Team Miscalculations - Nancy Li, Sadia Azmine
   APCS1 pd9
   HW 33 -- Do You Even Add, Bro?
   2015-11-19
*/

public class Rational {
    private int p; //numerator
    private int q;//denominator
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
        return (p*1.0)/q;
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
        p = p*s.getQ();
        q = q*s.getP();
    }
    

    //////////////////////     PHASE 2    ///////////////////
	  
    //adds two rational classes and changes value of initial class
    public void add(Rational s){
        p = (this.getP() * s.getQ()) + (s.getP() * this.getQ());
	//numerators multiplied by the other rational object's denominator then added
        q = this.getQ() * s.getQ(); 
    }
    
    //subtracts two rational classes and changes value of initial class
    public void subtract(Rational s){
        p = (this.getP() * s.getQ()) - (s.getP() * this.getQ());
        q = this.getQ() * s.getQ();
    }
    
    // Finds the GCD of two integer inputs recursively.
    public int gcdER (int a, int b){
        if ((a == b) || (b == 0)){
            return a;} //returns the GCD.
        else if (a < b){
            return gcdER (b,a);
	} //If b is greater than a,the function will be run again with both values swapped.
        else{
            return gcdER (b , (a-b));
        }
    } //Recalls the function with b and the difference between a and b.
    
    //changes rational to reduced form
    public void reduce() {
	int p1 = p;
	int q1 = q;
        p = p / gcdER(p1, q1); //num divided by gcd of num and denom
        q = q / gcdER(p1, q1); //denom divided by gcd of num and denom
    }

    //////////////////////     PHASE 3     ///////////////////
    
    public static int gcd(int p, int q) {
    	if ((p == q) || (q == 0)){
            return q;} //returns the GCD.
        else if (p < q){
            return gcd (q,p);
	} //If q is greater than p,the function will be run again with both values swapped.
        else{
            return gcd (q , (p-q));
        }
    } //Recalls the function with b and the difference between a and b.
    
    public int compareTo(Rational hi){
    	if (floatValue() == hi.floatValue() )  {
	    return 0; //Returns 0 if the two numbers are equal
    	}
    	else if (floatValue() > hi.floatValue()) {
	    return 1;
    	}//Returns 1 if the calling number is larger than the parameter
    	else {
	    return -1;
    	}//Returns -1 if the calling number is smaller than the parameter
    }
    //////////////////////     PHASE 4     ///////////////////
    public boolean equals( Object a ) {
 
	//First, check for aliasing.
	boolean retVal = this == a;
 
	//Next, if this and input Object are different objects,
        if ( !retVal ) {
 
	    //...check to see if input Object is a Tile
	    if (retVal = a instanceof Rational) {
		this.reduce();
		((Rational)a).reduce();
			
		//...and that its state variables match those of this Tile
		retVal = (this.getP() == ((Rational)a).getP()) && (this.getQ() == ((Rational)a).getQ());
	    }
        }
	return retVal;
    }
 
    
    
    //main method for testing purposes
    public static void main(String[] args){
        Rational r = new Rational(2,3); //Stores the rational number 2/3
        Rational s = new Rational(1,2); //Stores the rational number 1/2
        System.out.println("Rational r: \t" + r);
        System.out.println("Rational s: \t" + s);

	//tests Phase 1
	System.out.println("Testing Phase 1...");	
	r.multiply(s); //Multiplies r by s, changes r to 2/6.  s remains ½
	System.out.println("r * s = \t" + r);
	System.out.println("r now equals 2/6");	
	r.divide(s); //Multiplies r by s, changes r to 4/6.  s remains ½
	System.out.println("r / s = \t" + r);
	System.out.println("r now equals 4/6");	

	//tests Phase 2
	System.out.println("Testing Phase 2...");	
	r.add(s); //Adds r and s, r becomes 14/12
	System.out.println("r + s = \t" + r);
	System.out.println("r now equals 14/12");	
	r.subtract(s); //subtracts s from r, r becomes 16/24
	System.out.println("r - s = \t" + r);
	System.out.println("r now equals 16/24");	
	r.reduce(); // r becomes 2/3
	System.out.println("when reduced r now equals: \t" + r);	
	Rational a = new Rational(1,0);
	System.out.println(a);
		
	//tests Phase 3
	System.out.println("Testing Phase 3...");
	System.out.println("A 0 indicates two Rationals are equal.");
        System.out.println("How does r compare to r? \t" + r.compareTo(r)); //should return 0
	System.out.println("A 1 indicates that the first Rational is greater than the second.");
	System.out.println("How does r compare to s? \t" + r.compareTo(s)); //should return 1
	System.out.println("A -1 indicates that the first Rational is less than the second.");
	System.out.println("How does s compare to r? \t" + s.compareTo(r)); //should return -1

	//tests Phase 4
	System.out.println("Testing Phase 4...");	
	Rational i = new Rational(1,4);
	Rational j = new Rational(2,8);
	System.out.println("Is r equal to s? \t" + r.equals(s));
        System.out.println("Rational i: \t" + i);
        System.out.println("Rational j: \t" + j);	
	System.out.println("Is i equal to j? \t" + i.equals(j));		
	System.out.println("Is i equal to i? \t" + i.equals(i));	
	System.out.println("Is j equal to i? \t" + j.equals(i));
	System.out.println("Rational a is not defined but has a numerator of 1 and denominator of 0.");
	System.out.println("Is i equal to a? \t" + i.equals(a));
    }
} 
//end class Rational
