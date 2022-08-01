package com.gavin.atguigu.principles.ocp.improve;

public class Oce01 {
  public static void main(String[] args) {
    GraphicEditor graphicEditor = new GraphicEditor();
    graphicEditor.drawShape(new Rectangle());
    graphicEditor.drawShape(new Circle());
    graphicEditor.drawShape(new Triangle());
  }
}

// 这是一个绘图的模类
class GraphicEditor {
  // 根据接shape对象，根据type，绘制不同的图形·
  public void drawShape(Shape s) {
    s.draw();
  }

}


interface Shape {
  void draw();
}

class Rectangle implements Shape {
  @Override
  public void draw() {
    System.out.println("画矩形");
  }
}

class Circle implements Shape {
  @Override
  public void draw() {
    System.out.println("画圆形");
  }
}

class Triangle implements Shape {
  @Override
  public void draw() {
    System.out.println("画三角形");
  }
}