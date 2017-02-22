package br.com.cds.connecta.framework.connector2.context.database;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class LobExclusionStrategy implements ExclusionStrategy {

	@Override
    public boolean shouldSkipClass(Class<?> clazz) {
    	if(LobClasses.isBlobClass(clazz.getName()))
    		return true;
    	return false;
    }

    @Override
    public boolean shouldSkipField(FieldAttributes f) {
    	return false;
    }
    
    enum LobClasses {
    	ORACLE_BLOB("oracle.sql.BLOB"),
    	ORACLE_CLOB("oracle.sql.CLOB"),
    	MYSQL_BLOB("com.mysql.jdbc.Blob"),
    	MYSQL_CLOB("com.mysql.jdbc.Clob"),
    	SQLSERVER_BLOB("com.microsoft.sqlserver.jdbc.SQLServerBlob"),
    	SQLSERVER_CLOB("com.microsoft.sqlserver.jdbc.SQLServerClob")
    	;
    	
    	private final String clazz;
    	
    	private LobClasses(final String clazz){
    		this.clazz = clazz;
    	}
    	
    	public String getName(){
    		return clazz;
    	}
    	
    	public static boolean isBlobClass(String clazz){
    		for(LobClasses bc : LobClasses.values()){
    			if(bc.getName().equals(clazz))
    				return true;
    		}
    		return false;
    	}
    	
    }
    
}
