import edu.princeton.cs.algs4.QuickFindUF;
// The QuickFindUF used methods will be explained in this file, and it will be implemented

public class Percolation {
	// OUR IMPLEMENTATION WILL USE 1 FOR THE FIRST ROW AND NOT 0(THAT'S WHY WE'LL BE SUBSTRACTING ONE EACH TIME) 
	private final int N; // We will simulate a grid by NxN
	private final int TOP = 0;
	/*
	 *  The idea of top is that instead of looking if site is connected to another in the top line
	 *  We will make a site (considered the TOP) connected to all the sites in the top row
	 *  So if a site is connected to another in the first row, it's necessary connected to the TOP
	 *  this make it easy to check if this site is connected to the first row
	 */
	private final int BOTTOM; // same idea as the TOP
	private boolean[][] grid; 
	// The N*N grid, since all we need is if a site is opened or not, we'll use boolean values (memory ;) )
	private final boolean OPEN = true;
	private QuickFindUF quickFind;
	
	public Percolation(int n){
		// create n-by-n grid, with all sites blocked
		if(n<=0)
			throw new IllegalArgumentException("'n' can not be negative or null");
		this.N = n;
		this.BOTTOM = n*n +1; // Since the grid be will have two extra sites (TOP and BOTTOM)
		quickFind = new QuickFindUF(n*n +2); 
		// The constructor builds the grid in a way to be easy to look for connected sites, connect them if not ...
		grid = new boolean[n][n]; // This is our real grid
	}
	
	public void open(int i, int j){
		// open site (row i, column j) if it is not open already
		// connects also an opened site to it's neighborhoods
		grid[i-1][j-1] = OPEN;
		if(i == 1)
			quickFind.union(getIndex(i, j), TOP); // union method connects two sites (Brillant haah !!)
		if(i == N)
			quickFind.union(getIndex(i, j), BOTTOM);
		if(j>1 && isOpen(i, j-1))
			quickFind.union(getIndex(i, j), getIndex(i, j-1));
		if(j<N && isOpen(i, j+1))
			quickFind.union(getIndex(i, j), getIndex(i, j+1));
		if(i<N && isOpen(i+1, j))
			quickFind.union(getIndex(i, j), getIndex(i+1, j));
		if(i>1 && isOpen(i-1, j))
			quickFind.union(getIndex(i, j), getIndex(i-1, j));
	}
	
	public boolean isOpen(int i, int j){
		// is site (row i, column j) open?
		if (i <= 0 || i > N) throw new IndexOutOfBoundsException("row index i out of bounds");
		if (j <= 0 || j > N) throw new IndexOutOfBoundsException("column index j out of bounds");
		return grid[i-1][j-1];
	}
	
	public boolean isFull(int i, int j){
		// is site (row i, column j) full?
		// And full means, is there a way of opened sites from the site in (i,j) to the TOP (a site in 1st row)
		if (i <= 0 || i > N) throw new IndexOutOfBoundsException("row index i out of bounds");
		if (j <= 0 || j > N) throw new IndexOutOfBoundsException("column index j out of bounds");
		return quickFind.connected(getIndex(i, j), TOP); 
		// connected returns true if the two given sites are connected, false if they're not
	}
	
	public boolean percolates(){
		return quickFind.connected(TOP, BOTTOM);
		// The system percolates if there is a way from the top row to the botton row
		//See how TOP and BOTTOM are useful now ?
	}
	
	private int getIndex(int i, int j){
		/*
		 * Let me tell you a secret, the data structure used in QuickFindUF use an inline array (one dimension)
		 * instead of two dimensions. So this method simply get the index of a site in a one dimension array
		 * from it's position in the two dimensional array. Do the math and check.
		 */
		return N * (i - 1) + j;
	}
}
