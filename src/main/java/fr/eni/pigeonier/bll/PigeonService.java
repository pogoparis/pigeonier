package fr.eni.pigeonier.bll;

import fr.eni.pigeonier.bo.Pigeon;
import fr.eni.pigeonier.bo.PigeonHistorique;

import java.util.List;
import java.util.Optional;

public interface PigeonService {
    List<Pigeon> getAllPigeons();

    void addPigeon(Pigeon pigeon);

    List<Pigeon> getPigeonsByCode(String code);
    void addAllPigeons(List<Pigeon> pigeons);

    void supprimerPigeonsByCode(String code);


    void enregistrerEntreePigeon(Pigeon pigeon);

    Pigeon getPigeonById(Integer pigeonId);

    void enregistrerSortiePigeon(Pigeon pigeon);

    List<PigeonHistorique> getAllPigeonsHistorique();

    Pigeon getPigeonByCode(String pigeonCode);
}
