package fr.eni.pigeonier.WS;

import fr.eni.pigeonier.bll.PigeonService;
import fr.eni.pigeonier.bo.Pigeon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("/pigeon")
public class PigeonWS {

    @Autowired
    private PigeonService pigeonService;

    @GetMapping("/attaque/{code}")
    public List<Pigeon> attaquerMonPigeonnier(@PathVariable String code) {
        List<Pigeon> pigeons = pigeonService.getPigeonsByCode(code);
        if (!pigeons.isEmpty()) {
            pigeonService.supprimerPigeonsByCode(code);
        }
        return pigeons;
    }

        @PostMapping("/attaque")
        public ModelAndView attaquerPigeonnier(@RequestParam String targetPigeonnierUrl,
                                               @RequestParam Integer attackNumber,
                                               RedirectAttributes redirectAttributes) {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://" + targetPigeonnierUrl + ":8081/pigeon/attaque/" + attackNumber;
            ResponseEntity<List<Pigeon>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
            });

            List<Pigeon> pigeonsVoles = response.getBody();

            if (pigeonsVoles.isEmpty()) {
                redirectAttributes.addFlashAttribute("message", "L'attaque n'a donné aucun résultat.");
            } else {
                pigeonService.addAllPigeons(pigeonsVoles);
                redirectAttributes.addFlashAttribute("message", "L'attaque a réussi. Pigeons ajoutés avec succès.");
            }

            return new ModelAndView( "redirect:/pigeons");
        }


}