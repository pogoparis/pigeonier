package fr.eni.pigeonier.bll;


import fr.eni.pigeonier.bo.Pigeon;
import fr.eni.pigeonier.dal.PigeonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PigeonServiceImpl implements PigeonService{

    @Autowired
    PigeonDAO pigeonDAO;

    @Override
    public List<Pigeon> getAllPigeons() {
        return pigeonDAO.findAll();
    }

    @Override
    public void addPigeon(Pigeon pigeon) {
    pigeonDAO.saveAndFlush(pigeon);
    }

    @Override
    public void addAllPigeons(List<Pigeon> pigeons) {
        pigeonDAO.saveAll(pigeons);
    }

    public List<Pigeon> getPigeonsByCode(String code) {
        return pigeonDAO.findByCode(code);
    }

    public void supprimerPigeonsByCode(String code) {
        List<Pigeon> pigeons = pigeonDAO.findByCode(code);
        pigeonDAO.deleteAll(pigeons);
    }

    @Override
    public List<Pigeon> attaquerPigeonnier(String targetPigeonnierUrl, Integer attackNumber) {
        return null;
    }

    @Override
    public void enregistrerEntreePigeon(Pigeon pigeon) {

    }

    @Override
    public Pigeon getPigeonById(Integer pigeonId) {
        return pigeonDAO.findById(pigeonId).orElse(null);
    }

    @Override
    public void enregistrerSortiePigeon(Pigeon pigeon) {

    }
}
