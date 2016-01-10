package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImageAccessParameters")
public class ImageAccessParameters implements Validateable {

    @XmlElement(required = true)
    private RecoverPointTimeStamp timeStamp;
    @XmlElement(required = true)
    private ImageAccessMode mode;
    private SearchImageType imageType;
    private String searchText;
    private boolean searchExactText;
    private Long maximumSearchRange;
    /*private MountType mountType;*/

    public ImageAccessParameters() {
    }

    public ImageAccessParameters(RecoverPointTimeStamp timeStamp, ImageAccessMode mode, SearchImageType imageType, String searchText,
                                 boolean searchExactText, Long maximumSearchRange, MountType mountType) {
        this.timeStamp = timeStamp;
        this.mode = mode;
        this.imageType = imageType;
        this.searchText = searchText;
        this.searchExactText = searchExactText;
        this.maximumSearchRange = maximumSearchRange;
    }

    public RecoverPointTimeStamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(RecoverPointTimeStamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public ImageAccessMode getMode() {
        return mode;
    }

    public void setMode(ImageAccessMode mode) {
        this.mode = mode;
    }

    public SearchImageType getImageType() {
        return imageType;
    }

    public void setImageType(SearchImageType imageType) {
        this.imageType = imageType;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public boolean getSearchExactText() {
        return searchExactText;
    }

    public void setSearchExactText(boolean searchExactText) {
        this.searchExactText = searchExactText;
    }

    public Long getMaximumSearchRange() {
        return maximumSearchRange;
    }

    public void setMaximumSearchRange(Long maximumSearchRange) {
        this.maximumSearchRange = maximumSearchRange;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ImageAccessParameters [timeStamp=").append(timeStamp)
            .append(", mode=").append(mode).append(", imageType=")
            .append(imageType).append(", searchText=").append(searchText)
            .append(", searchExactText=").append(searchExactText)
            .append(", maximumSearchRange=").append(maximumSearchRange)
            .append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((imageType == null) ? 0 : imageType.hashCode());
        result = prime
            * result
            + ((maximumSearchRange == null) ? 0 : maximumSearchRange
            .hashCode());
        result = prime * result + ((mode == null) ? 0 : mode.hashCode());
        result = prime * result + (searchExactText ? 1231 : 1237);
        result = prime * result
            + ((searchText == null) ? 0 : searchText.hashCode());
        result = prime * result
            + ((timeStamp == null) ? 0 : timeStamp.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ImageAccessParameters other = (ImageAccessParameters) obj;
        if (imageType != other.imageType)
            return false;
        if (maximumSearchRange == null) {
            if (other.maximumSearchRange != null)
                return false;
        } else if (!maximumSearchRange.equals(other.maximumSearchRange))
            return false;
        if (mode != other.mode)
            return false;
        if (searchExactText != other.searchExactText)
            return false;
        if (searchText == null) {
            if (other.searchText != null)
                return false;
        } else if (!searchText.equals(other.searchText))
            return false;
        if (timeStamp == null) {
            if (other.timeStamp != null)
                return false;
        } else if (!timeStamp.equals(other.timeStamp))
            return false;
        return true;
    }


}
