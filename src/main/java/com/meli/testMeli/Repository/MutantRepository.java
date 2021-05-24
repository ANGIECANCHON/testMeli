package com.meli.testMeli.Repository;

import com.meli.testMeli.Model.Mutants;
import com.meli.testMeli.POJO.AverageMutantsPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface MutantRepository extends JpaRepository<Mutants, Long> {
    @Query(value = "select count(mt.mutant) from mutants mt where mt.mutant = true", nativeQuery = true)
    public int getCountMutants();
    @Query(value = "select count(mt.mutant) from mutants mt where mt.mutant = false", nativeQuery = true)
    public int getCountHumans();
}
