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
    @Query(value = "select countMutantDna, countHumanDna, cast(countMutantDna as float4)/cast(countHumanDna as float4) as ratio from (" +
            "select count(mutant) as countMutantDna , " +
            "(select count(mutant) as countHumanDna " +
            "from public.mutants mt where mt.mutant = false)  " +
            "from public.mutants mt where mt.mutant = true) as result", nativeQuery = true)
    public ArrayList<AverageMutantsPojo> averageMutants();
}
