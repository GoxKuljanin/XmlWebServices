package com.agentApp.app.services;

import com.agentApp.app.dto.TipGorivaDTO;
import com.agentApp.app.exception.NotFoundException;
import com.agentApp.app.models.TipGoriva;
import com.agentApp.app.repository.TipGorivaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipGorivaService {

    @Autowired
    private TipGorivaRepository tipGorivaRepository;

    @Autowired
    public TipGorivaService(
            TipGorivaRepository tipGorivaRepository
    ) {
        this.tipGorivaRepository = tipGorivaRepository;
    }

    public TipGoriva createTipGoriva(TipGorivaDTO tipGorivaDTO) {
        // this.userConnection.verify(oglasdto.getUser_id());
        TipGoriva tipGoriva = this.tipGorivaRepository.save(new TipGoriva(tipGorivaDTO));
        return tipGoriva;
    }

    public TipGoriva updateTipGoriva(TipGorivaDTO tipGorivaDTO) {
        TipGoriva tipGoriva = this.tipGorivaRepository.findById(tipGorivaDTO.getId())
                .orElseThrow(() -> new NotFoundException("TipGoriva with that id does not exist!"));

        tipGoriva.setId(tipGorivaDTO.getId());
        tipGoriva.setNaziv(tipGorivaDTO.getNaziv());

        return this.tipGorivaRepository.save(tipGoriva);
    }

    public void delete(Long id) {
        tipGorivaRepository.deleteById(id);
        return;
    }

    public boolean verify(Long id) {
        try {
            TipGoriva o = tipGorivaRepository.findById(id).get();
            if(o != null)
                return true;
            return false;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

}
