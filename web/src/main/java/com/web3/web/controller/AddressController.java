package com.web3.web.controller;

import java.io.IOException;

import com.web3.web.entity.ResultUtils;
import com.web3.web.entity.vo.AddressProfileVO;
import com.web3.service.address.AddressService;
import com.web3.service.address.dto.AddressProfileDTO;
import com.web3.web.entity.vo.Result;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: mianyun.yt
 * @Date: 2022/12/23
 */
@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Resource
    private AddressService addressService;

    @GetMapping("/profile")
    Result<AddressProfileVO> getProfile(@RequestParam String address) {
        AddressProfileDTO dto = addressService.getProfile(address);
        if (dto == null) {
            return ResultUtils.createSuccessRes(null);
        }
        AddressProfileVO result = new AddressProfileVO();
        BeanUtils.copyProperties(dto, result);
        return ResultUtils.createSuccessRes(result);
    }

    @GetMapping("/version")
    Result<String> getVersion() throws IOException {
        return ResultUtils.createSuccessRes(addressService.getWeb3ClientVersion());
    }

}
