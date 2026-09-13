package eda;
import java.util.*;

class VerificaDuplicados {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("alg time sample");
        while (sc.hasNextLine()) {
        	String linha = sc.nextLine().trim();

        	if (linha.isEmpty()) {
        	    continue;
        	}

        	String[] nums = linha.split("\\s+");
        	long start = System.nanoTime();
        	verificaDuplicadosComSet(nums);
        	long end = System.nanoTime();

        	System.out.println("\"Verifica Duplicados com Set\" " +
        	                   (end - start) + " " + nums.length);

        	start = System.nanoTime();
        	verificaDuplicadosDoisFor(nums);
        	end = System.nanoTime();

        	System.out.println("\"Verifica Duplicados com Dois for\" " +
        	                   (end - start) + " " + nums.length);
        }
	}
	
	public static boolean verificaDuplicadosDoisFor(String[] n) {
		for (int i = 0; i < n.length; i++) {
			for (int j = i+1; j < n.length; j++) {
				int n1 = Integer.parseInt(n[i]);
				int n2 = Integer.parseInt(n[j]);
				if (n1 == n2) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean verificaDuplicadosComSet(String[] n) {
		HashSet<Integer> repetidos = new HashSet<>();
		for (int i = 0; i < n.length; i++) {
			int n1 = Integer.parseInt(n[i]);
			if (!repetidos.add(n1)){
				return true;
			}
		}
		return false;
	}

}
