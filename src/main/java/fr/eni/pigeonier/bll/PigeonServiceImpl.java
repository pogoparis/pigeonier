package fr.eni.pigeonier.bll;


import fr.eni.pigeonier.dal.PigeonHistoriqueDAO;
import fr.eni.pigeonier.bo.Pigeon;
import fr.eni.pigeonier.bo.PigeonHistorique;
import fr.eni.pigeonier.dal.PigeonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class PigeonServiceImpl implements PigeonService{

    @Autowired
    PigeonDAO pigeonDAO;
    @Autowired
    PigeonHistoriqueDAO pigeonHistoriqueDAO;
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
        return pigeonDAO.findAllByCode(code);
    }

    public void supprimerPigeonsByCode(String code) {
        List<Pigeon> pigeons = pigeonDAO.findAllByCode(code);
        pigeonDAO.deleteAll(pigeons);
    }

    @Override
    public void enregistrerEntreePigeon(Pigeon pigeon) {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        PigeonHistorique historique = new PigeonHistorique();
        historique.setNom(pigeon.getNom());
        historique.setProprio(pigeon.getProprio());
        historique.setDateEntree(localDateTime);
        pigeonHistoriqueDAO.save(historique);
    }

    @Override
    public void enregistrerSortiePigeon(Pigeon pigeon) {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        PigeonHistorique historique = new PigeonHistorique();
        historique.setNom(pigeon.getNom());
        historique.setProprio(pigeon.getProprio());
        historique.setDateSortie(localDateTime);
        pigeonHistoriqueDAO.save(historique);
    }

    @Override
    public List<PigeonHistorique> getAllPigeonsHistorique() {
        return pigeonHistoriqueDAO.findAll();
    }

}
