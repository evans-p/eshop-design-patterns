package gr.evansp.setup.product.impl.ws.models;

import gr.evansp.constants.StringConstants;
import gr.evansp.setup.product.def.ws.models.CharacteristicDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CharacteristicDTOImpl implements CharacteristicDTO {
    private String name = StringConstants.EMPTY;
    private String value = StringConstants.EMPTY;
}
