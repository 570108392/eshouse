package it.qsbl.com;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("it.qsbl.com")
@EnableRabbit
public class EshouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshouseApplication.class, args);
    }

    public RestHighLevelClient esClient(){
        RestClientBuilder builder = RestClient.builder(new HttpHost("129.204.182.56", 9300, "http"));

        RestHighLevelClient highLevelClient = new RestHighLevelClient(builder);
        return  highLevelClient;
    }

}
