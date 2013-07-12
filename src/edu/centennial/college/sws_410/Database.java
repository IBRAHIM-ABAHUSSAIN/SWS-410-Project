package edu.centennial.college.sws_410;

//Name: Ibrahim O. Abahussain
//Student Number: 300 641 258

import java.util.Map;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
@SuppressWarnings("unused")
public class Database {

	private static final String Database_Name = "SWS-410";
	private static final int Database_Version = 1;

	private static final String Database_Table_01 = "Professor_Information";
	private static final String Table_01_Column_01 = "Professor_Id";
	private static final String Table_01_Column_02 = "Professor_First_Name";
	private static final String Table_01_Column_03 = "Professor_Last_Name";
	private static final String Table_01_Column_04 = "Professor_Email";
	private static final String Table_01_Column_05 = "Professor_Password";
	private static final String Table_01_Column_06 = "Professor_Status";

	
	private static final String[] Table_01_Columns = { Table_01_Column_01,Table_01_Column_02, Table_01_Column_03,Table_01_Column_04,Table_01_Column_05,Table_01_Column_06 };

	private static final String Database_Table_02 = "Exam_Schedule";
	private static final String Table_02_Column_01 = "Exam_Id";
	private static final String Table_02_Column_02 = "Exam_Date";
	private static final String Table_02_Column_03 = "Exam_Time";
	private static final String Table_02_Column_04 = "Exam_Duration";
	private static final String Table_02_Column_05 = "Professor_Email";
	private static final String Table_02_Column_06 = "Course_Id";
	private static final String Table_02_Column_07 = "Exam_Section";
	private static final String Table_02_Column_08 = "Exam_Capacity";
	private static final String Table_02_Column_09 = "Campus_Id";
	private static final String Table_02_Column_10 = "Room_Number";
	private static final String Table_02_Column_11 = "Exam_Assistants";

	private static final String[] Table_02_Columns = { Table_02_Column_01,Table_02_Column_02, Table_02_Column_03,Table_02_Column_04,Table_02_Column_05, Table_02_Column_06,Table_02_Column_07,Table_02_Column_08, Table_02_Column_09,Table_02_Column_10,Table_02_Column_11 };

	private static final String Database_Table_03 = "Course_Information";
	private static final String Table_03_Column_01 = "Course_Id";
	private static final String Table_03_Column_02 = "Course_Name";
	private static final String Table_03_Column_03 = "Course_Section";
	private static final String Table_03_Column_04 = "Professor_Email";
	private static final String Table_03_Column_05 = "Campus_Id";

	private static final String[] Table_03_Columns = { Table_03_Column_01,Table_03_Column_02, Table_03_Column_03, Table_03_Column_04,Table_03_Column_05 };
	
	private static final String Database_Table_04 = "Campus_Information";
	private static final String Table_04_Column_01 = "Campus_Id";
	private static final String Table_04_Column_02 = "Campus_Name";
	private static final String Table_04_Column_03 = "Room_Number";

	private static final String[] Table_04_Columns = { Table_04_Column_01,Table_04_Column_02, Table_04_Column_03};
	
	private static final String Database_Table_05 = "Invigilators_Information";
	private static final String Table_05_Column_01 = "Exam_Id";
	private static final String Table_05_Column_02 = "Invigilators_Email";

	private static final String[] Table_05_Columns = { Table_05_Column_01,Table_05_Column_02};	
	
	private SQLiteDatabase Database;
	private Context Context;
	private DatabaseHelper DatabaseHelper;

	public Database(Context context) {
		this.Context = context;
	}

	protected Database open() {

		DatabaseHelper = new DatabaseHelper(Context);
		Database = DatabaseHelper.getWritableDatabase();
		return this;
	}

	protected void close() {

		DatabaseHelper.close();
	}

	private static class DatabaseHelper extends SQLiteOpenHelper {

