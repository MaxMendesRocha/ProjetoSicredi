package br.com.company.CotacaoDolarApplication.Components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CotacaoDolarScheduler {

    private static final String API_URL = "http://127.0.0.1:5000/cotacao-dolar";


    public final RestTemplate restTemplate;

    @Autowired
    public CotacaoDolarScheduler(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Scheduled(fixedRate = 1800000)
    public void consultarCotacaoDolar() {
        try {
            // chamada à API Flask para obter a cotação do dólar
            String cotacaoDolar = restTemplate.getForObject(API_URL, String.class);

            // Exibe a cotação no console
            System.out.println("Cotação do Dólar: " + cotacaoDolar);

        } catch (Exception e) {
            System.err.println("Erro ao consultar a cotação do dólar: " + e.getMessage());
        }
    }
}
