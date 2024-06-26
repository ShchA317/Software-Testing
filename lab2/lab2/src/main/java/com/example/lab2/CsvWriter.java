package com.example.lab2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;

public class CsvWriter {

    public static void write(
            final String filename,
            final Function<BigDecimal, BigDecimal> function,
            final BigDecimal from,
            final BigDecimal to,
            final BigDecimal step)
            throws IOException {
        final Path path = Paths.get(filename);
        final File file = new File(path.toUri());
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        final PrintWriter printWriter = new PrintWriter(file);
        for (BigDecimal current = from; current.compareTo(to) <= 0; current = current.add(step)) {
            printWriter.println(current + "," + function.apply(current));
        }
        printWriter.close();
    }

}
