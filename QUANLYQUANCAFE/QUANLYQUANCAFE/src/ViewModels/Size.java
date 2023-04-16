package ViewModels;

public class Size {

    private String id;
    private String size;

    public Size() {
    }

    public Size(String id, String size) {
        this.id = id;
        this.size = size;
    }

    public Size(String size) {
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "SizeModel{" + "id=" + id + ", size=" + size + '}';
    }

    public Object[] toRowDataSize() {
        return new Object[]{id, size};
    }
}
