package it.qsbl.com.domain.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class MemberVO {

    private Integer memberId;

    private String memberName;

    private BigDecimal memberPrice;


    private Date registerTime;


    private String memberTell;

    private Integer memberStatus;
}
