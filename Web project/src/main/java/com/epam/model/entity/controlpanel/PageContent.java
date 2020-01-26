package com.epam.model.entity.controlpanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class designed as container for data, that will be shown at the table on control panel page.
 * <p>
 * By default, it contains an empty {@code ArrayList<>()} of {@code Application} type.
 *
 */
public class PageContent {
    private List<?> objectsList;
    private PageContentType type;

    public PageContent() {
        objectsList = new ArrayList<>();
        type = PageContentType.APPLICATIONS;
    }

    public List<?> getObjectsList() {
        return objectsList;
    }

    public PageContentType getType() {
        return type;
    }

    public void setType(PageContentType type) {
        this.type = type;
    }

    public void setContent(List<?> applicationList) {
        this.objectsList = applicationList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PageContent)) return false;
        PageContent that = (PageContent) o;
        return Objects.equals(getObjectsList(), that.getObjectsList()) &&
                getType() == that.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getObjectsList(), getType());
    }

    @Override
    public String toString() {
        return "PageContent{" +
                "applicationList=" + objectsList +
                ", type=" + type +
                '}';
    }
}
