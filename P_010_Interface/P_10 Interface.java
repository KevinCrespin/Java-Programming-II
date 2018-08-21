interface P_10 Interface {
	public double computeArea();
	 
}

class MyCircle implements MyShape {
	
	int radius;
	
	MyCircle(int radius) {
		this.radius = radius;
	}
	
	public double computeArea() {
		double area = 3.14*radius*radius;
		return area;
	}

}

class MyRectangle implements MyShape {
	int w;
	int h;
	
	MyRectangle(int w, int h) {
	   this.w = w;
	   this.h= h;
	}

 	public double computeArea() {
		double area = w*h;
		return area;
	}
}

