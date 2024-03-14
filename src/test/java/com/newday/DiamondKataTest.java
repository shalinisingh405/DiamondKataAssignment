package com.newday;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiamondKataTest {

/*    @Test
    void should_print_diamond_for_letter_a() {
        assertEquals(List.of("A"), DiamondKata.printDiamond('A'));
    }

    @Test
    void should_print_half_diamond_for_letter_b() {
        assertEquals(List.of("-A-", "B-B"), DiamondKata.printDiamond('B'));
    }

    @Test
    void should_print_half_diamond_for_letter_c() {
        assertEquals(List.of("--A--", "-B-B-", "C---C"), DiamondKata.printDiamond('C'));
    }*/

    @Test
    void should_calculate_correct_outer_dashes_from_diamond_letter() {

        char currentLetter = 'C';
        char diamondLetter = 'D';

        assertEquals(1, DiamondKata.calculateOuterSpace(diamondLetter, currentLetter));

        diamondLetter++;
        //E,C
        assertEquals(2, DiamondKata.calculateOuterSpace(diamondLetter, currentLetter));

        currentLetter--;
        //E,B
        assertEquals(3, DiamondKata.calculateOuterSpace(diamondLetter, currentLetter));

    }

    @Test
    void should_calculate_correct_inner_dashes_from_diamond_letter() {

        char currentLetter = 'C';

        assertEquals(3, DiamondKata.calculateMiddleSpace(currentLetter));

        currentLetter++;
        //D
        assertEquals(5, DiamondKata.calculateMiddleSpace(currentLetter));

        currentLetter--;
        //C
        assertEquals(3, DiamondKata.calculateMiddleSpace(currentLetter));

        currentLetter--;
        //B
        assertEquals(1, DiamondKata.calculateMiddleSpace(currentLetter));

        currentLetter++;
        //C
        assertEquals(3, DiamondKata.calculateMiddleSpace(currentLetter));

    }

    @Test
    void should_print_half_diamond_for_letter_e() {
        assertEquals(List.of("--A--", "-B-B-", "C---C", "-B-B-", "--A--"), DiamondKata.printDiamond('C'));
    }

    @Test
    void should_print_full_diamond_for_letter_b() {
        assertEquals(List.of("-A-", "B-B", "-A-"), DiamondKata.printDiamond('B'));
    }

}
