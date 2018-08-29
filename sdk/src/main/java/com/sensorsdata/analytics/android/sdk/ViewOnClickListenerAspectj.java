package com.sensorsdata.analytics.android.sdk;


import android.content.DialogInterface;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@SuppressWarnings("unused")
public class ViewOnClickListenerAspectj {
    /**
     * android.view.View.OnClickListener.onClick(android.view.View)
     *
     * @param joinPoint JoinPoint
     */
    @After("execution(* android.view.View.OnClickListener.onClick(android.view.View))")
    public void onViewClickAOP(final JoinPoint joinPoint) {
        View view = (View) joinPoint.getArgs()[0];
        SensorsDataPrivate.trackViewOnClick(view);
    }

    /**
     * 支持 ButterKnife @OnClick 注解
     *
     * @param joinPoint JoinPoint
     */
    @After("execution(@butterknife.OnClick * *(android.view.View))")
    public void onButterknifeClickAOP(final JoinPoint joinPoint) {
        View view = (View) joinPoint.getArgs()[0];
        SensorsDataPrivate.trackViewOnClick(view);
    }

    /**
     * 支持 @SensorsDataTrackViewOnClick 注解
     *
     * @param joinPoint JoinPoint
     */
    @After("execution(@com.sensorsdata.analytics.android.sdk.SensorsDataTrackViewOnClick * *(android.view.View))")
    public void onTrackViewOnClickAOP(final JoinPoint joinPoint) {
        View view = (View) joinPoint.getArgs()[0];
        SensorsDataPrivate.trackViewOnClick(view);
    }

    /**
     * 支持 onOptionsItemSelected(android.view.MenuItem)
     *
     * @param joinPoint JoinPoint
     */
    @After("execution(* android.app.Activity.onOptionsItemSelected(android.view.MenuItem))")
    public void onOptionsItemSelectedAOP(JoinPoint joinPoint) {
        MenuItem view = (MenuItem) joinPoint.getArgs()[0];
        SensorsDataPrivate.trackViewOnClick(joinPoint.getTarget(), view);
    }

    /**
     * 支持 onContextItemSelected(android.view.MenuItem)
     *
     * @param joinPoint JoinPoint
     */
    @After("execution(* android.app.Activity.onContextItemSelected(android.view.MenuItem))")
    public void onContextItemSelectedAOP(JoinPoint joinPoint) {
        MenuItem view = (MenuItem) joinPoint.getArgs()[0];
        SensorsDataPrivate.trackViewOnClick(joinPoint.getTarget(), view);
    }

    /**
     * 支持 onMenuItemSelected(int, android.view.MenuItem)
     *
     * @param joinPoint JoinPoint
     */
    @After("execution(* android.app.Activity.onMenuItemSelected(int, android.view.MenuItem))")
    public void onMenuItemSelectedAOP(JoinPoint joinPoint) {
        MenuItem view = (MenuItem) joinPoint.getArgs()[1];
        SensorsDataPrivate.trackViewOnClick(joinPoint.getTarget(), view);
    }

    /**
     * 支持 DialogInterface.OnClickListener.onClick(android.content.DialogInterface, int)
     *
     * @param joinPoint JoinPoint
     */
    @After("execution(* android.content.DialogInterface.OnClickListener.onClick(android.content.DialogInterface, int))")
    public void onDialogClickAOP(final JoinPoint joinPoint) {
        DialogInterface dialogInterface = (DialogInterface) joinPoint.getArgs()[0];
        int which = (int) joinPoint.getArgs()[1];
        SensorsDataPrivate.trackViewOnClick(dialogInterface, which);
    }

    /**
     * 支持 DialogInterface.OnMultiChoiceClickListener.onClick(android.content.DialogInterface, int, boolean)
     *
     * @param joinPoint JoinPoint
     */
    @After("execution(* android.content.DialogInterface.OnMultiChoiceClickListener.onClick(android.content.DialogInterface, int, boolean))")
    public void onDialogMultiChoiceClickAOP(final JoinPoint joinPoint) {
        DialogInterface dialogInterface = (DialogInterface) joinPoint.getArgs()[0];
        int which = (int) joinPoint.getArgs()[1];
        boolean isChecked = (boolean) joinPoint.getArgs()[2];
        SensorsDataPrivate.trackViewOnClick(dialogInterface, which, isChecked);
    }

