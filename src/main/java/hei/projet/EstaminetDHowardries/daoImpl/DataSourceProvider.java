package hei.projet.EstaminetDHowardries.daoImpl;

import javax.sql.DataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSourceProvider {
	
	private static MysqlDataSource dataSource;

	public static DataSource getDataSource() {
		if (dataSource == null) {
			dataSource = new MysqlDataSource();
			dataSource.setServerName("localhost");
			dataSource.setPort(3306);
			dataSource.setDatabaseName("estaminet");
			dataSource.setUser("root");
			dataSource.setPassword("d1dyp5gr");
		}
		return dataSource;
	}
}