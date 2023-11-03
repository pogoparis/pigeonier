package fr.eni.pigeonier.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class PigeonHistorique {
    @Id
    @GeneratedValue
    private Integer id;
    @Getter
    private String nom;
    @Getter
    private String proprio;
    @Getter
    private String code;
    @Getter
    private Integer pigeonId;
    @Getter
    private LocalDateTime dateEntree;
    @Getter
    private LocalDateTime dateSortie;

    public PigeonHistorique(String nom, String proprio, String code, Integer pigeonId, LocalDateTime dateEntree, LocalDateTime dateSortie) {
        this.nom = nom;
        this.proprio = proprio;
        this.code = code;
        this.pigeonId = pigeonId;
        this.dateEntree = dateEntree;
        this.dateSortie = dateSortie;
    }
}
