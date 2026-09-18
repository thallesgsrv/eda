package eda;

import java.util.*;

class PrimeiroNegativo {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("alg time sample");
        while (sc.hasNextLine()){
            String linha = sc.nextLine().trim();

            if (linha.isEmpty()){
                continue;
            }

            String[] nums = linha.split("\\s+");
            long start = System.nanoTime();

            procuraNegativo(nums, 0);

            long end = System.nanoTime();
            long time = end - start;
            System.out.println("\"ProcuraNegativo Recursivo \" " + time + " " + nums.length);
        }
    }

    public static boolean procuraNegativo(String[] v, int i){
        if (i>=v.length) return false;
        int n = Integer.parseInt(v[i]);
        if (n < 0) return true;
        return procuraNegativo(v,i+1);
    }
}
