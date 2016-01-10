package com.emc.rpsp.fal.commons;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@Data
// this CTOR should NOT be used! (due to UIDs cache)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@XmlRootElement
@XmlType(name = "CredentialsUID")
public class CredentialsUID implements Validateable {

    private long id;

    //This member handles all CredUID objects retrieval\creation
//    private static ObjectsGenerator<CredentialsUID> credentialsUIDgenerator = new ObjectsGenerator<CredentialsUID>();

    public static CredentialsUID generateCredentialsUID(long id) {
        return (new CredentialsUID(id));
    }

}
