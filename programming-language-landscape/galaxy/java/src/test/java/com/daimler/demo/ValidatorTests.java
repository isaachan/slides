package com.daimler.demo;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ValidatorTests {

    @Test
    public void validate() {
        final Validator validator = new Validator();
        assertEquals(true, validator.validate(""));

        assertEquals(false, validator.validate("IIII"));
        assertEquals(true, validator.validate("IIIUI"));
        assertEquals(true, validator.validate("III"));

        assertEquals(false, validator.validate("XXXX"));
        assertEquals(true, validator.validate("XXXUX"));
        assertEquals(true, validator.validate("XXX"));

        assertEquals(false, validator.validate("CCCC"));
        assertEquals(true, validator.validate("CCCUC"));
        assertEquals(true, validator.validate("CCC"));

        assertEquals(false, validator.validate("MMMM"));
        assertEquals(true, validator.validate("MMMUM"));
        assertEquals(true, validator.validate("MMM"));

        assertEquals(false, validator.validate("LMMMM"));
        assertEquals(false, validator.validate("LLMMMM"));
        assertEquals(false, validator.validate("LLMMMMLLL"));

        assertEquals(true, validator.validate("CMMMUM"));
        assertEquals(true, validator.validate("MMMUML"));
        assertEquals(true, validator.validate("CMMMUML"));
        assertEquals(true, validator.validate("CMMMUMLL"));

        assertEquals(true, validator.validate("IV"));
        assertEquals(true, validator.validate("IX"));
        assertEquals(false, validator.validate("IL"));
        assertEquals(false, validator.validate("IC"));
        assertEquals(false, validator.validate("ID"));
        assertEquals(false, validator.validate("IM"));

        assertEquals(true, validator.validate("XL"));
        assertEquals(true, validator.validate("XC"));
        assertEquals(false, validator.validate("XV"));
        assertEquals(false, validator.validate("XD"));
        assertEquals(false, validator.validate("XU"));
        assertEquals(false, validator.validate("XM"));

        assertEquals(true, validator.validate("CD"));
        assertEquals(true, validator.validate("CM"));
        assertEquals(false, validator.validate("CX"));
        assertEquals(false, validator.validate("CV"));
        assertEquals(false, validator.validate("CU"));
        assertEquals(false, validator.validate("CL"));

        assertEquals(true, validator.validate("VI"));
        assertEquals(false, validator.validate("VX"));
        assertEquals(false, validator.validate("VL"));
        assertEquals(false, validator.validate("VC"));
        assertEquals(false, validator.validate("VD"));
        assertEquals(false, validator.validate("VM"));

        assertEquals(true, validator.validate("LI"));
        assertEquals(true, validator.validate("LV"));
        assertEquals(true, validator.validate("LX"));
        assertEquals(false, validator.validate("LC"));
        assertEquals(false, validator.validate("LD"));
        assertEquals(false, validator.validate("LM"));

        assertEquals(true, validator.validate("DI"));
        assertEquals(true, validator.validate("DV"));
        assertEquals(true, validator.validate("DX"));
        assertEquals(true, validator.validate("DL"));
        assertEquals(true, validator.validate("DC"));
        assertEquals(false, validator.validate("DM"));
    }

}

