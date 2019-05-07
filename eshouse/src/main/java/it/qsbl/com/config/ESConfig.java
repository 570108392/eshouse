package it.qsbl.com.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class ESConfig {
//
//    @Value("${elasticsearch.host:129.204.182.56}")
//    private String esHost;
//
//    @Value("${elasticsearch.port:9300}")
//    private int esPort;
//
//    @Value("${elasticsearch.clusterName:docker-cluster}")
//    private String esClusterName;
//
//    private TransportClient client;
//
//    @PostConstruct
//    public void initialize() throws Exception {
//        Settings esSettings = Settings.builder()
//                .put("cluster.name", esClusterName)
//                .put("client.transport.sniff", true).build();
//        client = new PreBuiltTransportClient(esSettings);
//
//        String[] esHosts = esHost.trim().split(",");
//        for (String host : esHosts) {
//            client.addTransportAddress(new TransportAddress(InetAddress.getByName(host),
//                    esPort));
//        }
//    }
//
//    @Bean
//    public Client client() {
//        return client;
//    }
//
//
//    @Bean
//    public ElasticsearchTemplate elasticsearchTemplate() throws Exception {
//        return new ElasticsearchTemplate(client);
//    }
//
//
//    @PreDestroy
//    public void destroy() {
//        if (client != null) {
//            client.close();
//        }
//    }

}