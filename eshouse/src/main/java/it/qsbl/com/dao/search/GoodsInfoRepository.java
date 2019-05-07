package it.qsbl.com.dao.search;

import it.qsbl.com.domain.search.GoodsInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface GoodsInfoRepository extends ElasticsearchCrudRepository<GoodsInfo,Integer> {
}
