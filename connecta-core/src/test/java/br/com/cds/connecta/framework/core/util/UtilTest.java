package br.com.cds.connecta.framework.core.util;

import static br.com.cds.connecta.framework.core.util.Util.prepareForSearch;
import static org.junit.Assert.assertThat;
import static br.com.cds.connecta.framework.core.util.Util.removeSpecialCharacters;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

/**
 *
 * @author Vinicius Pires <vinicius.pires@cds.com.br>
 */
public class UtilTest {
    
    @Test
    public void testRemoveSpecialCharacters() {
        assertThat(
            removeSpecialCharacters("Lá vai a Chalana"),
            equalTo("La vai a Chalana")
        );
        assertThat(
            removeSpecialCharacters("âàãáäÁÂÀÃÄéèêẽëÉÈÊẼËíìîĩïÍÌÎĨÏóòôõöÓÒÔÕÖúùûũüÚÙÛŨÜÇç"),
            equalTo("aaaaaAAAAAeeeeeEEEEEiiiiiIIIIIoooooOOOOOuuuuuUUUUUCc")
        );
    }
    
    @Test
    public void testPrepareForSearch() {
        assertThat(
            prepareForSearch("   Lá vai a Chalana  ", false),
            equalTo("LA VAI A CHALANA")
        );
        assertThat(
            prepareForSearch("   Lá vai a Chalana  ", true),
            equalTo("%LA VAI A CHALANA%")
        );
        assertThat(
            prepareForSearch("     âàãáäÁÂÀÃÄéèêẽëÉÈÊẼËíìîĩïÍÌÎĨÏóòôõöÓÒÔÕÖúùûũüÚÙÛŨÜÇç  ", false),
            equalTo("AAAAAAAAAAEEEEEEEEEEIIIIIIIIIIOOOOOOOOOOUUUUUUUUUUCC")
        );
    }
    
}