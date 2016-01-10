package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.RpaUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;


@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class AddConsistencyGroupWithDefaultPolicyParams {

    private String groupName;
    private RpaUID primaryRPA;

}
