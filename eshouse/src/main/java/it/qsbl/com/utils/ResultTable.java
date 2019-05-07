package it.qsbl.com.utils;

import lombok.Data;

@Data
public class ResultTable extends Result {
    private Long total = 0l;

    public ResultTable(boolean success, String msg, Integer statis, Long total) {
        super(success, msg, statis);
        this.total = total;
    }

    public ResultTable(StatusEnum statusEnum, Object t,Long total) {
        super(statusEnum,t);
        super.setT(t);
        this.total = total;
    }
    public ResultTable(StatusEnum statusEnum) {
        super(statusEnum);
    }

    public static ResultTable seccess(Object t,Long total){
        return new ResultTable(StatusEnum.SUCCESS,t,total);
    }

    public static ResultTable error(StatusEnum statusEnum){
        return new ResultTable(statusEnum);
    }


}
