class ArrayOperations {
    public static void reverseElements(int[][] twoDimArray) {
        for (int[] value : twoDimArray) {
            for (int j = 0; j < value.length / 2; j++) {
                value[j] += value[value.length - 1 - j];
                value[value.length - 1 - j] = value[j] - value[value.length - 1 - j];
                value[j] -= value[value.length - 1 - j];
            }
        }
    }
}