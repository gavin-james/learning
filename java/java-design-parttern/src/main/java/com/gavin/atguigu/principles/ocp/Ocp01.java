package com.gavin.atguigu.principles.ocp;

public class Ocp01 {

  public static void main(String[] args) {
    GraphicEditor  graphicEditor = new GraphicEditor();
    Rectangle rectangle = new Rectangle();
    Circle circle = new Circle();
    graphicEditor.drawShape(rectangle);
    graphicEditor.drawShape(circle);

  }
}

// 这是一个绘图的模类
class GraphicEditor {
  // 根据接shape对象，根据type，绘制不同的图形·
  public void drawShape(Shape s) {
    if (s.m_type == 1) {
      drawRectangle(s);
    } else {
      drawCircle(s);
    }
  }

  public void drawRectangle(Shape s) {
    System.out.println("画矩形");
  }

  public void drawCircle(Shape s) {
    System.out.println("画圆形");
  }
}

class Shape {
  int m_type;
}

class Rectangle extends Shape {
  public Rectangle() {
    super.m_type = 1;
  }
}


class Circle extends Shape {
  public Circle() {
    super.m_type = 2;
  }
}