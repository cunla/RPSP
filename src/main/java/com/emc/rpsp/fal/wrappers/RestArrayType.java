package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.ArrayType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@NoArgsConstructor
@Data
public class RestArrayType {
    private ArrayType restEnum;

    public RestArrayType(ArrayType restEnum) {
        this.restEnum = restEnum;
    }
}
