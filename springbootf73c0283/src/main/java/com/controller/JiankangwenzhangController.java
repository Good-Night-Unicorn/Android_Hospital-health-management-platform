package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JiankangwenzhangEntity;
import com.entity.view.JiankangwenzhangView;

import com.service.JiankangwenzhangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 健康文章
 * 后端接口
 * @author 
 * @email 
 * @date 2025-06-01 22:37:42
 */
@RestController
@RequestMapping("/jiankangwenzhang")
public class JiankangwenzhangController {
    @Autowired
    private JiankangwenzhangService jiankangwenzhangService;

    @Autowired
    private StoreupService storeupService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiankangwenzhangEntity jiankangwenzhang,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JiankangwenzhangEntity> ew = new EntityWrapper<JiankangwenzhangEntity>();


        //查询结果
		PageUtils page = jiankangwenzhangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangwenzhang), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiankangwenzhangEntity jiankangwenzhang, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JiankangwenzhangEntity> ew = new EntityWrapper<JiankangwenzhangEntity>();

        //查询结果
		PageUtils page = jiankangwenzhangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangwenzhang), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiankangwenzhangEntity jiankangwenzhang){
       	EntityWrapper<JiankangwenzhangEntity> ew = new EntityWrapper<JiankangwenzhangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiankangwenzhang, "jiankangwenzhang")); 
        return R.ok().put("data", jiankangwenzhangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiankangwenzhangEntity jiankangwenzhang){
        EntityWrapper< JiankangwenzhangEntity> ew = new EntityWrapper< JiankangwenzhangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiankangwenzhang, "jiankangwenzhang")); 
		JiankangwenzhangView jiankangwenzhangView =  jiankangwenzhangService.selectView(ew);
		return R.ok("查询健康文章成功").put("data", jiankangwenzhangView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiankangwenzhangEntity jiankangwenzhang = jiankangwenzhangService.selectById(id);
        if(null==jiankangwenzhang.getClicknum()){
            jiankangwenzhang.setClicknum(0);
        }
		jiankangwenzhang.setClicknum(jiankangwenzhang.getClicknum()+1);
		jiankangwenzhang.setClicktime(new Date());
		jiankangwenzhangService.updateById(jiankangwenzhang);
        jiankangwenzhang = jiankangwenzhangService.selectView(new EntityWrapper<JiankangwenzhangEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jiankangwenzhang,deSens);
        return R.ok().put("data", jiankangwenzhang);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiankangwenzhangEntity jiankangwenzhang = jiankangwenzhangService.selectById(id);
        if(null==jiankangwenzhang.getClicknum()){
            jiankangwenzhang.setClicknum(0);
        }
		jiankangwenzhang.setClicknum(jiankangwenzhang.getClicknum()+1);
		jiankangwenzhang.setClicktime(new Date());
		jiankangwenzhangService.updateById(jiankangwenzhang);
        jiankangwenzhang = jiankangwenzhangService.selectView(new EntityWrapper<JiankangwenzhangEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jiankangwenzhang,deSens);
        return R.ok().put("data", jiankangwenzhang);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        JiankangwenzhangEntity jiankangwenzhang = jiankangwenzhangService.selectById(id);
        if(type.equals("1")) {
        	jiankangwenzhang.setThumbsupnum(jiankangwenzhang.getThumbsupnum()+1);
        } else {
        	jiankangwenzhang.setCrazilynum(jiankangwenzhang.getCrazilynum()+1);
        }
        jiankangwenzhangService.updateById(jiankangwenzhang);
        return R.ok("投票成功");
    }

    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiankangwenzhangEntity jiankangwenzhang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangwenzhang);
        jiankangwenzhangService.insert(jiankangwenzhang);
        return R.ok().put("data",jiankangwenzhang.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiankangwenzhangEntity jiankangwenzhang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangwenzhang);
        jiankangwenzhangService.insert(jiankangwenzhang);
        return R.ok().put("data",jiankangwenzhang.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiankangwenzhangEntity jiankangwenzhang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangwenzhang);
        //全部更新
        jiankangwenzhangService.updateById(jiankangwenzhang);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiankangwenzhangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,JiankangwenzhangEntity jiankangwenzhang, HttpServletRequest request,String pre){
        EntityWrapper<JiankangwenzhangEntity> ew = new EntityWrapper<JiankangwenzhangEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        // 组装参数
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");

		PageUtils page = jiankangwenzhangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangwenzhang), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,JiankangwenzhangEntity jiankangwenzhang, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "jiankangfenlei";
        // 查询收藏集合
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "jiankangwenzhang").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<JiankangwenzhangEntity> jiankangwenzhangList = new ArrayList<JiankangwenzhangEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            List<String> typeList = new ArrayList<String>();
            for(StoreupEntity s : storeups) {
                if(typeList.contains(s.getInteltype())) continue;
                typeList.add(s.getInteltype());
                jiankangwenzhangList.addAll(jiankangwenzhangService.selectList(new EntityWrapper<JiankangwenzhangEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<JiankangwenzhangEntity> ew = new EntityWrapper<JiankangwenzhangEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        // 根据协同结果查询结果并返回
        PageUtils page = jiankangwenzhangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangwenzhang), params), params));
        List<JiankangwenzhangEntity> pageList = (List<JiankangwenzhangEntity>)page.getList();
        if(jiankangwenzhangList.size()<limit) {
            int toAddNum = (limit-jiankangwenzhangList.size())<=pageList.size()?(limit-jiankangwenzhangList.size()):pageList.size();
            for(JiankangwenzhangEntity o1 : pageList) {
                boolean addFlag = true;
                for(JiankangwenzhangEntity o2 : jiankangwenzhangList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    jiankangwenzhangList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(jiankangwenzhangList.size()>limit) {
            jiankangwenzhangList = jiankangwenzhangList.subList(0, limit);
        }
        page.setList(jiankangwenzhangList);
        return R.ok().put("data", page);
    }






}
