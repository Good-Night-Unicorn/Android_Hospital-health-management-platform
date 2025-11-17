package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 健康评估
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-06-01 22:37:42
 */
@TableName("jiankangpinggu")
public class JiankangpingguEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiankangpingguEntity() {
		
	}
	
	public JiankangpingguEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 评估标题
	 */
					
	private String pinggubiaoti;
	
	/**
	 * 评估情况
	 */
					
	private String pingguqingkuang;
	
	/**
	 * 运动建议
	 */
					
	private String yundongjianyi;
	
	/**
	 * 饮食建议
	 */
					
	private String yinshijianyi;
	
	/**
	 * 评估时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date pinggushijian;
	
	/**
	 * 患者账号
	 */
					
	private String huanzhezhanghao;
	
	/**
	 * 患者姓名
	 */
					
	private String huanzhexingming;
	
	/**
	 * 档案名称
	 */
					
	private String danganmingcheng;
	
	/**
	 * 头像
	 */
					
	private String touxiang;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：评估标题
	 */
	public void setPinggubiaoti(String pinggubiaoti) {
		this.pinggubiaoti = pinggubiaoti;
	}
	/**
	 * 获取：评估标题
	 */
	public String getPinggubiaoti() {
		return pinggubiaoti;
	}
	/**
	 * 设置：评估情况
	 */
	public void setPingguqingkuang(String pingguqingkuang) {
		this.pingguqingkuang = pingguqingkuang;
	}
	/**
	 * 获取：评估情况
	 */
	public String getPingguqingkuang() {
		return pingguqingkuang;
	}
	/**
	 * 设置：运动建议
	 */
	public void setYundongjianyi(String yundongjianyi) {
		this.yundongjianyi = yundongjianyi;
	}
	/**
	 * 获取：运动建议
	 */
	public String getYundongjianyi() {
		return yundongjianyi;
	}
	/**
	 * 设置：饮食建议
	 */
	public void setYinshijianyi(String yinshijianyi) {
		this.yinshijianyi = yinshijianyi;
	}
	/**
	 * 获取：饮食建议
	 */
	public String getYinshijianyi() {
		return yinshijianyi;
	}
	/**
	 * 设置：评估时间
	 */
	public void setPinggushijian(Date pinggushijian) {
		this.pinggushijian = pinggushijian;
	}
	/**
	 * 获取：评估时间
	 */
	public Date getPinggushijian() {
		return pinggushijian;
	}
	/**
	 * 设置：患者账号
	 */
	public void setHuanzhezhanghao(String huanzhezhanghao) {
		this.huanzhezhanghao = huanzhezhanghao;
	}
	/**
	 * 获取：患者账号
	 */
	public String getHuanzhezhanghao() {
		return huanzhezhanghao;
	}
	/**
	 * 设置：患者姓名
	 */
	public void setHuanzhexingming(String huanzhexingming) {
		this.huanzhexingming = huanzhexingming;
	}
	/**
	 * 获取：患者姓名
	 */
	public String getHuanzhexingming() {
		return huanzhexingming;
	}
	/**
	 * 设置：档案名称
	 */
	public void setDanganmingcheng(String danganmingcheng) {
		this.danganmingcheng = danganmingcheng;
	}
	/**
	 * 获取：档案名称
	 */
	public String getDanganmingcheng() {
		return danganmingcheng;
	}
	/**
	 * 设置：头像
	 */
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}

}
