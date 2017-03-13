package com.daimler.demo;

import java.util.Arrays;

public class Validator {
    public boolean validate(String number) {
        return doValidate(number.toCharArray());
    }

    private boolean doValidate(char[] chars) {
        if (chars.length == 0) return true;

        if (chars[0] == 'I') {
            if (chars.length >= 3) {
                if (chars[0] == chars[1] && chars[1] == chars[2]) {
                    if (chars.length >= 4 && chars[3] == 'I') return false;
                    return doValidate(Arrays.copyOfRange(chars, 3, chars.length));
                }
            }
        }
        if (chars[0] == 'X') {
            if (chars.length >= 3) {
                if (chars[0] == chars[1] && chars[1] == chars[2]) {
                    if (chars.length >= 4 && chars[3] == 'X') return false;
                    return doValidate(Arrays.copyOfRange(chars, 3, chars.length));
                }
            }
        }

        if (chars[0] == 'C') {
            if (chars.length >= 3) {
                if (chars[0] == chars[1] && chars[1] == chars[2]) {
                    if (chars.length >= 4 && chars[3] == 'C') return false;
                    return doValidate(Arrays.copyOfRange(chars, 3, chars.length));
                }
            }
        }

        if (chars[0] == 'M') {
            if (chars.length >= 4) {
                if (chars[1] == chars[2] && chars[2] == chars[3] && chars[3] == 'M') return false;
                return doValidate(Arrays.copyOfRange(chars, 1, chars.length));
            }
        }

        if (chars[0] == 'I') {
            if (chars.length >= 2) {
                if (chars[1] != 'X' && chars[1] != 'V') return false;
                return doValidate(Arrays.copyOfRange(chars, 1, chars.length));
            }
        }

        if (chars[0] == 'X') {
            if (chars.length >= 2) {
                if (chars[1] != 'C' && chars[1] != 'L') return false;
                return doValidate(Arrays.copyOfRange(chars, 1, chars.length));
            }
        }

        if (chars[0] == 'C') {
            if (chars.length >= 2) {
                if (chars[1] != 'D' && chars[1] != 'M') return false;
                return doValidate(Arrays.copyOfRange(chars, 1, chars.length));
            }
        }

        if (chars[0] == 'V') {
            if (chars.length >= 2) {
                if (chars[1] == 'L' || chars[1] == 'X' || chars[1] == 'C' || chars[1] == 'D' || chars[1] == 'M') return false;
                return doValidate(Arrays.copyOfRange(chars, 1, chars.length));
            }
        }

        if (chars[0] == 'L') {
            if (chars.length >= 2) {
                if (chars[1] == 'C' || chars[1] == 'D' || chars[1] == 'M') return false;
                return doValidate(Arrays.copyOfRange(chars, 1, chars.length));
            }
        }
        if (chars[0] == 'D') {
            if (chars.length >= 2) {
                if (chars[1] == 'M') return false;
                return doValidate(Arrays.copyOfRange(chars, 1, chars.length));
            }
        }

        return doValidate(Arrays.copyOfRange(chars, 1, chars.length));
    }
}
