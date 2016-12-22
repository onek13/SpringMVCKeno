/**
 * 
 */
package com.training.customer.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Repository;

import com.training.customer.model.Customer;

/**
 * @author Keno San Pedro
 *
 */
@Repository
public class CustomerJDBC extends JdbcDaoSupport implements ICustomerJDBC {
	
	@Autowired
	public CustomerJDBC(@Qualifier("dataSource") DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	
	public List<Customer> getCustomerList()
	{
		String sqlQueary = "select * from tbl_customer";
		
		List<SqlParameter> searchParamTypeList 	= new ArrayList<SqlParameter>();
		List<Object> searchParamValueList 		= new ArrayList<Object>();
		
//		searchParamTypeList.add(new SqlParameter(Types.BIGINT));
//		searchParamValueList.add(custId);
		
		CustomerQuery searchQuery = new CustomerQuery(getDataSource(),sqlQueary);
		
		List<Customer> resultList = searchQuery.execute(searchParamTypeList,searchParamValueList);

		return resultList;
	}
	
	
	class CustomerQuery extends MappingSqlQuery
	{
		/**
		 * 
		 * @param ds
		 * @param sql
		 */
		public CustomerQuery(DataSource ds, String sql)
		{
			super(ds, sql);
		}

		/**
		 * @param rs
		 * @param idx
		 * @return
		 */
		protected Object mapRow(ResultSet rs, int idx) throws SQLException 
		{			
			Customer customer = new Customer();
			customer.setId(rs.getInt("ID"));
			customer.setFirstName(rs.getString("first_name"));
			customer.setLastName(rs.getString("last_name"));
			return customer;
		}
		/**
		 * 
		 * @param typeList list contain the SqlParameter definition of input parameter type
		 * @param valueList list contain the value of input parameter
		 * @return
		 */
		public List execute(List typeList, List valueList)
		{
			//<let it be exception if TYPE list not exist
			for(int idx=0; idx < typeList.size(); idx++)
			{
				//<declaring input parameter(s)
				declareParameter((SqlParameter)typeList.get(idx));
			}
			
			return super.execute(valueList.toArray());
		}
	}
	
	
	

}
