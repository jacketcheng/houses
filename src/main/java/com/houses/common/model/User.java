package com.houses.common.model;

import lombok.Data;

import java.util.Date;

/**
 * 用户表
 */
@Data
public class User {

    /**
     * id
     */
    private long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 自我介绍
     */
    private String aboutme;

    /**
     * 加密密码
     */
    private String passwd;

    /**
     * 头像图片
     */
    private String avatar;

    /**
     * 1:普通用户，2:房产经纪人
     */
    private int type;

    /**
     * 创建时间
     */
    private Date create_time;

    /**
     * 是否启用,1启用，0停用
     */
    private int enable;

    /**
     * 所属经纪机构
     */
    private int agency_id;

}
