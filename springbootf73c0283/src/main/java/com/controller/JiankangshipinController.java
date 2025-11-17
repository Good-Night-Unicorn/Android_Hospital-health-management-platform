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

import com.entity.JiankangshipinEntity;
import com.entity.view.JiankangshipinView;

import com.service.JiankangshipinService;
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
 * 健康视频
 * 后端接口
 * @author 
 * @email 
 * @date 2025-06-01 22:37:42
 */
@RestController
@RequestMapping("/jiankangshipin")
public class JiankangshipinController {
    @Autowired
    private JiankangshipinService jiankangshipinService;

    @Autowired
    private StoreupService storeupService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiankangshipinEntity jiankangshipin,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JiankangshipinEntity> ew = new EntityWrapper<JiankangshipinEntity>();


        //查询结果
		PageUtils page = jiankangshipinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangshipin), params), params));
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
    public R list(@RequestParam Map<String, Object> params,JiankangshipinEntity jiankangshipin, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JiankangshipinEntity> ew = new EntityWrapper<JiankangshipinEntity>();

        //查询结果
		PageUtils page = jiankangshipinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangshipin), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiankangshipinEntity jiankangshipin){
       	EntityWrapper<JiankangshipinEntity> ew = new EntityWrapper<JiankangshipinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiankangshipin, "jiankangshipin")); 
        return R.ok().put("data", jiankangshipinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiankangshipinEntity jiankangshipin){
        EntityWrapper< JiankangshipinEntity> ew = new EntityWrapper< JiankangshipinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiankangshipin, "jiankangshipin")); 
		JiankangshipinView jiankangshipinView =  jiankangshipinService.selectView(ew);
		return R.ok("查询健康视频成功").put("data", jiankangshipinView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiankangshipinEntity jiankangshipin = jiankangshipinService.selectById(id);
        if(null==jiankangshipin.getClicknum()){
            jiankangshipin.setClicknum(0);
        }
		jiankangshipin.setClicknum(jiankangshipin.getClicknum()+1);
		jiankangshipin.setClicktime(new Date());
		jiankangshipinService.updateById(jiankangshipin);
        jiankangshipin = jiankangshipinService.selectView(new EntityWrapper<JiankangshipinEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jiankangshipin,deSens);
        return R.ok().put("data", jiankangshipin);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiankangshipinEntity jiankangshipin = jiankangshipinService.selectById(id);
        if(null==jiankangshipin.getClicknum()){
            jiankangshipin.setClicknum(0);
        }
		jiankangshipin.setClicknum(jiankangshipin.getClicknum()+1);
		jiankangshipin.setClicktime(new Date());
		jiankangshipinService.updateById(jiankangshipin);
        jiankangshipin = jiankangshipinService.selectView(new EntityWrapper<JiankangshipinEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jiankangshipin,deSens);
        return R.ok().put("data", jiankangshipin);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        JiankangshipinEntity jiankangshipin = jiankangshipinService.selectById(id);
        if(type.equals("1")) {
        	jiankangshipin.setThumbsupnum(jiankangshipin.getThumbsupnum()+1);
        } else {
        	jiankangshipin.setCrazilynum(jiankangshipin.getCrazilynum()+1);
        }
        jiankangshipinService.updateById(jiankangshipin);
        return R.ok("投票成功");
    }

    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiankangshipinEntity jiankangshipin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangshipin);
        jiankangshipinService.insert(jiankangshipin);
        return R.ok().put("data",jiankangshipin.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiankangshipinEntity jiankangshipin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangshipin);
        jiankangshipinService.insert(jiankangshipin);
        return R.ok().put("data",jiankangshipin.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiankangshipinEntity jiankangshipin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangshipin);
        //全部更新
        jiankangshipinService.updateById(jiankangshipin);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiankangshipinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,JiankangshipinEntity jiankangshipin, HttpServletRequest request,String pre){
        EntityWrapper<JiankangshipinEntity> ew = new EntityWrapper<JiankangshipinEntity>();
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

		PageUtils page = jiankangshipinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangshipin), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,JiankangshipinEntity jiankangshipin, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "jiankangfenlei";
        // 查询收藏集合
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "jiankangshipin").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<JiankangshipinEntity> jiankangshipinList = new ArrayList<JiankangshipinEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            List<String> typeList = new ArrayList<String>();
            for(StoreupEntity s : storeups) {
                if(typeList.contains(s.getInteltype())) continue;
                typeList.add(s.getInteltype());
                jiankangshipinList.addAll(jiankangshipinService.selectList(new EntityWrapper<JiankangshipinEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<JiankangshipinEntity> ew = new EntityWrapper<JiankangshipinEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        // 根据协同结果查询结果并返回
        PageUtils page = jiankangshipinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangshipin), params), params));
        List<JiankangshipinEntity> pageList = (List<JiankangshipinEntity>)page.getList();
        if(jiankangshipinList.size()<limit) {
            int toAddNum = (limit-jiankangshipinList.size())<=pageList.size()?(limit-jiankangshipinList.size()):pageList.size();
            for(JiankangshipinEntity o1 : pageList) {
                boolean addFlag = true;
                for(JiankangshipinEntity o2 : jiankangshipinList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    jiankangshipinList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(jiankangshipinList.size()>limit) {
            jiankangshipinList = jiankangshipinList.subList(0, limit);
        }
        page.setList(jiankangshipinList);
        return R.ok().put("data", page);
    }






}
