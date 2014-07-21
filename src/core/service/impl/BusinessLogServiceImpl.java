package core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import core.dao.SupportDao;
import core.model.BusinessLog;
import core.service.BusinessLogService;

@Service("businessLogService")
public class BusinessLogServiceImpl extends SupportServiceImpl<BusinessLog> implements BusinessLogService {

	@Override
	@Resource(name="businessLogDao")
	public void setSupportDao(@SuppressWarnings("rawtypes") SupportDao supportDao) {
		super.setSupportDao(supportDao);
	}
}
