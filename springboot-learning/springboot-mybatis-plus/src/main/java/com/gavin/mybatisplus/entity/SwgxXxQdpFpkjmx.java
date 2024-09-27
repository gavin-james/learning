package com.gavin.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 全电发票开具明细;
 *
 * @author : http://www.chiner.pro
 * @date : 2024-8-19
 */
@Data
@TableName("swgx_xx_qdp_fpkjmx")
public class SwgxXxQdpFpkjmx implements Serializable, Cloneable {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    /**
     * 全电票发票开具id
     */
    private String qdqFpkjId;
    /**
     * 发票开具id
     */
    private String fpkjId;
    /**
     * 发票开具明细id
     */
    private String fpkjmxId;
    /**
     * 序号
     */
    private String xh;
    /**
     * 发票行性质
     */
    private String fphxz;
    /**
     * 折扣行序号
     */
    private String zkxh1;
    /**
     * 商品名称
     */
    private String xmmc;
    /**
     * 商品分类简称
     */
    private String spfwjc;
    /**
     * 商品全称
     */
    private String spmc;
    /**
     * 商品编码
     */
    private String spbm;
    /**
     * 规格型号
     */
    private String ggxh;
    /**
     * 单位
     */
    private String dw;
    /**
     * 单价
     */
    private String dj;
    /**
     * 数量
     */
    private String spsl;
    /**
     * 金额
     */
    private String je;
    /**
     * 含税金额
     */
    private String hsje;
    /**
     * 税额
     */
    private String se;
    /**
     * 税率
     */
    private String slv;
    /**
     * 零税率标识
     */
    private String lslbs;
    /**
     * 优惠政策标识
     */
    private String yhzcbs;
    /**
     * 所属优惠政策类型代码
     */
    private String ssyhzclxDm;
    /**
     * 增值税特殊管理代码
     */
    private String zzstsgl;
    /**
     *
     */
    private String tdyslxDm;
    /**
     *
     */
    private String tdzsfsDm;
    /**
     *
     */
    private String zspmDm;
    /**
     *
     */
    private String zzszcyjDm;
    /**
     *
     */
    private String hzfpdylzfpmxxh;
    /**
     * 含税单价
     */
    private String hsdj;
    /**
     * 不含税单价
     */
    private String bhsdj;
    /**
     * 不含税金额
     */
    private String bhsje;
    /**
     * 商品原始税率
     */
    private String yslv;
    /**
     * 被折扣行明细id
     */
    private String bzkhMxid;
    /**
     * 折扣金额
     */
    private String zkje;
    /**
     * 建筑服务发生地
     */
    private String jzfwfsd;
    /**
     * 建筑项目名称
     */
    private String jzxmmc;
    /**
     * 不动产产权证书编号
     */
    private String cqzsh;
    /**
     * 扩展1
     */
    private String kz1;
    /**
     * 扩展2
     */
    private String kz2;
    /**
     * 扩展3
     */
    private String kz3;
    /**
     * 扩展4
     */
    private String kz4;
    /**
     * 扩展5
     */
    private String kz5;
    /**
     * 扩展6
     */
    private String kz6;
    /**
     * 商品批次
     */
    private String sppc;
    /**
     * 负票上的蓝票明细序号
     */
    private String lzmxxh;

}