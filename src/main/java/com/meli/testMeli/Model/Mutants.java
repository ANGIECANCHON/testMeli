package com.meli.testMeli.Model;

import javax.persistence.*;

@Entity
public class Mutants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private long id;
    @Column
    private boolean mutant;
    @Column
    private String[] dna;

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isMutant() {
        return mutant;
    }

    public void setMutant(boolean mutant) {
        this.mutant = mutant;
    }

    public Mutants(boolean mutant, String[] dna){
        this.mutant = mutant;
        this.dna = dna;
    }
}
