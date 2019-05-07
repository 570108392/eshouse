package it.qsbl.com.service.es;

import it.qsbl.com.domain.search.GoodsInfo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GoodInfoService<T> extends  BaseService<T>{

    /**
     * 商城前台 首页商品卡片展示
     * @return
     */
    Iterable<GoodsInfo> findALL();
    Iterable<GoodsInfo> findALLByPage(Pageable pageable);

    long getTotal();

    List getListProductByCategory(Integer categoryID,Pageable pageable);

    Long getListProductByCategoryCounts(Integer categoryID);
}
