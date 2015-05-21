package br.com.connecta.framework.amcharts.provider;

import br.com.cds.connecta.framework.amcharts.provider.ChartProvider;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Vinicius Pires <vinicius.pires@cds.com.br>
 */
public class ChartProviderTest {
    private final ChartProvider provider = new ChartProvider();
    
    @Test
    @Ignore
    public void providerListsTemplateTypes() {
        assertThat(provider.listTemplateTypes(), hasSize(12));
    }
    
    
}
