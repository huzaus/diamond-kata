package com.huzaus

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class DiamondSpec extends Specification {

    def "should reject '#symbol'"() {
        when:
        Diamond.apply(symbol as char)
        then:
        thrown IllegalArgumentException
        where:
        symbol << [' ', '5', '-', '$', 'a', 64, 91]
    }

    def "Diamond.lineOf('#symbol') == '#line' "() {
        expect:
        Diamond.lineOf(symbol as char) == line
        where:
        symbol || line
        'A'    || 'A'
        'B'    || 'B B'
        'C'    || 'C   C'
        'F'    || 'F         F'
    }

    def "Diamond.withIndent('#line' , '#indent') == '#result' "() {
        expect:
        Diamond.withIndent(line, indent as char) == result
        where:
        line  | indent || result
        'A'   | 0      || 'A'
        'A'   | 1      || ' A '
        'B B' | 3      || '   B B   '
    }

    def "Diamond.apply('#symbol') == '#diamond'"() {
        expect:
        Diamond.apply(symbol as char) == diamond
        where:
        symbol || diamond
        'A'    || 'A'
        'B'    || ' A \nB B\n A '
        'C'    || '  A  \n B B \nC   C\n B B \n  A  '
    }
}
