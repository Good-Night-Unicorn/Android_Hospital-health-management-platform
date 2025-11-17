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

import com.entity.JiankangdanganEntity;
import com.entity.view.JiankangdanganView;

import com.service.JiankangdanganService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 健康档案
 * 后端接口
 * @author 
 * @email 
 * @date 2025-06-01 22:37:42
 */
@RestController
@RequestMapping("/jiankangdangan")
public class JiankangdanganController {
    @Autowired
    private JiankangdanganService jiankangdanganService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiankangdanganEntity jiankangdangan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huanzhe")) {
			jiankangdangan.setHuanzhezhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<JiankangdanganEntity> ew = new EntityWrapper<JiankangdanganEntity>();


        //查询结果
		PageUtils page = jiankangdanganService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangdangan), params), params));
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
    public R list(@RequestParam Map<String, Object> params,JiankangdanganEntity jiankangdangan, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JiankangdanganEntity> ew = new EntityWrapper<JiankangdanganEntity>();

        //查询结果
		PageUtils page = jiankangdanganService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangdangan), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiankangdanganEntity jiankangdangan){
       	EntityWrapper<JiankangdanganEntity> ew = new EntityWrapper<JiankangdanganEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiankangdangan, "jiankangdangan")); 
        return R.ok().put("data", jiankangdanganService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiankangdanganEntity jiankangdangan){
        EntityWrapper< JiankangdanganEntity> ew = new EntityWrapper< JiankangdanganEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiankangdangan, "jiankangdangan")); 
		JiankangdanganView jiankangdanganView =  jiankangdanganService.selectView(ew);
		return R.ok("查询健康档案成功").put("data", jiankangdanganView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiankangdanganEntity jiankangdangan = jiankangdanganService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jiankangdangan,deSens);
        return R.ok().put("data", jiankangdangan);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiankangdanganEntity jiankangdangan = jiankangdanganService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jiankangdangan,deSens);
        return R.ok().put("data", jiankangdangan);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiankangdanganEntity jiankangdangan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangdangan);
        jiankangdanganService.insert(jiankangdangan);
        return R.ok().put("data",jiankangdangan.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiankangdanganEntity jiankangdangan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangdangan);
        jiankangdanganService.insert(jiankangdangan);
        return R.ok().put("data",jiankangdangan.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiankangdanganEntity jiankangdangan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangdangan);
        //全部更新
        jiankangdanganService.updateById(jiankangdangan);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiankangdanganService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
