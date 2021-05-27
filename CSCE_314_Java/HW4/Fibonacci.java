class SubsetOutputFeb { //Problem 2

	static final int MAX_INDEX = 9;
	/**
	* Print out the first few Fibonacci numbers,
	* marking evens with a '*'
	*/
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		String mark;
		int be = Integer.parseInt(args[0]);
		int en = Integer.parseInt(args[1]);
		//System.out.println(be);
		//System.out.println(en);
		if(be<0){
			System.out.println("First command line input must be positive");
			return;
		}
		if(en<0){
			System.out.println("Second command line input must be positive");
			return;
		}
		if(be>en){
			System.out.println("First command line input must less than second command line input");
			return;
		}
		if(be==1){
			System.out.println("1: " + lo);
		}
		if(en >= 2){
			for (int i = 2; i <= en; i++) {
				if (hi % 2 == 0)
					mark = " *";
				else
					mark = "";
			if(i >= be){
				System.out.println(i + ": " + hi + mark);
			}
			hi = lo + hi;
			lo = hi - lo;
			}
		}
	}
}

//Exercise 1.13: Rewrite the ImprovedFibonacci program using printf instead of println.
class ImprovedFibonacci {
	static final int MAX_INDEX = 9;
	/**
	* Print out the first few Fibonacci numbers,
	* marking evens with a '*'
	*/
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		String mark;
		System.out.printf("1: %d%n", lo);
		for (int i = 2; i <= MAX_INDEX; i++) {
			if (hi % 2 == 0)
				mark = " *";
			else
				mark = "";
		//System.out.printf(i + ": " + hi + mark);
		System.out.printf("%d: %d%s%n", i, hi, mark);
		hi = lo + hi;
		lo = hi - lo;
		}
	}
}
