import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LengthOfLongestSubstringTest {

    @Test
    void should_hash_init_with_false() {
        LengthOfLongestSubstring.Hash hash = new LengthOfLongestSubstring.Hash();
        for (char ch = 1; ch < 128; ch++) {
            assertEquals(false, hash.has(ch));
        }
    }

    @Test
    void should_hash_can_set_and_clear_bit() {
        LengthOfLongestSubstring.Hash hash = new LengthOfLongestSubstring.Hash();
        for (char ch = 1; ch < 128; ch++) {
            assertEquals(true, hash.set(ch));
        }

        for (char ch = 1; ch < 128; ch++) {
            assertEquals(true, hash.has(ch));
        }

        for (char ch = 1; ch < 128; ch++) {
            hash.clear(ch);
        }

        for (char ch = 1; ch < 128; ch++) {
            assertEquals(false, hash.has(ch));
        }
    }

    @Test
    void should_occurs_length_from_begin() {
        String str = "abcabcbb";
        char[] array = str.toCharArray();
        int longest = 1;
        LengthOfLongestSubstring.Hash hash = new LengthOfLongestSubstring.Hash();
        for (int i = 0; i < array.length; i++) {
            if (!hash.set(array[i])) {
                longest = i;
                break;
            }
        }
        assertEquals(3, longest);
    }

    @ParameterizedTest
    @CsvSource({
            "abcabcbb, 3",
            "abc, 3",
    })
    void should_occurs_end_begin_with_index(String input, int output) {
        int offset = 0;

        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
        LengthOfLongestSubstring.Hash hash = new LengthOfLongestSubstring.Hash();
        int longest = solution.findNextDups(input.toCharArray(), hash, offset);
        assertEquals(output, longest - offset);
    }

    @Test
    void should_clear_until_next_char() {
        String str = "abcabcbb";
        int offset = 4;

        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
        LengthOfLongestSubstring.Hash hash = new LengthOfLongestSubstring.Hash();
        solution.findNextDups(str.toCharArray(), hash, offset);

        assertEquals(1, solution.clearUntilChar(str.toCharArray(), hash, 0, 'a'));
        assertEquals(2, solution.clearUntilChar(str.toCharArray(), hash, 0, 'b'));
        assertEquals(3, solution.clearUntilChar(str.toCharArray(), hash, 0, 'c'));
    }

    @ParameterizedTest
    @CsvSource({
            "abcabcbb, 3",
            "bbbbb, 1",
            "pwwkew, 3",
            "'', 0",
            "'aabaab!bb', 3"
    })
    void should_find_longest(String input, int output) {
        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
        int longest = solution.lengthOfLongestSubstring(input);
        assertEquals(output, longest);
    }
}