class DynamicArray {
    private int[] arr;
    private int size;

    public DynamicArray(int capacity) {
      if (capacity > 0) {
        arr = new int[capacity];
        size = 0;
      } else {
        throw new IllegalArgumentException("Capacity must be > 0");
      }
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if (arr.length == size) {
            resize();
        }
        arr[size++] = n;
    }

    public int popback() {
        if (size == 0) {
            throw new IllegalStateException("Empty array");
        }
        return arr[--size];
    }

    public void resize() {
        int[] brr = new int[arr.length * 2];
        for(int i = 0; i < arr.length; i++) {
            brr[i] = arr[i];
        }
        arr = brr;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return arr.length;
    }
}
