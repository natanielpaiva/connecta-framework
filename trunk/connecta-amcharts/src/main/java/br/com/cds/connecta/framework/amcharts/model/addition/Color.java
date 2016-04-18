package br.com.cds.connecta.framework.amcharts.model.addition;

import br.com.cds.connecta.framework.amcharts.model.serializer.ColorSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;

@JsonSerialize(using = ColorSerializer.class)
public class Color implements Serializable {

    public static final Color BLACK = create("000000");
    public static final Color WHITE = create("FFFFFF");

    private String colorHexVal;

    private Color() {
    }

    private Color(String colorHexVal) {
        this.colorHexVal = colorHexVal;
    }

    public static Color create(String colorHexVal) {
        return new Color(colorHexVal);
    }

    // Append # to color values as we have hex values
    @Override
    public String toString() {
        return this.colorHexVal;
    }
}
