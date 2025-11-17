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
 * 健康数据
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-06-01 22:37:42
 */
@TableName("jiankangshuju")
public class JiankangshujuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiankangshujuEntity() {
		
	}
	
	public JiankangshujuEntity(T t) {
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
	 * 患者姓名
	 */
					
	private String huanzhexingming;
	
	/**
	 * 时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date shijian;
	
	/**
	 * 身高(m)
	 */
					
	private String shengao;
	
	/**
	 * 体重(kg)
	 */
					
	private String tizhong;
	
	/**
	 * 左眼视力
	 */
					
	private String zuoyanshili;
	
	/**
	 * 右眼视力
	 */
					
	private String youyanshili;
	
	/**
	 * 血糖(mmol/L)
	 */
					
	private String xuetang;
	
	/**
	 * 舒张压(kpa)
	 */
					
	private String shuzhangya;
	
	/**
	 * 收缩压(kpa)
	 */
					
	private String shousuoya;
	
	/**
	 * 患者账号
	 */
					
	private String huanzhezhanghao;
	
	/**
	 * 年龄
	 */
					
	private String nianling;
	
	/**
	 * 性别
	 */
					
	private String xingbie;
	
	/**
	 * 报告图片
	 */
					
	private String baogaotupian;
	
	
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
	 * 设置：时间
	 */
	public void setShijian(Date shijian) {
		this.shijian = shijian;
	}
	/**
	 * 获取：时间
	 */
	public Date getShijian() {
		return shijian;
	}
	/**
	 * 设置：身高(m)
	 */
	public void setShengao(String shengao) {
		this.shengao = shengao;
	}
	/**
	 * 获取：身高(m)
	 */
	public String getShengao() {
		return shengao;
	}
	/**
	 * 设置：体重(kg)
	 */
	public void setTizhong(String tizhong) {
		this.tizhong = tizhong;
	}
	/**
	 * 获取：体重(kg)
	 */
	public String getTizhong() {
		return tizhong;
	}
	/**
	 * 设置：左眼视力
	 */
	public void setZuoyanshili(String zuoyanshili) {
		this.zuoyanshili = zuoyanshili;
	}
	/**
	 * 获取：左眼视力
	 */
	public String getZuoyanshili() {
		return zuoyanshili;
	}
	/**
	 * 设置：右眼视力
	 */
	public void setYouyanshili(String youyanshili) {
		this.youyanshili = youyanshili;
	}
	/**
	 * 获取：右眼视力
	 */
	public String getYouyanshili() {
		return youyanshili;
	}
	/**
	 * 设置：血糖(mmol/L)
	 */
	public void setXuetang(String xuetang) {
		this.xuetang = xuetang;
	}
	/**
	 * 获取：血糖(mmol/L)
	 */
	public String getXuetang() {
		return xuetang;
	}
	/**
	 * 设置：舒张压(kpa)
	 */
	public void setShuzhangya(String shuzhangya) {
		this.shuzhangya = shuzhangya;
	}
	/**
	 * 获取：舒张压(kpa)
	 */
	public String getShuzhangya() {
		return shuzhangya;
	}
	/**
	 * 设置：收缩压(kpa)
	 */
	public void setShousuoya(String shousuoya) {
		this.shousuoya = shousuoya;
	}
	/**
	 * 获取：收缩压(kpa)
	 */
	public String getShousuoya() {
		return shousuoya;
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
	 * 设置：年龄
	 */
	public void setNianling(String nianling) {
		this.nianling = nianling;
	}
	/**
	 * 获取：年龄
	 */
	public String getNianling() {
		return nianling;
	}
	/**
	 * 设置：性别
	 */
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
	/**
	 * 设置：报告图片
	 */
	public void setBaogaotupian(String baogaotupian) {
		this.baogaotupian = baogaotupian;
	}
	/**
	 * 获取：报告图片
	 */
	public String getBaogaotupian() {
		return baogaotupian;
	}

}
