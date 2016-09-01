package arraylisttest;


import java.util.Arrays;
import listtest.TestList;

/**
 *
 * @author Игорь
 */
public class TestArrayList implements TestList {

    private Object[] arr;
    private final static int INITIAL_CAPACITY = 32;
    private int capacity = 0;

    TestArrayList() {
        this(INITIAL_CAPACITY);
    }

    TestArrayList(int capacity) {
        if (capacity < 1 || capacity > Integer.MAX_VALUE) {
            throw new IllegalArgumentException();
        }
        arr = new Object[capacity];
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return capacity;
    }

    /**
     * Appends the specified element to the end of this list (optional
     * operation).
     *
     * @param o element to be appended to this list
     * @return <tt>true</tt>
     */
    @Override
    public boolean add(Object o) {
        if (size() == arr.length) {
            Object[] arr1 = new Object[capacity * 2];
            System.arraycopy(arr, 0, arr1, 0, arr.length);
            arr = arr1;
            arr[this.capacity++] = o;
        } else {
            arr[this.capacity++] = o;
        }
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this list
     * (optional operation).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    @Override
    public void add(int index, Object element) {
        if (index < 0 || index > (size())) {
            throw new IllegalArgumentException();
        }
        if (size() <= arr.length - 1) {
            Object[] arr1 = new Object[arr.length * 2];

            insertElement(arr1, index, element);
        } else {
            Object[] arr1 = new Object[arr.length];
            insertElement(arr1, index, element);
        }
    }

    private void insertElement(Object[] arr1, int index, Object element) {
        System.arraycopy(arr, 0, arr1, 0, index);
        arr1[index] = element;
        capacity++;
        System.arraycopy(arr, index, arr1, index + 1, arr.length - index);
        arr = arr1;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if
     * it is present (optional operation).
     *
     * @param o element to be removed from this list, if present
     * @return <tt>true</tt> if this list contained the specified element
     */
    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < capacity; i++) {
            if (arr[i] == o) {
                capacity--;
                if (i != 0) {
                    Object[] arr1 = new Object[arr.length - 1];
                    System.arraycopy(arr, 0, arr1, 0, i);
                    System.arraycopy(arr, i + 1, arr1, i, arr.length - (i + 1));
                    arr = arr1;
                    return true;
                } else {
                    Object[] arr1 = new Object[arr.length - 1];
                    System.arraycopy(arr, 1, arr1, 0, arr.length - 1);
                    arr = arr1;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Removes all of the elements from this list (optional operation). The list
     * will be empty after this call returns.
     *
     */
    @Override
    public void clear() {
        Arrays.fill(arr, null);
        capacity = 0;
    }

    /**
     * Returns <tt>true</tt> if this list contains the specified element.
     *
     * @param o element whose presence in this list is to be tested
     * @return <tt>true</tt> if this list contains the specified element
     */
    @Override
    public boolean contains(Object o) {
        for (Object arr1 : arr) {
            if (arr1 == o) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    @Override
    public Object get(int index) {
        if (index < 0 || index > (capacity - 1)) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    /**
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < capacity; i++) {
            if (arr[i] == o) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element in this
     * list, or -1 if this list does not contain the element.
     *
     * @param o element to search for
     * @return the index of the last occurrence of the specified element in this
     */
    @Override
    public int lastIndexOf(Object o) {
        for (int i = capacity - 1; i >= 0; i--) {
            if (arr[i] == o) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns <tt>true</tt> if this list contains no elements.
     *
     * @return <tt>true</tt> if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element (optional operation).
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     */
    @Override
    public Object set(int index, Object element) {
        Object o;
        if (index < 0 || index > (capacity - 1)) {
            throw new IllegalArgumentException();
        } else {
            o = arr[index];
            arr[index] = element;
        }
        return o;
    }

    /**
     * Removes the element at the specified position in this list (optional
     * operation).
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     */
    @Override
    public Object remove(int index) {
        if (index < 0 || index > (capacity - 1)) {
            throw new IllegalArgumentException();
        }
        Object o = arr[index];
        capacity--;
        if (index != 0) {
            Object[] arr1 = new Object[arr.length - 1];
            System.arraycopy(arr, 0, arr1, 0, index);
            System.arraycopy(arr, index + 1, arr1, index, arr.length - (index + 1));
            arr = arr1;
        } else {
            Object[] arr1 = new Object[arr.length - 1];
            System.arraycopy(arr, 1, arr1, 0, arr.length - 1);
            arr = arr1;
        }
        return o;
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element).
     *
     * @return an array containing all of the elements in this list in proper
     * sequence
     */
    @Override
    public Object[] toArray() {
        Object[] arr1 = new Object[capacity];
        System.arraycopy(arr, 0, arr1, 0, capacity);
        return arr1;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

}
