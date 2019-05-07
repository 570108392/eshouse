package it.qsbl.com.domain;


import lombok.Data;

import java.io.Serializable;

@Data
public class HousePicture implements Serializable {
    private Long id;

    private Long houseId;

    private String path;

    private String cdnPrefix;

    private int width;

    private int height;

    private String location;

}
