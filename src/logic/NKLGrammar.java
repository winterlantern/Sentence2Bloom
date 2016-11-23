package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import container.NKLRule;

public class NKLGrammar {
	
	private HashMap<String, HashMap<String,ArrayList<NKLRule>>> productionRules;
	private Set<String> alphabet;
	private Set<String> turtleAlphabet;
	private String axiom;
	private int n,k;
	
	/**
	 * NLKGrammar describes a generic (N,K) L System
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
	 *  
	 */
	public NKLGrammar(int n, int k, String axiom, HashMap<String,ArrayList<NKLRule>> productionRules,Set<String> alphabet, Set<String> turtleAlphabet){
		this.n = n;
		this.k = k;
		
		if(axiom == null || "".equals(axiom)){
			throw new RuntimeException("Axiom can't be null or the empty string");	
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
		
		insertRules(productionRules);
		
	}
	
	/**
	 * Insert rules into a HashMap ordered by alphabet symbol which contains another map for ordering
	 * rules internally by context sensitivity information 
	 * 
	 * @param productionRules
	 */
	private void insertRules(HashMap<String,ArrayList<NKLRule>> productionRules){
		for(String symb : productionRules.keySet()){
			
			if(!this.productionRules.containsKey(symb)){
				this.productionRules.put(symb, new HashMap<String,ArrayList<NKLRule>>());
			}
			
			for(NKLRule rule : productionRules.get(symb)){
				String contextSensitivity = rule.getN() + "," + rule.getK();
				
				
				if(this.productionRules.get(symb).containsKey(contextSensitivity)){
					this.productionRules.get(symb).get(contextSensitivity).add(rule);
				}else{
					ArrayList<NKLRule> rules = new ArrayList<>();
					this.productionRules.get(symb).put(contextSensitivity, rules);
				}
				
			}
			
		}
	}

	public HashMap<String, HashMap<String,ArrayList<NKLRule>>> getProductionRules() {
		return productionRules;
	}

	public Set<String> getAlphabet() {
		return alphabet;
	}

	public Set<String> getTurtleAlphabet() {
		return turtleAlphabet;
	}

	public String getAxiom() {
		return axiom;
	}

	public int getN() {
		return n;
	}

	public int getK() {
		return k;
	}

}
