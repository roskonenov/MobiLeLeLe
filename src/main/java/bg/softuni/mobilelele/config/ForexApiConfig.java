package bg.softuni.mobilelele.config;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "forex.api")
public class ForexApiConfig {

    private String key;

    private String url;

    private String base;

    public String getKey() {
        return key;
    }

    public ForexApiConfig setKey(String key) {
        this.key = key;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public ForexApiConfig setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getBase() {
        return base;
    }

    public ForexApiConfig setBase(String base) {
        this.base = base;
        return this;
    }

    @PostConstruct
    public void checkConfiguration(){
        if (!base.equals("BGN")) {
            throw new IllegalStateException("The price must be converted only from BGN");
        }
        verifyIsNotNullOrEmpty("key", key);
        verifyIsNotNullOrEmpty("url", url);
        verifyIsNotNullOrEmpty("base", base);
    }

    private void verifyIsNotNullOrEmpty(String name, String value){
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(name + " must not be empty!");
        }
    }
}
