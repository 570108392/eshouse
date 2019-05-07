package it.qsbl.com.service.impl;

import it.qsbl.com.dao.ProductInfoMapper;
import it.qsbl.com.domain.ProductInfo;
import it.qsbl.com.domain.vo.ProductInfoVO;
import it.qsbl.com.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Override
    public List<ProductInfo> getAllProductInfo() {
        return productInfoMapper.getAllProductInfo();
    }

    @Override
    public ProductInfo getProductInfo(String id) {
        return  productInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addProductInfo(ProductInfo productInfo) {
        productInfoMapper.insert(productInfo);
    }

    @Override
    public void editProductInfo(ProductInfo productInfo) {
        productInfoMapper.updateByPrimaryKey(productInfo);
    }

    @Override
    public Integer productInfoDelete(String id) {
        return productInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void productInfoDeleteBatch(List<String> ids) {

        productInfoMapper.getAllProductInfoByConitions(ids);
    }

    @Override
    public List<ProductInfo> getAllProductInfo(String productionDate, String productStatus, String startTime, String endTime) {
        return productInfoMapper.getAllProductInfoByConition(productionDate,productStatus,startTime,endTime);
    }
}
