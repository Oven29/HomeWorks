package HomeWork2;

public class MyLinkedList<Type> {
    private Object[] array = new Object[10];
    public int lenght = 0;

    private void resize(int newSize) {
        // Переопределяем размер массива array
        Object[] newArray = new Object[newSize];
        System.arraycopy(array, 0, newArray, 0, lenght);
        array = newArray;
    }

    public void add(Type element) {
        // Добавляем элемет в конец
        if (lenght == array.length - 1) {
            resize(lenght * 2);
        }
        array[lenght++] = element;
    }

    public void add(Type element, int index) {
        // Добавляем элемент на определённую позицию или в конец
        if (index > lenght || index < 0) {
            add(element);
        } else {
            if (lenght == array.length - 1) {
                resize(lenght * 2);
            }
            Type mem, old = (Type) array[index];
            lenght++;
            for (int i = index + 1; i < lenght; i++) {
                mem = (Type) array[i];
                array[i] = old;
                old = mem;
            }
            array[index] = element;
        }
    }

    public Type remove(int index) {
        // Удаляет элемент из массива, возвращает его значение
        Type element = (Type) array[index];
        for (int i = index; i < lenght; i++) {
            array[i] = array[i + 1];
        }
        array[lenght] = null;
        lenght--;
        return element;
    }

    public Type get(int index) {
        // Возвращает элемент массива по его индексу
        return (Type) array[index];
    }

    public String toString() {
        String string = "[";
        if (array[0].getClass() == String.class) {
            for (int i = 0; i < lenght - 1; i++) {
                string += "'" + array[i] + "'" + ", ";
            }
            if (lenght > 0) {
                string += "'" + array[lenght - 1] + "'";
            }
        } else {
            for (int i = 0; i < lenght - 1; i++) {
                string += array[i] + ", ";
            }
            if (lenght > 0) {
                string += array[lenght - 1];
            }
        }
        string += "]";
        return string;
    }

}
