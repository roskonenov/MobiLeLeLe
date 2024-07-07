package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.config.ForexApiConfig;
import bg.softuni.mobilelele.exception.ObjectNotFoundException;
import bg.softuni.mobilelele.model.dto.ExRateDTO;
import bg.softuni.mobilelele.model.entity.ExRate;
import bg.softuni.mobilelele.repository.ExRatesRepository;
import bg.softuni.mobilelele.service.ExRatesService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
public class ExRatesServiceImpl implements ExRatesService {

    private final ExRatesRepository exRatesRepository;

    private final RestClient restClient;

    private final ForexApiConfig forexApiConfig;

    public ExRatesServiceImpl(ExRatesRepository exRatesRepository, RestClient restClient, ForexApiConfig forexApiConfig) {
        this.exRatesRepository = exRatesRepository;
        this.restClient = restClient;
        this.forexApiConfig = forexApiConfig;
    }

    @Override
    public boolean isDataInit() {
        return exRatesRepository.count() > 0;
    }

    @Override
    public ExRateDTO fetchExRates() {
       return restClient
                .get()
                .uri(forexApiConfig.getUrl(), forexApiConfig.getKey(), forexApiConfig.getBase())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(ExRateDTO.class);
    }

    @Override
    public void updateExRates(ExRateDTO exRateDTO) {
        if (!forexApiConfig.getBase().equals(exRateDTO.getBase())) {
            throw new IllegalArgumentException("Base currency must be BGN");
        }

        exRateDTO.getRates().forEach((k, v) -> {
            ExRate rate = exRatesRepository.findByCurrency(k)
                    .orElseGet(() -> new ExRate().setCurrency(k));

            rate.setRate(v);
            exRatesRepository.saveAndFlush(rate);
        });
    }

    @Override
    public Optional<BigDecimal> getExRate(String from, String to) {
        if (from.equals(to)) {
            return Optional.of(BigDecimal.ONE);
        }

        Optional<BigDecimal> optFrom = getOptionalRate(from);

        Optional<BigDecimal> optTo = getOptionalRate(to);

        if (optFrom.isEmpty() || optTo.isEmpty()) {
            return Optional.empty();
        } else {
           return Optional.of(optTo.get().divide(optFrom.get(), 2, RoundingMode.HALF_DOWN));
        }
    }

    private Optional<BigDecimal> getOptionalRate(String currency) {
        return forexApiConfig.getBase().equals(currency) ?
                Optional.of(BigDecimal.ONE) :
                exRatesRepository.findByCurrency(currency)
                        .map(ExRate::getRate);
    }

    @Override
    public BigDecimal convert(String from, String to, BigDecimal amount) {
        return getExRate(from, to)
                .orElseThrow(() -> new ObjectNotFoundException("Conversion from " + from + " to " + to + " is not possible"))
                .multiply(amount);
    }

    @Override
    public List<String> findAllCurrencies() {
        return exRatesRepository.findAll()
                .stream()
                .map(ExRate::getCurrency)
                .toList();
    }
}
