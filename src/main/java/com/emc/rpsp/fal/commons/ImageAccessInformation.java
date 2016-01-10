package com.emc.rpsp.fal.commons;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "ImageAccessInformation")
public class ImageAccessInformation {

    private boolean imageAccessEnabled;
    private ImageAccessParameters imageInformation;
    private String imageName;
    private ImageAccessScenario scenario;

    public ImageAccessInformation() {
    }

    public ImageAccessInformation(boolean imageAccessEnabled, ImageAccessParameters imageInformation, String imageName, ImageAccessScenario scenario) {
        this.imageAccessEnabled = imageAccessEnabled;
        this.imageInformation = imageInformation;
        this.imageName = imageName;
        this.scenario = scenario;
    }

    public boolean getImageAccessEnabled() {
        return imageAccessEnabled;
    }

    public void setImageAccessEnabled(boolean imageAccessEnabled) {
        this.imageAccessEnabled = imageAccessEnabled;
    }

    public ImageAccessParameters getImageInformation() {
        return imageInformation;
    }

    public void setImageInformation(ImageAccessParameters imageInformation) {
        this.imageInformation = imageInformation;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public ImageAccessScenario getScenario() {
        return scenario;
    }

    public void setScenario(ImageAccessScenario scenario) {
        this.scenario = scenario;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((scenario == null) ? 0 : scenario.hashCode());
        result = prime * result + (imageAccessEnabled ? 1231 : 1237);
        result = prime
            * result
            + ((imageInformation == null) ? 0 : imageInformation.hashCode());
        result = prime * result
            + ((imageName == null) ? 0 : imageName.hashCode());
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
        ImageAccessInformation other = (ImageAccessInformation) obj;
        if (scenario != other.scenario)
            return false;
        if (imageAccessEnabled != other.imageAccessEnabled)
            return false;
        if (imageInformation == null) {
            if (other.imageInformation != null)
                return false;
        } else if (!imageInformation.equals(other.imageInformation))
            return false;
        if (imageName == null) {
            if (other.imageName != null)
                return false;
        } else if (!imageName.equals(other.imageName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ImageAccessInformation [imageAccessEnabled=")
            .append(imageAccessEnabled).append(", imageInformation=")
            .append(imageInformation).append(", imageName=")
            .append(imageName).append(", scenario=").append(scenario)
            .append("]");
        return builder.toString();
    }

    public boolean isImageAccessEnabled() {
        return imageAccessEnabled;
    }
}
