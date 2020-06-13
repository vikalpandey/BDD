package Util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DB {
	
	
	
	public static void dbconnect_testbyvp() throws ClassNotFoundException, SQLException
	{
//--sql server add sql server jdbc maven   "com.microsoft.sqlserver" "mssql-jdbc" "8.2.2.jre8"
		
		//Loading the required JDBC Driver class
		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 
		//Creating a connection to the database
		 // Connection conn = DriverManager.getConnection("DatabaseURL","UserName", "Password");
		 Connection conn = DriverManager.getConnection("jdbc:sqlserver://10.11.198.213/AvitusNet_Release3.15_Dev","avitusadmin","India@1234");
	     System.out.println("db connected");
		//Executing SQL query and fetching the result
		 Statement st = conn.createStatement();
		 String Sql = "select isactive, * from avl.EmployeeSeparation order by EmployeeSeparationId desc"; 
		 ResultSet rs = st.executeQuery(Sql);
		 
		 while (rs.next())
		 {
		 System.out.println(rs.getString("EmployeeSeparationId"));
		 }
		 conn.close();

	}
	
	// - gaurav methods
	

	private Map<String, Map<String, String>> getTableDataFromDB(String tableName, String testCaseId) throws Exception {
		Map<String, Map<String, String>> testData = new HashMap<String, Map<String, String>>();

		tableName = tableName.trim().toUpperCase();

		try {

			String DB_URL = "jdbc:mysql://192.168.8.199/FCAUTOMATION";
			java.sql.Connection conn = null;
			Statement stmt = null;
			String sql;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, "root", "root");
			stmt = conn.createStatement();

			String TC_ID = "";
			String TCKEY = "";
			String TCVAL = "";

			sql = "SELECT * FROM " + tableName + " WHERE TC_ID IN ('" + testCaseId + "')";
			ResultSet rs = stmt.executeQuery(sql);
			int size = rs.getFetchSize();
			// ResultSet rsTemp = stmt.executeQuery(sql);
			// rsTemp.next();
			int cnt = 0;
			while (rs.next()) {
				Map<String, String> keyval = new HashMap<String, String>();
				TC_ID = rs.getString("TC_ID");
				TCKEY = rs.getString("TCKEY");
				TCVAL = rs.getString("TCVAL");
				keyval.put(TCKEY, TCVAL);
				// System.out.println(TC_ID);
				// rs.next();
				if (rs.isLast() == false) {
					while (rs.next()) {
						String nextTestCaseId = rs.getString("TC_ID");
						if (nextTestCaseId.equalsIgnoreCase(TC_ID)) {
							// TC_ID = rs.getString("TC_ID");
							// System.out.println("Compare : "+tempTestCaseId);
							TCKEY = rs.getString("TCKEY");
							TCVAL = rs.getString("TCVAL");
							keyval.put(TCKEY, TCVAL);

							testData.put(TC_ID, keyval);
						}

						else {
							rs.previous();
							break;
						}
					}
				} else {
					testData.put(TC_ID, keyval);
				}
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// throw new SkipException(e.getMessage());
		}

		return testData;
	}

	/* This method is used to get translation key-values from Database */
	/*public List<String> translate(String searchKey) throws IOException {

		List<String> listValues = new ArrayList<>();
		try {
			String i18n = FranconnectUtil.config.get("i18Files");
			if (i18n != null && !i18n.isEmpty()) {
				String DB_URL = "jdbc:mysql://192.168.8.199/FCAUTOMATION";
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = null;
				String valueName = null;
				conn = (Connection) DriverManager.getConnection(DB_URL, "root", "root");
				PreparedStatement stmtp = conn
						.prepareStatement("select VALUE_NAME from TRANSLATION where KEY_NAME=(?)");

				stmtp.setString(1, searchKey);
				ResultSet rs = stmtp.executeQuery();
				while (rs.next()) {
					valueName = rs.getString("VALUE_NAME");
					listValues.add(valueName);
				}
				stmtp.close();
				conn.close();
			}

			else {
				listValues.add(searchKey);

			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return listValues;

	}

	*/
	
	// Govind: This method is used for Data Provider

		public Object[][] getTableDataFromDBforDataProvider(String tableName) throws Exception {
			Map<String, Map<String, String>> testData = new HashMap<String, Map<String, String>>();

			tableName = tableName.trim().toUpperCase();

			try {

				String DB_URL = "jdbc:mysql://192.168.8.199/FCAUTOMATION";
				java.sql.Connection conn = null;
				Statement stmt = null;
				String sql;
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(DB_URL, "root", "root");
				stmt = conn.createStatement();

				sql = "SELECT * FROM " + tableName + " WHERE TC_EXECUTE IN ('YES')";
				ResultSet rs = stmt.executeQuery(sql);
				int size = rs.getFetchSize();

				int rowSize = 0;

				System.out.println(rs.getFetchSize());
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnSize = rsmd.getColumnCount();
				ArrayList<String[]> dataList = new ArrayList<String[]>();

				String[] colDataArray = new String[columnSize];
				while (rs.next()) {
					colDataArray = new String[columnSize];
					for (int j = 0; j < columnSize; j++) {
						colDataArray[j] = rs.getString(j + 1);
					}
					dataList.add(colDataArray);

					rowSize++; // typeID is the number of rows in the ResultSet
				}
				String[][] finalDataMatrix = new String[rowSize][columnSize];
				finalDataMatrix = dataList.toArray(finalDataMatrix);
				stmt.close();
				conn.close();
				return finalDataMatrix;
			} catch (Exception e) {
				System.out.println(e.toString());
				return null;
				// throw new SkipException(e.getMessage());
			}
		}

		/***
		 * @author : Akshat
		 * @param tableName
		 * @param columnNameToBeUpdated
		 * @param columnValueToBeUpdated
		 * @param whereColumn1
		 * @param whereValue1
		 */
		public void updateDatabase(String tableName, String columnNameToBeUpdated, String columnValueToBeUpdated,
				String whereColumn1, String whereValue1) {
			try {
				String DB_URL = "jdbc:mysql://192.168.8.199/FCAUTOMATION";
				java.sql.Connection conn = null;
				Statement stmt = null;
				String sql;
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(DB_URL, "root", "root");
				stmt = conn.createStatement();

				sql = "UPDATE " + tableName + " SET " + columnNameToBeUpdated + "=" + "'" + columnValueToBeUpdated + "'"
						+ " WHERE " + whereColumn1 + "=" + "'" + whereValue1 + "'";
				stmt.executeUpdate(sql);
				System.out.println("Table Updated Success");

			} catch (Exception e) {
				System.out.println(e.toString());
			}

		}
		// Govind: This method will click on multi select drop-down, Type & Enter, and
		// select value.

		
	
	
	
	
	
	

}
