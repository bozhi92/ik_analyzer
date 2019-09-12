package org.wltea.analyzer.dic;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.logging.log4j.Logger;
import org.wltea.analyzer.help.ESPluginLoggerFactory;

public class MysqlExtLoader implements Runnable {
    private static final Logger logger = ESPluginLoggerFactory.getLogger(MysqlExtLoader.class.getName());
    
    
    private final static String JDBC_FILE_NAME = "jdbc.properties";
    private final static String EXT_DICT_TABLE = "ext.dict.table";
    private final static String EXT_STOP_TABLE = "ext.stopwords.table";
    private final static String EXT_WORD_FIELD_NAME = "ext.word.field.name";
    private final static String ENABLE_DICT = "enable.dict";
    private final static String ENABLE_EXT_DICT = "enable.ext.dict";
    private final static String ENABLE_STOPWORDS_DICT = "enable.stopwords.dict";
    
    private static DataSource ds;
    private Properties jdbcProps;
    
    public MysqlExtLoader(Properties jdbcProps) {
        this.jdbcProps = jdbcProps;
    }
    
    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }

}
