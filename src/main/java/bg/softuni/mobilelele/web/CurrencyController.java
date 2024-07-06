package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.dto.ConversionResultDTO;
import bg.softuni.mobilelele.service.ExRatesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyController {

    private final ExRatesService exRatesService;

    public CurrencyController(ExRatesService exRatesService) {
        this.exRatesService = exRatesService;
    }

    @GetMapping("/api/convert")
    public ResponseEntity<ConversionResultDTO> convert(
            @RequestParam("from") String from,
            @RequestParam("to") String to,
            @RequestParam("amount") BigDecimal amount
    ) {
        BigDecimal result = exRatesService.convert(from, to, amount);
        return ResponseEntity.ok(new ConversionResultDTO(from, to, amount, result));
    }
}