		public DatabaseHelper(Context context) {
			super(context, Database_Name, null, Database_Version);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {

			String SQL1 = "Create Table If Not Exists " + Database_Table_01;
			SQL1 += " ( ";
			SQL1 += Table_01_Column_01 + " Integer Primary key , ";
			SQL1 += Table_01_Column_02 + " Text Not Null , ";
			SQL1 += Table_01_Column_03 + " Text Not Null , ";
			SQL1 += Table_01_Column_04 + " Text Not Null , ";
			SQL1 += Table_01_Column_05 + " Text Not Null , ";
			SQL1 += Table_01_Column_06 + " Integer Not Null ";
			SQL1 += " ); ";

			db.execSQL(SQL1);

			String SQL2 = "Create Table If Not Exists " + Database_Table_02;
			SQL2 += " ( ";
			SQL2 += Table_02_Column_01 + " Integer Primary key , ";
			SQL2 += Table_02_Column_02 + " Text Not Null , ";
			SQL2 += Table_02_Column_03 + " Text Not Null , ";
			SQL2 += Table_02_Column_04 + " Text Not Null , ";
			SQL2 += Table_02_Column_05 + " Text Not Null , ";
			SQL2 += Table_02_Column_06 + " Text Not Null , ";
			SQL2 += Table_02_Column_07 + " Integer Not Null , ";
			SQL2 += Table_02_Column_08 + " Integer Not Null , ";
			SQL2 += Table_02_Column_09 + " Text Not Null , ";
			SQL2 += Table_02_Column_10 + " Text Not Null , ";
			SQL2 += Table_02_Column_11 + " Integer Not Null ";
			SQL2 += " ); ";

			db.execSQL(SQL2);

			String SQL3 = "Create Table If Not Exists " + Database_Table_03;
			SQL3 += " ( ";
			SQL3 += Table_03_Column_01 + " Text Not Null , ";
			SQL3 += Table_03_Column_02 + " Text Not Null , ";
			SQL3 += Table_03_Column_03 + " Integer Not Null , ";
			SQL3 += Table_03_Column_04 + " Text Not Null , ";
			SQL3 += Table_03_Column_05 + " Text Not Null ";
			SQL3 += " ); ";

			db.execSQL(SQL3);

			String SQL4 = "Create Table If Not Exists " + Database_Table_04;
			SQL4 += " ( ";
			SQL4 += Table_04_Column_01 + " Text Not Null , ";
			SQL4 += Table_04_Column_02 + " Text Not Null , ";
			SQL4 += Table_04_Column_03 + " Text Not Null ";
			SQL4 += " ); ";

			db.execSQL(SQL4);
			
			String SQL5 = "Create Table If Not Exists " + Database_Table_05;
			SQL5 += " ( ";
			SQL5 += Table_05_Column_01 + " Integer Not Null , ";
			SQL5 += Table_05_Column_02 + " Text Not Null ";
			SQL5 += " ); ";

			db.execSQL(SQL5);
			
			ContentValues contentValues = new ContentValues();
			
			contentValues.put(Table_01_Column_01, 300646464);
			contentValues.put(Table_01_Column_02, "Yin Hua");
			contentValues.put(Table_01_Column_03, "Li");
			contentValues.put(Table_01_Column_04, "Yli@my.centennialcollege.ca");
			contentValues.put(Table_01_Column_05, "6464");
			contentValues.put(Table_01_Column_06, 0);
			
			db.insert(Database_Table_01, null, contentValues);
			contentValues.clear();
			
			contentValues.put(Table_01_Column_01, 300696969);
			contentValues.put(Table_01_Column_02, "Mokhoo");
			contentValues.put(Table_01_Column_03, "Mbobi");
			contentValues.put(Table_01_Column_04, "Mmbobi@my.centennialcollege.ca");
			contentValues.put(Table_01_Column_05, "6969");
			contentValues.put(Table_01_Column_06, 0);
			
			db.insert(Database_Table_01, null, contentValues);
			contentValues.clear();
			
			contentValues.put(Table_02_Column_01, 1757);
			contentValues.put(Table_02_Column_02, "2012-08-14");
			contentValues.put(Table_02_Column_03, "13:30");
			contentValues.put(Table_02_Column_04, "2:00");
			contentValues.put(Table_02_Column_05, "Yli@my.centennialcollege.ca");
			contentValues.put(Table_02_Column_06, "SWS-312");
			contentValues.put(Table_02_Column_07, 61);
			contentValues.put(Table_02_Column_08, 7);
			contentValues.put(Table_02_Column_09, "PR");
			contentValues.put(Table_02_Column_10, "A1-63");
			contentValues.put(Table_02_Column_11, 0);
			
			db.insert(Database_Table_02, null, contentValues);
			contentValues.clear();
			
			contentValues.put(Table_02_Column_01, 1756);
			contentValues.put(Table_02_Column_02, "2012-08-16");
			contentValues.put(Table_02_Column_03, "13:30");
			contentValues.put(Table_02_Column_04, "2:00");
			contentValues.put(Table_02_Column_05, "Mmbobi@my.centennialcollege.ca");
			contentValues.put(Table_02_Column_06, "SWS-310");
			contentValues.put(Table_02_Column_07, 61);
			contentValues.put(Table_02_Column_08, 7);
			contentValues.put(Table_02_Column_09, "PR");
			contentValues.put(Table_02_Column_10, "A1-13");
			contentValues.put(Table_02_Column_11, 0);
			
			db.insert(Database_Table_02, null, contentValues);
			contentValues.clear();
			
			contentValues.put(Table_03_Column_01, "SWS-310");
			contentValues.put(Table_03_Column_02, "Software Stand Test and Main");
			contentValues.put(Table_03_Column_03, 61);
			contentValues.put(Table_03_Column_04, "Mmbobi@my.centennialcollege.ca");
			contentValues.put(Table_03_Column_05, "PR");
			
			db.insert(Database_Table_03, null, contentValues);
			contentValues.clear();
			
			contentValues.put(Table_03_Column_01, "SWS-312");
			contentValues.put(Table_03_Column_02, "Database Programming");
			contentValues.put(Table_03_Column_03, 61);
			contentValues.put(Table_03_Column_04, "Yli@my.centennialcollege.ca");
			contentValues.put(Table_03_Column_05, "PR");
			
			db.insert(Database_Table_03, null, contentValues);
			contentValues.clear();
			
			contentValues.put(Table_04_Column_01, "PR");
			contentValues.put(Table_04_Column_02, "Progress Campus");
			contentValues.put(Table_04_Column_03, "A1-13");
			
			
			db.insert(Database_Table_04, null, contentValues);
			contentValues.clear();
			
			contentValues.put(Table_04_Column_01, "PR");
			contentValues.put(Table_04_Column_02, "Progress Campus");
			contentValues.put(Table_04_Column_03, "A1-63");
			
			
			db.insert(Database_Table_04, null, contentValues);
			contentValues.clear();
			
			//PrePopulatedDatabase(db);
		}
		
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

			String SQL1 = "DROP TABLE IF EXISTS " + Database_Table_01;
			db.execSQL(SQL1);

			String SQL2 = "DROP TABLE IF EXISTS " + Database_Table_02;
			db.execSQL(SQL2);

			String SQL3 = "DROP TABLE IF EXISTS " + Database_Table_03;
			db.execSQL(SQL3);

			String SQL4 = "DROP TABLE IF EXISTS " + Database_Table_04;
			db.execSQL(SQL4);

			String SQL5 = "DROP TABLE IF EXISTS " + Database_Table_05;
			db.execSQL(SQL5);
			
			onCreate(db);
		}

	}

