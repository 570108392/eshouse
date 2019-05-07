package it.qsbl.com.domain.vo;

import lombok.Data;

import java.util.Objects;

@Data
public class MenuVO {
    private Integer mid;
    private Integer pid;

    private String mname;

    private String mdesc;

    private Integer rid;

    private String menuUrl;

    private Boolean LAY_CHECKED = false;
}