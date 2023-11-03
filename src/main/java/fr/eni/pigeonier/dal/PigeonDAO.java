package fr.eni.pigeonier.dal;

import fr.eni.pigeonier.bo.Pigeon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PigeonDAO extends JpaRepository<Pigeon, Integer> {


    List<Pigeon> findAllByCode(String code);
}
