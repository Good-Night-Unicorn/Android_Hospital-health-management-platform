package com.entity.vo;

import com.entity.JiankangpingguEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 健康评估
 * @author 
 * @email 
 * @date 2025-06-01 22:37:42
 */
public class JiankangpingguVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
