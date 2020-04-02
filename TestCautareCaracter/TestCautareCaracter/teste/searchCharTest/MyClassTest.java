package searchCharTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import searchChar.MyClass;

import java.io.Console;

import static org.junit.Assert.*;


public class MyClassTest {
    MyClass tester = new MyClass();

    @Rule
    public SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void equivalencePartitioning() {
        assertEquals(false, tester.FormeazaTriunghi(new String[]{"2", "4", "5", "9"}));
        assertEquals(false, tester.FormeazaTriunghi(new String[]{"2", "4", "ana"}));
        assertEquals(false, tester.FormeazaTriunghi(new String[]{"3", "6", "12"}));
    }

    @Test
    public void boundaryValueAnalysis() {
        assertEquals(false, tester.FormeazaTriunghi(new String[]{}));
        assertEquals(false, tester.FormeazaTriunghi(new String[]{"-3", "4", "9"}));
        assertEquals(true, tester.FormeazaTriunghi(new String[]{"5", "21", "20"}));
        assertEquals(false, tester.FormeazaTriunghi(new String[]{"3", "6", "12"}));
    }

    @Test
    public void categoryPartitioning() {
        assertEquals(false, tester.FormeazaTriunghi(new String[] {"242"}));
        assertEquals(false, tester.FormeazaTriunghi(new String[] {"1", "ana", "+3"}));
        assertEquals(true, tester.FormeazaTriunghi(new String[]{"15", "16", "17"}));
        assertEquals(false, tester.FormeazaTriunghi(new String[]{"2", "5", "9"}));
        assertEquals(false, tester.FormeazaTriunghi(new String[]{"4", "13", "6"}));
        assertEquals(false, tester.FormeazaTriunghi(new String[]{"20", "5", "8"}));
    }

    @Test
    public void statementCoverage() {
        assertEquals(false, tester.FormeazaTriunghi(new String[] {"5"}));
        assertEquals(false, tester.FormeazaTriunghi(new String[] {"ana", "6", "8"}));
        assertEquals(false, tester.FormeazaTriunghi(new String[]{"2", "2", "12"}));
        assertEquals(false, tester.FormeazaTriunghi(new String[]{"2", "12", "2"}));
        assertEquals(false, tester.FormeazaTriunghi(new String[]{"14", "3", "2"}));
        assertEquals(true, tester.FormeazaTriunghi(new String[] {"8", "8", "8"}));
    }

    @Test
    public void conditionCoverage() {
        assertEquals(false, tester.FormeazaTriunghi(new String[] {"0", "2"}));
        assertEquals(false, tester.FormeazaTriunghi(new String[] {"9", "-6", "8"}));
        assertEquals(false, tester.FormeazaTriunghi(new String[]{"14", "13", "30"}));
        assertEquals(false, tester.FormeazaTriunghi(new String[]{"5", "19", "3"}));
        assertEquals(false, tester.FormeazaTriunghi(new String[]{"29", "12", "1"}));
        assertEquals(true, tester.FormeazaTriunghi(new String[] {"17", "15", "20"}));
    }

    @Test
    public void killMutants() {
        systemOutRule.clearLog();
        assertEquals(false, tester.FormeazaTriunghi(new String[]{"0", "2", "7", "6"}));
        assertEquals(tester.log, systemOutRule.getLog());

        systemOutRule.clearLog();
        assertEquals(false, tester.FormeazaTriunghi(new String[]{"1", "mutant", "8"}));
        assertEquals(tester.log, systemOutRule.getLog());

        systemOutRule.clearLog();
        assertEquals(false, tester.FormeazaTriunghi(new String[]{"6", "6", "12"}));
        assertEquals(tester.log, systemOutRule.getLog());

        systemOutRule.clearLog();
        assertEquals(false, tester.FormeazaTriunghi(new String[]{"6", "12", "6"}));
        assertEquals(tester.log, systemOutRule.getLog());

        systemOutRule.clearLog();
        assertEquals(false, tester.FormeazaTriunghi(new String[]{"12", "6", "6"}));
        assertEquals(tester.log, systemOutRule.getLog());

        systemOutRule.clearLog();
        assertEquals(true, tester.FormeazaTriunghi(new String[]{"26", "24", "29"}));
        assertEquals(tester.log, systemOutRule.getLog());
    }
}