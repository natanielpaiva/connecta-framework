package br.com.cds.connecta.framework.core.persistence.jdbc.common.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;
import org.springframework.stereotype.Repository;

import br.com.cds.connecta.framework.core.exception.PersistenceException;

/**
 *
 * @author Ryan Achilles de Thuin
 * @version 0.1
 */

@Repository
@Configuration
public abstract class AbstractBaseJdbcDAO  {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private OracleSequenceMaxValueIncrementer oracleSequenceMaxValueIncrementer;

    private String sequenceName;

    private final String dateFormat = "yyyy-MM-dd kk:mm:s.S";

    private final String twitterDateFormat = "yyyy-MM-dd kk:mm:s";

    protected String getDateFormatWithMS() {
        return dateFormat;
    }

    protected String getDateFormat() {
        return twitterDateFormat;
    }

    public void setDataSource(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
                dataSource);
    }

    public void setSequenceName(final String sequenceName) {
        this.sequenceName = sequenceName;
        this.oracleSequenceMaxValueIncrementer = new OracleSequenceMaxValueIncrementer(
                this.getJdbcTemplate().getDataSource(), this.sequenceName);
    }

    public abstract void configureSequenceName();

    protected JdbcTemplate getJdbcTemplate() {
        return (JdbcTemplate) this.namedParameterJdbcTemplate
                .getJdbcOperations();
    }

    protected NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return this.namedParameterJdbcTemplate;
    }

    public int getNextKey() {
        configureSequenceName();
        return this.oracleSequenceMaxValueIncrementer.nextIntValue();
    }

    protected void commit() {
        try {
            getJdbcTemplate().getDataSource().getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Save, update e delete
     * @param sql
     * @return 
     */
    public int executeQuery(String sql) {
        try {
            return getJdbcTemplate().update(sql);

        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    /**
     * Save, update e delete
     * @param sql
     * @param params
     * @return 
     */
    public int executeQuery(String sql, Object...params) {
        try {
            return getJdbcTemplate().update(sql, params);

        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }
   

    public Map<String, Object> queryForMap(String sql, Object[] params) {
        try {
            return getJdbcTemplate().queryForMap(sql, params);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    public List<Map<String, Object>> queryForList(String sql) {
        try {

            return getJdbcTemplate().queryForList(sql.toString());
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    public List<Map<String, Object>> queryForList(String sql, Object[] params) {
        try {

            return getJdbcTemplate().queryForList(sql.toString(), params);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }
    
     
    public <T> List<T> queryForList (String sql, RowMapper<T> mapper, Object... args){
        List<T> list = getJdbcTemplate().query(sql, args, mapper);
        return list;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public Object queryForObject(String sql, Class classe) {
        try {

            return getJdbcTemplate().queryForObject(sql, classe);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public Object queryForObject(String sql, Class classe, Object[] params) {
        try {
            return getJdbcTemplate().queryForObject(sql, params, classe);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    public Object queryForObject(String sql, Object[] params, RowMapper<?> rowMapper) {
        try {
            return getJdbcTemplate().queryForObject(sql, params, rowMapper);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<?> queryForList(String sql, Class classe) {
        try {
            return getJdbcTemplate().queryForList(sql, classe);
        } catch (DataAccessException e) {
            throw new PersistenceException(e);
        }
    }

    /*@SuppressWarnings({ "unchecked", "rawtypes" })
     public  List queryForList(String sql,RowMapper<?> rowMapper,int rowsExpected){
     return this.getJdbcTemplate().query(sql,
     new RowMapperResultSetExtractor(rowMapper, rowsExpected) {
     });
     }*/
    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<?> queryForStringList(String sql, Object[] params) {
        return new ArrayList(this.getJdbcTemplate().query(sql, params,
                new RowMapper() {
                    /*
                     * 
                     * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
                     *      int)
                     */
                    public Object mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                        int i = 1;
                        return rs.getString(i++);

                    }
                }));
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public Set load_StringList(String sql, String params) {
        try {
            return new HashSet(this.getJdbcTemplate().query(sql,
                    new Object[]{new String(params)}, new RowMapper() {
                        /*
                         * 
                         * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
                         *      int)
                         */
                        public Object mapRow(ResultSet rs, int rowNum)
                        throws SQLException {
                            int i = 1;
                            return rs.getString(i++);

                        }
                    }));
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    public String queryForString(String sql) {

        try {
            return (String) this.getJdbcTemplate().queryForObject(sql,
                    String.class);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    public String queryForString(String sql, Object[] params) {

        try {
            return (String) this.getJdbcTemplate().queryForObject(sql, params,
                    String.class);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    public String queryForStringByObject(String sql, Object[] params) {

        try {
            return (String) this.getJdbcTemplate().queryForObject(sql, params, Object.class);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<?> queryForStringList(String sql) {
        return new ArrayList(this.getJdbcTemplate().query(sql,
                new RowMapper() {
                    /*
                     * 
                     * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
                     *      int)
                     */
                    public Object mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                        int i = 1;
                        return rs.getString(i++);

                    }
                }));
    }
    
    public List<Map<String, Object>> getJobResultAndPostId(String query, List<String> listPostId, Long userId){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", userId);
        params.put("listPostId", listPostId);
        return getNamedParameterJdbcTemplate().queryForList(query, params);
    }

}
