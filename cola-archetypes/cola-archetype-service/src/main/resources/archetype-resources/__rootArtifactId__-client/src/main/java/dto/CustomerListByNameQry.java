#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dto;

import com.appril.cola.dto.Query;
import lombok.Data;

@Data
public class CustomerListByNameQry extends Query{
   private String name;
}
