package br.com.cds.connecta.framework.connector2.common;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.metamodel.DataContext;

import br.com.cds.connecta.framework.connector2.context.database.DatabaseDataContextFactory;
import br.com.cds.connecta.framework.connector2.query.QueryBuilder;
import redis.clients.jedis.Jedis;

/**
 *
 * @author diego
 */
public class Base {

    protected DataContext dataContext = null;
    protected QueryBuilder queryContext = null;
    private Jedis jedis = null;
    private final Logger logger = Logger.getLogger(Base.class);
    
    //verificar a possibilidade de pagar esse método
    public DataContext createDataContext() {
        return dataContext;
    }
    
    public QueryBuilder getQueryContext() {
        return queryContext;
    }

    public void setQueryContext(QueryBuilder queryContext) {
        this.queryContext = queryContext;
    }
    
    public DataContext getDataContext() {
        return dataContext;
    }
    
	public Jedis getJedisInstance() {
		if (jedis == null) {
			String redisHost = null;
			String redisPort = null;
			
	        try {
	        	Properties props = new Properties();
				props.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
				redisHost = props.getProperty("connecta.redis.host");
				redisPort = props.getProperty("connecta.redis.port");
			} catch (Exception e){
				logger.error("Erro ao tentar recuperar os endereços do Redis");
			}
	        
	        jedis = new Jedis(redisHost != null ? redisHost : "localhost",
	        					redisPort != null ? new Integer(redisPort) : new Integer(6379));
		}
		return jedis;
	}

}
