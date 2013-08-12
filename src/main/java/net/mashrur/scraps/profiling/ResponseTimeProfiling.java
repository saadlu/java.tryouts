package net.mashrur.scraps.profiling;

import gnu.trove.list.array.TIntArrayList;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: saad
 * Date: 8/11/13
 * Time: 3:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class ResponseTimeProfiling {

    private static final Logger LOGGER = LogManager.getLogger(ResponseTimeProfiling.class.getName());

    public static void main(String args[]) {
//        singleDimensionMeasures(96);
//        singleDimensionMeasures(384);
//        singleDimensionMeasures(1536);
        singleDimensionMeasures(5000);
    }

    public static void singleDimensionPrimitives(int size) {
        TIntArrayList collection = new TIntArrayList();
        for (int i = 0; i < size; ++i) {
            collection.add((int) (Math.random() * 100));
        }

        for (int i = 0; i < size; ++i) {
            collection.get((int) (Math.random() * size));
        }

        collection.clear();
        collection.trimToSize();

    }

    public static void singleDimensionGenerics(int size) {
        List<Integer> collection = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            collection.add((int) (Math.random() * 100));
        }

        for (int i = 0; i < size; ++i) {
            collection.get((int) (Math.random() * size));
        }

        collection.clear();


    }

    public static void singleDimensionMeasures(int size) {


        SummaryStatistics summaryStatisticsGenerics = new SummaryStatistics();
        SummaryStatistics summaryStatisticsPrimitives = new SummaryStatistics();

        List<Long> generics = new ArrayList<>();
        List<Long> primitives = new ArrayList<>();

        for (int i = 0; i <= 10; ++i) {

            CPUTimeProfiler.startCPUTimer();
            singleDimensionGenerics(size);
            long elapsedTimeGenerics = CPUTimeProfiler.getElapsedTime();

            CPUTimeProfiler.startCPUTimer();
            singleDimensionPrimitives(size);
            long elapsedTimePrimitives = CPUTimeProfiler.getElapsedTime();

            if (i != 0) {
                LOGGER.debug("Elapsed time generics: " + elapsedTimeGenerics + " elapsed time primitives: " + elapsedTimePrimitives);
                generics.add(elapsedTimeGenerics);
                primitives.add(elapsedTimePrimitives);


            }
        }

        LOGGER.debug("Generics Max Min : \t" + Collections.max(generics) + "\t" + Collections.min(generics));
        LOGGER.debug("Primitive Max Min : \t" + Collections.max(primitives) + "\t" + Collections.min(primitives));
    }


}
