#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api;

import com.appril.cola.dto.MultiResponse;
import com.appril.cola.dto.Response;
{package}.dto.CustomerAddCmd;
import ${package}.dto.CustomerListByNameQry;{package}.dto.data.CustomerDTO;

public interface CustomerServiceI {

    public Response addCustomer(CustomerAddCmd customerAddCmd);

    public MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry);
}
