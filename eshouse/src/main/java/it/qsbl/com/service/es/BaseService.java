package it.qsbl.com.service.es;

public interface BaseService<T> {

     Boolean save(T object);
     Boolean update(T object);
     Boolean delete(T object);
     T search(Integer object);
}
