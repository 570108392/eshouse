package it.qsbl.com.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseResponse {
    private int code;
    private String msg;
    private Object data;

    private int count;
}