	public boolean verifyUserLogin(Map<Integer, String> userInfo) throws SQLException {

		boolean exist = false;

		Cursor Cursor = Database.query(Database_Table_01, Table_01_Columns,
				Table_01_Column_04 + " = '" + userInfo.get(1) + "'", null, null, null,
				null, null);

		if (Cursor.moveToFirst()) {

			String password = Cursor.getString(Cursor.getColumnIndex(Table_01_Column_05));

			if (password.equals(userInfo.get(2))) {

				exist = true;
			}
		}

		return exist;
	}
	
	public void delete() {
	
		Database.delete(Database_Table_01, null, null);
		Database.delete(Database_Table_02, null, null);
		Database.delete(Database_Table_03, null, null);
		Database.delete(Database_Table_04, null, null);
		Database.delete(Database_Table_05, null, null);
	}
	
	/*
	public void addUser(Map<Integer, String> userInfo) throws SQLException {

		ContentValues contentValues = new ContentValues();

		contentValues.put(Table_3_Column_2, userInfo.get(1));
		contentValues.put(Table_3_Column_3, userInfo.get(2));
		contentValues.put(Table_3_Column_4, userInfo.get(3));

		Database.insert(Database_Table_3, null, contentValues);
	}

	public boolean verifyUserLogin(Map<Integer, String> userInfo) throws SQLException {

		boolean exist = false;

		Cursor Cursor = Database.query(Database_Table_3, Table_3_Columns,
				Table_3_Column_1 + " = " + userInfo.get(1), null, null, null,
				null, null);

		if (Cursor.moveToFirst()) {

			String password = Cursor.getString(Cursor
					.getColumnIndex(Table_3_Column_4));

			if (password.equals(userInfo.get(2))) {

				exist = true;
			}
		}

		return exist;
	}

	public String getUser(String string) {

		String userInfo = "";

		Cursor Cursor = Database
				.query(Database_Table_3, Table_3_Columns, Table_3_Column_1
						+ " = " + string, null, null, null, null, null);

		if (Cursor.moveToFirst()) {

			int userID = Cursor.getInt(Cursor.getColumnIndex(Table_3_Column_1));
			String first_Name = Cursor.getString(Cursor
					.getColumnIndex(Table_3_Column_2));
			String last_Name = Cursor.getString(Cursor
					.getColumnIndex(Table_3_Column_3));

			userInfo = userID + " " + first_Name + " " + last_Name;
		} else {
			userInfo = "Error";
		}

		return userInfo;
	}
	
	public Cursor getAllUser() {

		
		Cursor Cursor = null;
		String[] Table_3_Columns = {Table_3_Column_1,Table_3_Column_2, Table_3_Column_3};
		
		Cursor = Database.query(Database_Table_3, Table_3_Columns,
				null, null, null, null, null, null);
		
		return Cursor;
	}

	public void addPatient(Map<Integer, String> patientInfo) {
		
		ContentValues contentValues = new ContentValues();

		contentValues.put(Table_1_Column_2, patientInfo.get(1));
		contentValues.put(Table_1_Column_3, patientInfo.get(2));
		contentValues.put(Table_1_Column_4, patientInfo.get(3));
		contentValues.put(Table_1_Column_5, patientInfo.get(4));

		Database.insert(Database_Table_1, null, contentValues);
	}

	public void addPatientTest(Map<Integer, String> patientTestInfo) {
		
		ContentValues contentValues = new ContentValues();

		contentValues.put(Table_2_Column_2, patientTestInfo.get(1));
		contentValues.put(Table_2_Column_3, patientTestInfo.get(2));
		contentValues.put(Table_2_Column_4, patientTestInfo.get(3));
		contentValues.put(Table_2_Column_5, patientTestInfo.get(4));

		Database.insert(Database_Table_2, null, contentValues);
	}

	public Cursor getAllPatient() {

		Cursor Cursor = null;
		
		Cursor = Database.query(Database_Table_1, Table_1_Columns, 
				null, null, null, null, null, null);

		return Cursor;
	}
	
	public Cursor getAllPatientTest() {

		Cursor Cursor = null;
		
		Cursor = Database.query(Database_Table_2, Table_2_Columns, 
				null, null, null, null, null, null);

		return Cursor;
	}

	
	public boolean patientIsExist(String patientId) throws SQLException {

		boolean exist = false;

		Cursor Cursor = Database.query(Database_Table_1, Table_1_Columns,
				Table_1_Column_1 + " = " + patientId, null, null, null,
				null, null);

		if (Cursor.moveToFirst()) {
				exist = true;
		}

		return exist;
	}*/

}

