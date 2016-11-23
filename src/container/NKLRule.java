package container;

public class NKLRule {
	
	private String lhs,rhs;
	private int n = 0,k =0;
	
	public NKLRule(String lhs, String rhs){
		
		this.lhs = lhs.trim();
		this.rhs = rhs.trim();
		
		String[] nContext = this.lhs.split("<");
		String[] kContext = this.lhs.split(">");
		
		if(nContext.length != 1){
			this.n = nContext[0].length();
		}
		
		if(kContext.length != 1){
			this.k = kContext[1].length();
		}
		
		
	}

	public String getLhs() {
		return lhs;
	}

	public String getRhs() {
		return rhs;
	}

	public int getN() {
		return n;
	}

	public int getK() {
		return k;
	}

}
