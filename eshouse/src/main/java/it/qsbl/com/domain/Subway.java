package it.qsbl.com.domain;


import lombok.Data;

import java.io.Serializable;

/**
 * Created by 瓦力.
 */
@Data
public class Subway implements Serializable {
    private Long id;

    private String name;

    private String cityEnName;

}
