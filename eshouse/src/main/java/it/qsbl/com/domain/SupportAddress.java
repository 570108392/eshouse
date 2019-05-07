package it.qsbl.com.domain;


import lombok.Data;

import java.io.Serializable;

/**
 * Created by 瓦力.
 */
@Data
public class SupportAddress implements Serializable {
    private Long id;

    // 上一级行政单位
    private String belongTo;

    private String enName;

    private String cnName;

    private String level;

    private double baiduMapLongitude;

    private double baiduMapLatitude;


    /**
     * 行政级别定义
     */
    public enum Level {
        CITY("city"),
        REGION("region");

        private String value;

        Level(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static Level of(String value) {
            for (Level level : Level.values()) {
                if (level.getValue().equals(value)) {
                    return level;
                }
            }

            throw new IllegalArgumentException();
        }
    }
}
