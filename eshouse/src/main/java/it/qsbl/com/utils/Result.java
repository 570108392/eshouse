package it.qsbl.com.utils;

import lombok.Data;

@Data
public class Result {
    private boolean success = true;

    private String msg = "success";

    private Object t;

    private Integer status = 200;

    public Result(boolean success, String msg, Integer statis) {
        this.success = success;
        this.msg = msg;
        this.status = statis;
    }
    public Result( String msg) {
        this.msg = msg;
    }
    public Result(StatusEnum statusEnum) {
        this.status = statusEnum.getStatus();
        this.msg = statusEnum.getMessage();
        this.success = statusEnum.isSuccess();
    }
    public Result(StatusEnum statusEnum, Object t) {
        this.status = statusEnum.getStatus();
        this.msg = statusEnum.getMessage();
        this.success = statusEnum.isSuccess();
        this.t = t;
    }

    public static Result seccess(){
        return new Result(StatusEnum.SUCCESS);
    }
    public static Result seccess(Object t){
        return new Result(StatusEnum.SUCCESS,t);
    }
//    public static Result seccess(String msg){
//        return new Result(true,msg,200);
//    }

    public static Result error(){
        return new Result(StatusEnum.ERROR);
    }
    public static Result error(Object o ){
        return new Result(StatusEnum.ERROR,o);
    }
//    public static Result error(String msg ){
//        return new Result(false,msg,500);
//    }

    public static Result error(StatusEnum statusEnum){
        return new Result(statusEnum);
    }

}
