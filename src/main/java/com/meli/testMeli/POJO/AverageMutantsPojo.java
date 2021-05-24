package com.meli.testMeli.POJO;

public class AverageMutantsPojo {
    int count_mutant_dna;
    int count_human_dna;
    float ratio;

    public int getCountMutantDna() {
        return count_mutant_dna;
    }

    public void setCountMutantDna(int countMutantDna) {
        this.count_mutant_dna = countMutantDna;
    }

    public int getCountHumanDna() {
        return count_human_dna;
    }

    public void setCountHumanDna(int countHumanDna) {
        this.count_human_dna = countHumanDna;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }

    public AverageMutantsPojo(int count_mutant_dna, int count_human_dna, float ratio){
        this.count_mutant_dna = count_mutant_dna;
        this.count_human_dna = count_human_dna;
        this.ratio = ratio;
    }
}
