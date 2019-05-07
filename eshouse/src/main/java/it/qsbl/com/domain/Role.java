package it.qsbl.com.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * Created by 瓦力.
 */
@Data
public class Role implements Serializable {
    private Integer id;

    private String userId;

    @NotBlank(message = "角色名称不能为空")
    private String name;

}
