package com.emc.rpsp.fal.commons;

import java.util.HashSet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReplicateVmsParam")
public class ReplicateVmsParam implements Validateable {

    @XmlElement(required = true)
    private String cgName;
    @XmlElement(required = true)
    private GlobalCopyUID productionCopy;
    @XmlElement(required = true)
    private HashSet<VMReplicationSetParam> vmReplicationSets;
    private HashSet<FullConsistencyGroupLinkPolicy> links;
    @XmlElement(required = true)
    private HashSet<ConsistencyGroupCopyParam> copies;
    @XmlElement(required = true)
    private boolean startTransfer;
    
    
    public HashSet<VMReplicationSetParam> getVmReplicationSets()
      {
         if (vmReplicationSets == null) {
           vmReplicationSets = new HashSet<VMReplicationSetParam>();
         }
         return vmReplicationSets;
      }

      public HashSet<FullConsistencyGroupLinkPolicy> getLinks()
       {
         if (links == null) {
           links = new HashSet<FullConsistencyGroupLinkPolicy>();
         }
         return links;
       }

       public HashSet<ConsistencyGroupCopyParam> getCopies()
       {
         if (copies == null) {
           copies = new HashSet<ConsistencyGroupCopyParam>();
         }
         return copies;
       }

}
