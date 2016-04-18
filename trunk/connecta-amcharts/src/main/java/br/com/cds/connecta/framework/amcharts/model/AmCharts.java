package br.com.cds.connecta.framework.amcharts.model;

import java.io.Serializable;
import java.util.List;

public class AmCharts implements Serializable {
    private Boolean baseHref;
    private List<String> dayNames;
    private List<String> monthNames;
    private Double processDelay;
    private List<String> shortDayNames;
    private List<String> shortMonthNames;
    private String theme;
    private Boolean useUTC;

    /**
     * Set it to true if you have base href set for your page. This will fix rendering problems
     * in Firefox caused by base href.
     **/
    public Boolean getBaseHref() {
        return baseHref;
    }
    public AmCharts setBaseHref(boolean baseHref) {
        this.baseHref = baseHref;
        return this;
    }

    /**
     * Array of day names, used when formatting dates (if categoryAxis.parseDates is set
     * to true)
     **/
    public List<String> getDayNames() {
        return dayNames;
    }
    public AmCharts setDayNames(List<String> dayNames) {
        this.dayNames = dayNames;
        return this;
    }

    /**
     * Array of month names, used when formatting dates (if categoryAxis.parseDates is set
     * to true)
     **/
    public List<String> getMonthNames() {
        return monthNames;
    }
    public AmCharts setMonthNames(List<String> monthNames) {
        this.monthNames = monthNames;
        return this;
    }

    /**
     * Delay in ms at which each chart on the page should be rendered. This is very handy
     * if you have a lot of charts on the page and do not want to overload the device CPU.
     **/
    public Double getProcessDelay() {
        return processDelay;
    }
    public AmCharts setProcessDelay(double processDelay) {
        this.processDelay = processDelay;
        return this;
    }

    /**
     * Array of short versions of day names, used when formatting dates (if categoryAxis.parseDates
     * is set to true)
     **/
    public List<String> getShortDayNames() {
        return shortDayNames;
    }
    public AmCharts setShortDayNames(List<String> shortDayNames) {
        this.shortDayNames = shortDayNames;
        return this;
    }

    /**
     * Array of short versions of month names, used when formatting dates (if categoryAxis.parseDates
     * is set to true)
     **/
    public List<String> getShortMonthNames() {
        return shortMonthNames;
    }
    public AmCharts setShortMonthNames(List<String> shortMonthNames) {
        this.shortMonthNames = shortMonthNames;
        return this;
    }

    /**
     * You can set theme for all the charts on your page by setting: AmCharts.theme = AmCharts.themes.light;
     * // or some other theme. If you are creating charts using JavaScript API, not JSON,
     * then this is quite a comfortable way, as you won't need to pass theme to each object
     * you create. Note, you should set theme before write method is called. There is no
     * way to change theme of already created chart, you have to create chart's instance
     * once more if you want to change theme.
     **/
    public String getTheme() {
        return theme;
    }
    public AmCharts setTheme(String theme) {
        this.theme = theme;
        return this;
    }

    /**
     * Set it to true if you want UTC time to be used instead of local time.
     **/
    public Boolean getUseUTC() {
        return useUTC;
    }
    public AmCharts setUseUTC(boolean useUTC) {
        this.useUTC = useUTC;
        return this;
    }


}