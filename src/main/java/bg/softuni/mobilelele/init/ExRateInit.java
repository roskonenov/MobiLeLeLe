package bg.softuni.mobilelele.init;

import bg.softuni.mobilelele.service.ExRatesService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ExRateInit implements CommandLineRunner {

    private final ExRatesService exRatesService;

    public ExRateInit(ExRatesService exRatesService) {
        this.exRatesService = exRatesService;
    }

    @Override
    public void run(String... args) {
        if (!exRatesService.isDataInit()){
            exRatesService.updateExRates(exRatesService.fetchExRates());
        }
    }
}