    /**
     * 支持 CompoundButton.OnCheckedChangeListener.onCheckedChanged(android.widget.CompoundButton,boolean)
     *
     * @param joinPoint JoinPoint
     */
    @After("execution(* android.widget.CompoundButton.OnCheckedChangeListener.onCheckedChanged(android.widget.CompoundButton,boolean))")
    public void onCheckedChangedAOP(final JoinPoint joinPoint) {
        CompoundButton compoundButton = (CompoundButton) joinPoint.getArgs()[0];
        boolean isChecked = (boolean) joinPoint.getArgs()[1];
        SensorsDataPrivate.trackViewOnClick(compoundButton, isChecked);
    }

    /**
     * 支持 RatingBar.OnRatingBarChangeListener.onRatingChanged(android.widget.RatingBar,float,boolean)
     * @param joinPoint JoinPoint
     */
    @After("execution(* android.widget.RatingBar.OnRatingBarChangeListener.onRatingChanged(android.widget.RatingBar,float,boolean))")
    public void onRatingBarChangedAOP(final JoinPoint joinPoint) {
        View view = (View) joinPoint.getArgs()[0];
        SensorsDataPrivate.trackViewOnClick(view);
    }


    /**
     * 支持 SeekBar.OnSeekBarChangeListener.onStopTrackingTouch(android.widget.SeekBar)
     * @param joinPoint JoinPoint
     */
    @After("execution(* android.widget.SeekBar.OnSeekBarChangeListener.onStopTrackingTouch(android.widget.SeekBar))")
    public void onStopTrackingTouchMethod(JoinPoint joinPoint) {
        View view = (View) joinPoint.getArgs()[0];
        SensorsDataPrivate.trackViewOnClick(view);
    }

    /**
     * 支持 AdapterView.OnItemSelectedListener.onItemSelected(android.widget.AdapterView,android.view.View,int,long)
     * @param joinPoint JoinPoint
     */
    @After("execution(* android.widget.AdapterView.OnItemSelectedListener.onItemSelected(android.widget.AdapterView,android.view.View,int,long))")
    public void onItemSelectedAOP(final JoinPoint joinPoint) {
        android.widget.AdapterView adapterView = (android.widget.AdapterView) joinPoint.getArgs()[0];
        View view = (View) joinPoint.getArgs()[1];
        int position = (int) joinPoint.getArgs()[2];
        SensorsDataPrivate.trackViewOnClick(adapterView, view, position);
    }

    /**
     * 支持 AdapterView.OnItemClickListener.onItemClick(android.widget.AdapterView,android.view.View,int,long)
     * @param joinPoint JoinPoint
     */
    @After("execution(* android.widget.AdapterView.OnItemClickListener.onItemClick(android.widget.AdapterView,android.view.View,int,long))")
    public void onAdapterViewItemClickAOP(final JoinPoint joinPoint) {
        android.widget.AdapterView adapterView = (android.widget.AdapterView) joinPoint.getArgs()[0];
        View view = (View) joinPoint.getArgs()[1];
        int position = (int) joinPoint.getArgs()[2];
        SensorsDataPrivate.trackViewOnClick(adapterView, view, position);
    }

    /**
     * 支持 TabHost.OnTabChangeListener.onTabChanged(String)
     * @param joinPoint JoinPoint
     */
    @After("execution(* android.widget.TabHost.OnTabChangeListener.onTabChanged(String))")
    public void onTabChangedAOP(final JoinPoint joinPoint) {
        String tabName = (String) joinPoint.getArgs()[0];
        SensorsDataPrivate.trackTabHost(tabName);
    }

    /**
     * public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id)
     *
     * @param joinPoint JoinPoint
     */
    @After("execution(* android.widget.ExpandableListView.OnChildClickListener.onChildClick(android.widget.ExpandableListView, android.view.View, int, int, long))")
    public void onExpandableListViewChildClickAOP(final JoinPoint joinPoint) {
        ExpandableListView expandableListView = (ExpandableListView) joinPoint.getArgs()[0];
        View view = (View) joinPoint.getArgs()[1];
        int groupPosition = (int) joinPoint.getArgs()[2];
        int childPosition = (int) joinPoint.getArgs()[3];
        SensorsDataPrivate.trackExpandableListViewChildOnClick(expandableListView, view, groupPosition, childPosition);
    }

    /**
     * public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long l)
     *
     * @param joinPoint JoinPoint
     */
    @After("execution(* android.widget.ExpandableListView.OnGroupClickListener.onGroupClick(android.widget.ExpandableListView, android.view.View, int, long))")
    public void onExpandableListViewGroupClickAOP(final JoinPoint joinPoint) {
        ExpandableListView expandableListView = (ExpandableListView) joinPoint.getArgs()[0];
        View view = (View) joinPoint.getArgs()[1];
        int groupPosition = (int) joinPoint.getArgs()[2];
        SensorsDataPrivate.trackExpandableListViewChildOnClick(expandableListView, view, groupPosition, -1);
    }
}
