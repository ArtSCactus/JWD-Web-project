package com.epam.model.dto.entity;

/**
 * @author ArtSCactus
 * @version 1.0
 */
public enum StudentStatus{
    ENROLLED("enrolled"), DISMISSED("dismissed");

    StudentStatus(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }


    /**
     * Returns the name of this enum constant, as contained in the
     * declaration.  This method may be overridden, though it typically
     * isn't necessary or desirable.  An enum type should override this
     * method when a more "programmer-friendly" string form exists.
     *
     * @return the name of this enum constant
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
