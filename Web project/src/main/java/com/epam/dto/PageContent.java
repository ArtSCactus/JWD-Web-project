package com.epam.dto;

import java.util.*;

/**
 * This class designed as container for data, that will be shown at the table on control panel page.
 * <p>
 * By default, it contains an empty {@code ArrayList<>()} of {@code Application} type.
 */
public class PageContent {
    private List<?> objectsList;
    private Map<Object, Object> additionalAttributes;

    public PageContent() {
        objectsList = new ArrayList<>();
        additionalAttributes = new HashMap<>();
    }

    public List<?> getObjectsList() {
        return objectsList;
    }


    public void setContent(List<?> applicationList) {
        this.objectsList = applicationList;
    }

    public void setObjectsList(List<?> objectsList) {
        this.objectsList = objectsList;
    }

    public Map<Object, Object> getAdditionalAttributes() {
        return additionalAttributes;
    }

    public void setAdditionalAttributes(Map<Object, Object> additionalAttributes) {
        this.additionalAttributes = additionalAttributes;
    }

    public void setAttribute(Object key, Object value){
        additionalAttributes.put(key, value);
    }

    public void removeAttribute(Object key){
        additionalAttributes.remove(key);
    }

    public Object getAttribute(Object key){
        return additionalAttributes.get(key);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PageContent)) return false;
        PageContent content = (PageContent) o;
        return Objects.equals(getObjectsList(), content.getObjectsList()) &&
                Objects.equals(getAdditionalAttributes(), content.getAdditionalAttributes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getObjectsList(), getAdditionalAttributes());
    }

    @Override
    public String toString() {
        return "PageContent{" +
                "objectsList=" + objectsList +
                ", additionalAttributes=" + additionalAttributes +
                '}';
    }
}
