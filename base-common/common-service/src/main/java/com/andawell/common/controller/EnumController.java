package com.andawell.common.controller;

import com.andawell.common.cache.EnumCacheMap;
import com.andawell.common.entity.constant.RestResultMessageConstant;
import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author DCY
 *      枚举类的请求接口
 */
@RestController
@RequestMapping(value = "enum", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EnumController {
    @GetMapping(value = "map/{key}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public RestResultVo<Map> map(@ApiParam(value = "key", name = "key") @PathVariable("key") String key) {
        if (!EnumCacheMap.containsKey(key)) {
            return new RestResultVo(RestStatus.BAD_REQUEST, RestResultMessageConstant.RESPONSE_PARAMS_ERROR_MESSAGE);
        }
        return new RestResultVo<Map>(RestStatus.SUCCESS, RestResultMessageConstant.RESPONSE_FIND_SUCCESS_MESSAGE, EnumCacheMap.get(key).getMap());
    }

    @GetMapping(value = "list/{key}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public RestResultVo<List> list(@ApiParam(value = "key", name = "key") @PathVariable("key") String key) {
        if (!EnumCacheMap.containsKey(key)) {
            return new RestResultVo(RestStatus.BAD_REQUEST, RestResultMessageConstant.RESPONSE_PARAMS_ERROR_MESSAGE);
        }
        return new RestResultVo<List>(RestStatus.SUCCESS, RestResultMessageConstant.RESPONSE_FIND_SUCCESS_MESSAGE, EnumCacheMap.get(key).getList());
    }
}