package com.web3.dal.data.mapper;

import java.util.List;

import com.web3.dal.data.entity.AddressChangeTemp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 地址余额变化中间表 Mapper 接口
 * </p>
 *
 * @author system
 * @since 2023-01-13
 */
public interface AddressChangeTempMapper extends BaseMapper<AddressChangeTemp> {

    /**
     * replace into 批量插入
     *
     * @param list
     */
    void replaceIntoBatch(List<AddressChangeTemp> list);

}
