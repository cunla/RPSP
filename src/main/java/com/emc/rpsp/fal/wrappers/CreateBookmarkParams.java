package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.BookmarkConsolidationPolicy;
import com.emc.rpsp.fal.commons.ConsistencyGroupUID;
import com.emc.rpsp.fal.commons.SnapshotConsistencyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;


@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class CreateBookmarkParams {
    private HashSet<ConsistencyGroupUID> groups;
    private String bookmarkName;
    private BookmarkConsolidationPolicy consolidationPolicy;
    private SnapshotConsistencyType consistencyType;

}
