package ru.rmamedovjtablefromarray;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {

    private static Connection con;

    private Object[][] contents;
    private String[] columnNames;
    private Class[] columnClasses;

    public MyTableModel(Connection con, String tableName) throws SQLException {
        super();
        MyTableModel.con = con;
        getTableContents(tableName);
    }

    private void getTableContents(String tableName) throws SQLException {
        DatabaseMetaData meta = con.getMetaData();
        ResultSet res = meta.getColumns(null, null, tableName, null);

        ArrayList columnNameList = new ArrayList();
        ArrayList columnTypesList = new ArrayList();

        // Dafine name and type for ich row.
        while (res.next()) {
            columnNameList.add(res.getString("COLUMN_NAME"));
            int dbType = res.getInt("DATA_TYPE");
            switch (dbType) {
                case Types.INTEGER:
                    columnTypesList.add(Integer.class);
                    break;
                case Types.FLOAT:
                    columnTypesList.add(Float.class);
                    break;
                case Types.DOUBLE:
                case Types.REAL:
                    columnTypesList.add(Double.class);
                    break;
                case Types.DATE:
                case Types.TIME:
                case Types.TIMESTAMP:
                    columnTypesList.add(java.sql.Date.class);
                    break;
                default:
                    columnTypesList.add(String.class);
            }
        }
        //coloumn names save to array.
        columnNames = new String[columnNameList.size()];
        columnNameList.toArray(columnNames);
        //coloumn types save to array.
        columnClasses = new Class[columnTypesList.size()];
        columnTypesList.toArray(columnClasses);

        Statement stmt = con.createStatement();
        res = stmt.executeQuery("SELECT * FROM " + tableName);

        ArrayList rowList = new ArrayList();
        while (res.next()) {

            ArrayList cellList = new ArrayList();

            for (int i = 0; i < columnClasses.length; i++) {

                Object cellValue = null;

                if (columnClasses[i] == String.class) {
                    cellValue = res.getString(columnNames[i]);
                } else if (columnClasses[i] == Integer.class) {
                    cellValue = new Integer(res.getInt(columnNames[i]));
                } else if (columnClasses[i] == Float.class) {
                    cellValue = new Float(res.getInt(columnNames[i]));
                } else if (columnClasses[i] == Double.class) {
                    cellValue = new Double(res.getInt(columnNames[i]));
                } else if (columnClasses[i] == java.sql.Date.class) {
                    cellValue = res.getDate(columnNames[i]);
                } else {
                    System.out.println("Не могу определить тип поля " + columnNames[i]);
                }
                cellList.add(cellValue);
            }
            Object cells[] = cellList.toArray();
            rowList.add(cells);
        }

        contents = new Object[rowList.size()][];
        for (int i = 0; i < contents.length; i++) {
            contents[i] = (Object[]) rowList.get(i);
        }

        if (res != null) {
            res.close();
        }
        if (stmt != null) {
            stmt.close();
        }
    }

    
    public boolean updateDB(String tableName) {
         
        ArrayList<String> sqlList = new ArrayList();
        
        for (int i = 0; i < contents.length; i++) {
            Object[] objects = contents[i];
            sqlList.add("update " + tableName + " set name_ru='" + objects[1] + "', name_en='" + objects[2] + "' where id=" + objects[0] + ";");
        }

        Statement statement = null;
        
        try {
            statement = con.createStatement();
            
            for (String sql : sqlList) {
                statement.executeUpdate(sql);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MyTableModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                if (statement!=null) statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(MyTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return true;

    }
    
    
    
    @Override
    public int getRowCount() {
        return contents.length;
    }

    @Override
    public int getColumnCount() {
        if (contents.length == 0) {
            return 0;
        } else {
            return contents[0].length;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return contents[rowIndex][columnIndex];
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        contents[rowIndex][columnIndex] = aValue;

        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public Class getColumnClass(int col) {
        return columnClasses[col];
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return false;
        }
        return true;
    }
}
