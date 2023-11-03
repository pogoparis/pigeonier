package fr.eni.pigeonier.WS;

import fr.eni.pigeonier.bll.PigeonService;
import fr.eni.pigeonier.bo.Pigeon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pigeon")
public class PigeonWS {

    @Autowired
    private PigeonService pigeonService;

    @GetMapping("/attaque/{code}")
    public List<Pigeon> attaquerPigeonier(@PathVariable String code) {
        List<Pigeon> pigeons = pigeonService.getPigeonsByCode(code);
        pigeonService.supprimerPigeonsByCode(code);
        return pigeons;
    }

        @PostMapping("/attaque")
        public ResponseEntity<List<Pigeon>> attaquerPigeonnier(@RequestParam String targetPigeonnierUrl,
                                                               @RequestParam Integer attackNumber) {

            RestTemplate restTemplate = new RestTemplate();
            String url = "http://" + targetPigeonnierUrl + ":8080/pigeon/attaque/" + attackNumber;
            ResponseEntity<List<Pigeon>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Pigeon>>() {});

            List<Pigeon> pigeonsVoles = response.getBody();


            if (pigeonsVoles.isEmpty()) {
                return ResponseEntity.ok(new ArrayList<>());
            } else {
                // Ajout les pigeons volés
                pigeonService.addPigeon((Pigeon) pigeonsVoles);
                return ResponseEntity.ok(pigeonsVoles);
            }
        }


}