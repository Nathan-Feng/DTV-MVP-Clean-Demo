package com.nathan.arch.domain.interactors.base;

/**
 * <p>
 * This interface represents a basic callback. All calback should implement these common methods.
 * </p>
 */
public interface IDVBBaseInteractorCallback {

    /**
     * This method is used for showing error messages on the UI.
     *
     * @param message The error message to be displayed.
     */
    void showError(String message);
}
