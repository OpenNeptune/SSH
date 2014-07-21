package core.dao.impl;

import org.springframework.stereotype.Repository;

import core.dao.BusinessLogDao;
import core.model.BusinessLog;

@Repository("businessLogDao")
public class BusinessLogDaoImpl extends SupportDaoImpl<BusinessLog> implements BusinessLogDao {

}
