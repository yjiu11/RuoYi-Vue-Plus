package com.ruoyi.gds.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import com.ruoyi.common.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 销售属性对象 sell_attribute
 * 
 * @author ruoyi
 * @date 2020-07-31
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sell_attribute")
public class SellAttribute implements Serializable {

private static final long serialVersionUID=1L;


    /** ID */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 商品ID */
    @Excel(name = "商品ID")
    private Long itemId;

    /** 价格ID */
    @Excel(name = "价格ID")
    private Long priceId;

    /** 属性代码 */
    @Excel(name = "属性代码")
    private String code;

    /** 属性值 */
    @Excel(name = "属性值")
    private String value;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private Long isDelete;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createdBy;

    /** 创建时间 */
    @Excel(name = "创建时间" , width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    /** 修改人 */
    @Excel(name = "修改人")
    private String updatedBy;

    /** 修改时间 */
    @Excel(name = "修改时间" , width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;
}
