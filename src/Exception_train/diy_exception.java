package Exception_train;

import Exception_train.IndexIsNagetiveException;
import Exception_train.IndexIsOutofRangeException;

public class diy_exception implements IStringBuffer{
	int capacity = 16;
    int length = 0;
    char[] value;
    
    public diy_exception() {
        value = new char[capacity];
    }
 
    // 有参构造方法
    public diy_exception(String str) {
        this();
        if (null == str)
            return;
 
        if (capacity < str.length()) {
            capacity = value.length * 2;
            value = new char[capacity];
        }
 
        if (capacity >= str.length())
            System.arraycopy(str.toCharArray(), 0, value, 0, str.length());
 
        length = str.length();
 
    }
    
	@Override
	public void append(String str) throws IndexIsOutofRangeException, IndexIsNagetiveException {
		insert(length, str);// TODO 自动生成的方法存根
		
	}

	@Override
	public void append(char c) throws IndexIsOutofRangeException, IndexIsNagetiveException {
		append(String.valueOf(c));// TODO 自动生成的方法存根
		
	}

	@Override
	public void insert(int pos, char b) throws IndexIsOutofRangeException, IndexIsNagetiveException {
		insert(pos, String.valueOf(b));// TODO 自动生成的方法存根
		
	}

	@Override
	public void insert(int pos, String b) throws IndexIsOutofRangeException, IndexIsNagetiveException {
		 // 边界条件判断
        if (pos < 0)
            throw new IndexIsNagetiveException();
 
        if (pos > length)
            throw new IndexIsOutofRangeException();
 
        if (null == b)
            throw new NullPointerException();
 
        // 扩容
        if (length + b.length() > capacity) {
            capacity = (int) ((length + b.length()) * 2.5f);
            char[] newValue = new char[capacity];
            System.arraycopy(value, 0, newValue, 0, length);
            value = newValue;
        }
 
        char[] cs = b.toCharArray();
 
        // 先把已经存在的数据往后移
 
        System.arraycopy(value, pos, value, pos + cs.length, length - pos);
        // 把要插入的数据插入到指定位置
        System.arraycopy(cs, 0, value, pos, cs.length);
 
        length = length + cs.length;// TODO 自动生成的方法存根
		
	}

	@Override
	public void delete(int start) throws IndexIsOutofRangeException, IndexIsNagetiveException {
		delete(start, length);// TODO 自动生成的方法存根
		
	}

	@Override
	public void delete(int start, int end) throws IndexIsOutofRangeException, IndexIsNagetiveException {
		// 边界条件判断
        if (start < 0)
            throw new IndexIsNagetiveException();
 
        if (start > length)
            throw new IndexIsOutofRangeException();
 
        if (end < 0)
            throw new IndexIsNagetiveException();
 
        if (end > length)
            throw new IndexIsOutofRangeException();
 
        if (start >= end)
            throw new IndexIsOutofRangeException();
 
        System.arraycopy(value, end, value, start, length - end);
        length -= end - start; // TODO 自动生成的方法存根
		
	}

	@Override
	public void reverse() {
		for (int i = 0; i < length / 2; i++) {
			 
            char temp = value[i];
            value[i] = value[length - i - 1];
            value[length - i - 1] = temp;
        }// TODO 自动生成的方法存根
		
	}

	@Override
	public int length() {
		return length;// TODO 自动生成的方法存根
	}

	 public static void main(String[] args) {
	        try {
	        	diy_exception sb = new diy_exception("there light");
	            System.out.println(sb);
	            sb.insert(0, "let ");
	            System.out.println(sb);
	            sb.insert(10, "be ");
	            System.out.println(sb);
	            sb.insert(0, "God Say:");
	            System.out.println(sb);
	            sb.append("!");
	            System.out.println(sb);
	            sb.append('?');
	            System.out.println(sb);
	            sb.reverse();
	            System.out.println(sb);
	 
	            sb.reverse();
	            System.out.println(sb);
	 
	            sb.delete(0, 4);
	            System.out.println(sb);
	            sb.delete(4);
	            System.out.println(sb);
	        } catch (IndexIsNagetiveException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IndexIsOutofRangeException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	 
	    }
	
}
