package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum SearchImageType {
    ALL("All"),
    ALL_BOOKMARKS("AllBookmarks"),
    SYSTEM_BOOKMARKS("SystemBookmarks"),
    USER_BOOKMARKS("UserBookmarks"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
