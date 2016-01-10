package com.emc.rpsp.fal.commons;

import org.codehaus.jackson.annotate.JsonTypeName;

import javax.xml.bind.annotation.*;

@SuppressWarnings("serial")
@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeName("ImageAccessQueryParameters")
@XmlType(name = "ImageAccessQueryParameters")
public class ImageAccessQueryParameters extends ImageAccessGeneralParameters {

    @XmlElement(required = true)
    private ImageAccessParameters params;

    public ImageAccessQueryParameters() {
    }

    public ImageAccessQueryParameters(ImageAccessScenario scenario, ImageAccessTargetVirtualNetworkParam targetNetwork, ImageAccessParameters params) {
        super(scenario, targetNetwork);
        this.params = params;
    }

    public ImageAccessParameters getParams() {
        return params;
    }

    public void setParams(ImageAccessParameters params) {
        this.params = params;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((params == null) ? 0 : params.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ImageAccessQueryParameters other = (ImageAccessQueryParameters) obj;
        if (params == null) {
            if (other.params != null)
                return false;
        } else if (!params.equals(other.params))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ImageAccessQueryParameters [params=").append(params)
            .append(", super=").append(super.toString()).append("]");
        return builder.toString();
    }
}
