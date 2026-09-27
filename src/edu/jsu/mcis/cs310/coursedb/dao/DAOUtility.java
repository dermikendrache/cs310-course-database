package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;
import java.util.ArrayList;

public class DAOUtility {
    
    public static final int TERMID_SP26 = 1;
    
    public static String getResultSetAsJson(ResultSet rs) {
        
        JsonArray records = new JsonArray();
        
        try {
        
            if (rs != null) {
                ResultSetMetaData metadata = rs.getMetaData();
                int colCount = metadata.getColumnCount();
                
                
                while (rs.next()) {
                    JsonObject recording = new JsonObject();
                    
                    for (int i= 1; i<=colCount; i++){
                        String colname =metadata.getColumnName(i);
                        Object value = rs.getObject(i);
                        recording.put(colname, value);
                }
                    records.add(recording);
                }

            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return Jsoner.serialize(records);
        
    }
    
}
