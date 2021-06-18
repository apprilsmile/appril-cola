package com.appril.cola.extension.test.customer.app.extension;

import com.appril.cola.exception.BizException;
import com.appril.cola.extension.Extension;
import com.appril.cola.extension.test.customer.app.extensionpoint.AddCustomerValidatorExtPt;
import com.appril.cola.extension.test.customer.client.AddCustomerCmd;
import com.appril.cola.extension.test.customer.client.Constants;
import com.appril.cola.extension.test.customer.domain.CustomerType;

/**
 * AddCustomerBizOneValidator
 *
 * @author Frank Zhang
 * @date 2018-01-07 1:31 AM
 */
@Extension(bizId = Constants.BIZ_1)
public class AddCustomerBizOneValidator implements AddCustomerValidatorExtPt {

    public void validate(AddCustomerCmd addCustomerCmd) {
        //For BIZ TWO CustomerTYpe could not be VIP
        if(CustomerType.VIP == addCustomerCmd.getCustomerDTO().getCustomerType())
            throw new BizException("Customer Type could not be VIP for Biz One");
    }
}
