package com.gonghr.fmmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Orders {
    private String orderId;
    private String userId;
    private String untitled;
    private String receiverName;
    private String receiverMobile;
    private String receiverAddress;
    private BigDecimal totalAmount;
    private BigDecimal actualAmount;
    private Integer payType;
    private String orderRemark;
    private String status;
    private String deliveryType;
    private String deliveryFlowId;
    private BigDecimal orderFreight;
    private Integer deleteStatus;
    private Date createTime;
    private Date updateTime;
    private Date payTime;
    private Date deliveryTime;
    private Date flishTime;
    private Date cancelTime;
    private Integer closeType;
}
