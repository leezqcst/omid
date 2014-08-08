package com.yahoo.omid.metrics;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Named;
import javax.inject.Singleton;

import com.google.inject.Inject;

@Singleton
public class CodahaleMetricsConfig extends AbstractMetricsConfig {

    public enum Reporter {
        CSV, SLF4J, GRAPHITE, CONSOLE
    }

    private static final String DEFAULT_PREFIX = "omid";
    private static final String DEFAULT_GRAPHITE_HOST_CONFIG = "localhost:2003";
    private static final String DEFAULT_CSV_DIR = ".";
    private static final String DEFAULT_SLF4J_LOGGER = "metrics";

    private static final String METRICS_CODAHALE_PREFIX_KEY = "metrics.codahale.prefix";
    private static final String METRICS_CODAHALE_REPORTERS_KEY = "metrics.codahale.reporters";
    private static final String METRICS_CODAHALE_GRAPHITE_HOST_CONFIG = "metrics.codahale.graphite.host.config";
    private static final String METRICS_CODAHALE_CSV_DIR = "metrics.codahale.cvs.dir";
    private static final String METRICS_CODAHALE_SLF4J_LOGGER = "metrics.codahale.slf4j.logger";

    private String prefix = DEFAULT_PREFIX;
    private Set<Reporter> reporters = new HashSet<Reporter>();
    private String graphiteHostConfig = DEFAULT_GRAPHITE_HOST_CONFIG;
    private String csvDir = DEFAULT_CSV_DIR;
    private String slf4jLogger = DEFAULT_SLF4J_LOGGER;

    public String getPrefix() {
        return prefix;
    }

    @Inject(optional = true)
    public void setPrefix(@Named(METRICS_CODAHALE_PREFIX_KEY) String prefix) {
        this.prefix = prefix;
    }

    public Set<Reporter> getReporters() {
        return reporters;
    }

    @Inject(optional = true)
    public void setReporters(@Named(METRICS_CODAHALE_REPORTERS_KEY) Set<Reporter> reporters) {
        this.reporters = reporters;
    }

    public void addReporter(Reporter reporter) {
        reporters.add(reporter);
    }

    public String getGraphiteHostConfig() {
        return graphiteHostConfig;
    }

    @Inject(optional = true)
    public void setGraphiteHostConfig(@Named(METRICS_CODAHALE_GRAPHITE_HOST_CONFIG) String graphiteHostConfig) {
        this.graphiteHostConfig = graphiteHostConfig;
    }

    public String getCSVDir() {
        return csvDir;
    }

    @Inject(optional = true)
    public void setCSVDir(@Named(METRICS_CODAHALE_CSV_DIR) String csvDir) {
        this.csvDir = csvDir;
    }

    public String getSlf4jLogger() {
        return slf4jLogger;
    }

    @Inject(optional = true)
    public void setSlf4jLogger(@Named(METRICS_CODAHALE_SLF4J_LOGGER) String slf4jLogger) {
        this.slf4jLogger = slf4jLogger;
    }

}