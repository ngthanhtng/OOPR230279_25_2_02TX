public class Rectangle {
    private double width;
    private double height;

    //Tạo hình vuông với cạnh = 1
    public Rectangle() {
        width = 1;
        height = 1;
    }

    //Tạo hình vuông cạnh side
    public Rectangle(double side) {
        width = side;
        height = side;
    }

    //Copy Constructor
    public Rectangle(Rectangle other) {
        this(other.width, other.height);
    }

    //Tạo hình chữ nhật
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return (width + height) * 2;
    }

    public boolean isSquare() {
        return width == height;
    }

    public void scale(double factor) {
        width *= factor;
        height *= factor;
    }

    /*
    Trong Java, constructor overloading phân biệt dựa trên số lượng, thứ tự tham số và kiểu dữ liệu tham số. Nếu bạn viết:
    public Rectangle(double side) { ... }
    public Rectangle(double width) { ... }
    thì cả hai đều có chữ ký giống nhau (Rectangle(double)), dẫn đến lỗi biên dịch vì trình biên dịch không biết gọi constructor nào khi bạn truyền vào một số thực.
     */
}
