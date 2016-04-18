/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cds.connecta.framework.connector.database.service;

/**
 *
 * @author diego
 */
public class ColumnImp implements IDatabaseColumn{
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private String dataType;
    private Integer dataPrecision;
    private IDatabaseForeignKeyColumn foreignKey;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Override
    public Integer getDataPrecision() {
        return dataPrecision;
    }

    public void setDataPrecision(Integer dataPrecision) {
        this.dataPrecision = dataPrecision;
    }

    public IDatabaseForeignKeyColumn getForeignKey() {
        return foreignKey;
    }

    public void setForeignKey(IDatabaseForeignKeyColumn foreignKey) {
        this.foreignKey = foreignKey;
    }
    
}
