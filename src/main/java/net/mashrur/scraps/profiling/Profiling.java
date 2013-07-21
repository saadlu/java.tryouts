package net.mashrur.scraps.profiling;


import org.apache.commons.math3.stat.StatUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Profiling {

    private static final Logger LOGGER = LogManager.getLogger("Profiling");

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        reportMemory(runtime);

        long totalMemoryLast = runtime.totalMemory();
        long freeMemoryLast = runtime.freeMemory();


        byte[] space = new byte[1 * 1048576];

        long amountUsed = (runtime.totalMemory() - runtime.freeMemory()) - (totalMemoryLast - freeMemoryLast);

        reportMemory(runtime);

        LOGGER.debug(getFormattedMemoryInfo("Amount Used", amountUsed));

        LOGGER.debug("Mean: " + StatUtils.mean(new double[]{2.0, 3.0, 4.0}));

    }

    private static void reportMemory(Runtime runtime) {
        LOGGER.debug(getFormattedMemoryInfo("Total memory", runtime.totalMemory()));
        LOGGER.debug(getFormattedMemoryInfo("Max memory", runtime.maxMemory()));
        LOGGER.debug(getFormattedMemoryInfo("Free memory", runtime.freeMemory()));
    }

    public static String getFormattedMemoryInfo(String text, long memoryAmount) {
        return String.format("%-15s %10.2f M", text, memoryAmount / Math.pow(2, 20));
    }
}
