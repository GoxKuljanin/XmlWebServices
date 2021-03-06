package com.admin.adminServis.controller;

import com.admin.adminServis.dto.MarkaVozilaDTO;
import com.admin.adminServis.dto.TipGorivaDTO;
import com.admin.adminServis.model.MarkaVozila;
import com.admin.adminServis.model.ModelVozila;
import com.admin.adminServis.model.TipGoriva;
import com.admin.adminServis.repository.TipGorivaRepository;
import com.admin.adminServis.service.TipGorivaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/gorivo")
public class TipGorivaController {

    protected final static Logger logger = LoggerFactory.getLogger(TipGorivaController.class);

    @Autowired
    private TipGorivaRepository tipGorivaRepository;
    @Autowired
    private TipGorivaService tipGorivaService;

    @Autowired
    public TipGorivaController(TipGorivaService tipGorivaService){
        this.tipGorivaService=tipGorivaService;
    }

    @PostMapping
    //@PreAuthorize("hasAuthority('create_oglas')")
    public ResponseEntity<?> sacuvajTipGoriva(@RequestBody TipGorivaDTO tipGorivaDTO) {

        TipGoriva tipGoriva = this.tipGorivaService.createTipGoriva(tipGorivaDTO);
logger.info("Sacuvan je tip goriva");
        return new ResponseEntity<>(tipGoriva, HttpStatus.OK);
    }

    @PutMapping
    //@PreAuthorize("hasAuthority('update_oglas')")
    public ResponseEntity<?> izmenaGoriva(@RequestBody TipGorivaDTO tipGorivaDTO) {
        Optional<TipGoriva> tipGorivadata = tipGorivaRepository.findById(tipGorivaDTO.getId());
        if(tipGorivadata.isPresent()){
            this.tipGorivaService.updateTipGoriva(tipGorivaDTO);
            logger.info("Uspesno je izmenjen tip goriva");
            return new ResponseEntity<>("Successful updated tip goriva vozila", HttpStatus.OK);
        }else{
            logger.info("Tip goriva ne moze da se pronadje");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    List<TipGoriva> svitipoviGorivaVozila() {
       logger.info("Lista svih tipova goriva");
        return tipGorivaRepository.findAll();
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasRole('ROLE_operator')")
    //@PreAuthorize("hasAuthority('delete_oglas')")
    public ResponseEntity<HttpStatus> brisanjeGoriva(@PathVariable("id") Long id) {
        try {
            tipGorivaService.delete(id);
            logger.info("Tip goriva je obrisan");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            logger.info("Tip goriva ne moze da se obrise ili nije pronadjen");
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
/*
    @GetMapping("/verify/{tipgoriva_id}")
    public boolean verify(@PathVariable("tipgoriva_id") Long tipgoriva_id){
        return tipGorivaService.verify(tipgoriva_id);
//		if(postoji)
//			return new ResponseEntity<>(HttpStatus.OK);
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
*/
}
