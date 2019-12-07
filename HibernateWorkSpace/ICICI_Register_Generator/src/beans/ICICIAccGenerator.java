package beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ICICIAccGenerator implements IdentifierGenerator {
	
	public  Serializable generate(SharedSessionContractImplementor s,Object o){
		String name="ICICI";
		try
		{
	/*
    CREATE SEQUENCE ICICI
	START WITH 1234
	INCREMENT BY 1
	NOCYCLE
	NOCACHE
	*/
		Connection con=s.connection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select ICICI.nextval from dual");
		/*  above query will give output like
		 * nextval 
		   1234,1235,1236,1237.... **/
		if(rs.next())
		{
			name=name+rs.getInt(1);
		}
		}
		catch(Exception e)
		{
		}
		return name;
		}
	
}

