package com.meli.testMeli.Controller;

import com.meli.testMeli.POJO.AverageMutantsPojo;
import com.meli.testMeli.Repository.MutantRepository;
import com.meli.testMeli.Model.Mutants;
import com.meli.testMeli.POJO.MutantsPojo;
import com.meli.testMeli.Service.MutantVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mutant")
public class MutantController {

    @Autowired
    private  MutantVerifyService mutantVerifyService;

    @Autowired
    private MutantRepository mutantRepository;

    @PostMapping("/verify")
    public ResponseEntity<String> mutantVerify(@RequestBody MutantsPojo arrayDna){
        Boolean res = mutantVerifyService.isMutant(arrayDna.getDna());
        if (res){
            Mutants mutants = new Mutants(true, arrayDna.getDna());
            mutantRepository.save(mutants);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            Mutants mutants = new Mutants(false, arrayDna.getDna());
            mutantRepository.save(mutants);
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/stats")
    public ResponseEntity<ArrayList<AverageMutantsPojo>>averageMutants(){
        ArrayList<AverageMutantsPojo> response = mutantRepository.averageMutants();
        return new ResponseEntity<ArrayList<AverageMutantsPojo>>(response, HttpStatus.OK);
    }
}
