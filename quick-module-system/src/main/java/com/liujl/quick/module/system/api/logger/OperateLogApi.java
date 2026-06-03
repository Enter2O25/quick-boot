package com.liujl.quick.module.system.api.logger;

import com.liujl.quick.framework.common.biz.system.logger.OperateLogCommonApi;
import com.liujl.quick.framework.common.pojo.PageResult;
import com.liujl.quick.module.system.api.logger.dto.OperateLogPageReqDTO;
import com.liujl.quick.module.system.api.logger.dto.OperateLogRespDTO;

/**
 * 操作日志 API 接口
 *
 * @author admin
 */
public interface OperateLogApi extends OperateLogCommonApi {

    /**
     * 获取指定模块的指定数据的操作日志分页
     *
     * @param pageReqDTO 请求
     * @return 操作日志分页
     */
    PageResult<OperateLogRespDTO> getOperateLogPage(OperateLogPageReqDTO pageReqDTO);

}
