package com.emc.rpsp.fal.wrappers;

import com.emc.rpsp.fal.commons.BookmarkConsolidationPolicy;
import com.emc.rpsp.fal.commons.ConsistencyGroupSetSubset;
import com.emc.rpsp.fal.commons.SnapshotConsistencyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;


@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class CreateBookmarkForGroupSetSubSetParams {
    private ConsistencyGroupSetSubset groupSetSubset;
    private String bookmarkName;
    private BookmarkConsolidationPolicy consolidationPolicy;
    private SnapshotConsistencyType consistencyType;
}
