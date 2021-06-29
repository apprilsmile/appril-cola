package com.appril.leads.repository;


import com.appril.leads.model.CreditLeadsEntity;
import com.appril.cola.domain.repository.DataRepository;
import com.appril.leads.valueobj.LeadFollow;

import java.util.List;

public interface CreditLeadsRepository extends DataRepository<Long, CreditLeadsEntity> {


    List<LeadFollow> acquireLeadsFollows(String globalId);
}
