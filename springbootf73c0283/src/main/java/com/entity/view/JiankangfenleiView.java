package com.entity.view;

import com.entity.JiankangfenleiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 健康分类
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-06-01 22:37:42
 */
@TableName("jiankangfenlei")
public class JiankangfenleiView  extends JiankangfenleiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiankangfenleiView(){
	}
 
 	public JiankangfenleiView(JiankangfenleiEntity jiankangfenleiEntity){
 	try {
			BeanUtils.copyProperties(this, jiankangfenleiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
