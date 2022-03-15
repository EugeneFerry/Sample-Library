package com.sample.library.business;

/**
 * The interface Command.
 *
 * @param <R>  the type parameter
 * @param <P>  the type parameter
 */
public interface ICommand <R, P> {

    // ===========================================
    // Constants
    // ===========================================

    // ===========================================
    // Methods
    // ===========================================

    /**
     * Execute r.
     *
     * @param param the param
     * @return the r
     */
    R execute(final P param);
}
