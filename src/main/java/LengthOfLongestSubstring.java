public class LengthOfLongestSubstring {
    // TODO 把hash冲突的信息升级成上次出现的位置，当前长度=当前位置-上次的位置，然后更新最大长度
    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        int longest = 0;
        int ends = 0;
        int begin = 0;
        Hash hash = new Hash();
        while (ends < array.length) {
            // 插入hash时冲突，说明之前的没重复，记录此时的长度
            ends = findNextDups(array, hash, ends);
            int length = ends - begin;
            if (longest < length) {
                longest = length;
            }

            // 下次从冲突的下一个开始，把冲突之前的hash清空
            if (ends < array.length) {
                begin = clearUntilChar(array, hash, begin, array[ends]);
            }

            // 然后继续寻找，直到碰到下一次冲突
        }

        return longest;
    }

    public int clearUntilChar(char[] array, Hash hash, int begin, char ch) {
        for (int i = begin; i < array.length; i++) {
            hash.clear(array[i]);
            if (ch == array[i]) {
                return i + 1;
            }
        }
        return begin;
    }

    public int findNextDups(char[] array, Hash hash, int begin) {
        int i;
        for (i = begin; i < array.length; i++) {
            if (!hash.set(array[i])) {
                break;
            }
        }

        return i;
    }

    // 使用二进制&来判断是否冲突，32bit，4int
    public static class Hash {
        private int[] bits;

        public Hash() {
            this.bits = new int[128 / 32];
        }

        public boolean set(char ch) {
            if (has(ch)) {
                return false;
            }

            int index = ch;
            this.bits[index / 32] |= (1 << (index % 32));
            return true;
        }

        public boolean has(char ch) {
            int index = ch;
            return (this.bits[index / 32] & (1 << (index % 32))) != 0;
        }

        public void clear(char ch) {
            int index = ch;
            this.bits[index / 32] &= ~(1 << (index % 32));
        }
    }

}
