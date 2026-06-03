package com.liujl.quick.module.system.dal.mysql.mail;

import com.liujl.quick.framework.common.pojo.PageResult;
import com.liujl.quick.framework.mybatis.core.mapper.BaseMapperX;
import com.liujl.quick.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.liujl.quick.module.system.controller.admin.mail.vo.account.MailAccountPageReqVO;
import com.liujl.quick.module.system.dal.dataobject.mail.MailAccountDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MailAccountMapper extends BaseMapperX<MailAccountDO> {

    default PageResult<MailAccountDO> selectPage(MailAccountPageReqVO pageReqVO) {
        return selectPage(pageReqVO, new LambdaQueryWrapperX<MailAccountDO>()
                .likeIfPresent(MailAccountDO::getMail, pageReqVO.getMail())
                .likeIfPresent(MailAccountDO::getUsername , pageReqVO.getUsername())
                .orderByDesc(MailAccountDO::getId));
    }

}
