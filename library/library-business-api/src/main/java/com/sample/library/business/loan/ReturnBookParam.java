package com.sample.library.business.loan;

/**
 * The type Return book param.
 */
public class ReturnBookParam {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The Load id. */
    private int loadId;

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Return book param.
     *
     * @param loadId the load id
     */
    public ReturnBookParam(final int loadId) {
        super();
        this.loadId = loadId;
    }


    // ===========================================
    // Public Methods
    // ===========================================

    /**
     * Gets load id.
     *
     * @return the load id
     */
    public int getLoadId() {
        return this.loadId;
    }

    /**
     * Sets load id.
     *
     * @param loadId the load id
     */
    public void setLoadId(int loadId) {
        this.loadId = loadId;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return String.format("ReturnBookParam [loadId=%s]", this.loadId);
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
