package it.qsbl.com.service.es.Impl;

import it.qsbl.com.dao.search.GoodsInfoRepository;
import it.qsbl.com.domain.search.GoodsInfo;
import it.qsbl.com.service.es.GoodInfoService;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static org.elasticsearch.index.mapper.AllFieldMapper.Defaults.INDEX_NAME;
import static org.elasticsearch.index.query.QueryBuilders.*;
import static org.elasticsearch.search.aggregations.metrics.percentiles.Percentiles.TYPE_NAME;

@Service
public class GoodInfoServiceImpl extends BaseServiceImpl<GoodsInfo> implements GoodInfoService<GoodsInfo> {


    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private GoodsInfoRepository goodsInfoRepository;


    @Override
    public Boolean save(GoodsInfo goodsInfo) {

        goodsInfo.setCreateTime(new Date());
        goodsInfoRepository.save(goodsInfo);
        return true;
    }


    @Override
    public Boolean update(GoodsInfo goodsInfo) {
        goodsInfo.setCreateTime(new Date());
        goodsInfoRepository.save(goodsInfo);
        return true;
    }

    @Override
    public Boolean delete(GoodsInfo goodsInfo) {

        goodsInfoRepository.delete(goodsInfo);
        return true;
    }

    @Override
    public GoodsInfo search(Integer id) {

        return goodsInfoRepository.findById(id).get();
    }
    @Override
    public Iterable<GoodsInfo> findALL() {

        Iterable<GoodsInfo> all = goodsInfoRepository.findAll(Sort.by(Sort.Direction.DESC,"price"));
        return all;
    }

    @Override
    public Iterable<GoodsInfo> findALLByPage(Pageable pageable) {

        Page<GoodsInfo> all = goodsInfoRepository.findAll(pageable);

        return all;
    }

    public long getTotal(){
        return goodsInfoRepository.count();
    }

    public List getListProductByCategory(Integer categoryID,Pageable pageable){
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchQuery("categoryId",categoryID))//.withSort(SortBuilders.fieldSort("price").order(SortOrder.DESC))
                .withPageable(pageable).build();


        return elasticsearchTemplate.queryForList(searchQuery,GoodsInfo.class);
    }
    public Long getListProductByCategoryCounts(Integer categoryID){

        SearchQuery searchQuery=new NativeSearchQueryBuilder().withQuery(boolQuery().
                must(termQuery("categoryId",categoryID))).build();

//        return elasticsearchTemplate.count(searchQuery);用这个就会报错no index defined for query
        return (long)elasticsearchTemplate.queryForList(searchQuery,GoodsInfo.class).size();
    }


}
