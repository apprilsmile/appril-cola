package com.appril.cola.extension.test.customer.client;

import com.appril.cola.dto.Response;
import com.appril.cola.dto.SingleResponse;

/**
 * CustomerServiceI
 *
 * @author Frank Zhang 2018-01-06 7:24 PM
 */
public interface CustomerServiceI {
    public Response addCustomer(AddCustomerCmd addCustomerCmd);
    public SingleResponse<CustomerDTO> getCustomer(GetOneCustomerQry getOneCustomerQry);
}
