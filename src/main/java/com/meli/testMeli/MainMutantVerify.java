package com.meli.testMeli;

public class MainMutantVerify {
    public static void main(String[] args){
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        Boolean res = isMutantStatic( dna );
        if(res){
            System.out.println("DNA indicates that it is a mutant");
        }else {
            System.out.println("DNA indicates that it is an ordinary human");
        }
    }

    public static boolean isMutantStatic(String[] dna){
        int total = 0;
        int cont = 0;

        for (int i = 0; i < dna[0].length(); i++){
            for (int j = 1; j< dna.length; j++){
                boolean equals = isEqual(dna[i].charAt(j -1), dna[i].charAt(j));
                if(equals){
                    cont ++;
                }else if(cont >= 3){
                    total ++;
                    cont = 0;
                }
            }
            cont = 0;
        }

        for (int i = 0; i < dna[0].length(); i++){
            for (int j = 1; j< dna.length; j++){
                boolean equals = isEqual(dna[j-1].charAt(i), dna[j].charAt(i));
                if(equals){
                    cont ++;
                }else if(cont >= 3){
                    total ++;
                    cont = 0;
                }
            }
            cont = 0;
        }

        for (int i = 0; i < dna.length -1; i++ ){
            boolean equals = isEqual(dna[i].charAt(i), dna[i+1].charAt(i+1));
            if(equals){
                cont ++;
            }else if(cont >= 3){
                total ++;
                cont = 0;
            }
        }

        if (total > 1){
            return true;
        }
        return false;
    }

    public static boolean isEqual(char a, char b){
        boolean res = (a == b) ? true : false;

        return res;
    }
}
