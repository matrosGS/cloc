package com.alexm;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Alexey M. on 19.08.2016.
 */
public class Counter implements ICounter {

    @Override
    public int count(List<String> allLines) {
        AtomicInteger amount = new AtomicInteger(0);

        allLines.forEach(
            line -> {
                if (line.trim().matches("(?!//)^(\\} else \\{$)|( \\? )|(^try \\{)")) {
                    amount.incrementAndGet();
                }
                if (line.trim().matches("(?!//)^do \\{")) {
                    amount.incrementAndGet();
                }
                if (line.trim().matches("(?!//)(return .*;|throw new .*|(break|continue);).*")) {
                    amount.incrementAndGet();
                }
                if (line.trim().matches("(?!//)^(?!return|throw new|\\)|\\}\\)).*;$")) {
                    amount.incrementAndGet();
                }
                if (line.trim().matches("((?!//).*[a-zA-Z0-9]+( |)\\(.*\\).*\\{$|.* (class|interface) .*\\{)")) {
                    amount.incrementAndGet();
                }
                if (line.trim().matches("(?!//)(^@[a-zA-Z0-9]+$)")) {
                    amount.incrementAndGet();
                }
                if (line.trim().matches("(?!//)(^.*\\..*\\($)")) {
                    amount.incrementAndGet();
                }
                if (line.trim().matches(".* -> \\{")) {
                    amount.incrementAndGet();
                }
            }
        );

        return amount.get();
    }
}
