package com.nathan.arch.presentation.presenters.base;


import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * Use for listening APP Lift Cycle,and then control DVB resources
 */
public interface IDVBMainLifeCycle extends LifecycleObserver {
    /**
     *  for AndroicX lifeCycle
     * ON_ANY will be called when the LifeCycle changed .such as onCreate->onStart
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void onAny(LifecycleOwner owner);

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onCreate() method.
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate(LifecycleOwner owner);

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onStart() method.
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStart(LifecycleOwner owner);

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onStop() method.
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop(LifecycleOwner owner);

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onResume() method.
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume(LifecycleOwner owner);


    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause(LifecycleOwner owner);


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestory(LifecycleOwner owner);

}
