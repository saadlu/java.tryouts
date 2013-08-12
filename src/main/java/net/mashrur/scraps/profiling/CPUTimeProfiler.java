package net.mashrur.scraps.profiling;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * Created with IntelliJ IDEA.
 * User: saad
 * Date: 8/11/13
 * Time: 3:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class CPUTimeProfiler {

    public static long startTime;
    private static ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

    public static void startCPUTimer() {

        if (threadMXBean.isCurrentThreadCpuTimeSupported()) {
            startTime = threadMXBean.getCurrentThreadCpuTime();

        }
    }

    public static long getElapsedTime() {
        return threadMXBean.getCurrentThreadCpuTime() - startTime;
    }
}
