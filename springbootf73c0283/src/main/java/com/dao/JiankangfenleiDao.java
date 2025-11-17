package com.dao;

import com.entity.JiankangfenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiankangfenleiVO;
import com.entity.view.JiankangfenleiView;


/**
 * 健康分类
 * 
 * @author 
 * @email 
 * @date 2025-06-01 22:37:42
 */
public interface JiankangfenleiDao extends BaseMapper<JiankangfenleiEntity> {
	
	List<JiankangfenleiVO> selectListVO(@Param("ew") Wrapper<JiankangfenleiEntity> wrapper);
	
	JiankangfenleiVO selectVO(@Param("ew") Wrapper<JiankangfenleiEntity> wrapper);
	
	List<JiankangfenleiView> selectListView(@Param("ew") Wrapper<JiankangfenleiEntity> wrapper);

	List<JiankangfenleiView> selectListView(Pagination page,@Param("ew") Wrapper<JiankangfenleiEntity> wrapper);

	
	JiankangfenleiView selectView(@Param("ew") Wrapper<JiankangfenleiEntity> wrapper);
	

}
