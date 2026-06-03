package com.liujl.quick.module.infra.dal.mysql.db;

import com.liujl.quick.framework.mybatis.core.mapper.BaseMapperX;
import com.liujl.quick.module.infra.dal.dataobject.db.DataSourceConfigDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据源配置 Mapper
 *
 * @author admin
 */
@Mapper
public interface DataSourceConfigMapper extends BaseMapperX<DataSourceConfigDO> {
}
