package logic;

import java.util.ArrayList;
import java.util.HashMap;

import container.NKLRule;

public class LSystemGenerator {
	
	public static ArrayList<String> generateLSystem(NKLGrammar grammar, int iterations){
		
		ArrayList<String> finalParses = new ArrayList<>();
		
		String axiom = grammar.getAxiom();
		
		for(int i = 0; i < iterations; i++){
			
			ArrayList<Integer> nonTurtleStringIndex = calculateNonTurtleStringIndex(axiom,grammar);
			
			ArrayList<String> replacements;
			int nonTurtleIndex = 0;
			
			for(int j = 0; j < axiom.length(); j++){
				char currentChar = axiom.charAt(i);
				if(grammar.getAlphabet().contains(currentChar)){
					
					HashMap<String,ArrayList<NKLRule>> rules = grammar.getProductionRules().get(currentChar);
					
					int currentN = nonTurtleIndex > grammar.getN() ? grammar.getN(): nonTurtleIndex;
					int displacementEnd = nonTurtleStringIndex.size() - nonTurtleIndex;
					int currentK = displacementEnd > grammar.getK() ? grammar.getK() : displacementEnd;
					
					int runtimeN = currentN;
					int runtimeK = currentK;
					
					while(!(runtimeN == 0 && runtimeK == 0)){
						
						if(rules.containsKey("")){}
						
						
					}
					
					
					
					nonTurtleIndex++;
				}
				
			}
			
			
		}
		
		
		return finalParses;
	}
	
	
	private static ArrayList<Integer> calculateNonTurtleStringIndex(String axiom, NKLGrammar grammar){
		ArrayList<Integer> nonTurtleStringIndex = new ArrayList<>();
		
		for(int i = 0; i < axiom.length(); i++){
			
			if(grammar.getAlphabet().contains(axiom.charAt(i))){
				nonTurtleStringIndex.add(i);
			}
		}
		
		
		return nonTurtleStringIndex;
	}
	
	
	private static ArrayList<String> generatePartialParseIndice(int n, int k){
		ArrayList<String> parseIndice = new ArrayList<>();
		
		if(n == k){
			parseIndice.add(n+","+k);
		}else{
			for(int i = n; i >= 0; i--){
				for(int j = k; j >= 0; j--){
					//TODO implement algo, for loop -> wrong
				}
			}
		}
		
		return parseIndice;
	}

}
