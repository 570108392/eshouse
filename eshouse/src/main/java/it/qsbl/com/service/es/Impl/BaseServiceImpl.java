package it.qsbl.com.service.es.Impl;

import it.qsbl.com.service.es.BaseService;
import org.springframework.beans.factory.annotation.Autowired;


public class BaseServiceImpl<T> implements BaseService<T> {


    @Override
    public Boolean save(T object) {
        return null;
    }

    @Override
    public Boolean update(T object) {
        return null;
    }

    @Override
    public Boolean delete(T object) {
        return null;
    }

    @Override
    public T search(Integer object) {
        return null;
    }


}
