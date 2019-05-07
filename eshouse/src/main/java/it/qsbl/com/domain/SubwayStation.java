package it.qsbl.com.domain;


import lombok.Data;

import java.io.Serializable;

/**
 * Created by 瓦力.
 */
@Data
public class SubwayStation implements Serializable {
    private Long id;

    private Long subwayId;

    private String name;
}
