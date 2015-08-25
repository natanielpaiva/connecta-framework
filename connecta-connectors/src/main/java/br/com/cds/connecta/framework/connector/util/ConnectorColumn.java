package br.com.cds.connecta.framework.connector.util;

import java.math.BigDecimal;

/**
 *
 * @author diego
 */
public class ConnectorColumn {
    
    private Long id;

    private String formula;

    private String label;

    private String name;

    private BigDecimal type;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getType() {
        return type;
    }

    public void setType(BigDecimal type) {
        this.type = type;
    }
    
}
