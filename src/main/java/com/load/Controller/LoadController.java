package com.load.Controller;

import com.load.Entity.Load;
import com.load.Repository.LoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    private LoadRepository loadRepository;

    @PostMapping()
    public ResponseEntity<String>addLoad(@RequestBody Load load){

        loadRepository.save(load);

        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Load>> getAllLoadByShipperId(@RequestParam String shipperId) {

        List<Load> load = loadRepository.findByShipperId(shipperId);


        return new ResponseEntity<>(load, HttpStatus.OK);
    }

    @GetMapping("/{loadId}")
    public ResponseEntity<Load>getLoad(@PathVariable Long loadId){

       Optional<Load>load= loadRepository.findById(loadId);
       if(load.isEmpty()){
           throw new RuntimeException("Enter Valid Load Id");
       }
       Load newLoad=load.get();

        return new ResponseEntity<>(newLoad,HttpStatus.OK);

    }

    @PutMapping("/{loadId}")
    public ResponseEntity<Load>addLoad(@PathVariable Long loadId,
                                       @RequestBody Load load
                                       ){

        load.setLoadId(loadId);
        Load save = loadRepository.save(load);


        return new ResponseEntity<>(save,HttpStatus.OK);

    }



}
