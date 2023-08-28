package org.gridnine.testing;

/**
 * Предоставляет метод, проверяющий соответствие перелета заданным условиям.
 * Если условия выполнены - возвращает true, иначе - false
 */
public interface FlightFilter {

    boolean Filter(Flight flight);
}
