package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiankangshujuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiankangshujuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiankangshujuView;


/**
 * 健康数据
 *
 * @author 
 * @email 
 * @date 2025-06-01 22:37:42
 */
public interface JiankangshujuService extends IService<JiankangshujuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiankangshujuVO> selectListVO(Wrapper<JiankangshujuEntity> wrapper);
   	
   	JiankangshujuVO selectVO(@Param("ew") Wrapper<JiankangshujuEntity> wrapper);
   	
   	List<JiankangshujuView> selectListView(Wrapper<JiankangshujuEntity> wrapper);
   	
   	JiankangshujuView selectView(@Param("ew") Wrapper<JiankangshujuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiankangshujuEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<JiankangshujuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<JiankangshujuEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<JiankangshujuEntity> wrapper);

    List<Map<String, Object>> xuetangSectionStat(Map<String, Object> params,Wrapper<JiankangshujuEntity> wrapper);
    List<Map<String, Object>> shousuoyaSectionStat(Map<String, Object> params,Wrapper<JiankangshujuEntity> wrapper);


}

