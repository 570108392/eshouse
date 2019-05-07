package it.qsbl.com.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


/**
 * Created by 瓦力.
 */
@Data
@ToString
public class House implements Serializable {
    private Long id;

    private String title;

    private Long adminId;

    private int price;

    private int area;

    private int room;

    private int parlour;

    private int bathroom;

    private int floor;

    private int totalFloor;

    private int watchTimes;

    private int buildYear;

    private int status;

    private Date createTime;

    private Date lastUpdateTime;

    private String cityEnName;

    private String regionEnName;

    private String street;

    private String district;

    private int direction;

    private String cover;

    private int distanceToSubway;

}
