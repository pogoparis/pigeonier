package fr.eni.pigeonier.bll;

import fr.eni.pigeonier.bo.Pigeon;

import java.util.List;
import java.util.Optional;

public interface PigeonService {
    List<Pigeon> getAllPigeons();

    void addPigeon(Pigeon pigeon);

    List<Pigeon> getPigeonsByCode(String code);

    void supprimerPigeonsByCode(String code);

    List<Pigeon> attaquerPigeonnier(String targetPigeonnierUrl, Integer attackNumber);

    void enregistrerEntreePigeon(Pigeon pigeon);

    Pigeon getPigeonById(Integer pigeonId);

    void enregistrerSortiePigeon(Pigeon pigeon);
}
