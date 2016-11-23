package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class NKLGrammar {
	
	private HashMap<String, ArrayList<String>> productionRules;
	private Set<String> alphabet;
	private Set<String> turtleAlphabet;
	private String axiom;
	private int n,k;
	
	/**
	 * NLKGrammar describes a generic (N,L) L System
	 * @param n context sensitivity of n chars to the left
	 * @param k context sensitivity of k chars to the right
	 * @param axiom nonempty string consisting of elements from alphabet unified with {[,]} 
	 * @param productionRules string replacement rules which map elements of the alphabet on the LHS 
	 * 		  to combinations of elements of alphabet and turtleAlphabet on the RHS
	 * 
	 * @param the alphabet used in productions
	 * @param turtleAlphabet symbols which are used by the turtle, they are ignored during derivation
	 * 		  the intersection of alphabet and turtleAlphabet has to be empty
	 * 
	 * @throws RuntimeException if axiom equals empty string or is null
	 * @throws RuntimeException if intersection (set.retainAll) of alphabet and turtle alphabet is not empty 
	 */
	public NKLGrammar(int n, int k, String axiom, HashMap<String, ArrayList<String>> productionRules,Set<String> alphabet, Set<String> turtleAlphabet){
		this.n = n;
		this.k = k;
		
		if(axiom == null || "".equals(axiom)){
			throw new RuntimeException("Axiom can't null or the empty string");	
		}
		
		
		this.alphabet = alphabet;
		this.turtleAlphabet = turtleAlphabet;
		
		Set<String> intersection = new HashSet<String>(alphabet);
		intersection.retainAll(turtleAlphabet);
		
		if(!intersection.isEmpty()){
			throw new RuntimeException("Intersection of alphabet and turtle alphabet is not empty");
		}
		intersection = null;
		
		this.axiom = axiom;
		this.productionRules = productionRules;
		
	}

}
