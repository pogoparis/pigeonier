package fr.eni.pigeonier.dal;

import fr.eni.pigeonier.bo.PigeonHistorique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PigeonHistoriqueDAO extends JpaRepository<PigeonHistorique, Integer> {

    List<PigeonHistorique> findByPigeonId(Integer idPigeon);
}
