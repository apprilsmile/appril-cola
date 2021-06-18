package com.appril.cola.extension.test.customer.app;

import com.appril.cola.dto.Response;
import com.appril.cola.dto.SingleResponse;
import com.appril.cola.extension.test.customer.client.AddCustomerCmd;
import com.appril.cola.extension.test.customer.client.CustomerDTO;
import com.appril.cola.extension.test.customer.client.CustomerServiceI;
import com.appril.cola.extension.test.customer.client.GetOneCustomerQry;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * CustomerServiceImpl
 *
 * @author Frank Zhang 2018-01-06 7:40 PM
 */
@Service
public class CustomerServiceImpl implements CustomerServiceI {

    @Resource
    private AddCustomerCmdExe addCustomerCmdExe;

    @Resource
    private GetOneCustomerQryExe getOneCustomerQryExe;


    @Override
    public Response addCustomer(AddCustomerCmd addCustomerCmd) {
        return addCustomerCmdExe.execute(addCustomerCmd);
    }

    @Override
    public SingleResponse<CustomerDTO> getCustomer(GetOneCustomerQry getOneCustomerQry) {
        return getOneCustomerQryExe.execute(getOneCustomerQry);
    }
}
