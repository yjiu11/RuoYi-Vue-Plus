package com.ruoyi.web.controller.gds;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import java.util.List;
import java.util.Arrays;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.utils.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.gds.domain.SellAttribute;
import com.ruoyi.gds.service.ISellAttributeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 销售属性Controller
 * 
 * @author ruoyi
 * @date 2020-07-31
 */
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/gds/attribute" )
@DataSource(DataSourceType.SLAVE)
public class SellAttributeController extends BaseController {

    private final ISellAttributeService iSellAttributeService;

    /**
     * 查询销售属性列表
     */
    @PreAuthorize("@ss.hasPermi('gds:attribute:list')")
    @GetMapping("/list")
    public TableDataInfo list(SellAttribute sellAttribute)
    {
        startPage();
        LambdaQueryWrapper<SellAttribute> lqw = new LambdaQueryWrapper<SellAttribute>();
        if (sellAttribute.getItemId() != null){
            lqw.eq(SellAttribute::getItemId ,sellAttribute.getItemId());
        }
        if (sellAttribute.getPriceId() != null){
            lqw.eq(SellAttribute::getPriceId ,sellAttribute.getPriceId());
        }
        if (StringUtils.isNotBlank(sellAttribute.getCode())){
            lqw.eq(SellAttribute::getCode ,sellAttribute.getCode());
        }
        if (StringUtils.isNotBlank(sellAttribute.getValue())){
            lqw.eq(SellAttribute::getValue ,sellAttribute.getValue());
        }
        if (sellAttribute.getStatus() != null){
            lqw.eq(SellAttribute::getStatus ,sellAttribute.getStatus());
        }
        if (sellAttribute.getIsDelete() != null){
            lqw.eq(SellAttribute::getIsDelete ,sellAttribute.getIsDelete());
        }
        if (StringUtils.isNotBlank(sellAttribute.getCreatedBy())){
            lqw.eq(SellAttribute::getCreatedBy ,sellAttribute.getCreatedBy());
        }
        if (sellAttribute.getCreatedTime() != null){
            lqw.eq(SellAttribute::getCreatedTime ,sellAttribute.getCreatedTime());
        }
        if (StringUtils.isNotBlank(sellAttribute.getUpdatedBy())){
            lqw.eq(SellAttribute::getUpdatedBy ,sellAttribute.getUpdatedBy());
        }
        if (sellAttribute.getUpdatedTime() != null){
            lqw.eq(SellAttribute::getUpdatedTime ,sellAttribute.getUpdatedTime());
        }
        List<SellAttribute> list = iSellAttributeService.list(lqw);
        return getDataTable(list);
    }

    /**
     * 导出销售属性列表
     */
    @PreAuthorize("@ss.hasPermi('gds:attribute:export')" )
    @Log(title = "销售属性" , businessType = BusinessType.EXPORT)
    @GetMapping("/export" )
    public AjaxResult export(SellAttribute sellAttribute) {
        LambdaQueryWrapper<SellAttribute> lqw = new LambdaQueryWrapper<SellAttribute>(sellAttribute);
        List<SellAttribute> list = iSellAttributeService.list(lqw);
        ExcelUtil<SellAttribute> util = new ExcelUtil<SellAttribute>(SellAttribute. class);
        return util.exportExcel(list, "attribute" );
    }

    /**
     * 获取销售属性详细信息
     */
    @PreAuthorize("@ss.hasPermi('gds:attribute:query')" )
    @GetMapping(value = "/{id}" )
    public AjaxResult getInfo(@PathVariable("id" ) Long id) {
        return AjaxResult.success(iSellAttributeService.getById(id));
    }

    /**
     * 新增销售属性
     */
    @PreAuthorize("@ss.hasPermi('gds:attribute:add')" )
    @Log(title = "销售属性" , businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SellAttribute sellAttribute) {
        return toAjax(iSellAttributeService.save(sellAttribute) ? 1 : 0);
    }

    /**
     * 修改销售属性
     */
    @PreAuthorize("@ss.hasPermi('gds:attribute:edit')" )
    @Log(title = "销售属性" , businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SellAttribute sellAttribute) {
        return toAjax(iSellAttributeService.updateById(sellAttribute) ? 1 : 0);
    }

    /**
     * 删除销售属性
     */
    @PreAuthorize("@ss.hasPermi('gds:attribute:remove')" )
    @Log(title = "销售属性" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}" )
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(iSellAttributeService.removeByIds(Arrays.asList(ids)) ? 1 : 0);
    }
}
