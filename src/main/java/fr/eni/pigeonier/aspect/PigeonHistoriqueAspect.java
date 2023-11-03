package fr.eni.pigeonier.aspect;

import fr.eni.pigeonier.bll.PigeonService;
import fr.eni.pigeonier.bo.Pigeon;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Aspect
@Component
public class PigeonHistoriqueAspect {

    @Autowired
    private PigeonService pigeonService;

    @Before("execution(* fr.eni.pigeonier.bll.PigeonServiceImpl.addAllPigeons(..)) && args(pigeons)")
    public void avantAjoutPigeon(List<Pigeon> pigeons) {
        for (Pigeon pigeon : pigeons) {
            pigeonService.enregistrerEntreePigeon(pigeon);
        }
    }

    @Before("execution(* fr.eni.pigeonier.bll.PigeonServiceImpl.supprimerPigeonsByCode(..)) && args(pigeonId)")
    public void avantSuppressionPigeon(Integer pigeonId) {
        Pigeon pigeon = pigeonService.getPigeonById(pigeonId);
        if (pigeon != null) {
            pigeonService.enregistrerSortiePigeon(pigeon);
        }
    }
}


