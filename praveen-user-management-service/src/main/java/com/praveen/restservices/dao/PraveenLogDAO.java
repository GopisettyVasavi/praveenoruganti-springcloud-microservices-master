package com.praveen.restservices.dao;

import com.praveen.restservices.model.PraveenLog;

public interface PraveenLogDAO {
	abstract PraveenLog createLog(final PraveenLog praveenLog) throws Exception;

}
