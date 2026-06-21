package utils;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class GenericStack<T> {

    private List<T> elements;

    public GenericStack() {
        elements = new ArrayList<>();
    }

    // Thêm phần tử vào đỉnh stack
    public void push(T item) {
        elements.add(item);
    }

    // Lấy và xóa phần tử trên đỉnh
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return elements.remove(elements.size() - 1);
    }

    // Xem phần tử trên đỉnh nhưng không xóa
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return elements.get(elements.size() - 1);
    }

    // Kiểm tra stack rỗng
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    // Số lượng phần tử
    public int size() {
        return elements.size();
    }
}