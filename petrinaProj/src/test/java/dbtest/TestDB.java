package dbtest;


import libs.Database;
import libs.UtilsForDB;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestDB {
    static Logger logger = Logger.getLogger(TestDB.class);
    static Database dbMySql;


    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySql = new Database("MySQL_PADB_DB", "MySQL");
        logger.info("MySQL DB connected");
    }


    @After
    public void tearDown() throws SQLException {
        dbMySql.quit();
    }

    @Test
    public void dataFromDbTest() throws SQLException, IOException, ClassNotFoundException {
        List<Map<String,String>> dataFromSeleniumTable =
                dbMySql.selectTable("select * from seleniumTable where login = 'test'");
        logger.info("Result = " + dataFromSeleniumTable);
        logger.info("FirstPass = " + dataFromSeleniumTable.get(1));
       // int effectedRows = dbMySql.changeTable("INSERT INTO seleniumTable VALUES (2,'HiHi','pass')");
      //  logger.info("Effected = " + effectedRows);
        List<ArrayList> dataFromSeleniumTable_1 =dbMySql.selectTable("select * from seleniumTable where login = 'HiHi'");
        logger.info(" Result = " + dataFromSeleniumTable_1.get(1).get(2));


        UtilsForDB utilsForDB = new UtilsForDB();
        utilsForDB.getPassForLogin("G32");
        logger.info(utilsForDB.getPassForLogin("G32"));

    }

}