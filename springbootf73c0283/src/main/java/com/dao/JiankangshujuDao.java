package com.dao;

import com.entity.JiankangshujuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiankangshujuVO;
import com.entity.view.JiankangshujuView;


/**
 * 健康数据
 * 
 * @author 
 * @email 
 * @date 2025-06-01 22:37:42
 */
public interface JiankangshujuDao extends BaseMapper<JiankangshujuEntity> {
	
	List<JiankangshujuVO> selectListVO(@Param("ew") Wrapper<JiankangshujuEntity> wrapper);
	
	JiankangshujuVO selectVO(@Param("ew") Wrapper<JiankangshujuEntity> wrapper);
	
	List<JiankangshujuView> selectListView(@Param("ew") Wrapper<JiankangshujuEntity> wrapper);

	List<JiankangshujuView> selectListView(Pagination page,@Param("ew") Wrapper<JiankangshujuEntity> wrapper);

	
	JiankangshujuView selectView(@Param("ew") Wrapper<JiankangshujuEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiankangshujuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiankangshujuEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiankangshujuEntity> wrapper);

    List<Map<String, Object>> xuetangSectionStat(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiankangshujuEntity> wrapper);
    List<Map<String, Object>> shousuoyaSectionStat(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiankangshujuEntity> wrapper);


}
