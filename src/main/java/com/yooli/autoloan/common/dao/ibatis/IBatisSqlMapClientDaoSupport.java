package com.yooli.autoloan.common.dao.ibatis;

import javax.sql.DataSource;

import org.springframework.dao.support.DaoSupport;
import org.springframework.util.Assert;

import com.ibatis.sqlmap.client.SqlMapClient;

public abstract class IBatisSqlMapClientDaoSupport extends DaoSupport {
	
	private IBatisSqlMapClientTemplate sqlMapClientTemplate = new IBatisSqlMapClientTemplate();

	private boolean externalTemplate = false;


	
	public final void setDataSource(DataSource dataSource) {
		if (!this.externalTemplate) {
	  	this.sqlMapClientTemplate.setDataSource(dataSource);
		}
	}


	public final DataSource getDataSource() {
		return this.sqlMapClientTemplate.getDataSource();
	}

	
	public final void setSqlMapClient(SqlMapClient sqlMapClient) {
		if (!this.externalTemplate) {
			this.sqlMapClientTemplate.setSqlMapClient(sqlMapClient);
		}
	}

	
	public final SqlMapClient getSqlMapClient() {
		return this.sqlMapClientTemplate.getSqlMapClient();
	}

	
	public final void setSqlMapClientTemplate(IBatisSqlMapClientTemplate sqlMapClientTemplate) {
		Assert.notNull(sqlMapClientTemplate, "SqlMapClientTemplate must not be null");
		this.sqlMapClientTemplate = sqlMapClientTemplate;
		this.externalTemplate = true;
	}

	
	public final IBatisSqlMapClientTemplate getSqlMapClientTemplate() {
	  return this.sqlMapClientTemplate;
	}

	@Override
	protected final void checkDaoConfig() {
		if (!this.externalTemplate) {
			this.sqlMapClientTemplate.afterPropertiesSet();
		}
	}


}
