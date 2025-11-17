package com.dao;

import com.entity.JiankangwenzhangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiankangwenzhangVO;
import com.entity.view.JiankangwenzhangView;


/**
 * 健康文章
 * 
 * @author 
 * @email 
 * @date 2025-06-01 22:37:42
 */
public interface JiankangwenzhangDao extends BaseMapper<JiankangwenzhangEntity> {
	
	List<JiankangwenzhangVO> selectListVO(@Param("ew") Wrapper<JiankangwenzhangEntity> wrapper);
	
	JiankangwenzhangVO selectVO(@Param("ew") Wrapper<JiankangwenzhangEntity> wrapper);
	
	List<JiankangwenzhangView> selectListView(@Param("ew") Wrapper<JiankangwenzhangEntity> wrapper);

	List<JiankangwenzhangView> selectListView(Pagination page,@Param("ew") Wrapper<JiankangwenzhangEntity> wrapper);

	
	JiankangwenzhangView selectView(@Param("ew") Wrapper<JiankangwenzhangEntity> wrapper);
	

}
