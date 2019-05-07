package it.qsbl.com.domain;

import lombok.Data;

import java.io.Serializable;


/**
 * Created by 瓦力.
 */
@Data
public class HouseTag implements Serializable {
    private Long id;

    private Long houseId;

    private String name;

    public HouseTag() {
    }

}
