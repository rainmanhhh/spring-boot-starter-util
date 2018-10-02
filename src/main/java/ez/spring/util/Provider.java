package ez.spring.util;

public class Provider<T> {
    private String className = null;

    public String getClassName() {
        return className;
    }

    public Provider<T> setClassName(String className) {
        this.className = className;
        return this;
    }

    @SuppressWarnings("unchecked")
    public T createInstance() throws Exception {
        String cn = className;
        return cn == null || cn.isEmpty() ? null : (T) Class.forName(cn).getConstructor().newInstance();
    }

    public static <T> T createInstance(String className) throws Exception {
        return new Provider<T>().setClassName(className).createInstance();
    }
}
