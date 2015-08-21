class Test{
        public static int END = Integer.MAX_VALUE;
        public static int START = END - 10;

        public static void main(String[] args) {
            int count = 0;
            for (long i = START; i <= END; i++) {
                count++;
            }
            System.out.println(count);
        }
    }
