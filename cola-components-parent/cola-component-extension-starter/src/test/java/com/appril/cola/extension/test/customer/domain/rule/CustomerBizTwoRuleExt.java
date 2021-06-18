package com.appril.cola.extension.test.customer.domain.rule;

import com.appril.cola.extension.Extension;
import com.appril.cola.extension.test.customer.domain.CustomerEntity;
import com.appril.cola.extension.test.customer.client.Constants;

/**
 * CustomerBizTwoRuleExt
 *
 * @author Frank Zhang
 * @date 2018-01-07 12:10 PM
 */
@Extension(bizId = Constants.BIZ_2)
public class CustomerBizTwoRuleExt implements CustomerRuleExtPt{

    @Override
    public boolean addCustomerCheck(CustomerEntity customerEntity) {
        //Any Customer can be added
        return true;
    }
}
