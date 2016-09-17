package com.huzaus

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

class FizzBuzzNumberConverterSpec extends Specification {

    @Subject
    def fizzBuzzNumberConverter = new FizzBuzzNumberConverter()

    @Unroll
    def "should transform '#number' to '#result'"() {
        expect:
        fizzBuzzNumberConverter.apply(number) == result
        where:
        number || result
        0      || '0'
        3      || 'fizz'
        5      || 'buzz'
        99     || 'fizz'
        15     || 'fizz buzz'
        55     || 'buzz'
        45     || 'fizz buzz'
    }

    @Unroll
    def "should return as '#result' result of appending append('#source', '#stringToAppend', fizzPredicate)"() {
        expect:
        fizzBuzzNumberConverter.append(source, stringToAppend) == result
        where:
        source | stringToAppend || result
        'fizz' | 'buzz'         || 'fizz buzz'
        null   | 'buzz'         || 'buzz'
        'fizz' | null            | 'fizz'

    }

    @Unroll
    def "isFizz should return '#result' for '#number' input"() {
        expect:
        fizzBuzzNumberConverter.isFizz(number) == result
        where:
        number || result
        0      || false
        1      || false
        2      || false
        3      || true
        21     || true
    }

    @Unroll
    def "isBuzz should return '#result' for '#number' input"() {
        expect:
        fizzBuzzNumberConverter.isBuzz(number) == result
        where:
        number || result
        0      || false
        1      || false
        4      || false
        5      || true
        125    || true
    }

}
